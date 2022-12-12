import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry();
        PingService pingService = (PingService) registry.lookup("PingPongService");
        String response = pingService.ping();
        System.out.println(response);
    }
}
