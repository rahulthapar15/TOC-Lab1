import java.util.Scanner;

/**
 * Created by rahthap on 18/3/17.
 */
public class TestNFA {
    static char[] array = new char[50];
    static int str_length;
    static char temp;
    static String string, new_string;
    static char[] result_con = new char[str_length];

    public static void main(String[] args) {

        char[] charArray = new char[50];
        int k=0;
        int count=0;


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String : ");
        string = sc.nextLine();
        new_string = string.replaceAll("\\w{2}", "$0.");
       System.out.println(string.replaceAll("\\w{2}", "$0."));
        str_length = new_string.length();


        System.out.println("Entered String : " + new_string + " of length :" + str_length);

        for (int i = 0; i < str_length; i++) {
            array[i] = new_string.charAt(i);
        }

        //Array contents : Check the alphabets in the string
        for (int i = 0; i < str_length; i++) {
                System.out.println("Index :" + i + " = " + array[i]);
        }

        //---------------------------------------------------------
        //CharArray containing all the alphabets in the expression

         /*for (int i=0;i<count;i++){
           System.out.println(" "+charArray[i]);
       }*/

        //---------------------------------------------------------



        //------------------------------------------------------
        //        STEP 1 : Put concatenation operator(. Dot)
        //                 wherever concatenation is required.
        //-------------------------------------------------------


        for (int i=0;i<str_length;i++){
            if (Character.isLetter(array[i])&&Character.isLetter(array[i+1])) //Check if there are 2 consecutive alphabets
            {
               // System.out.println("2 consecutive alphabets : "+array[i]+" and "+ array[i+1]);
                //Concatenate(array, i);
            }
        }
        for (int i=0;i<result_con.length;i++){
            System.out.print(result_con[i]);
        }
    }

    private static void Concatenate(char[] array, int pos) {

        /* ab : a - pos and b - pos+1 */


    }
}
