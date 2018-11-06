package com.hit.cost.validator;

import javax.validation.Constraint;
import java.lang.annotation.*;

/**
 * =========================
 *
 * @Author:fealty
 * @Description:
 * @Date：2018/9/28 15:27
 * <p>
 * Created By IDEA
 * ==========================
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = StrValidatorClass.class)
public @interface StrValidator {

    String values();

    String message() default "值不存在";

    Class<?> [] groups() default {};
}
