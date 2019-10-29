package com.bnuz.propertyManagementSystem.service.impl;

import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.model.ResultStatusCode;
import com.bnuz.propertyManagementSystem.service.QRCodeService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import jodd.util.Base64;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

/**
 * @Author: Harry
 * @Date: 2019-10-24 16:16
 * @Version 1.0
 */

@Service("QRCodeServiceImpl")
@Slf4j
public class QRCodeServiceImpl implements QRCodeService {

    @Override
    public Result getQrCodeBase64String(String content, int width, int height, int margin) {
        String base64 = null;

        try {
            byte[] qrcode = getQRCodeBytes(content, width, height, margin);
            base64 = Base64.encodeToString(qrcode);
        } catch (Exception e) {
            log.error("生成二维码错误!");
            log.error(e.toString());
        }

        if(base64 == null){
            return new Result(false, ResultStatusCode.ERROR,ResultStatusCode.ERROR_MES_SYS);
        }
        else{
            return new Result(true,ResultStatusCode.OK,"二维码生成成功!",base64);
        }
    }


    /**
     * 生成二维码图片
     * @param content 二维码内容
     * @param width 宽
     * @param height 高
     * @param margin 二维码外边距，0到4
     * @param imgPath 二维码图片存放路径
     */
    public void createQRCode(String content,int width,int height,int margin,String imgPath,String imgName) throws WriterException, IOException {
        /**二维码参数设定*/
        Hashtable<EncodeHintType,Object> hintTypes = setQrCodeParameter(margin);


        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,width,height,hintTypes);//创建二维码，本质为二位数组

        BufferedImage bufferedImage = createImage(width,height,bitMatrix);

        File imageFile = new File(imgPath + imgName + ".jpeg");
        if (!imageFile.getParentFile().exists()){
            imageFile.getParentFile().mkdirs();
        }
        ImageIO.write(bufferedImage,"JPEG",imageFile);

    }

    /**
     * 生成二维码图片字节数组，可将字节数组写入文件、经base64编码后写入FreeMarker模版等操作
     * @param content 二维码内容
     * @param width 宽
     * @param height 高
     * @param margin 外边距
     * @return 二维码对应的字节数组
     * @throws Exception
     */
    public byte[] getQRCodeBytes(String content, int width, int height, int margin) throws Exception{
        Hashtable<EncodeHintType,Object> hintTypes = setQrCodeParameter(margin);
        ByteArrayOutputStream outputStream = null;

        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,width,height,hintTypes);//获取二维码

            //将二维码写入图片
            BufferedImage bufferedImage = createImage(width,height,bitMatrix);

            //将图片转为字节数组
            outputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage,"JPEG",outputStream);

            return outputStream.toByteArray();
        } catch (Exception e) {
            throw e;
        } finally {
            if (outputStream != null){
                outputStream.close();
            }
        }
    }

    private Hashtable<EncodeHintType,Object> setQrCodeParameter(int margin){
        Hashtable<EncodeHintType,Object> hintTypes = new Hashtable<EncodeHintType, Object>();
        hintTypes.put(EncodeHintType.CHARACTER_SET,CharacterSetECI.UTF8);
        hintTypes.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);//容错级别，共4级，详细问度娘
        hintTypes.put(EncodeHintType.MARGIN,margin);//二维码外边距

        return hintTypes;
    }

    private BufferedImage createImage(int width, int height, BitMatrix bitMatrix){

        BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                bufferedImage.setRGB(i,j,bitMatrix.get(i,j)? Color.BLACK.getRGB():Color.WHITE.getRGB());
            }
        }

        return bufferedImage;
    }
}