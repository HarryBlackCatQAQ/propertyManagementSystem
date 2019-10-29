package com.bnuz.propertyManagementSystem.tp;

import java.io.*;

/**
 * @Author: Harry
 * @Date: 2019-10-23 01:21
 * @Version 1.0
 */
public class test {
    /**
     * Java代码实现MySQL数据库导出
     * @param ip MySQL数据库所在服务器地址IP
     * @param host 数据库端口号
     * @param userName 进入数据库所需要的用户名
     * @param password 进入数据库所需要的密码
     * @param databaseName 要导出的数据库名
     * @param savePath 数据库导出文件保存路径
     * @param fileName 数据库导出文件文件名
     * @return 返回true表示导出成功，否则返回false。
     * @throws IOException
     */
    public static void exportDatabaseTool(String ip, String host, String userName, String password, String databaseName, String savePath, String fileName) throws IOException {
        File saveFile = new File(savePath);
        if (!saveFile.exists()) {// 如果目录不存在
            saveFile.mkdirs();// 创建文件夹
        }
        if(!savePath.endsWith(File.separator)){
            savePath = savePath + File.separator;
        }
//        "/Users/harry/logs/"
        String cmd[] = new String[]{"/bin/sh", "-c", "/usr/local/mysql/bin/mysqldump --opt " +
                "-u" + userName
                + " -p" + password
                + " -P" + host
                + " " + databaseName
                + "> " + savePath
                + databaseName+"-`date '+%Y-%m-%d %H:%M:%S'`.sql"};

        String ss = "";
        for(String s:cmd){
            ss += s;
        }
        System.err.println(ss);

        Runtime.getRuntime().exec(cmd);
    }

    public static void main(String[] args) {
        try {
            exportDatabaseTool("127.0.0.1","3306","root","7894456klj",
                    "property_management_system","./dataBase","my.sql");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}