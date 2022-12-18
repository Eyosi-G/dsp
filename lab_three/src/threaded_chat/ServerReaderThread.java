package threaded_chat;

import java.io.DataInputStream;
import java.io.IOException;

public class ServerReaderThread extends  Thread{
    private final DataInputStream dataInputStream;

    public ServerReaderThread(DataInputStream dataInputStream) {
        this.dataInputStream = dataInputStream;
    }

    @Override
    public void run() {
        super.run();
        try {
            String message = dataInputStream.readUTF();
            while (message != "STOP"){
                System.out.println("Client: " + message);
                message = dataInputStream.readUTF();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
