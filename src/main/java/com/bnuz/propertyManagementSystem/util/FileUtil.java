package com.bnuz.propertyManagementSystem.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * @Author: Harry
 * @Date: 2019-10-14 16:58
 * @Version 1.0
 */

@Component
@Slf4j
public class FileUtil {

    /**
     * 获取文件后缀
     * @param fileName
     * @return
     */
    public String getFileSuffix(String fileName){
        int start = fileName.indexOf(".");
        if(start == -1){
            return "null";
        }
        return fileName.substring(start);
    }

    /**
     * 获取文件名
     * @param fileName
     * @return
     */
    public String getFileNameWithOutSuffix(String fileName){
        int end = fileName.indexOf(".");
        if(end == -1){
            return "null";
        }
        return fileName.substring(0,end);
    }

    /**
     * 同时获取文件名和后缀
     * @param fileName
     * @return
     */
    public String[] getFileNameSplitSuffix(String fileName){
        String[] ans = new String[2];

        ans[0] = getFileNameWithOutSuffix(fileName);
        ans[1] = getFileSuffix(fileName);

        return ans;
    }

    /**
     * 创建存在在的路径文件/文件夹
     * @param strPath
     * @throws IOException
     */
    public void  mkDirs(String strPath) throws IOException {
        File file = new File(strPath);
        if (!file.exists()) {
            file.mkdirs();
        }

    }

    /**
     * 写入文件
     * @param in
     * @param os
     * @return
     */
    public boolean writeFile(FileInputStream in, OutputStream os) {
        if (os == null || in == null) {
            return false;
        }

        byte[] buffer = new byte[1024];
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fis = in;
            bis = new BufferedInputStream(fis);
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    /**
     * 删除文件夹
     * @param folderPath
     */
    public void delFolder(String folderPath) {
        try {
            delAllFile(folderPath); //删除完里面所有内容
            String filePath = folderPath;
            filePath = filePath.toString();
            java.io.File myFilePath = new java.io.File(filePath);
            myFilePath.delete(); //删除空文件夹
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除指定文件夹下的所有文件
     * @param path
     * @return 返回是否删除成功
     */
    public boolean delAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        if(tempList == null){
            return flag;
        }
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            }
            else {
                temp = new File(path + File.separator + tempList[i]);
            }

            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delAllFile(path + "/" + tempList[i]);//先删除文件夹里面的文件
                delFolder(path + "/" + tempList[i]);//再删除空文件夹
                flag = true;
            }
        }
        return flag;
    }
}