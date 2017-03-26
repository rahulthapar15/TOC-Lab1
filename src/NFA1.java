import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by rahthap on 24/3/17.
 */
public class NFA1 {
    public static void main(String[] args) {
        String string ;
        int string_length;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string :");
        string = sc.nextLine();


        //check ab
        string = two_Consecutive(string);
        string_length = string.length();

        ArrayList<Character> arrayList = new ArrayList<Character>();
        for (int i=0;i<string_length;i++){
            arrayList.add(string.charAt(i));
        }

        for (int i=0;i<arrayList.size();i++){
            System.out.print(arrayList.get(i)+"   ");
        }


    }

    private static String two_Consecutive(String new_string0) {
        new_string0 = new_string0.replaceAll("(\\w)(\\w)", "$1\\.$2");

        //check a(
        new_string0 = charc_OpenBracket(new_string0);
        return new_string0;
    }

    private static String charc_OpenBracket(String new_string1) {
        new_string1 = new_string1.replaceAll("(\\w)(\\()","$1\\.$2");

        //check )a
        new_string1= closeBrack_charac(new_string1);
        return new_string1;
    }

    private static String closeBrack_charac(String new_string2) {
        new_string2 = new_string2.replaceAll("(\\))(\\w)","$1\\.$2");

        //check *a
        new_string2 = star_Charc(new_string2);
        return new_string2;
    }

    private static String star_Charc(String new_string3) {
        new_string3 = new_string3.replaceAll("(\\*)(\\w)","$1\\.$2");

        //check *(
        new_string3 = star_Brack(new_string3);
        return new_string3;
    }

    private static String star_Brack(String new_string4) {
        new_string4 = new_string4.replaceAll("(\\*)(\\()","$1\\.$2");

        //check )(
        new_string4 = open_Closebrack(new_string4);
        return new_string4;
    }

    private static String open_Closebrack(String new_string5) {
        new_string5 = new_string5.replaceAll("(\\))(\\()","$1\\.$2");
        return new_string5;
    }
}
