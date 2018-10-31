package com.ThreeNines;

import java.util.Stack;

//394 Decode String
public class DecodeString {


    /*
    * Given an encoded string, return it's decoded string.
    The encoding rule is: k[encoded_string],
    where the encoded_string inside the square brackets is being repeated exactly k times.
    Note that k is guaranteed to be a positive integer.
    You may assume that the input string is always valid; No extra white spaces,
    square brackets are well-formed, etc.
    Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
    For example, there won't be input like 3a or 2[4].
    * */

    public static void main(String[] args) {
        //TC1:
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
        System.out.println("expected output:  "+ "aaabcbc");
        s = "3[a2[c]]";
        System.out.println(decodeString(s));
        System.out.println("expected output:  "+ "accaccacc");
        s = "2[abc]3[cd]ef";
        System.out.println(decodeString(s));
        System.out.println("expected output:  "+ "abcabccdcdcdef");
    }
    //Sol 1: stack
    //1. repeating times & characters
    public static String decodeString(String s) {
        //final result
        String res = "";
        //stack to ave repeating times
        Stack<Integer> countStack = new Stack<>();
        //stack to save repeating strings
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while(idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                //get the integer which could be >=10
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++; //move pointer forward
                }
                //save the counts
                countStack.push(count);
            } else if (s.charAt(idx) == '[') {
                resStack.push(res); //seg priror substring
                res = "";//start save the cur substring
                idx++;
            } else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder(resStack.pop()); //prior block
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res); //append current block* reapeat times to prior block
                }
                res = temp.toString();
                idx++;
            } else {
                res += s.charAt(idx++);//append current letter to cur substring

            }
        }
            return res;

        }



    //sol 2: DFS-> same idea of sol1, just another way implementation
    /*
    一个DFS的题目, 给定的字符串可能会有嵌套很多层, 在每一层我们只要在碰到正常的字符就保存到当前层的结果中,
    如果碰到数字就另外保存起来作为倍数,
    碰到'[' 就进入下层递归,
    碰到']' 就将当前层结果返回,
    这样在返回给上层之后就可以用倍数加入到上层结果字符串中.
    最终当所有层都完成之后就可以得到结果. 在不同层次的递归中, 我们可以维护一个共同的位置索引,
    这样在下层递归完成之后上层可以知道已经运算到哪里了.
     */

}
