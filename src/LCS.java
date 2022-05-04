import java.util.*;

public class LCS {

    public String LongCommSub (char[] first, char[] second) {
        String [][] comparisonMatrix = new String[second.length+1][first.length+1];
        int rowLength = comparisonMatrix.length;
        int colLength = comparisonMatrix[0].length;

        for (int i = 0; i < rowLength; i++) {
            for(int j = 0; j < colLength; j++) {
                comparisonMatrix[i][j] = "";
            }
        }
        
        for (int iRow = 1; iRow < rowLength; iRow++) {
            for(int jCol = 1; jCol < colLength; jCol++) {
                if(first[jCol-1] == second[iRow-1]) {
                    comparisonMatrix[iRow][jCol] = comparisonMatrix[iRow-1][jCol-1] + first[iRow];
                }
                else {
                    int topNeighbor = comparisonMatrix[iRow-1][jCol].length();
                    int DiagNeighbor = comparisonMatrix[iRow-1][jCol-1].length();
                    int leftNeighbor = comparisonMatrix[iRow][jCol-1].length();

                    if(topNeighbor >= DiagNeighbor && topNeighbor >= leftNeighbor){
                        comparisonMatrix[iRow][jCol] = comparisonMatrix[iRow-1][jCol];
                    } 
                    else if (DiagNeighbor >= topNeighbor && DiagNeighbor >= leftNeighbor) {
                        comparisonMatrix[iRow][jCol] =  comparisonMatrix[iRow-1][jCol-1];
                    }
                    else {
                        comparisonMatrix[iRow][jCol] = comparisonMatrix[iRow][jCol-1];
                    }
                }
            }
        }

        // Printing 2D array to compare the results
        // for (int i = 0; i < rowLength; i++) {
        //     for(int j = 0; j < colLength; j++) {
        //         System.out.print(comparisonMatrix[i][j] + " "); 
        //     }
        //     System.out.println();
        // }

        // LCS final string
        return comparisonMatrix[second.length][first.length];
    }

    public static void main(String[] args) throws Exception {
        LCS lcs = new LCS();
        // String s1 = "BANANA";
        // String s2 = "ATANA";

        String s1 = "cgtcgttatccgtcactggttgagatcgagtaagcaagacg";
        String s2 = "caaccatcgagtttgacgataagccgcaccagcgcgacat";

        char[] first = s1.toCharArray();
        char[] second = s2.toCharArray();

        System.out.println(lcs.LongCommSub(first, second));

    }
}
