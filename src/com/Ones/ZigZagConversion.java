package com.Ones;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
    /*
    *           *      *     *
    *           *    * *    **
    *           *  *   *  *  *
    *           **     **    *
    *           *      *     *
    *
    *
    * */
    public static void main(String[] args) {
        String s =  "PAYPALISHIRING";
        //TC1:
        String result = convert(s,3);
        /*
        * expected:
        * P   A   H   N
        * A P L S I I G
        * Y   I   R
        * result = "PAHNAPLSIIGYIR";
        * */
        System.out.println(result);
        //TC2:
        String result2 = convert(s,4);
        /*
        * expected:
        * P     I    N
        * A   L S  I G
        * Y A   H R
        * P     I
        * */
    }


    //Sol 1: sort by row: left->right, current row & current direction
    //Time = O(n), n == leng(s)
    //Space = O(n)
    public static String convert(String s, int numRows) {
            //corner case
            if(numRows == 1) {
                return s;
            }
            //process
            //1.create result rows
            List<StringBuilder> rows = new ArrayList();
            for(int i = 0; i<Math.min(numRows, s.length()); i++) {
                rows.add(new StringBuilder());
            }
            int curRow = 0;
            boolean goingDown = false;
            //2.traverse string characters
            for(char c: s.toCharArray()) {
                rows.get(curRow).append(c);
                if(curRow == 0 || curRow == numRows -1) {
                    goingDown = !goingDown; //转向
                }
                //update position for curRow: go down/up
                curRow += goingDown ? 1:-1;
            }
            //3.attach all rows to one result string
            StringBuilder res = new StringBuilder();
            for(StringBuilder row:rows) {
                res.append(row);
            }
            return res.toString();
    }


}
