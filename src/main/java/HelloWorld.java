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
import Server.Pojo.Sex;
import Server.Pojo.User;
import Server.Pojo.UserFromResponse;
import Server.Pojo.WishedPerson;
import Server.Resource.SexResource;
import Server.Resource.UserResource;
import Server.Resource.WishedPersonResource;

@Path("/hello-world")
public class HelloWorld {

    UserResource userResource = new UserResource();
    SexResource sexResource = new SexResource();
    WishedPersonResource wishedPersonResource = new WishedPersonResource();


    /*
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



    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUser(@PathParam("id") int id) {
        User user = userResource.getUser(id);
        if(user.getId()!= 0){
            userResource.deleteUser(id);
        }
    }


    @GET
    @Path("/sexes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sex> getClichedMessage() {

        return sexResource.getAllSex();
    }

    @GET
    @Path("/sex/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Sex getClichedMessage(@PathParam("id") int id) {
        return sexResource.getSex(id);
    }

    @PUT
    @Path("/user/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(User user) {
        userResource.updateUser(user);
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(Sex sex) {
        sexResource.updateSex(sex);
    }

    @DELETE
    @Path("/sex/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUser(@PathParam("id") int id) {
        //abfrage einbauen ob sex referenziert wird von user
        Sex sex = sexResource.getSex(id);
        if(sex.getId()!= 0){
            sexResource.deleteSex(id);
        }
    }



    @POST
    @Path("/sex/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public String getClichedMessage(Sex sex) {
        sexResource.createSex(sex);
        System.out.println("ready");
        return "Hello, World!";
    }



    @POST
    @Path("/sex/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public String getClichedMessage(Sex sex) {
        sexResource.createSex(sex);
        System.out.println("ready");
        return "teeest";
    }


     */
    @POST
    @Path("/sex/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void getClichedMessage(UserFromResponse userFromResponse) {
        String sexString= userFromResponse.getSexx();

        Sex sex= new Sex();
        sex.setDiscription(sexString);
        int sexId = sexResource.createSexx(sex);

        String userName = userFromResponse.getUserName();
        int id = userFromResponse.getId();
        String mail = userFromResponse.getMail();
        String password = userFromResponse.getPassword();
        boolean isManager = userFromResponse.isManager();

        User user = new User(userName,mail,password,isManager,id,sexId);
        userResource.createUser(user);
    }

    @POST
    @Path("/wishedPerson/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public String getClichedMessage(WishedPerson wishedPerson) {
        wishedPersonResource.createWishedPerson(wishedPerson);
        System.out.println("ready");
        return "teeest";
    }



}