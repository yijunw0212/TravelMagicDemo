package travelmagic.objects;

public class User implements java.io.Serializable{

    private int userId;
    private String userName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User(int Id, String name) {
        userId = Id;
        userName = name;
    }
    
}
