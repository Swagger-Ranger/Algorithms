package JavaEE.annotation.annoDemo;

import JavaEE.annotation.annoDemo.UserCase.UseCase;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: UseCaseTest
 * Author:   liufei32@outlook.com
 * Date:     2018/12/2 2:14
 * Description: Test
 * Aha-eureka:
 *******************************************************************************/

public class UseCaseTest {

    public static void main( String[] args ) {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUseCases(useCases,PasswordUtils.class);
    }

    static void trackUseCases( List<Integer> useCases, Class<?> cl ) {
        for (Method m : cl.getDeclaredMethods()) {
            //获得注解对象,get the obnect of annotation
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println("Found Use Case:" + uc.id() + " +" +
                        uc.description());
                useCases.remove(new Integer((uc.id())));
            }
        }

        for (int i : useCases) {
            System.out.println("Warning: Missing use case-" + i);
        }
    }
}
