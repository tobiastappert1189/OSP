import java.time.LocalDateTime;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Server.Pojo.Tour;
import Server.Pojo.TourResponse;
import Server.Pojo.WishedPerson;
import Server.Resource.TourResource;
import Server.Resource.WishedPersonResource;

@Path("tour")
public class TourService {
    TourResource tourResource = new TourResource();
    WishedPersonResource wishedPersonResource = new WishedPersonResource();

    @GET
    @Path("/getTour/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TourResponse getTour(@PathParam("id") int id)
    {
        Tour tour= tourResource.getTour(id);

        int destinationPlz = tour.getDestinationPlz();
        int startPlz = tour.getStartPlz();
        LocalDateTime localDateTime = tour.getDateTime();
        boolean arriveDrive = tour.isArriveDrive();
        int hasSize = tour.getSize();
        boolean isSmoking = tour.isSmoking();
        boolean isAnimal = tour.isAnimal();
        boolean isLuggage = tour.isLuggage();
        String discription = tour.getDiscription();
        int providerInt = tour.getProvider();
        int cost = tour.getCost();


        int wishedPersonId = tour.getWishedPersonId();
        WishedPerson wishedPerson = wishedPersonResource.getWishedPerson(wishedPersonId);
        String stringWishedPerson = wishedPerson.getDiscription();

        return new TourResponse(id,destinationPlz,startPlz,localDateTime,cost,hasSize,isSmoking,isAnimal,isLuggage,stringWishedPerson,discription,arriveDrive,providerInt);

    }

    @GET
    @Path("/allTours")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tour> getALlTours()
    {
        return tourResource.getTours();
    }

    @GET
    @Path("/updateTour/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void updateTour(@PathParam("id")int tourId) {
        tourResource.teilnehmen(tourId);
    }

    @GET
    @Path("/deleteTour/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteTour(@PathParam("id")int tourId) {
        tourResource.deleteTour(tourId);
    }

    @POST
    @Path("/createTour")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(TourResponse tourResponse)
    {
        String wishedPersonString = tourResponse.getWishedPersonId();

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
        int providerInt = tourResponse.getProvider();

        Tour tour = new Tour(id, destinationPlz, startPlz, localDateTime, hasSize, isSmoking, isAnimal, isLuggage, wishedPersonId, discription, arriveDrive, providerInt);
        tourResource.createTour(tour);
    }
}