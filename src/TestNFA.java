import java.util.Scanner;

/**
 * Created by rahthap on 18/3/17.
 */
public class TestNFA {
    static char[] array = new char[50];
    static int str_length;
    static char temp;
    static String string;
    static char[] result_con = new char[str_length];

    public static void main(String[] args) {

        char[] charArray = new char[50];
        int k=0;
        int count=0;


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String : ");
        string = sc.nextLine();
        str_length = string.length();

        System.out.println("Entered String : " + string + " of length :" + str_length);

        for (int i = 0; i < str_length; i++) {
            array[i] = string.charAt(i);
        }

        //Array contents : Check the alphabets in the string
        for (int i = 0; i < str_length; i++) {
            /*char charAt2 = string.charAt(i);
            if (Character.isLetter(charAt2)) {
                count++;
                charArray[k]=array[i];
                k++;*/
                System.out.println("Index :" + i + " = " + array[i]);
                //System.out.println(string.replaceAll("(\\d)(\\d)", "$1.$2"));
            //}
        }

        //CharArray containing all the alphabets in the expression
       /*for (int i=0;i<count;i++){
           System.out.println(" "+charArray[i]);
       }*/

        /*
        * Put concatenation operator :
        * ab
        * a(
         * )a
         * *a
         * *(
         * )(.
         *
        * */
        //System.out.println(string.replaceAll("ab","a.b"));
        for (int i=0;i<str_length;i++){
            if (Character.isLetter(array[i])&&Character.isLetter(array[i+1])) {
                result_con=Concatenate_ab(array,i,'.');
            }
        }
        for (int i=0;i<result_con.length;i++){
            System.out.print(result_con[i]);
        }


    }

    private static char[] Concatenate_ab(char[] array, int pos, char charc) {
        char[] result = new char[string.length()];
        for(int i = 0; i < pos; i++)
            result[i] = array[i];
        result[pos] = charc;
        for(int i = pos + 1; i < array.length; i++)
            result[i] = array[i - 1];
        return result;

    }


}
