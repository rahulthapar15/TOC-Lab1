import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rahthap on 9/3/17.
 */
public class RegularExpression {
    public static void main(String[] args) {



        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string : ");
        String string;

        string = sc.nextLine();

        // Testing for a multiline comment
        findMultilineComment(string);

        /*Scanner sc = new Scanner(System.in);
        String string;

        System.out.println("Enter String  : ");
        string = sc.nextLine();

        System.out.println("String : " + string);

        boolean isRegex;
        try {
            Pattern.compile(string);
            isRegex = true;
        } catch (PatternSyntaxException e) {
            isRegex = false;
        }

        if(isRegex){
            System.out.println("It is a regular expression");
        }else{
            System.out.println("It is not a regular expression");
        }
*/
    }

    private static void findMultilineComment(String string) {

        String matchedComment = null;
        Pattern regex = Pattern.compile("/\\*.*?\\*/",Pattern.DOTALL);
        Matcher regexMatcher = regex.matcher(string);
        if (regexMatcher.find()){
            matchedComment = regexMatcher.group();
            System.out.println("Macthed Comment :" + matchedComment);
        }else{
            System.out.println("Not a regular expression");
        }


    }
}
