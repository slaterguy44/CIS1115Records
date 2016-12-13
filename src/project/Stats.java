/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author 55slaterbc30
 */
public class Stats {


    /**
     * Sum up the numbers in an array
     *
     * @param nums - array of numbers to sum
     * @return total of the numbers
     */
    public static int sum(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[1];
        }
        return total;

    }

    /**
     *Finds the <b>maximum</b> value in an array.
     * 
     * @param x
     * @return
     */
    public static int max(int[] x) {
        int biggest = Integer.MIN_VALUE;
        for (int i = 0; i < x.length; i++) {
            if (x[i] > biggest) {
                biggest = x[i];
            }
        }
        return biggest;
    }

    /**
     *Finds the smallest number in an array
     * @param x
     * @return
     */
    public static int min(int[] x) {
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < x.length; i++) {
            if (x[i] < smallest) {
                smallest = x[i];
            }
        }
        return smallest;
    }

    /**
     *Finds the average of an array
     * @param x
     * @return
     */
    public static double avg(int[] x) {
        if (x.length > 0) {
            return (double) sum(x) / x.length;
        }
        return 0;
    }

    /**
     *Finds the deviation of an array
     * @param x
     * @return
     */
    public static double standardDeviation(int[] x) {
        double total = 0;
        double mean = avg(x);
        for (int i = 0; i < x.length; i++) {
            total += Math.pow(x[i] - mean, 2);
        }
        return Math.sqrt(total / (x.length - 1));
    }

    /**
     *Reverses the order of the array
     * @param x
     */
    public static void reverse(int[] x) {
        for (int i = 0; i < x.length / 2; i++) {
            int temp = x[i];
            x[i] = x[x.length - i - 1];
            x[x.length - i - 1] = temp;

        }

    }

    /**
     *
     * @param x
     * @return
     */
    public static int[] reverseNC(int[] x) {

        int n = x.length;
        int[] result = new int[n];
        for (int resultIndex = 0, xIndex = n - 1; resultIndex < n; resultIndex++, xIndex--) {
            result[resultIndex] = x[xIndex];
        }
        return result;

    }

    /**
     *generate a new array size 100
     * @param x
     * @return
     */
    public static int[] count100(int[] x) {
        int[] count = new int[101];
        
        return count;
    }

    /**
     *Finds the numbers above average in the array
     * @param x
     * @return
     */
    public static int aboveAvg(int[] x) {
        double myavg = (double) avg(x);
        int count = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] >= myavg) {
                count++;
            }

        }
        return count;

    }

    /**
     *reads the reversed string
     * @param x
     * @return
     */
    public static String toString(int[] x) {
        StringBuilder sb = new StringBuilder("");
        int i = 0;
        for (i = 0; i < x.length - 1; i++) {
            sb.append(x[i]).append(", ");
        }
        if(x.length > 0){
            
        
        sb.append(x[i]);
        }
        return sb.toString();

    }

}
  

