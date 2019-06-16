package com.heyang.annotion;

import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * @ProjectName: annotion
 * @Package: com.heyang.annotion
 * @Description: java类作用描述
 * @Author: heyang
 * @CreateDate: 2019/6/16 11:59
 */
@Target({ElementType.METHOD})
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface myannotion {
     public String type();
     public String description() default "123";
}
