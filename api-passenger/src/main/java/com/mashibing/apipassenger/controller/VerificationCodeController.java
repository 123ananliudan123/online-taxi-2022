package com.mashibing.apipassenger.controller;


import com.mashibing.apipassenger.request.VertificationCodeDTO;
import com.mashibing.apipassenger.service.VertificationCodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationCodeController {

    private VertificationCodeService vertificationCodeService;

    @GetMapping("/vertification-code")
    public String vertificationCode(@RequestBody VertificationCodeDTO vertificationCodeDTO){

        String passengerPhone = vertificationCodeDTO.getPassengerPhone();
        System.out.println("接收到的手机号参数为："+passengerPhone);

        // 接下来要调用（service中）生成验证码的方法
        return vertificationCodeService.generatorCode(passengerPhone);

    }



}
