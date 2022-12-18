package threaded_chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket connected = serverSocket.accept();

        DataInputStream dataInputStream = new DataInputStream(connected.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(connected.getOutputStream());
        Scanner scanner = new Scanner(System.in);
        ServerReaderThread readerThread = new ServerReaderThread(dataInputStream);
        readerThread.start();

        while (true){
            String message = scanner.nextLine();
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();
        }
    }
}
