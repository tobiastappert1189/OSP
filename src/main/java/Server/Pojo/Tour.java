package Server.Pojo;

import java.text.DateFormat;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tour
{

    public Tour(int id, int destinationPlz, int startPlz, LocalDateTime dateTime, int size, boolean isSmoking, boolean isAnimal, boolean isLuggage, int wishedPersonId, String discription, boolean arriveDrive,int provider)
    {
        this.id = id;
        this.destinationPlz = destinationPlz;
        this.startPlz = startPlz;
        this.dateTime = dateTime;
        this.size = size;
        this.isSmoking = isSmoking;
        this.isAnimal = isAnimal;
        this.isLuggage = isLuggage;
        this.wishedPersonId = wishedPersonId;
        this.discription = discription;
        this.arriveDrive = arriveDrive;
        this.provider = provider;

    }

    int cost;
    int size;

    public Tour(){

    }

    public int getCost()
    {
        return cost;
    }

    public void setCost(int cost)
    {
        this.cost = cost;
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public boolean isSmoking()
    {
        return isSmoking;
    }

    public void setSmoking(boolean smoking)
    {
        isSmoking = smoking;
    }

    public LocalDateTime getDateTime()
    {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime)
    {
        this.dateTime = dateTime;
    }

    public boolean isAnimal()
    {
        return isAnimal;
    }

    public void setAnimal(boolean animal)
    {
        isAnimal = animal;
    }

    public boolean isLuggage()
    {
        return isLuggage;
    }

    public void setLuggage(boolean luggage)
    {
        isLuggage = luggage;
    }

    public int getWishedPersonId()
    {
        return wishedPersonId;
    }

    public void setWishedPersonId(int wishedPersonId)
    {
        this.wishedPersonId = wishedPersonId;
    }

    public String getDiscription()
    {
        return discription;
    }

    public void setDiscription(String discription)
    {
        this.discription = discription;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getDestinationPlz()
    {
        return destinationPlz;
    }

    public void setDestinationPlz(int destinationPlz)
    {
        this.destinationPlz = destinationPlz;
    }

    public int getStartPlz()
    {
        return startPlz;
    }

    public void setStartPlz(int startPlz)
    {
        this.startPlz = startPlz;
    }

    boolean isSmoking;
    LocalDateTime dateTime;
    boolean isAnimal;
    boolean isLuggage;
    int wishedPersonId;
    String discription;
    int id;
    int destinationPlz;
    int startPlz;

    public int getProvider()
    {
        return provider;
    }

    public void setProvider(int provider)
    {
        this.provider = provider;
    }

    int provider;

    public boolean isArriveDrive()
    {
        return arriveDrive;
    }

    public void setArriveDrive(boolean arriveDrive)
    {
        this.arriveDrive = arriveDrive;
    }

    boolean arriveDrive;


}
