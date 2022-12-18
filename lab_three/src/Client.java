import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        String line = dataInputStream.readUTF();
        System.out.println(line);
    }
}
