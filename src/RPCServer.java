import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RPCServer {

    public static void main(String args[]) {
        System.out.println("Starting server...");
        try {
            EchoService server = new EchoServiceImpl();

            System.out.println("Creating stub...");
            // Create a stub
            EchoService stub = (EchoService) UnicastRemoteObject.exportObject((EchoService) server, 0);

            System.out.println("Creating registry...");
            // Create a registry
            Registry registry = LocateRegistry.createRegistry(1337);

            // Bind the stub to the registry
            System.out.println("Binding stub to registry...");
            registry.bind("EchoService", stub);

            System.out.println("Done.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
