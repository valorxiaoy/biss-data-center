package com.iyungu.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: yueyang@iyungu.com
 * @Description:
 * @Date: Created in 16:09 2018/4/18
 * @Modified By:
 */
@Target({ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PathVariable {
    String param() default "";
}