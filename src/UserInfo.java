import java.util.ArrayList;
import java.util.Objects;

public class UserInfo implements Utility {
    private String name;
    private String email;
    private String phoneNumber;
    private String age;
    private String seatNumber;

    public UserInfo(String name, String email, String age, String phoneNumber, String seatNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.seatNumber = seatNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public boolean validateData(UserInfo data) {
        int seatNumber = Integer.parseInt(data.getSeatNumber());
        return (!Objects.equals(data.getName(), "")) &&
                (!Objects.equals(data.getEmail(), "")) &&
                (!Objects.equals(data.getAge(), "")) &&
                (!Objects.equals(data.getPhoneNumber(), "")) &&
                (!Objects.equals(data.getSeatNumber(), "") && (seatNumber >= 1 && seatNumber <= 52));
    }

    @Override
    public boolean isReserved(ArrayList <UserInfo> data, String seatNumber) {
        for(int i = 0; i < data.size(); i++) {
            if(Objects.equals(data.get(i).getSeatNumber(), seatNumber)) {
                return false;
            }
        }
        return true;
    }
}
