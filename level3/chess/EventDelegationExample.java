import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventDelegationExample {
    static  int id = 1;
     int count = 0;

    public void start() {
        JFrame frame = new JFrame("Event Delegation " + id++);
        JButton button = new JButton("Click Me");
        JLabel label = new JLabel("Count = " + count++);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Count = " + count++);
            }
        });


        frame.add(button);
        frame.add(label);
        label.setBounds(0, 0, 100, 40);
        button.setBounds(0, 0, 100, 40);
        frame.setSize(300, 300);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
