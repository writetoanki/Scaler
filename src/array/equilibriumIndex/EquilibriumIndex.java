package array.equilibriumIndex;

import java.util.Scanner;

public class EquilibriumIndex {
    //Driver Function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Size of Array");
        int n = sc.nextInt();
        int[] input = new int[n];
        for(int i=0;i<n;i++){
            input[i] = sc.nextInt();
        }
        System.out.println(equilibriumIndex(input));
    }

    // Actual Function
    public static int equilibriumIndex(int [] A){
        int n = A.length;
        long[] leftPrefix = new long[n];
        long[] rightPrefix = new long[n];
        leftPrefix[0]=A[0];
        rightPrefix[n-1] = A[n-1];
        for(int i=1;i<n;i++){
            leftPrefix[i]=leftPrefix[i-1]+A[i];
            rightPrefix[n-i-1]=rightPrefix[n-i]+A[n-i-1];
        }
        // -7,1,5,2,-4,3,0
        //left  -7,-6,-1,1,-3,0,0
        //right  -7,7,6,1,-1,3,0

        for(int i=0;i<n;i++){
            if(i==0 ){
                if(rightPrefix[1]==0)
                    return i;
            }
            else if(i==n-1){
                if(leftPrefix[n-2]==0)
                    return i;
            }
            else if(leftPrefix[i-1]==rightPrefix[i+1]){
                    return i;
                }
            }
        return -1;
    }

}
