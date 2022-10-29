package cn.wyz.insternalcommon.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;

/**
 * @author wangnanxiang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppException extends RuntimeException {

    private Integer code;

    private String message;
}
