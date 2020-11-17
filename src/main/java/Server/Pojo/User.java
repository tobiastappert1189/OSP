package Server.Pojo;

import utils.sex;

public class User {

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    int id;
    String userName;
    String mail;
    String password;
    boolean isManager;
    sex sex;

    public User(String userName, String mail, String password, boolean isManager, int id) {
        this.userName = userName;
        this.mail = mail;
        this.password = password;
        this.isManager = isManager;
        this.id = id;
    }

    public User(){

    }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getMail() { return mail; }

    public void setMail(String mail) { this.mail = mail; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public boolean isManager() { return isManager; }

    public void setManager(boolean manager) { isManager = manager; }

    public utils.sex getSex() { return sex; }

    public void setSex(utils.sex sex) { this.sex = sex; }
}
