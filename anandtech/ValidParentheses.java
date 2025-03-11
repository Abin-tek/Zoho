import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '[' || c == '{' || c == '(') {
                stk.push(c);
            } else {
                if (stk.isEmpty())
                    return false;
                char top = stk.pop();
                if (c == ']' && top == '[' || c == '}' && top == '{' || c == ')' && top == '(') {
                    continue;
                } else
                    return false;
            }
        }

        return stk.isEmpty();
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println(isValid("[]{}({)}[]"));
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
