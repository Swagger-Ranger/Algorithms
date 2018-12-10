package JavaEE.annotation.annoDemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: UserCase
 * Author:   liufei32@outlook.com
 * Date:     2018/12/2 2:02
 * Description: Java注解示例
 * Aha-eureka:
 *******************************************************************************/

public interface UserCase {


    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface UseCase {
        public String id();

        public String description() default "no description";
    }
}

