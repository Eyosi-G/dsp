import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket connected  = serverSocket.accept();
        DataOutputStream dataOutputStream = new DataOutputStream(connected.getOutputStream());
        dataOutputStream.writeUTF("Hello World");
        dataOutputStream.flush();
    }
}
