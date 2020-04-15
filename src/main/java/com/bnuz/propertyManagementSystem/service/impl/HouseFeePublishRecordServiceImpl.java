package com.bnuz.propertyManagementSystem.service.impl;

import com.bnuz.propertyManagementSystem.dao.HouseDao;
import com.bnuz.propertyManagementSystem.dao.HouseFeePublishRecordDao;
import com.bnuz.propertyManagementSystem.dao.HouseFeeRecordDao;
import com.bnuz.propertyManagementSystem.emailSender.MailService;
import com.bnuz.propertyManagementSystem.model.House;
import com.bnuz.propertyManagementSystem.model.HouseFeePublishRecord;
import com.bnuz.propertyManagementSystem.model.HouseFeeRecord;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.model.ResultStatusCode;
import com.bnuz.propertyManagementSystem.service.HouseFeePublishRecordService;
import com.bnuz.propertyManagementSystem.service.OutTradeNoFactoryService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("HouseFeePublishRecordServiceImpl")
@Transactional
public class HouseFeePublishRecordServiceImpl implements HouseFeePublishRecordService {

  @Autowired
  private HouseDao houseDao;

  @Autowired
  private HouseFeeRecordDao houseFeeRecordDao;

  @Autowired
  private HouseFeePublishRecordDao houseFeePublishRecordDao;

  @Autowired
  private OutTradeNoFactoryService outTradeNoFactoryService;

  @Autowired
  private MailService mailService;

  @Override
  public Result findAll(Integer pageNum, Integer pageSize) {
    Sort sort = new Sort(Direction.DESC,"publishTime");
    Pageable pageable = PageRequest.of(pageNum, pageSize,sort);
    Page page = houseFeePublishRecordDao.findAll(pageable);
    return new Result(true, ResultStatusCode.OK, "查询成功", page);
  }

  @Override
  public Result publish(HouseFeePublishRecord houseFeePublishRecord) {
    Calendar cal = Calendar.getInstance();
    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH) + 1;
    StringBuilder sb = new StringBuilder();
    sb.append(year).append("年").append(month).append("月份物业费");
    houseFeePublishRecord.setPaymentName(sb.toString());
    houseFeePublishRecord.setStatus(0);
    HouseFeePublishRecord result = houseFeePublishRecordDao.saveAndFlush(houseFeePublishRecord);
    this.insertHouseFeeRecord(result, year, month);
    return new Result(true, ResultStatusCode.OK, "添加成功", result);
  }

  private void insertHouseFeeRecord(HouseFeePublishRecord houseFeePublishRecord, Integer year, Integer month) {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(5000);
          List<House> houseList = houseDao.findAllByUserIdNotNull();
          Map<String, List<Map<String,String>>> map = new HashMap<>();
          houseList.forEach(house -> {
            HouseFeeRecord record = new HouseFeeRecord();
            record.setYear(year);
            record.setMonth(month);
            record.setPropertyId(house.getBuilding().getPropertyId());
            record.setBuildingId(house.getBuildingId());
            record.setHouseId(house.getId());
            record.setFee(house.getArea() * houseFeePublishRecord.getPrice());
            record.setIsPaid(false);
            record.setOutTradeNo(outTradeNoFactoryService.getOrderCode());
            HouseFeeRecord result = houseFeeRecordDao.saveAndFlush(record);
            HouseFeeRecord flag = houseFeeRecordDao.getByOutTradeNo(result.getOutTradeNo());
            String emailAddress = house.getUser().getEmailAddress();
            if(emailAddress != null && emailAddress.length() != 0) {
              List<Map<String, String>> userList = new ArrayList<>();
              if (map.containsKey(emailAddress)) {
                userList = map.get(emailAddress);
              }
              Map<String, String> flagMap = new HashMap<>();
              flagMap.put("paymentName", flag.getPaymentName());
              flagMap.put("price", flag.getFee().toString());
              userList.add(flagMap);
              map.put(emailAddress, userList);
            }
          });
          map.forEach((key, value) -> {
            String email = key;
            String html = composeEmail(value);
            mailService.sendHtmlMail(email, "物业费用账单", html);
          });
          houseFeePublishRecord.setStatus(1);
          houseFeePublishRecordDao.saveAndFlush(houseFeePublishRecord);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });
    thread.start();
  }

  private String composeEmail(List<Map<String,String>> payList){
    StringBuilder list = new StringBuilder();
    payList.forEach(obj -> {
      list.append("<tr><td>")
          .append(obj.get("paymentName"))
          .append("</td>")
          .append("<td>￥")
          .append(obj.get("price"))
          .append("</td></tr>");
    });
    StringBuilder html = new StringBuilder();
    html.append("<p>尊敬的业主:</p>")
        .append("<p>本月小区物业管理费用账单已出，您有如下项目需要交纳:<br/>")
        .append("<table>")
        .append("<tr>")
        .append("<th>费用名称</th>")
        .append("<th>金额</th>")
        .append("</tr>")
        .append(list.toString())
        .append("</table></p>")
        .append("<p>请及时登录<a href=http://localhost:8087>物业管理系统</a>进行缴费</p>")
        .append("<p>若有任何疑问请及时与我们取得联系:0756-12345678<br/>")
        .append("祝您生活愉快</p>");
    return html.toString();
  }

}
