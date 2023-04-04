package com.mashibing.apipassenger.remote;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.response.NumberCodeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: zhoulz
 * @Description: com.mashibing.apipassenger.remote
 * @Date: 2023/4/4 - 04 - 04 - 13:46
 */
@FeignClient("service-verificationcode")
public interface ServiceVerificationcodeClient {

    /*@RequestMapping(method = RequestMethod.GET , value = "/numberCode/6")
    ResponseResult<NumberCodeResponse> getNumberCode();*/

    // 上面写死了

    @RequestMapping(method = RequestMethod.GET , value = "/numberCode/{size}")
    ResponseResult<NumberCodeResponse> getNumberCode(@PathVariable("size") int size);

}
