package Server.Pojo;

public class UserFromResponse
{


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
        int sex;

        public String getSexx()
        {
            return sexx;
        }

        public void setSexx(String sexx)
        {
            this.sexx = sexx;
        }

        String sexx;


        public UserFromResponse(int id,String userName, String mail, String password, boolean isManager, String sexx) {
            this.userName = userName;
            this.mail = mail;
            this.password = password;
            this.isManager = isManager;
            this.sexx = sexx;
            this.id = id;
        }


        public UserFromResponse(){

        }

        public String getUserName() { return userName; }

        public void setUserName(String userName) { this.userName = userName; }

        public String getMail() { return mail; }

        public void setMail(String mail) { this.mail = mail; }

        public String getPassword() { return password; }

        public void setPassword(String password) { this.password = password; }

        public boolean isManager() { return isManager; }

        public void setManager(boolean manager) { isManager = manager; }

        public int getSex() { return sex;}

        public void setSex(int sex) { this.sex = sex; }
    }


