package com.yibo.controller;

import com.baidu.fsg.uid.UidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: huangyibo
 * @Date: 2019/10/20 14:42
 * @Description:
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private UidGenerator uidGenerator;

    @GetMapping("/uid")
    public String uid(){
        long time1 = System.nanoTime();
        long uid = uidGenerator.getUID();
        long time2 = System.nanoTime();
        System.out.println(time2-time1);
        System.out.println(uidGenerator.parseUID(uid));
        System.out.println("-----------------------------");
        long timeMillis = System.currentTimeMillis();
        for (int i = 0; i < 10000000 ; i++) {
            uidGenerator.getUID();
        }
        long timeMillis2 = System.currentTimeMillis();
        System.out.println("耗时:"+(timeMillis2-timeMillis));
        return String.valueOf(uid);
    }
}

