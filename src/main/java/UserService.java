import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Server.Pojo.Sex;
import Server.Pojo.User;
import Server.Pojo.UserFromResponse;
import Server.Resource.SexResource;
import Server.Resource.UserResource;

@Path("/user")
public class UserService
{

    UserResource userResource = new UserResource();
    SexResource sexResource = new SexResource();

    @GET
    @Path("/allUser")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> allUser() {
        return userResource.getUsers();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(User user) {
        userResource.updateUser(user);
    }

    @POST
    @Path("/createUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUser(UserFromResponse userFromResponse)
    {
        String sexString = userFromResponse.getSex();

        Sex sex = new Sex();
        sex.setDiscription(sexString);
        int sexId = sexResource.createSexx(sex);

        String userName = userFromResponse.getUserName();
        int id = userFromResponse.getId();
        String mail = userFromResponse.getMail();
        String password = userFromResponse.getPassword();
        boolean isManager = userFromResponse.isManager();

        User user = new User(userName, mail, password, isManager, id, sexId);
        userResource.createUser(user);
    }

    @GET
    @Path("/getUser/{userName}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserFromResponse getUserByUsernameAndPassword(@PathParam("userName") String userName,@PathParam("password") String password) {
        User user = userResource.getAuth(userName, password);
        Sex sex = sexResource.getSex(user.getSex());
        String sexString = sex.getDiscription();

        int id = user.getId();
        String mail = user.getMail();
        boolean isManager = user.isManager();

        return new UserFromResponse(id, userName, mail, password, isManager, sexString);
    }
}