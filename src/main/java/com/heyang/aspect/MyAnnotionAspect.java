package com.heyang.aspect;

import com.heyang.annotion.myannotion;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Function;

/**
 * @ProjectName: annotion
 * @Package: com.heyang.aspect
 * @Description: java类作用描述
 * @Author: heyang
 * @CreateDate: 2019/6/16 12:03
 */
@Aspect
@Component
public class MyAnnotionAspect {
    @Pointcut("@annotation(com.heyang.annotion.myannotion)")
    public void myannotion(){

    }
    @Around("myannotion()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        //InvocationHandler
        Function<String, Integer> fun = Integer::parseInt;
        Integer value = fun.apply("123");
        System.out.println(value);
        myannotion my = method.getAnnotation(myannotion.class);
        if(my != null){
            //注解上的描述
           System.out.println(my.type());
        }
        long beginTime = System.currentTimeMillis();
        //执行方法
        Object result = point.proceed();
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;

        //保存日志
        Object[] args = point.getArgs();
        System.out.println(args.toString());
            //String params = String.toJson(args[0]);

            return result;
    }
}
