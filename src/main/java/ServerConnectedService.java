import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/serverConnected")
public class ServerConnectedService
{
    @GET
    public String connected(){
        return "Started Server!";
    }
}
