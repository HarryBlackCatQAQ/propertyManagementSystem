package com.bnuz.propertyManagementSystem.websocket;

/**
 * WebSocketLogLockDto WebSocketLog锁信息类
 *
 * @Author: Harry
 * @Date: 2019-09-26 01:53
 * @Version 1.0
 */
public class WebSocketLogLockDto {
    private volatile static WebSocketLogLockDto webSocketLogLockDto;
    private int counter;
    private boolean flag;

    private WebSocketLogLockDto(){
        counter = 0;
        flag = false;
    }

    /**
     * 单例模式
     * @return
     */
    public static WebSocketLogLockDto getInstance(){
        if(webSocketLogLockDto == null){
            synchronized (WebSocketLogLockDto.class){
                if(webSocketLogLockDto == null){
                    webSocketLogLockDto = new WebSocketLogLockDto();
                }
            }
        }

        return webSocketLogLockDto;
    }

    public boolean doByString(String op){
        synchronized (this){
            if(op.equals("add")){
                return add();
            }
            else{
                return sub();
            }
        }
    }

    private boolean add(){
//        print();
        counter++;
        if(!flag){
            flag = true;
            return true;
        }
        return false;
    }

    private boolean sub(){
//        print();
        counter--;
        if(counter <= 0){
            counter = 0;
            flag = false;
            return true;
        }
        return false;
    }

    private void print(){
        System.err.println("flag:" + flag + " counter:" + counter);
    }


    @Override
    public String toString() {
        return "WebSocketLogLockDto{" +
                "counter=" + counter +
                ", flag=" + flag +
                '}';
    }
}
