package com.Nineties;

import java.util.ArrayList;
import java.util.List;

import static com.PrintFunctions.printListString;

//LC 93. Restore IP Addresses
public class Restore_IP_Addresses {
    /*
    * Given a string containing only digits,
    * restore it by returning all possible valid IP address combinations.
    *
    *
    * */

    public static void main(String[] args) {
        String input = "25525511135";
        // Expected Output: ["255.255.11.135", "255.255.111.35"]
        printListString(restoreIpAddresses(input));
        //printListString(restoreIpAddresses2(input));
        printListString(restoreIpAddresses3(input));

    }
    //all possible-> DFS
    //Valid IP address:
    //每一段都必须有数字，数字在0~255之间
    //一共四段数字
    //1. 一个ip地址只有3个点，根据点的个数判断合法不合法（也即字符串长度只能比点的个数多，且小于3*（k+1）,k为点的个数
    //2. 如果最后不需要添加点，则字段值小于256，则合法，添加结果集。

    //sol 1: recursive
    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList();
        if(s.length() < 1) {
            return result;
        }
        char[] digits = s.toCharArray();
        for(int i = 0; i<s.length();i++) {
            digits[i] -= '0';
        }
        DFS(0, digits[0],""+(int)(digits[0]),1, result, digits);
        return result;
    }

    private static void DFS(int part, int value, String tmp, int index, List<String> result, char[] digits) {
        if(part > 3 || index >= digits.length)  {
            if(part == 3 && index == digits.length) {
                result.add(tmp);
            }
            return;
        }
        if(value*10 +digits[index] <= 255 && value != 0) {
            DFS(part, value*10+digits[index], tmp+(int)digits[index],index+1, result, digits);
        }
        DFS(part+1, digits[index],tmp+"."+(int)digits[index],index+1,result, digits);

    }




    public static List<String> restoreIpAddresses3(String s) {
        List<String> list = new ArrayList();
        DFS(list, 3, "",s);
        return list;
    }

    private static void DFS(List<String> list, int k, String result, String s) {
        //1. check if it is a valid string
        if(s.length() <= k || s.length() > (k+1)*3) {
            return;
        }
        //2. check if the part < 256
        if(k == 0) {
            //not valid, skip
            if(s.charAt(0) == '0' && s.length()>1 ||Integer.parseInt(s) >= 256) {
                return;
            }
            //valid, append to temp and add dot
            list.add(result+"."+s);
            return;
        }
        //3. iterate first 3 parts, if less than 255, dive deeper
        for(int i = 1; i<=s.length(); i++) {
            String temp = s.substring(0,i);
            if(Integer.parseInt(temp) < 256) {
                String str = s.substring(i);
                //the first temp do not need .
                if(result.length()>0) {
                    temp = result+"."+temp;
                }
                DFS(list,k-1,temp,str);
                //why??
                if(s.charAt(0) == '0') {
                    break;
                }
            } else {
                break;
            }
        }


    }
}
