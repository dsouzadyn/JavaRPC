import java.rmi.Remote;
import java.rmi.RemoteException;


// Create the service interface which extends Remote
public interface EchoService extends Remote {
    String echoMessage(String message) throws RemoteException;
}
