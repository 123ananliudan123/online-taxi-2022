package com.mashibing.apipassenger.request;

import lombok.Data;

/**
 * @Auther: zhoulz
 * @Description: com.mashibing.apipassenger.request
 * @Date: 2023/3/31 - 03 - 31 - 16:15
 */

@Data
public class VertificationCodeDTO {

    private String passengerPhone;

    private String verificationCode;

    /*public String getPassengerPhone() {
        return passengerPhone;
    }
    public void setPassengerPhone(String passengerPhone) {
        this.passengerPhone = passengerPhone;
    }*/
}
