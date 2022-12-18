import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class Client {
    public static void main(String[] args) {
        ZContext context = new ZContext();

        ZMQ.Socket socket = context.createSocket(SocketType.REQ);
        socket.connect("tcp://localhost:8080");

        socket.send("ping");
        final String message = socket.recvStr();
        System.out.println(message);
    }
}
