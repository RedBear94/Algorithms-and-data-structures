package hw2;

import hw2.mystack.Stack;
import hw2.mystack.StackImpl;

public class FlippingLines {
    private static String TEXT = "ABCDEFG";

    private String line;

    public FlippingLines(String line) {
        this.line = line;
    }

    public static void main(String[] args) {
        new FlippingLines(TEXT).flip(); // GFEDCBA
        new FlippingLines(TEXT).flip(); // ABCDEFG
    }

    private void flip() {
        Stack<Character> stack = new StackImpl<>(TEXT.length());
        for (int index = 0; index < TEXT.length(); index++) {
            char currentChar = TEXT.charAt(index);
            stack.push(currentChar);
        }
        TEXT = "";
        while (!stack.isEmpty()){
            TEXT = TEXT.concat(stack.pop().toString());
        }
        System.out.println(TEXT);
    }
}
