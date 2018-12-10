package JavaSE.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: URLDemo
 * Author:   liufei32@outlook.com
 * Date:     2018/11/13 22:13
 * Description: URL学习
 * Aha-eureka:
 *******************************************************************************/

public class URLDemo {
    public static void getURL() throws MalformedURLException {
        //创建一个URL的实例
        URL baidu =new URL("http://www.baidu.com");
        URL url =new URL(baidu,"/index.html?username=tom#test");//？表示参数，#表示锚点
        /**
         * 参数与锚点：
         * #代表网页中的一个位置。其右面的字符，就是该位置的标识符。比如，http://www.example.com/index.html#print就代表网页index.html的print位置。浏览器读取这个URL后，会自动将print位置滚动至可视区域。
         * 为网页位置指定标识符，有两个方法。一是使用锚点，比如<a name="print"></a>，二是使用id属性，比如<div id="print">。
         * #是用来指导浏览器动作的，对服务器端完全无用。所以，HTTP请求中不包括#。
         * ?:连接作用，也可以用来清除缓存，后面一般跟参数
         * &:不同参数之间的间隔符
         * */
        String protocal = url.getProtocol();//获取协议
        String host = url.getHost();//获取主机
        int port = url.getPort();//如果没有指定端口号，根据协议不同使用默认端口。此时getPort()方法的返回值为 -1
        String path = url.getPath();//获取文件路径
        String fileName = url.getFile();//文件名，包括文件路径+参数
        String refPath = url.getRef();//相对路径，就是锚点，即#号后面的内容
        String para = url.getQuery();//查询字符串，即参数

        System.out.println(" the url:http://www.baidu.com/index.html?username=tom#test" + "\n" +
                "protocal: " + protocal + "\n"+
                "host: " + host + "\n"+
                "port: " + port + "\n"+
                "refpath: " + refPath + "\n"
        );
    }

    public static void getURLStream() throws IOException {
        //使用URL读取网页内容
        //创建一个URL实例
        URL url =new URL("http://www.baidu.com");
        InputStream is = url.openStream();//通过openStream方法获取资源的字节输入流
        InputStreamReader isr =new InputStreamReader(is,"UTF-8");//将字节输入流转换为字符输入流,如果不指定编码，中文可能会出现乱码
        BufferedReader br =new BufferedReader(isr);//为字符输入流添加缓冲，提高读取效率
        char datas = (char) isr.read();
//        System.out.println("-------------" + datas);
        String data = br.readLine();//读取数据
        while(data!=null){
            System.out.println(data);//输出数据
            data = br.readLine();
        }
        br.close();
        isr.close();
        is.close();
    }

    public static void main( String[] args ) throws IOException {
//        getURL();
        getURLStream();
    }

}
