/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: MyEncryption
 * Author:   liufei32@outlook.com
 * Date:     2018/10/4 16:22
 * Description: 个人密码加密，使用ASCII码散列
 * Aha-eureka:
 *******************************************************************************/

package mylib;

import java.util.Arrays;

public class MyEncryption {

    private long[] encryptNum;//将原文转换成的数字分块
    private char[] cipherBuffer;

    public MyEncryption() {
//        new MyEncryption(5,15);
        this(5, 15);
    }


    private MyEncryption(int encryptNumLength,int cipherLength) {
        encryptNum = new long[encryptNumLength];
        for (int i = 0; i <encryptNum.length ; i++) {
            encryptNum[i] = (long)Math.pow(1993,2);//这里初始化1993的平方是因为平方数必能能够保证95进制下必定存在3位长度
        }

        cipherBuffer = new char[cipherLength];
    }


    //先将字符转化并散列到给定大小的数字块，然后做仿射变换（即拉伸和平移），最后再还原成字符即是密文
    private void affineTransfer(String source) {
        //转化散列字符后做拉伸
        for (int i = source.length() - 1; i >= 0; i--) {
            encryptNum[i % encryptNum.length] = (long) source.charAt(i) * encryptNum[i % encryptNum.length];
        }
        //平移62个数
        for (int i = 0; i < encryptNum.length; i++) {
            encryptNum[i] = encryptNum[i] + 62;
        }

        //还原成字符source
        int cellsize = cipherBuffer.length / encryptNum.length;
        for (int i = 0; i < encryptNum.length; i++) {
            int ciphercell = 0;
            while (ciphercell < cellsize) {
                cipherBuffer[i * cellsize + ciphercell] = (char) (encryptNum[i] % 95 + 32);
                encryptNum[i] = Long.divideUnsigned(encryptNum[i], 95);
                ciphercell++;
            }

        }
    }


    public String getCipher(String source) {
        affineTransfer(source);
        return new String(cipherBuffer);
    }
    public static void main(String[] args) {
        MyEncryption myEncryption = new MyEncryption();
        String s = myEncryption.getCipher("lwx425876github");
        String m = myEncryption.getCipher("19930602" );
        System.out.println(s);
        System.out.println(m);

    }
}
