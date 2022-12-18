import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Socket;

public class Server {
    public static void main(String[] args) {
        ZContext context = new ZContext();
        final String addressOne = "tcp://localhost:8080";
        final String addressTwo = "tcp://localhost:8081";

        ZMQ.Socket socket = context.createSocket(SocketType.REP);

        socket.bind(addressOne);
        socket.bind(addressTwo);


        String message = socket.recvStr();
        if(message.equals("ping")){
            socket.send("pong");
        }else {
            socket.send(message);
        }
    }
}
