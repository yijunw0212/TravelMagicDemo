package travelmagic.objects;

public class Reservation implements java.io.Serializable{

    private String name;
    private String phone;
    private String personId;
    private int space;
    private String hotelName;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String HotelName) {
        this.hotelName = hotelName;
    }

    public Reservation(String name, String phone, String personId, int space, String hotelName,int userId) {
        this.name = name;
        this.phone = phone;
        this.personId = personId;
        this.space = space;
        this.hotelName = hotelName;
        this.userId=userId;
    }
    public String toString(){return "This reservation made by"+name+", phone number is"+phone+"£¬ personal Id is"+personId+", reserve for "+space+"space in the "+hotelName+". UserId is"+userId;}
}
