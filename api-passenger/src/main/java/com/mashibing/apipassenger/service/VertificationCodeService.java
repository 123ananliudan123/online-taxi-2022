package com.mashibing.apipassenger.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mashibing.apipassenger.remote.ServiceVerificationcodeClient;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.response.NumberCodeResponse;
import net.sf.json.JSONObject;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.lang.model.element.NestingKind;
import javax.sound.midi.Soundbank;

/**
 * @Auther: zhoulz
 * @Description: com.mashibing.apipassenger.service
 * @Date: 2023/3/31 - 03 - 31 - 16:22
 */
@Service
public class VertificationCodeService {

    @Autowired
    private ServiceVerificationcodeClient serviceVerificationcodeClient;

    public String generatorCode(String passengerPhone){

        // 1、调用验证码服务，获取验证码
        System.out.println("调用验证码服务，获取验证码！");
        //String code = "111";

        // 调用验证码服务 —— 具体操作：
        ResponseResult<NumberCodeResponse> numberCodeResponse = serviceVerificationcodeClient.getNumberCode(6);
        int numberCode = numberCodeResponse.getData().getNumberCode();

        System.out.println("remote number code " +  numberCode);


        // 2、存入redis
        System.out.println("存入redis");

        ///3、返回值
        JSONObject result = new JSONObject();
        result.put("code",1);
        result.put("message","success");

        return result.toString();

    }

}
