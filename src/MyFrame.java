import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class MyFrame implements ActionListener {

    public ArrayList<UserInfo> useData = new ArrayList<>();

    JFrame frame = new JFrame();
    static JButton[] seats = new JButton[60];
    JLabel leftTitle, name, age, email, phoneNumber, rightTitle, seatNumber;
    JTextField nameText, ageText, emailText, phoneNumberText, seatText;
    JButton submit, viewData, saveData, redBtn, greenBtn;
    UserInfo userInfo;

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

        saveData = new JButton("SaveData");
        saveData.setFocusable(false);
        saveData.setPreferredSize(new Dimension(100, 30));
        saveData.addActionListener(this);

        redBtn = new JButton("Booked");
        redBtn.setPreferredSize(new Dimension(105,30));
        redBtn.setBackground(new Color(248, 23, 119));
        redBtn.setFocusable(false);
        greenBtn = new JButton("Available");
        greenBtn.setPreferredSize(new Dimension(105,30));
        greenBtn.setBackground(new Color(147, 206, 148));
        greenBtn.setFocusable(false);

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

       nameText.setPreferredSize(new Dimension(320,30));
       emailText.setPreferredSize(new Dimension(320,30));
       ageText.setPreferredSize(new Dimension(320,30));
       phoneNumberText.setPreferredSize(new Dimension(260,30));
       seatText.setPreferredSize(new Dimension(120, 50));

       rightTitle = new JLabel("Fill The Form");
       rightTitle.setFont(new Font("Roboto", Font.PLAIN,30));
       rightTitle.setPreferredSize(new Dimension(380, 100));
       rightTitle.setHorizontalTextPosition(JLabel.CENTER);

       leftTitle = new JLabel("Available Seats");
       leftTitle.setFont(new Font("Roboto", Font.PLAIN,30));
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
       panelRight.add(saveData);


       panelLeft.add(leftTitle);
       for(int i = 1; i <= 52; i++) {
            seats[i] = new JButton(i+"");
            seats[i].setBackground(new Color(147, 206, 148));
            seats[i].setFocusable(false);
            seats[i].setPreferredSize(new Dimension(50,30));
            panelLeft.add(seats[i]);
       }
       panelLeft.add(greenBtn);
        panelLeft.add(redBtn);

       frame.add(panelLeft);
       frame.add(panelRight);
       frame.setResizable(false);
       frame.setVisible(true);
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
        } else if (e.getSource() == saveData) {
            try {
                if(useData.get(0).getName() != null) {
                    new UserInfo().saveData(useData, frame);
                }
            } catch (Exception ea) {
                JOptionPane.showMessageDialog(frame, "Empty list of information", "Empty list", JOptionPane.WARNING_MESSAGE);
            }

        }
    }
    public void setData() {
        userInfo = new UserInfo(nameText.getText(), emailText.getText(), ageText.getText(), phoneNumberText.getText(), seatText.getText());
        if(userInfo.validateData(userInfo)) {
            if(userInfo.isReserved(useData, seatText.getText())) {
                useData.add(new UserInfo(nameText.getText(), emailText.getText(), ageText.getText(), phoneNumberText.getText(), seatText.getText()));
                if(!Objects.equals(seatText.getText(), "")) {
                    int number = Integer.parseInt(seatText.getText());
                    seats[number].setBackground(new Color(248, 23, 119));
                    this.setDefaultData();
                }
            } else {
                new ShowDialogue(seatText.getText() + " number seat is already reserved", "Seat Reserved");
            }
        }
    }

    public void getViewData() {
        for (UserInfo useDatum : useData) {
            System.out.println(useDatum.getName() + " " + useDatum.getEmail() + " " + useDatum.getAge() + " " + useDatum.getPhoneNumber() + " " + useDatum.getSeatNumber());
        }
    }

    public void setDefaultData() {
        nameText.setText("");
        emailText.setText("");
        ageText.setText("");
        phoneNumberText.setText("");
        seatText.setText("");
    }
}
