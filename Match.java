/**
 *
 * @author sonalishankar
 */

import java.util.Scanner;
public class Match
{
    public static final int NO_OF_CHARS = 1200;

    public static int nextState (char[] pattern , int M, int state, int x)
    {
        /*
         If the character c is same as next character in pattern tern,then simply increment state
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
     * given pattern tern
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
        int i, state = 0;
        for (i = 0; i < N; i++)
        {
            state = Transition [state][txt[i]];
            if (state == M)
            {
                System.out.print(pattern );
                System.out.print(" found at position " + (i - M + 1)+"\n");
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String main = sc.nextLine();
        System.out.println("Enter the pattern tern you want to find: ");
        String pattern = sc.nextLine();
        search(pattern.toCharArray(), main.toCharArray());
   
    }
}