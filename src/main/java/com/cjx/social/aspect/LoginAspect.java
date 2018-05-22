package com.cjx.social.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by 17858 on 2018-05-18.
 */
@Aspect
@Component
public class LoginAspect {

    @Pointcut("execution(* com.cjx.social.service.UserService.addUser(..))")
    public void print(){

    }

    @Before("print()")
    public void before(){
        System.out.println("Before userService...............");
    }

}
