import java.util.*;

/**
 * Created by rahthap on 24/3/17.
 */
public class NFA1 {
    private static final Map<Character, Integer> precedenceMap;
    static {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('(', 1);
        map.put('|', 2);
        map.put('.', 3); // explicit concatenation operator
        map.put('?', 4);
        map.put('*', 4);
        map.put('+', 4);
        map.put('^', 5);
        precedenceMap = Collections.unmodifiableMap(map);
    };

    public static String infixToPostfix(String regex) {
        String postfix = new String();

        Stack<Character> stack = new Stack<Character>();

        String formattedRegEx = regex;

        for (Character c : formattedRegEx.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push(c);
                    break;

                case ')':
                    while (!stack.peek().equals('(')) {
                        postfix += stack.pop();
                    }
                    stack.pop();
                    break;

                default:
                    while (stack.size() > 0) {
                        Character peekedChar = stack.peek();

                        Integer peekedCharPrecedence = getPrecedence(peekedChar);
                        Integer currentCharPrecedence = getPrecedence(c);

                        if (peekedCharPrecedence >= currentCharPrecedence) {
                            postfix += stack.pop();
                        } else {
                            break;
                        }
                    }
                    stack.push(c);
                    break;
            }

        }

        while (stack.size() > 0)
            postfix += stack.pop();

        return postfix;
    }

    private static Integer getPrecedence(Character c) {

        Integer precedence = precedenceMap.get(c);
        return precedence == null ? 6 : precedence;
    }

    private static String two_Consecutive(String new_string0) {
        new_string0 = new_string0.replaceAll("(\\w)(\\w)", "$1\\.$2");

        //check a(
        new_string0 = charc_OpenBracket(new_string0);
        return new_string0;
    }

    private static String charc_OpenBracket(String new_string1) {
        new_string1 = new_string1.replaceAll("(\\w)(\\()", "$1\\.$2");

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
        new_string5 = new_string5.replaceAll("(\\))(\\()", "$1\\.$2");
        return new_string5;
    }


    private static void checkCharachter(Character character) {
        if (Character.isLetter(character)){
            System.out.println("PUSH  " + character);
        }else
        if (character == '|'){
            System.out.println("UNION");
        }else
        if (character == '*'){
            System.out.println("STAR");
        }else
        if (character == '.'){
            System.out.println("CONCAT");
        }
    }

    public static void main(String[] args) {
        String string ;
        Character character;
        int string_length;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string :");
        string = sc.nextLine();

        //STEP 1 : Put concatenation operator wherever concatenation is required
        //check ab
        string = two_Consecutive(string);

        // STEP 2 : Convert that concatenated regex to postfix
        string = infixToPostfix(string);
        System.out.println("Postfix Expression : " + string);

        /*STEP 3 :  Build NFA
        *
        *  -> If operand PUSH to stack
        *  -> If operator apply the operator accordingly and push back the result to stack
        *
        * */
        string_length = string.length();
        ArrayList<Character> arrayList = new ArrayList<Character>();
        for (int i=0;i<string_length;i++){
            arrayList.add(string.charAt(i));
        }
        for (int i=0;i<arrayList.size();i++){
            //System.out.println("i : "+i +" : "+ arrayList.get(i));
            character = arrayList.get(i);
            checkCharachter(character);
        }
    }

}

