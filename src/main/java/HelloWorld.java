
import javax.ws.rs.GET;
        import javax.ws.rs.Path;
        import javax.ws.rs.Produces;

import Server.Database.ConnectionManager;

@Path("/hello-world")
public class HelloWorld {

    @GET
    @Produces("text/plain")
    public String getClichedMessage() {

        ConnectionManager connectionManager = new ConnectionManager();
        ConnectionManager.getConnection();
        System.out.println("ready");
        return "Hello, World!";
    }
}