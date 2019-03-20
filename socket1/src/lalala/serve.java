package lalala;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.*;
public class serve extends Thread {
    // 发送消息的线程
    Socket socket;
    serve(Socket a){
        socket=a;
    }
    public void run() {
        try {
            System.out.println("服务器在启动中...等待用户的连接");
            //一直接收用户的连接，连接之后发送一条短信给用户
            OutputStream os = socket.getOutputStream();
            System.out.println(socket.getInetAddress().getHostAddress() + "连接上了！");
            InputStream is = socket.getInputStream();
            PrintStream writer=new PrintStream(os);
            Scanner inputMan=new Scanner(System.in);
            os.write("open1".getBytes());
            byte[] bf=new byte[1000];
            int len=0;
            while (((len = is.read(bf))) != -1) {
                System.out.println("已和客户端连接");
                System.out.println("接收到客户端的数据： " + new String(bf));
                break;
            }
            writer.println("已接收到数据");
            System.out.println("收到数据了");
            writer.flush();
            socket.shutdownOutput();
            is.close();
            writer.close();
            os.close();
            inputMan.close();
        }
        catch (IOException e) {
            System.out.println("迷失在外太空");
            e.printStackTrace();
        }
    }
}

