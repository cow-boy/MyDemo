package com.example.demo;/**
 * Created by huxu on 2017/9/2.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HUXU
 * @create 2017-09-02 23:11
 **/
@RestController
public class Demo {

    @RequestMapping("/hello")
    public String index1() {
        return "Hello World";
    }

    @RequestMapping("/")
    public String index() {
        return "Hello";
    }

}
