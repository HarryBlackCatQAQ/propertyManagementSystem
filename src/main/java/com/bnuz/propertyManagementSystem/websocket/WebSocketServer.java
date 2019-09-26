package com.bnuz.propertyManagementSystem.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: Harry
 * @Date: 2019-09-25 18:47
 * @Version 1.0
 */
@Slf4j
@Service
public class WebSocketServer {

    private Process process;

    private InputStream inputStream;

    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        WebSocketServer.applicationContext = applicationContext;
    }

    private WebSocketLogLockDto webSocketLogLockDto = WebSocketLogLockDto.getInstance();

    /**
     * 新的WebSocket请求开启
     */
    public void onOpen(SimpMessagingTemplate template,String s) {
        String path = "";
        try {
            path = getPathById("");
//            System.err.println(path);


            /**
             * 锁判断
             */
            synchronized (WebSocketServer.class){
                // 执行tail -f命令
                if(webSocketLogLockDto.doByString("add")){
                    process = Runtime.getRuntime().exec("tail -f " + path);
                    inputStream = process.getInputStream();
                    TailLogThread thread = new TailLogThread(inputStream, template,s);
                    thread.start();
                }
            }


        } catch (IOException e) {
            log.error(String.format("read file [%s] error.%s", path, e));
        }
    }

    /**
     * WebSocket请求关闭
     */
    public void onClose() {
        /**
         * 锁判断
         */
        synchronized (WebSocketServer.class){
            if(webSocketLogLockDto.doByString("sub")){
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        log.error("close websocket error.:" + e);
                    }
                }

                if (process != null) {
                    process.destroy();
                }
            }
        }
    }


    private String getPathById(String id) {
//        System.out.println(id);
        return "./logs/log_all.log";
    }

}