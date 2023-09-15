import org.apache.xmlrpc.server.*;
import org.apache.xmlrpc.webserver.*;

public class JavaWebService
{
    public int sum(int x, int y)
    {
        return x+y;
    }
    public static void main (String [] args)
    {
        try {
            System.out.println("Attempting to start XML-RPC Web Serviece...");
            WebServer webServer = new WebServer(8080);
            XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();

            PropertyHandlerMapping phm = new PropertyHandlerMapping();
            phm.addHandler("sample", JavaWebService.class);
            xmlRpcServer.setHandlerMapping(phm);

            webServer.start();
            System.out.println("Started successfully.");
            System.out.println("Accepting requests");
        }
        catch (Exception exception) {
            System.err.println("Java Web Service: " + exception);
        }
    }
}
