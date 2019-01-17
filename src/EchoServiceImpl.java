import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Implement the echo service
public class EchoServiceImpl implements EchoService {

    @Override
    public String echoMessage(String message) {
        String msg = "EchoService says: " + message;
        return msg;
    }
}
