import java.util.ArrayList;

public interface Utility {

    public boolean validateData(UserInfo data);

    public boolean isReserved(ArrayList<UserInfo> data, String seatNumber);
}
