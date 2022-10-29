package cn.wyz.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangnanxiang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VerificationCodeDTO {

    private String passengerPhone;

    private String verificationCode;
}
