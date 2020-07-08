package com.pcq.react.proxypattern;


import com.pcq.inter.IMsgService;

public class MsgHandler implements IMsgService {
    @Override
    public void send() {//只关心发送消息的相关业务逻辑
        System.out.println("send msg......");
    }
}
