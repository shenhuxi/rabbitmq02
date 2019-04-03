package com.zpself;

import com.zpself.rabiitmq.MsgProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zengpeng on 2019/3/28
 */
@SpringBootApplication
@RestController
public class SpringSecurityApplication {
    @Autowired
    private MsgProducer msgProducer;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }
    @GetMapping("/sendMsgA")
    public String sendMsgA(String contans,String acount){
        msgProducer.sendMsgA(contans, acount);
        return "sendMsgA调用成功！  ";
    }
    @GetMapping("/sendMsgB")
    public String sendMsgB(String contans){
        msgProducer.sendMsgB(contans);
        return "sendMsgB调用成功！  ";
    }
    @GetMapping("/RadioBroadcast")//Fanout 就是我们熟悉的广播模式，给Fanout交换机发送消息，绑定了这个交换机的所有队列都收到这个消息。
    public String RadioBroadcast(String contans){
        msgProducer.RadioBroadcast(contans);
        return "sendMsgB调用成功！  ";
    }
}
