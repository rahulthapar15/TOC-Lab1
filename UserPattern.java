package automata1;

/**
 *
 * @author sonalishankar
 */
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/* program to find a substring within a string*/

public class UserPattern extends JFrame
{
    public static final int NO_OF_CHARS = 256;
    public static String main, pattern; // main stores string and pattern to store substring
    private JLabel labelmainstr = new JLabel("Enter a string: ");
	private JLabel substr = new JLabel("Enter text to search in the string: ");
	private JTextField textmainstr = new JTextField(20);
	private JTextField textsubstr = new JTextField(20);

	private JButton buttonLogin = new JButton("Search");



public UserPattern()
{


                JPanel newPanel = new JPanel(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);

		// add components to the panel
		constraints.gridx = 0;
		constraints.gridy = 0;
		newPanel.add(labelmainstr, constraints);

		constraints.gridx = 1;
		newPanel.add(textmainstr, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		newPanel.add(substr, constraints);

		constraints.gridx = 1;
		newPanel.add(textsubstr, constraints);

		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		newPanel.add(buttonLogin, constraints);

		// set border for the panel
		newPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Search String Panel"));


		buttonLogin.addActionListener( new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                         main = textmainstr.getText();
                         pattern = textsubstr.getText();
                         search(pattern.toCharArray(), main.toCharArray());
                    }

                });

                add(newPanel);
            		pack();

	}


    public static int nextState (char[] pattern , int M, int state, int x)
    {
        /*
         If the character c is same as next character in pattern,then simply increment state
         */
        if (state < M && x == pattern [state])
            return state + 1;
        int ns, i; // ns is the next state

        for (ns = state; ns > 0; ns--)
        {
            if (pattern [ns - 1] == x)
            {
                for (i = 0; i < ns - 1; i++)
                {
                    if (pattern [i] != pattern [state - ns + 1 + i])
                        break;
                }
                if (i == ns - 1)
                    return ns;
            }
        }
        return 0;
    }

    /*
     * This function builds the Transition  table which represents Finite Automata for a
     * given pattern
     */
    public static void computeTransition (char[] pattern , int M, int[][] Transition )
    {
        int state, x;
        for (state = 0; state <= M; ++state)
        {
            for (x = 0; x < NO_OF_CHARS; ++x)
            {
                Transition [state][x] = nextState (pattern , M, state, x);

            }
        }
    }    /*
     * Prints all occurrences of pattern  in txt
     */
    public static void search(char[] pattern , char[] txt)
    {

        int M = pattern .length;
        int N = txt.length;
        int[][] Transition  = new int[M + 1][NO_OF_CHARS];
        computeTransition (pattern , M, Transition );
        // Process txt over FA.
        int i, state = 0, j;
        int a = 0,b=0,c=0,k=0;
        int d;

        int[] f1 = new int[10];
        for (i = 0; i < N; i++)
        {
            state = Transition [state][txt[i]];
            if (state == M)
            {
               f1[k]=i-M+1;
               b=1;
               k++;
            }
                }
        
        
    }

    public static void main(String[] args)
    {
                new UserPattern().setVisible(true);

    }
}
