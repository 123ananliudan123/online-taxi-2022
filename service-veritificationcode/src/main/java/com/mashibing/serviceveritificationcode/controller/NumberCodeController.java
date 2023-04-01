package com.mashibing.serviceveritificationcode.controller;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.response.NumberCodeResponse;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: zhoulz
 * @Description: com.mashibing.serviceveritificationcode.controller
 * @Date: 2023/4/1 - 04 - 01 - 10:54
 */
@RestController
public class NumberCodeController {

    @GetMapping("/numberCode/{size}")

    public ResponseResult numberCode(@PathVariable("size") int size){
    //public String numberCode(@PathVariable("size") int size){
        System.out.println("size:"+size);
        // 生成验证码
        /*double mathRandom = (Math.random()*9 + 1) * (Math.pow(10,size-1));
        System.out.println(mathRandom);
        int resultInt = (int)mathRandom;
        System.out.println(resultInt);

        JSONObject result = new JSONObject();
        result.put("code",1);
        result.put("message","success");
        JSONObject data = new JSONObject();
        data.put("numberCode",data);
        result.put("data",data);

        return result.toString();*/

        // 上面: 初始的写法（过渡）

        System.out.println("size:"+size);
        // 生成验证码
        double mathRandom = (Math.random()*9 + 1) * (Math.pow(10,size-1));
        System.out.println(mathRandom);
        int resultInt = (int)mathRandom;
        System.out.println("generator src code:"+resultInt);

        // 定义返回值
        NumberCodeResponse response = new NumberCodeResponse();
        response.setNumberCode(resultInt);

        return ResponseResult.success(response);
    }

}
