package com.hit.cost.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * =========================
 *
 * @Author:fealty
 * @Description:
 * @Date：2018/10/8 19:14
 * <p>
 * Created By IDEA
 * ==========================
 */
public class StrValidatorClass implements ConstraintValidator<StrValidator,Object> {
    private String values;

    @Override
    public void initialize(StrValidator constraintAnnotation) {
      this.values = constraintAnnotation.values();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
