package com.didispace.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 翟永超
 * @create 2017/4/15.
 * @blog http://blog.didispace.com
 */
@RestController
public class SendController {

    @Autowired
    SinkSender sinkSender;

    @GetMapping("/test/send")
    public String dc() {
        sinkSender.send("some hello world");
        return "ok sent some hello world";
    }

}
