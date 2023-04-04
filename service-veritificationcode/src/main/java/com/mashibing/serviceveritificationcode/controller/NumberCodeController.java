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
    /*public String numberCode(@PathVariable("size") int size){
        System.out.println("size:"+size);
        //生成验证码
        double mathRandom = (Math.random()*9 + 1) * (Math.pow(10,size-1));
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
        double mathRandom = (Math.random()*9 +1 ) * (Math.pow(10,size-1));
        System.out.println(mathRandom);
        int resultInt = (int)mathRandom;
        System.out.println("generator src code:"+resultInt);

        /*
        * 因为：该生成验证码的方法numberCode()的返回值为string。这样的话，每次生成
        * 验证码的步骤都比较繁琐，不方便，如29-34行.
        *
        * 解决：统一将返回值进行包装。
        *
        * 下面写法的思路：
        * 1、先定义了一个公共模块internal-common：
        *      1）在常量包constant先定义错误/成功类型 —— 通过枚举的方式
        *      2) 继续优化冗的写法(json的方式)。在dto包下 —— 包装统一的返回值，包含code、message、data信息
        *         在里面自定义成功和失败的响应方法
        *      3）再定义一个java对象，里面放生成的验证码的值。即上面生成的resultInt。
        *
        * */

        // 定义返回值
        NumberCodeResponse response = new NumberCodeResponse();
        response.setNumberCode(resultInt);

        return ResponseResult.success(response);
    }

}
