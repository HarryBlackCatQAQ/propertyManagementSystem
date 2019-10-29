package com.bnuz.propertyManagementSystem.util;

import java.io.UnsupportedEncodingException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Base64加解密工具类
 * @Author: Hovees
 * @Date: 2019-10-29 15:16
 * @Version 1.0
 */

public class Base64Util {

  /**
   * 加密
   * @param str 待加密数据
   * @return 加密后数据
   */
  public static String encode(String str) {
    byte[] b = null;
    String s = null;
    try {
      b = str.getBytes("utf-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    if (b != null) {
      s = new BASE64Encoder().encode(b);
    }
    return s;
  }

  /**
   * 解密
   * @param s 待解密数据
   * @return 解密后数据
   */
  public static String decode(String s) {
    byte[] b = null;
    String result = null;
    if (s != null) {
      BASE64Decoder decoder = new BASE64Decoder();
      try {
        b = decoder.decodeBuffer(s);
        result = new String(b, "utf-8");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return result;
  }

  /**
   * 进行多次加密
   * @param data 待加密数据
   * @param times 加密次数
   */
  public static String NTimesEncode(String data, int times) {
    try {
      String temp = data;
      for (int i = 0; i < times; i++) {
        temp = encode(temp);
      }
      return temp;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return data;
  }

  /**
   * 进行多次解密
   * @param data 待解密数据
   * @param times 解密次数
   */
  public static String NTimesDecode(String data, int times) {
    try {
      String temp = data;
      for (int i = 0; i < times; i++) {
        temp = decode(temp);
      }
      return temp;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return data;
  }

}
