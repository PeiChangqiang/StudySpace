package com.pcq.react.proxypattern;


import com.pcq.inter.IMsgService;

public class MsgHandler implements IMsgService {
    @Override
    public void send() {//ֻ���ķ�����Ϣ�����ҵ���߼�
        System.out.println("send msg......");
    }
}
