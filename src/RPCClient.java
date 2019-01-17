import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class RPCClient {
    public static void main(String args[]) {
        String message = "";
        Scanner sc = new Scanner(System.in);
        try {
            // Fetch the registry
            Registry registry = LocateRegistry.getRegistry(1337);

            // lookup service
            EchoService server = (EchoService) registry.lookup("EchoService");
            while (true) {
                System.out.print("Enter message: ");
                message = sc.next();
                String response = server.echoMessage(message);
                System.out.println(response);
                message = "";
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
