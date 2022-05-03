import java.util.*;

public class LCS {

    public String LongCommSub (char[] first, char[] second) {
        String returnString [][] = new String[first.length+1][second.length+1];

        for (int i = 0; i < returnString.length; i++) {
            for(int j = 0; i < returnString[0].length; j++) {
                returnString[i][j] = " ";
            }
        }

        
        for (int i = 1; i < returnString.length; i++) {
            for(int j = 1; i < returnString[0].length; j++) {
                if(first[i] == second[j]){
                    returnString[i][j] = returnString[i-1][j-1] + first[i];
                }
                else {
                    int l1 = returnString[i-1][j].length();
                    int l2 = returnString[i-1][j-1].length();
                    int l3 = returnString[i-1][j].length();

                    if(l1 >= l2 && l1 >= l3){
                        returnString[i][j] = returnString[i][j] + returnString[i-1][j];
                    } 
                    else if (l2 >= l1 && l2 >= l3) {
                        returnString[i][j] = returnString[i][j] + returnString[i-1][j-1];
                    }
                    else {
                        returnString[i][j] = returnString[i][j] + returnString[i-1][j];
                    }
                }
            }
        }

        return returnString[first.length][second.length];
    }

    public static void main(String[] args) throws Exception {
        LCS lcs = new LCS();
        String s1 = "BANANA";
        String s2 = "ATANA";

        char[] first = s1.toCharArray();
        char[] second = s2.toCharArray();

        System.out.println(lcs.LongCommSub(first, second));


    }
}
