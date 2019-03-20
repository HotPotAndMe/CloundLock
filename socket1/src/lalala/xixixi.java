package lalala;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.Socket;
public class xixixi {
    public static void main(String[] args) {
        try{
            ServerSocket server=new ServerSocket(1500);
            System.out.println("正在等待连接...");
            while(true) {
                Socket socket = server.accept();
                serve serverthread=new serve(socket);
                serverthread.start();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}