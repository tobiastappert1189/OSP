package Server.Pojo;

public class WishedPerson
{

    int id;

    public WishedPerson(int id, String discription)
    {
        this.id = id;
        this.discription = discription;
    }

    public WishedPerson(){

    }

    String discription;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getDiscription()
    {
        return discription;
    }

    public void setDiscription(String discription)
    {
        this.discription = discription;
    }



}


