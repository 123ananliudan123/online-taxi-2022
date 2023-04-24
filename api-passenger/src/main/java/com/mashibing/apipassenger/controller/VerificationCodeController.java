package com.mashibing.apipassenger.controller;

import com.mashibing.apipassenger.request.VertificationCodeDTO;
import com.mashibing.apipassenger.service.VertificationCodeService;
import com.mashibing.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationCodeController {

    @Autowired
    private VertificationCodeService vertificationCodeService;

    @GetMapping("/verification-code")
    //public ResponseResult vertificationCode(@RequestBody VertificationCodeDTO vertificationCodeDTO){
    public String vertificationCode(@RequestBody VertificationCodeDTO vertificationCodeDTO){

        String passengerPhone = vertificationCodeDTO.getPassengerPhone();
        System.out.println("接收到的手机号参数为："+passengerPhone);

        // 接下来要调用（service中的）生成验证码的方法
        return vertificationCodeService.generatorCode(passengerPhone);
    }

}
