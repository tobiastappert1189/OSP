import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Server.Database.ConnectionManager;
import Server.Pojo.User;
import Server.Resource.UserRepositorie;

@Path("/hello-world")
public class HelloWorld {

    UserRepositorie userRepositorie = new UserRepositorie();

    @POST
    @Path("/test")
    @Consumes(MediaType.APPLICATION_JSON)
    public String getClichedMessage(User user) {
        userRepositorie.createUser(user);
        System.out.println("ready");
        return "Hello, World!";
    }

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getClichedMessage() {
        return userRepositorie.getUsers();
    }

    @GET
    @Path("/users/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getClichedMessage(@PathParam("id") int id) {
        return userRepositorie.getUser(id);
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(User user) {
        userRepositorie.updateUser(user);
    }
}