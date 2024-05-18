/**
 * @author Tom Shabtay
 * @version 2024b
 */
public class Ex13 {

    // Question 1

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
        
        while(last > first) {                                       // when first == last that means we found the number
            if(a[middle] == a[middle + 1]){
                if(middle % 2 == 0) {                               // number is to the right of middle
                    first = middle + 1;             
                } else {                                            // number is to the left of middle
                    last = middle - 1;
                }
            } else {
                if(middle % 2 == 0) {
                    last = middle - 1;                              // number is to the left of middle          
                } else {        
                    first = middle + 1;                             // number is to the right of middle
                }
            }

            middle = (first + last) / 2;            // recalculates middle
        }

        System.out.println("test" + middle);
        System.out.println("test");
        return a[middle];
    }

    // Question 2

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

    // Question 3
    
    /**
     * calls a function that cracks the password
     * @param p the Password object
     * @param length the length of P
     * @return the password in a String form
     */
    public static String findPassword(Password p, int length){
        String str = createStr(length, 0);   // creates a String of 'a'*length
        
        return findPassword(p, str);                                                    // calls the cracker function
    }
    
    /**
     * cracks a password from the class Password using brute force
     * @param p the Password object
     * @param str last's iteration try, on first iteration needs to be 'a'*length
     * @return the password in a String form
     */
    public static String findPassword(Password p, String str) {
        if(p.isPassword(str)) return str;       // stops the recursion

        return findPassword(p, increment(str)); // check next possible password
    }

    /**
     * increments a String by one letter
     * @param str the String to increment
     * @return the incremented String
     */
    private static String increment(String str) {
        char last = str.charAt(str.length() - 1);                                       // gets last char of str

        if(last == 'z'){                                                                // checks if last char of str is z
            return increment(str.substring(0, str.length() - 1)) + 'a';      // turns the last char to 'a' and increments second to last char
        } else {
            return str.substring(0, str.length() - 1) + (char)(last + 1);    // increments last char
        }
    }

    public static String createStr(int len, int counter) {
        if (counter < len - 1) {
            counter++;
            return "a" + createStr(len, counter);
        }
        return "a";
    }
    
    // Question 4

    /**
     * calls a method that counts "True Regions"
     * @param mat 2D boolean array
     * @return amount of "True Regions"
     */
    public static int cntTrueReg (boolean[][] mat) {
        return cntTrueReg(mat, 0, 0);   // calls a method that counts "True Regions" and returns result
    }

    /**
     * counts "True Regions" 
     * @param mat 2D boolean array to count "True Regions" in
     * @param row row to check, 0 on first iteration
     * @param col column to check, 0 on first iteration
     * @return amount of "True Regions"
     */
    public static int cntTrueReg (boolean[][] mat, int row, int col) {
        int maxRow = mat.length - 1;
        int maxCol = mat[0].length - 1;
        int square = 0;

        if(mat[row][col]){                                      // checks if the current square is true
            deleteRegion(mat, row, col);                        // deletes the region
            square = 1;                                         // adds 1 to the region counter
        }

        if(col == maxCol) {                                     // if statement to make sure not to go out of bounds
            if(row == maxRow) {                                 // true only if were at the bottom right square
                return square;
            }
            return square + cntTrueReg(mat, row + 1, 0);    // checks for more regoins
        } else {
            return square + cntTrueReg(mat, row, col + 1);      // checks for more regoins
        }
    }

    /**
     * deletes "True Regions"
     * @param mat 2D array to delete "True Regions" in
     * @param row row to check
     * @param col column to check
     */
    public static void deleteRegion (boolean[][] mat, int row, int col) {
        if(!mat[row][col]) return;                              // stops the recursion

        int maxRow = mat.length - 1;
        int maxCol = mat[0].length - 1;
        
        mat[row][col] = false;                                  // deletes the current square

        if(row < maxRow) deleteRegion(mat, row + 1, col);       // checks if needs to delete other squares
        if(row > 0) deleteRegion(mat, row - 1, col);
        if(col < maxCol) deleteRegion(mat, row, col + 1);
        if(col > 0) deleteRegion(mat, row, col - 1);
    }
}