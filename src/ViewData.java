import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

public class ViewData extends JFrame{

    JFrame frame;
    JTable table;
    JScrollPane sp;
    static int dataCount = 0;
    public ViewData(Image icon, ArrayList<UserInfo> data) {
        frame = new JFrame("User Data");
        frame.setIconImage(icon);
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);

        String[] column = {"Name", "Email", "Age", "PhoneNumber", "SeatNumber"};
        String[][] str = {{"", " ", " ", " ", " "}};
        table = new JTable(dataFatch(data), column);
        table.setBounds(30,40,400,300);
        sp = new JScrollPane(table);

        frame.add(sp);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    public String[][] dataFatch(ArrayList<UserInfo> data) {
        int size = data.size();
        String[][] str = new String[size][5];
        for(int i = 0; i < data.size(); i++) {
            str[i][0] = data.get(i).getName();
            str[i][1] = data.get(i).getEmail();
            str[i][2] = data.get(i).getAge();
            str[i][3] = data.get(i).getPhoneNumber();
            str[i][4] = data.get(i).getSeatNumber();
        }
        return str;
    }
}
