package JavaEE.annotation.annoDemo;

/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: PasswordUtils
 * Author:   liufei32@outlook.com
 * Date:     2018/12/2 2:05
 * Description: 注解使用类
 * Aha-eureka:
 *******************************************************************************/

public class PasswordUtils {

    /**
     * \W匹配字母或数字或下划线或汉字,\D表示匹配数字
     * \W和\w的区别
     * \w :匹配包括下划线的任何单词字符,等价于 [A-Z a-z 0-9_]
     * \W :匹配任何非单词字符,等价于 [^A-Z a-z 0-9_]
     * 前面之所以加上了两个\因为是字符中使用第一个\代表转义
     * */
    @UserCase.UseCase(id = "47", description = "this is the Swagger-Ranger's first annotation demo")
    public boolean validatePassword( String password ) {
        return (password.matches("\\w*\\W*\\d"));
    }

    @UserCase.UseCase(id = "48")
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }
}
