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
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
    String value() default "";

    /**
     * 是否为序列号
     *
     * @return
     */
    boolean id() default false;

    /**
     * 字段名称
     *
     * @return
     */
    String name() default "";

    /**
     * 字段描述
     *
     * @return
     */
    String description() default "";

    /**
     * 方法类型
     *
     * @return
     */
    String methodType() default "";
}