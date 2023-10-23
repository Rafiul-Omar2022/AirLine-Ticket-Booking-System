import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyFrame implements ActionListener {

    ArrayList<UserInfo> useData = new ArrayList<UserInfo>();

    JFrame frame = new JFrame();
    static JButton[] seats = new JButton[60];
    JLabel leftTitle, name, age, email, phoneNumber, rightTitle, seatNumber;
    JTextField nameText, ageText, emailText, phoneNumberText, seatText;
    JButton submit, viewData;

    MyFrame() {
       frame.setSize(new Dimension(800, 500));
       frame.setTitle("Air Line Ticket");
       frame.setIconImage(titleIcon("./src/planeIcon.png"));
       frame.setLayout(new GridLayout(1, 2));
       frame.setLocationRelativeTo(null);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       JPanel panelLeft = new JPanel();
       JPanel panelRight = new JPanel();

        submit = new JButton("Submit");
        submit.setFocusable(false);
        submit.setPreferredSize(new Dimension(200, 30));
        submit.setMargin(new Insets(0, 50, 0, 50));
        submit.addActionListener(this);
        viewData = new JButton("View Data");
        viewData.setFocusable(false);
        viewData.setPreferredSize(new Dimension(100, 30));
        viewData.addActionListener(this);

       name = new JLabel("Name : ");
       email = new JLabel("Email : ");
       age = new JLabel("Age : ");
       phoneNumber = new JLabel("Phone number : ");
       seatNumber = new JLabel("Enter Seat reserve number : ");

       nameText = new JTextField();
       ageText = new JTextField();
       emailText = new JTextField();
       phoneNumberText = new JTextField();
       seatText = new JTextField();

       nameText.setPreferredSize(new Dimension(320,20));
       emailText.setPreferredSize(new Dimension(320,20));
       ageText.setPreferredSize(new Dimension(320,20));
       phoneNumberText.setPreferredSize(new Dimension(260,20));
       seatText.setPreferredSize(new Dimension(120, 50));

       rightTitle = new JLabel("Fill The Form");
       rightTitle.setPreferredSize(new Dimension(380, 100));
       rightTitle.setHorizontalTextPosition(JLabel.CENTER);

       leftTitle = new JLabel("Available Seats");
       leftTitle.setPreferredSize(new Dimension(380, 100));
       leftTitle.setHorizontalTextPosition(JLabel.CENTER);

       panelLeft.setPreferredSize(new Dimension(250, 500));
       panelRight.setPreferredSize(new Dimension(250, 500));

       panelRight.add(rightTitle);
       panelRight.add(name);
       panelRight.add(nameText);
       panelRight.add(email);
       panelRight.add(emailText);
       panelRight.add(age);
       panelRight.add(ageText);
       panelRight.add(phoneNumber);
       panelRight.add(phoneNumberText);
       panelRight.add(seatNumber);
       panelRight.add(seatText);
       panelRight.add(submit);
       panelRight.add(viewData);


       panelLeft.add(leftTitle);
       for(int i = 1; i <= 52; i++) {
            seats[i] = new JButton(i+"");
            seats[i].setBackground(new Color(147, 206, 148));
            seats[i].setFocusable(false);
            seats[i].setPreferredSize(new Dimension(50,30));
            panelLeft.add(seats[i]);
       }

       frame.add(panelLeft);
       frame.add(panelRight);
       frame.setResizable(false);
       frame.setVisible(true);
//       frame.pack();
    }


    public Image titleIcon(String path) {
        return new ImageIcon(path).getImage();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit) {
            this.setData();
        } else if (e.getSource() == viewData) {
            this.getViewData();
            new ViewData(titleIcon("./src/planeIcon.png"), useData);
        }
    }
    public void setData() {
        useData.add(new UserInfo(nameText.getText(), emailText.getText(), ageText.getText(), phoneNumberText.getText(), seatText.getText()));
        if(seatText.getText() != null) {
            int number = Integer.parseInt(seatText.getText());
            seats[number].setBackground(new Color(248, 23, 119));
        }
    }

    public void getViewData() {
        for(int i = 0; i < useData.size(); i++) {
            System.out.println(useData.get(i).getName() + " " + useData.get(i).getEmail() + " " + useData.get(i).getAge() + " " + useData.get(i).getPhoneNumber() + " " +useData.get(i).getSeatNumber());
        }
    }
}
