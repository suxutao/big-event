package org.example.anno;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.validation.StateValidation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {StateValidation.class})
public @interface State {
    //提供校验失败的提示信息
    String message() default "{state参数的值只能是草稿或已发布}";
    //指定分组
    Class<?>[] groups() default {};
    //负载
    Class<? extends Payload>[] payload() default {};
}
