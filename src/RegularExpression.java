import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rahthap on 9/3/17.
 */
public class RegularExpression {
    public static void main(String[] args) {

        int multiline_flag=0;
        int singleline_flag=0;
        int email_flag=0;
        int url_flag=0;
        int headerfile_flag=0;


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string : ");
        String string;

        string = sc.nextLine();

        multiline_flag = findMultilineComment(string);
        singleline_flag = findSinglelineComment(string);
        email_flag = findEmail(string);
        url_flag = findURL(string);
        headerfile_flag = findHeaderfile(string);


        if (multiline_flag==1){
            System.out.println("Multiline Comment found");
        }else
        if (singleline_flag==1){
            System.out.println("Single Line Comment found");
        }else
        if (email_flag==1){
            System.out.println("Email found");
        }else
        if (url_flag==1){
            System.out.println("URL found");
        }else
        if (headerfile_flag==1){
            System.out.println("Header file found");
        }else {
            System.out.println("Nothing found");
        }

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
        }*/

    }

    private static int findHeaderfile(String string) {
        Pattern regex = Pattern.compile("#\\w{7} ?<?\"?\\w*.h>?\"?",Pattern.DOTALL);
        Matcher regexMatcher = regex.matcher(string);
        if (regexMatcher.find()){
            return 1;
        }else{
            return 0;
        }
    }

    private static int findURL(String string) {
        Pattern regex = Pattern.compile("(www|https|http).?:?/?/?.*",Pattern.DOTALL);
        Matcher regexMatcher = regex.matcher(string);
        if (regexMatcher.find()){
            return 1;
        }else{
            return 0;
        }
    }

    private static int findEmail(String string) {
        Pattern regex = Pattern.compile("[\\w.]+@\\w+\\.[com|net|edu|in]",Pattern.DOTALL);
        Matcher regexMatcher = regex.matcher(string);
        if (regexMatcher.find()){
            return 1;
        }else{
            return 0;
        }
    }

    private static int findSinglelineComment(String string) {
        Pattern regex = Pattern.compile("[^:]//.*",Pattern.DOTALL);
        Matcher regexMatcher = regex.matcher(string);
        if (regexMatcher.find()){
            return 1;
        }else{
            return 0;
        }
    }

    private static int findMultilineComment(String string) {
        Pattern regex = Pattern.compile("/\\*.*\\*/",Pattern.DOTALL);
        Matcher regexMatcher = regex.matcher(string);
        if (regexMatcher.find()){
            return 1;
        }else{
            return 0;
        }
    }
}
