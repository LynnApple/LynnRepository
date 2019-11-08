package cn.ngmc.security;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
@Aspect
public class SecurityHandler{

    @Before("execution(* getUser(..))")
    public void checkSecurity(){
        System.out.println("----checkSecurity----");
    }


}
