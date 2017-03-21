import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Character.isAlphabetic;

/**
 * Created by rahthap on 15/3/17.
 */
public class NFA {
    public static void main(String[] args) {

        JFrame frame = new JFrame("NFA Simulation");

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Conversion of regular expression into NFA");
        label.setHorizontalAlignment(JLabel.CENTER);

        JButton nfa = new JButton();
        nfa.setText("NFA");
        nfa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String exp = JOptionPane.showInputDialog("Enter Regular expression");
                //JOptionPane.showMessageDialog(frame, "Hello " + name + '!');
                System.out.println("Regular Expression : "+ exp);
                simNFA(exp);
            }
        });

        JButton algo = new JButton();
        algo.setText("ALGORITHM");
        algo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame2 = new JFrame();
                JPanel panel2 = new JPanel();
                panel2.setLayout(new FlowLayout());
                JLabel algorithm = new JLabel("Steps followed :");
                algorithm.setHorizontalAlignment(JLabel.CENTER);

                panel2.add(algorithm);
                frame2.add(panel2);
                frame2.setSize(250,600);
                frame2.setLocationRelativeTo(null);
                frame2.setVisible(true);

            }
        });

        panel.add(label);

        panel.add(nfa);
        panel.add(algo);
        frame.add(panel);
        frame.setSize(350,200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void simNFA(String exp) {
        char m[]   = new char[20];
        char t[][] = new char[10][10];
        int len, i, j;
        int r=0, c=0;

        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                t[i][j] = ' ';
            }
        }
        len = exp.length();
       // System.out.println("Len : "+len);
        for (i = 0; i<len; i++) {
            switch (m[i]) {
                case '|': {
                    t[r][r + 1] = 'E';
                    t[r + 1][r + 2] = m[i - 1];
                    t[r + 2][r + 5] = 'E';
                    t[r][r + 3] = 'E';
                    t[r + 4][r + 5] = 'E';
                    t[r + 3][r + 4] = m[i + 1];

                    r = r + 5;
                    break;
                }
                case '*': {
                    t[r - 1][r] = 'E';
                    t[r][r + 1] = 'E';
                    t[r][r + 3] = 'E';
                    t[r + 1][r + 2] = m[i - 1];
                    t[r + 2][r + 1] = 'E';
                    t[r + 2][r + 3] = 'E';

                    r = r + 3;
                    break;
                }
                case '+':{
                    t[r][r + 1] = m[i - 1];
                    t[r + 1][r] = 'E';

                    r = r + 1;
                    break;
                }
                default:
                {
                    if (c == 0) {
                        if ((isAlphabetic(m[i])) && (isAlphabetic(m[i + 1]))) {
                            t[r][r + 1] = m[i];
                            t[r + 1][r + 2] = m[i + 1];
                            r = r + 2;
                            c = 1;
                        }
                        c = 1;
                    } else if (c == 1) {
                        if (isAlphabetic(m[i + 1])) {
                            t[r][r + 1] = m[i + 1];
                            r = r + 1;
                            c = 2;
                        }
                    } else {
                        if (isAlphabetic(m[i + 1])) {

                            t[r][r + 1] = m[i + 1];
                            r = r + 1;
                            c = 3;
                        }
                    }
                }
                break;
            }
        }
        System.out.print("\n");
        for (j = 0; j <= r; j++)
            System.out.println(j);
        System.out.println("\n___________________________________\n");
        System.out.print("\n");
        for (i = 0; i <= r; i++) {
            for (j = 0; j <= r; j++) {
                System.out.println(t[i][j]);
            }
            System.out.println(" |" + i);
            System.out.println("\n");
        }
    }
}
