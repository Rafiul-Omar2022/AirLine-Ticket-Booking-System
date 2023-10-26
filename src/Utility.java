import javax.swing.*;
import java.util.ArrayList;

public interface Utility {

    public boolean validateData(UserInfo data);

    public boolean isReserved(ArrayList<UserInfo> data, String seatNumber);

    void saveData(ArrayList<UserInfo> data, JFrame frame);
}
