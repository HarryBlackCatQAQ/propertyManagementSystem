package com.bnuz.propertyManagementSystem.service.impl;

import com.bnuz.propertyManagementSystem.model.ImageCode;
import com.bnuz.propertyManagementSystem.service.ValidateCodeService;
import com.bnuz.propertyManagementSystem.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 验证码服务
 *
 * @Author: Harry
 * @Date: 2019-09-20 20:13
 * @Version 1.0
 */

@Service("ValidateCodeServiceImpl")
public class ValidateCodeServiceImpl implements ValidateCodeService {

    @Autowired
    RedisUtil redisUtil;

    /**
     * 默认60秒s
     * @return
     */
    @Override
    public ImageCode createImageCode() {
        return createImageCodeImpl(60);
    }

    @Override
    public ImageCode createImageCode(int seconds) {
        return createImageCodeImpl(seconds);
    }

    /**
     * 生成验证码图片
     * @param seconds 过期时间
     * @return
     */
    private ImageCode createImageCodeImpl(int seconds) {//创建验证码

        int width = 67;//先设置固定值
        int height = 23;

        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        Graphics g = image.getGraphics();

        Random random = new Random();

        g.setColor(getRandColor(200,250));
        g.fillRect(0,0,width,height);
        g.setFont(new Font("Times New Roman",Font.ITALIC,20));
        g.setColor(getRandColor(160,200));

        for(int i=0;i<155;i++){
            int x= random.nextInt(width);
            int y= random.nextInt(height);
            int xl= random.nextInt(12);
            int yl= random.nextInt(12);
            g.drawLine(x,y,x+xl,y+yl);

        }
        String sRand = "";
        for(int i=0;i<4;i++){//生成四位随机数
            String rand = String.valueOf(random.nextInt(10));
            sRand += rand;
            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            g.drawString(rand,13*i+6,16);
        }

        g.dispose();
        return new ImageCode(image,sRand,seconds);//60s过期
    }


    /**
     * 生成随机背景条纹
     * @param fc
     * @param bc
     * @return
     */
    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if(fc>255){
            fc=255;
        }
        if(bc>255){
            bc=255;
        }
        int r=fc+random.nextInt(bc-fc);
        int g=fc+random.nextInt(bc-fc);
        int b=fc+random.nextInt(bc-fc);
        return new Color(r,g,b);
    }
}