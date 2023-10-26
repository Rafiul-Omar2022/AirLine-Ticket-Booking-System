import javax.swing.*;
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
        boolean check = false;
        try {
            int seatNumber = Integer.parseInt(data.getSeatNumber());
            if (seatNumber >= 1 && seatNumber <= 52) {
                try {
                    int phoneNumber = Integer.parseInt(data.getPhoneNumber());
                    try {
                        int age = Integer.parseInt(data.getAge());
                        if(Objects.equals(data.getName(), "") || Objects.equals(data.getEmail(), "")) {
                            new ShowDialogue("Text field cannot be empty", "Empty text field");
                        } else {
                            return true;
                        }

                    } catch (Exception e) {
                        new ShowDialogue("Age should be an integer", "Invalid Input");
                    }

                } catch (Exception e) {
                    new ShowDialogue("Phone number cannot be empty or string", "Invalid Input");
                }

            } else {
                new ShowDialogue("Seat number should be between 1 to 52", "Invalid Input");
            }
        } catch (Exception e) {
            new ShowDialogue("Seat number cannot be empty or string", "Invalid Input");
        }
        return check;
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
