package Server.Pojo;

public class Sex
{
    public Sex(int id, String discription)
    {
        this.id = id;
        this.discription = discription;
    }

    public Sex(){};

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

    int id;
    String discription;
}
