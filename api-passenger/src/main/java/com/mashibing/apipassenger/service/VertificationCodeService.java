package com.mashibing.apipassenger.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mashibing.apipassenger.remote.ServiceVerificationcodeClient;
import com.mashibing.internalcommon.constant.CommonStatusEnum;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.response.NumberCodeResponse;
import com.mashibing.internalcommon.response.TokenResponse;
import net.sf.json.JSONObject;
import netscape.javascript.JSObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.lang.model.element.NestingKind;
import javax.sound.midi.Soundbank;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: zhoulz
 * @Description: com.mashibing.apipassenger.service
 * @Date: 2023/3/31 - 03 - 31 - 16:22
 */
@Service
public class VertificationCodeService {

    // 把远程调用的接口注入进来
    @Autowired
    private ServiceVerificationcodeClient serviceVerificationcodeClient;

    // 乘客验证码的前缀
    private String verificationCodePrefix = "passenger-verification-code-";

    //操作redis的方式
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 生成验证码
     * @param passengerPhone 乘客手机号
     * @return
     */
    public ResponseResult generatorCode(String passengerPhone){
    //public String generatorCode(String passengerPhone){

        // 1、调用验证码服务，获取验证码
        System.out.println("调用验证码服务，获取验证码！");
        //String code = "111";

        // 调用验证码服务 —— 具体操作：
        ResponseResult<NumberCodeResponse> numberCodeResponse = serviceVerificationcodeClient.getNumberCode(6);
        int numberCode = numberCodeResponse.getData().getNumberCode();

        System.out.println("remote number code : " +  numberCode);

        // 2、存入redis
        System.out.println("存入redis");

        // 存入redis - 具体实现：
        // key,value,过期时间ttl
        // key
        //String key = verificationCodePrefix + passengerPhone;
        // 抽象出来一个  根据手机号生成key  的方法
        String key = generatorKeyByPhone(passengerPhone);

        // value 就是验证码，即上面的numberCode
        // 过期时间定为两分钟

        // 存入redis
        stringRedisTemplate.opsForValue().set(key,numberCode + "",2, TimeUnit.MINUTES);

        ///3、返回值
        /*JSONObject result = new JSONObject();
        result.put("code",1);
        result.put("message","success");

        return result.toString();*/

        // 返回值 —— 具体实现
        // 将上面返回值的类型改为 ResponseResult  —— 参考模块service-veritificationcode下，controller包下的NumberCodeController类
        //return ResponseResult.success();

        // 4、通过短信服务，将对应的验证码发到手机上   ——  后面再实现
        //  借助 ： 阿里短信服务、腾讯短信通、华信、容联  —— 需要收费
        return ResponseResult.success("");
    }

    /**
     * 根据手机号，生成key
     * @param passengerPhone
     * @return
     */
    private String generatorKeyByPhone(String passengerPhone){
        return verificationCodePrefix + passengerPhone;
    }


    /**
     * 校验验证码
     * @param passengerPhone 手机号
     * @param verificationCode 验证码
     * @return
     */
    public ResponseResult checkCode(String passengerPhone,String verificationCode){

        // 1、根据手机号，去redis读取验证码
        System.out.println("1、根据手机号，去redis读取验证码");

        // 1)生成key
        // 不建议直接拷贝 ：拷贝——>抽象一个方法出来
        //String key = verificationCodePrefix + passengerPhone;
        String key = generatorKeyByPhone(passengerPhone);

        // 2)根据key获取value
        String codeRedis = stringRedisTemplate.opsForValue().get(key);
        System.out.println("redis中的value："+codeRedis);


        // 2、校验验证码
        System.out.println("2、校验验证码");
        if (StringUtils.isBlank(codeRedis)){
            return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(),CommonStatusEnum.VERIFICATION_CODE_ERROR.getValue());
        }
        if (!verificationCode.trim().equals(codeRedis.trim())){
            return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(),CommonStatusEnum.VERIFICATION_CODE_ERROR.getValue());
        }


        // 3、判断原来是否有用户，并进行对应的处理
        System.out.println("3、判断原来是否有用户，并进行对应的处理");

        ///4、颁发令牌token
        System.out.println("4、颁发令牌");

        ///5、响应
        //return null;
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken("token value");
        return ResponseResult.success(tokenResponse);
    }


}
