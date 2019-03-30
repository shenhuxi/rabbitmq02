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
   /* @GetMapping("/hello")
    public String hello(){
        return "hello萨达萨达撒  ";
    }*/
   @GetMapping("/hello")
   public String hello(String contans){
       msgProducer.sendMsg(contans);
       return "hello萨达萨达撒  ";
   }
}
