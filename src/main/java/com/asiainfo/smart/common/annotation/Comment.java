package com.asiainfo.smart.common.annotation;

import java.lang.annotation.*;

/**
 * @author king-pan
 * @date 2018/12/7
 * @Description 用于解释和说明类、方法、属性
 */
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Comment {

    /**
     * 注解内容
     */
    String value() default "";

}