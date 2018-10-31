package com.Twenties;

import java.util.Stack;

//LC 20. Valid Parentheses
public class Valid_Parentheses {
    /*
    *
    * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
    * determine if the input string is valid. An input string is valid if:
    * Open brackets must be closed by the same type of brackets.
    * Open brackets must be closed in the correct order.
    * Note that an empty string is also considered valid.
    * */
    public static void main(String[] args) {
        System.out.println("expected: true:  "+ isValid("()"));
        System.out.println("expected: true:  "+isValid("()[]{}"));
        System.out.println("expected: false:  "+isValid("(]"));
        System.out.println("expected: false:  "+isValid("([)]"));
        System.out.println("expected: true:  "+isValid("{[]}"));

        System.out.println("expected: false:  "+isValid("(])"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        //corner case
        if(s.length() == 0 || s == null || s == "") {
            return true;
        }
        if(s.length() == 1) {
            return false;
        }
        //process
       for(Character c: s.toCharArray()) {
            if(c == '{') {
                stack.push('}');
            } else if(c == '[') {
                stack.push(']');
            } else if(c == '(') {
                stack.push(')');
            } else if(stack.empty() || stack.peek() != c) {
                return false;
            }  else {
                stack.pop();
            }
       }

       return stack.empty() ;

    }



}
