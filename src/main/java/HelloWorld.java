import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Server.Database.ConnectionManager;
import Server.Pojo.User;
import Server.Resource.UserResource;

@Path("/hello-world")
public class HelloWorld {

    UserResource userResource = new UserResource();

    @GET
    @Produces("text/plain")
    public String getClichedMessagee() {

        ConnectionManager connectionManager = new ConnectionManager();
        ConnectionManager.getConnection();
        System.out.println("ready");
        return "Hello, World!";
    }

    @POST
    @Path("/test")
    @Consumes(MediaType.APPLICATION_JSON)
    public String getClichedMessage(User user) {
        userResource.createUser(user);
        System.out.println("ready");
        return "Hello, World!";
    }

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getClichedMessage() {

        return userResource.getUsers();
    }

    @GET
    @Path("/users/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getClichedMessage(@PathParam("id") int id) {
        return userResource.getUser(id);
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(User user) {
        userResource.updateUser(user);
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUser(@PathParam("id") int id) {
        User user = userResource.getUser(id);
        if(user.getId()!= 0){
            userResource.deleteUser(id);
        }
    }
}