import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.*;

public class server1test {
    public static void main(String[] args) {
        Server1 server = new Server1(); // 也可以指定端口号
        try {
            server.runServer1();
        } catch (EOFException e) {
            System.out.println("Server terminated");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}