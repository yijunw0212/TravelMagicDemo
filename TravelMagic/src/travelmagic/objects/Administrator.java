package travelmagic.objects;

public class Administrator implements java.io.Serializable {

    private int Id;
    private String name;
    private String passWord;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Administrator(int Id, String name, String passWord) {
        this.Id = Id;
        this.name = name;
        this.passWord = passWord;
    }

}
