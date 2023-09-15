import java.util.*;
import org.apache.xmlrpc.*;
import java.net.*;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

public class JavaClient
{
    public static void main (String [] args)
    {
        try {
            XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            config.setServerURL(new URL("http://localhost:8080"));

            XmlRpcClient server = new XmlRpcClient();
            server.setConfig(config);
            Vector params = new Vector();
            Scanner in = new Scanner(System.in);
            System.out.print("Input a: ");
            int a = in.nextInt();
            System.out.print("Input b: ");
            int b = in.nextInt();
            try {
                a = Integer.parseInt(args[0]);
                b = Integer.parseInt(args[1]);
            }

            catch(Exception e){System.out.println("Error: "+e);}
            params.addElement(a);
            params.addElement(b);
            Object result = server.execute("sample.sum", params);
            int sum = ((Integer) result).intValue();
            System.out.println("The sum is: "+ sum);
        } catch (Exception exception) {
            System.err.println("JavaClient: " + exception); }
    }
}