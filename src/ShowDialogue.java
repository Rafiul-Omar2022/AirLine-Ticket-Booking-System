import javax.swing.*;

public class ShowDialogue {
    JFrame frame;
    public ShowDialogue(String message, String error) {
        frame = new JFrame();
        JOptionPane.showMessageDialog(frame,message, error, JOptionPane.WARNING_MESSAGE);
    }
}
