package com.bnuz.propertyManagementSystem.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 读取日志线程
 *
 * @Author: Harry
 * @Date: 2019-09-25 16:20
 * @Version 1.0
 */
@Slf4j
public class TailLogThread extends Thread {

    /**
     * 日志文件默认读取大小，单位：KB
     */
    private final int READ_SIZE = 128;
    /**
     * 日志读取返回时间
     */
    private final int TIME_MILLS = 100;
    /**
     * 日志读取每次返回的行数
     */
    private final int READ_LINES = 15;

    private BufferedReader reader;

    private int lineCount = 0;

    /**
     * WebSocket 发送template
     */
    private SimpMessagingTemplate template;
    /**
     * 广播地址
     */
    private String destination;

    public TailLogThread(InputStream in, SimpMessagingTemplate template, String destination) {
        this.reader = new BufferedReader(new InputStreamReader(in));
        this.template = template;
        this.destination = destination;
    }

    @Override
    public void run() {
        StringBuilder reportContent = new StringBuilder();
        long startTime = getTime();
        long tempMill;
        String line;
        try {
            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
                reportContent.append(line).append("\r\n");
                tempMill = getTime();
                // 将实时日志通过WebSocket发送给客户端
                if (lineCount >= READ_LINES || tempMill - startTime >= TIME_MILLS) {
//                    session.getBasicRemote().sendText(reportContent.toString());
                    this.template.convertAndSend(destination,reportContent.toString());
                    startTime = tempMill;
                    lineCount = 0;
                    reportContent.setLength(0);
                } else {
                    lineCount++;
                }
            }
        } catch (IOException e) {
            log.warn("thead read file error:" + e);
        }
    }

    private long getTime() {
        return System.currentTimeMillis();
    }

}