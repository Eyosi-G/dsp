import java.rmi.RemoteException;

public class PingServiceImpl implements PingService{
    @Override
    public String ping() throws RemoteException {
        return "Pong";
    }
}
