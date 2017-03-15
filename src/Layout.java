import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by rahthap on 15/3/17.
 */
public class Layout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Regular Expression Check");

        String regular_expressions [] = {"Single Line Comment","Multi-Line Comment","Email","URL","Header File"};
        final JComboBox comboBox = new JComboBox(regular_expressions);
        comboBox.setBounds(50, 100,90,20);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel label = new JLabel("The program includes the following Regular Expressions");
        label.setHorizontalAlignment(JLabel.CENTER);
        JButton show = new JButton();
        show.setText("SHOW");
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = "Regular Expression : "+ comboBox.getItemAt(comboBox.getSelectedIndex());
                System.out.println(data);
            }
        });

        panel.add(label);
        panel.add(comboBox);
        panel.add(show);

        frame.add(panel);
        frame.setSize(500,350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
