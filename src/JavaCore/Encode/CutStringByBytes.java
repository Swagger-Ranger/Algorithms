package JavaCore.Encode;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: CutStringByBytes
 * @Author: liufei32@outlook.com
 * @Date: 2019/5/14 14:38
 * @Description: 截取带汉字的字符串
 * @Aha-eureka:
 *******************************************************************************/

public class CutStringByBytes {
    public static void main(String[] args) throws UnsupportedEncodingException {

//        System.out.println("utf-8---> gbk" + new String("中文转英文ABCD".getBytes("gbk"), "gbk"));
//        System.out.println("utf-8---> gbk" + new String("中文转英文ABCD".getBytes("ascii"), "gbk"));
//        System.out.println("中文转英文ABCD".length());
//        System.out.println(Arrays.toString(t.getBytes()));

//        System.out.println(cut("中文转ADF", 10));
//        System.out.println('文');

        BinaryOperator<Long> addExplicit = ( Long x, Long y) ->x+y;
        System.out.println(addExplicit.apply(1L, 3L));
    }


    /**
     * 根据对应编码按字节长度截取字符串，中文不能出现半个和乱码
     * @param str
     * @param i
     * @return
     */
    private static String cut( String str, int i ) {

        byte[] result = str.getBytes();
        int result_Length_bytes = 0;

        for (int j = 0; j < str.length(); j++) {

            String temp = String.valueOf(str.charAt(j));
            int m = temp.getBytes().length;

            if (m > 1) {
                if (result_Length_bytes + m > i) break;
                result_Length_bytes = result_Length_bytes + m;
            } else if (m == 1) {
                if (result_Length_bytes + m > i) break;
                result_Length_bytes++;
            }
        }

        return new String(Arrays.copyOfRange(result, 0, result_Length_bytes));
    }


    //通过字节数截取字符串
    private static String cutString(String str, int i) {
        String tempStr;
        StringBuilder resultStr=new StringBuilder();
        int len;
        int sum=0;

        for(int j=0;j<str.length();j++){
            tempStr=String.valueOf(str.charAt(j));
            len=tempStr.getBytes().length;

            //判断是否是汉字
            if(len>1){
                sum=sum+len;
                //判断字节数是否已越界
                if(sum<=i){
                    resultStr.append(tempStr);
                }else{
                    break;
                }
            }else{
                sum=sum+1;
                if(sum<=i){
                    resultStr.append(tempStr);
                }else{
                    break;
                }
            }
        }
        return resultStr.toString();
    }
}
