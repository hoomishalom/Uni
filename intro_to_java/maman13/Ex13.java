/**
 * @author Tom Shabtay
 * @version 2024b
 */
public class Ex13 {

    /**
     * finds the single number in an array
     * @param a the array
     * @return the single number
     * Time Complexity: O(logn), binary search
     * Space Complexity: O(1), constent number of variables
     */
    public static int findSingle(int[] a){
        int first = 0;
        int last = a.length - 1;
        int middle = (first + last) / 2;
        
        while(last > first) {                       // when first == last that means we found the number
            if(a[middle] == a[middle - 1]){         // if this statement is true that means the number is to the right of middle
                first = middle + 1;
            } else {                                // if the statement is false that means the number is to the left of middle
                last = middle - 1;
            }
            middle = (first + last) / 2;            // recalculates middle
        }

        return a[middle];
    }

    /**
     * takes an array of natural numbers that represent heights and calculates the water the shape can hold
     * @param heights array of heights
     * @return amount of water the shape can hold
     * Time Complexity: O(N), goes through the array once
     * Space Complexity: O(1), fixed number of variables
     */
    public static int waterVolume(int[] heights){
        int waterSum = 0;
        int leftIndex = 0, rightIndex = heights.length - 1;
        int leftMax = 0; 
        int rightMax = 0;

        while(rightIndex >= leftIndex) {
            if(heights[leftIndex] < heights[rightIndex]) {
                if (heights[leftIndex] > leftMax) {
                    leftMax = heights[leftIndex];
                } else {
                    waterSum += leftMax - heights[leftIndex];
                }
                leftIndex++;
            } else {
                if (heights[rightIndex] > rightMax) {
                    rightMax = heights[rightIndex];
                } else {
                    waterSum += rightMax - heights[rightIndex];
                }
                rightIndex--;
            }
        }
        return waterSum;
    }


    private static String increment(String str){
        char last = str.charAt(str.length() - 1);

        if(last == 'z'){
            return increment(str.substring(0, str.length() - 1)) + 'a';
        } else {
            return str.substring(0, str.length() - 1) + (char)(last + 1);
        }
    }


    /* not recursive */
    public static String findPassword(Password p, int length){
        String str = new String(new char[length]).replace('\0', 'a');  
        while(!p.isPassword(str)){
            str = increment(str);
        }
        return str;
    }

    public static int cntTrueReg (boolean[][]mat){

        return 1;
    }

}