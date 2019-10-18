package com.bnuz.propertyManagementSystem.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

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
            os.flush();
            os.close();
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

    public boolean delFile(String path){
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        file.delete();
        return true;
    }

    public void copyFile(String oldPath, String newPath,String mkdirPath) {
        InputStream inStream = null;
        FileOutputStream fs = null;
        try {
            (new File(mkdirPath)).mkdirs();
            int bytesum = 0;
            int byteread = 0;

            File oldfile = new File(oldPath);
            if (oldfile.exists()) { //文件存在时
                inStream = new FileInputStream(oldPath); //读入原文件
                fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                int length;
                while ( (byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; //字节数 文件大小
//                    System.out.println(bytesum);
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        }
        catch (Exception e) {
            System.out.println("复制单个文件操作出错");
            e.printStackTrace();

        }finally {
            try{
                if(fs != null){
                    fs.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(inStream != null){
                    inStream.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 复制整个文件夹内容
     * @param oldPath String 原文件路径 如：c:/fqf
     * @param newPath String 复制后路径 如：f:/fqf/ff
     * @return boolean
     */
    public void copyFolder(String oldPath, String newPath) {

        try {
            (new File(newPath)).mkdirs(); //如果文件夹不存在 则建立新文件夹
            File a=new File(oldPath);
            String[] file=a.list();
            File temp=null;
            for (int i = 0; i < file.length; i++) {
                if(oldPath.endsWith(File.separator)){
                    temp=new File(oldPath+file[i]);
                }
                else{
                    temp=new File(oldPath+File.separator+file[i]);
                }

                if(temp.isFile()){
                    FileInputStream input = new FileInputStream(temp);
                    FileOutputStream output = new FileOutputStream(newPath + "/" +
                            (temp.getName()).toString());
                    byte[] b = new byte[1024 * 5];
                    int len;
                    while ( (len = input.read(b)) != -1) {
                        output.write(b, 0, len);
                    }
                    output.flush();
                    output.close();
                    input.close();
                }
                if(temp.isDirectory()){//如果是子文件夹
                    copyFolder(oldPath+"/"+file[i],newPath+"/"+file[i]);
                }
            }
        }
        catch (Exception e) {
            System.out.println("复制整个文件夹内容操作出错");
            e.printStackTrace();

        }

    }

    public void downFile(HttpServletResponse response,String filename,String filepath){
        boolean flag = false;
        if (filename != null) {
            File file = new File(filepath);
            // 如果文件存在，则进行下载
            if (file.exists()) {
                // 配置文件下载
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                // 下载文件能正常显示中文
                try {
                    response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                // 实现文件下载
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;

                try {
                    fis = new FileInputStream(file);
                    OutputStream os = response.getOutputStream();
                    writeFile(fis,os);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }

    }
}