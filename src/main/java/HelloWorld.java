import java.time.LocalDateTime;
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
import Server.Pojo.WishedPerson;
import Server.Pojo.Tour;
import Server.Pojo.TourResponse;
import Server.Pojo.User;
import Server.Pojo.UserFromResponse;
import Server.Resource.SexResource;
import Server.Resource.TourResource;
import Server.Resource.UserResource;
import Server.Resource.WishedPersonResource;

@Path("/hello-world")
public class HelloWorld {

    UserResource userResource = new UserResource();
    SexResource sexResource = new SexResource();
    WishedPersonResource wishedPersonResource = new WishedPersonResource();
    TourResource tourResource = new TourResource();


    @POST
    @Path("/user/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public String createUser(User user) {
        userResource.createUser(user);
        System.out.println("ready");
        return "Hello, World!";
    }


    @GET
    @Path("/allUser")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> allUser() {

        return userResource.getUsers();
    }

    @GET
    @Path("/getUsers/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUsers(@PathParam("id") int id) {
        return userResource.getUser(id);
    }

    @DELETE
    @Path("/deleteUser/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUserWithId(@PathParam("id") int id) {
        User user = userResource.getUser(id);
        if(user.getId()!= 0){
            userResource.deleteUser(id);
        }
    }


    @GET
    @Path("/getAllSex")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sex> getClichedMessage() {

        return sexResource.getAllSex();
    }

    @GET
    @Path("/getSexId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Sex getSexId(@PathParam("id") int id) {
        return sexResource.getSex(id);
    }

    @PUT
    @Path("/user/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(User user) {
        userResource.updateUser(user);
    }

    @PUT
    @Path("/sexUpdate")
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
    public String sexCreate(Sex sex) {
        sexResource.createSex(sex);
        System.out.println("ready");
        return "Hello, World!";
    }


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
    @Path("/tour/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void geTour(TourResponse tourResponse) {
        String wishedPersonString= tourResponse.getWishedPersonId();

        WishedPerson wishedPerson = new WishedPerson();
        wishedPerson.setDiscription(wishedPersonString);
        int wishedPersonId = wishedPersonResource.createWishedPersonReturnInt(wishedPerson);

        int id = tourResponse.getId();
        int destinationPlz = tourResponse.getDestinationPlz();
        int startPlz = tourResponse.getStartPlz();
        LocalDateTime localDateTime = tourResponse.getDateTime();
        boolean arriveDrive = tourResponse.isArriveDrive();
        int hasSize = tourResponse.getSize();
        boolean isSmoking = tourResponse.isSmoking();
        boolean isAnimal = tourResponse.isAnimal();
        boolean isLuggage = tourResponse.isLuggage();
        String discription = tourResponse.getDiscription();



        Tour tour = new Tour(id,destinationPlz,startPlz,localDateTime,hasSize,isSmoking,isAnimal,isLuggage,wishedPersonId,discription,arriveDrive);
        tourResource.createTour(tour);
    }




    @POST
    @Path("/wishedPerson/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public String getClichedMessage(WishedPerson wishedPerson) {
        wishedPersonResource.createWishedPerson(wishedPerson);
        System.out.println("ready");

        return "teeest";
    }


    @GET
    @Path("/tour/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tour getClichedMessage(@PathParam("id") int id) {


        User user = userResource.getAuth("AUTO","test");
        System.out.println("teeest");

        return tourResource.getTour(id);
    }

    @GET
    @Path("/tour/{userName}/{password}")
    public String getClichedMessage(@PathParam("userName") String userName,@PathParam("password") String password) {


        User user = userResource.getAuth(userName,password);
        return "sucessFull login";
    }

}