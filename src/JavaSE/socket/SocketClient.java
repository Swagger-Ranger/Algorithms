package JavaSE.socket;

import java.io.*;
import java.net.Socket;

/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: SocketClient
 * Author:   liufei32@outlook.com
 * Date:     2018/11/13 21:48
 * Description:socket client通信学习
 * Aha-eureka:
 *******************************************************************************/

public class SocketClient {

    public static void creatSocketClient() throws IOException {
        //客户端
    //1、创建客户端Socket，指定服务器地址和端口
        Socket socket =new Socket("localhost",10086);
    //2、获取输出流，向服务器端发送信息
        OutputStream os = socket.getOutputStream();//字节输出流
        PrintWriter pw =new PrintWriter(os);//将输出流包装成打印流
        pw.write("用户名：admin；密码：123");
        pw.flush();
        socket.shutdownOutput();
    //3、获取输入流，并读取服务器端的响应信息
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String info = null;
        while ((info = br.readLine()) != null) {
            System.out.println("我是客户端，服务器说：\n" + info);
        }

    //4、关闭资源
        br.close();
        is.close();
        pw.close();
        os.close();
        socket.close();
    }

    public static void main( String[] args ) throws IOException {
        creatSocketClient();
    }
}
