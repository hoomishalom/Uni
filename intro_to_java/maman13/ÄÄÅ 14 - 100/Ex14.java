/**
 * @version 12/12/20
 */
public class Ex14 {
//--------------------------QUESTION 1-----------------------------------------------------------------------------------------

    /**
     * this method return the single number in an array of pairs of numbers
     * the run time of this method is in the order of log2-n O(log-n).
     * like binary search it discard half of the examined range each iteration
     * by determining whether the single number is left or right to the middle point.
     *
     * @param a array of integers that consist of pairs of numbers and one single number.
     * @return the single number (value)
     */
    public static int findSingle(int[] a) {
        int leftMark = 0;
        int rightMark = a.length - 1;
        int middle;
        int count = 0;

        while (leftMark != rightMark) {
            count++;
            middle = (rightMark - leftMark) / 2 + leftMark;
            if (middle % 2 == 0) { //case: even index
                if (a[middle] == a[middle + 1]) //normal condition - single number is after this couple
                    leftMark = middle + 2;
                else if (a[middle] == a[middle - 1]) //abnormal condition - single number is before this couple
                    rightMark = middle - 2;
                else return a[middle]; //single number found

            } else { //case: uneven index
                if (a[middle] == a[middle - 1])  //normal condition - single number is after this couple
                    leftMark = middle + 1;
                else  //abnormal condition - single number is before this couple
                    rightMark = middle - 1;

                //single number cannot be in uneven index.
            }
        }
        return a[leftMark]; // by now both marks are equal and pointing the single number
    }

//--------------------------QUESTION 2-------------------------------------------------------------------------------------------------

    /**
     * this method will return the length of the smallest partition of an array which the sum of is bigger than a given number.
     * the efficiency of the method is in the order of n - O(n). this is because for any given array the while loop will run for 2n times of less.
     *
     * @param arr an array of integers
     * @param x   the goal number
     * @return the length of the smallest partition that it sum exceeds the given number.
     */
    public static int smallestSubSum(int arr[], int x) {
        int sum = arr[0];
        int backMark = 0;
        int frontMark = 0;
        int min = -1; //default value

        //the two markers start to run the array, the sum between them is calculated
        while (frontMark >= backMark) {
            if (sum > x) {
                if (min > frontMark - backMark + 1 || min == -1) {
                    min = frontMark - backMark + 1;
                    sum -= arr[backMark++];
                    if (min == 1)
                        return min;
                } else {
                    sum -= arr[backMark++];
                }
            } else {
                if (frontMark == arr.length - 1)
                    return min;
                sum += arr[++frontMark]; //is the sum is smaller - add the next number.
            }
        }
        return min;
    }
//--------------------------QUESTION 3------------------------------------------------------------------------------------------------------

    /**
     * this method calculates the number of possible solutions for the equation X+Y+Z=num given 0<X,Y,Z<11. and print each one.
     *
     * @param num the number to divide
     * @return the number of possible solutions.
     */
    public static int solutions(int num) {
        int[] solution = new int[]{1, 1, 1};
        return solutions(num, solution, 0);

    }

    /**
     * this method calculates the number of possible solutions for the equation X+Y+Z=num given 0<X,Y,Z<11. and print each one.
     *
     * @param num      the number to divide.
     * @param solution the current solution being referred.
     * @param i        the current index being referred.
     * @return the number of possible solutions.
     */
    private static int solutions(int num, int[] solution, int i) {
        final int MIN_VAL = 1;
        final int MAX_VAL = 10;
        int sum = solution[0] + solution[1] + solution[2]; //calculate total
        //error checks:
        if (i > 2) //illegal index - 0 solutions
            return 0;
        if (solution[i] > MAX_VAL) { //illegal solution value
            solution[i] = MIN_VAL; //restore to min
            return 0;
        }
        //solution checks:
        if (sum == num) { //solution found!
            System.out.println(solution[0] + " + " + solution[1] + " + " + solution[2]); //print it
            solution[i] = MIN_VAL; //and restore to min
            return 1;
        }
        /*if there is no error, and its not a solution- there are two options:
         a)look for solution in the next index
         b) increase the value*/
        int a = solutions(num, solution, i + 1);
        solution[i]++;
        int b = solutions(num, solution, i);
        return a + b;

    }
//--------------------------QUESTION 4---------------------------------------------------------------------------------------------------------------

    /**
     * this method find the number of true regions in a square matrix.
     *
     * @param mat a square matrix
     * @return the number of true regions.
     */
    public static int cntTrueReg(boolean[][] mat) {
        return cntTrueReg(mat, 0, 0);
    }

    /**
     * this method find the number of true regions in a square 2D boolean array.
     *
     * @param mat    a square 2D boolean array
     * @param row    the current referred row
     * @param column the current referred column
     * @return the number of true regions
     */
    private static int cntTrueReg(boolean[][] mat, int row, int column) {
        final int MAX_VAL = mat.length - 1;
        //error prevention
        if (column > MAX_VAL) { //reached the end of a row
            column = 0;
            row++;
        }
        if (row > MAX_VAL) //reached the end of the matrix
            return 0;

        if (!mat[row][column]) {
            return cntTrueReg(mat, row, column + 1);
        } else { //if (mat[row][column] == true)
            eraseReg(mat, row, column); // turn all this true region to false
            return 1 + cntTrueReg(mat, row, column + 1);
        }
    }

    /**
     * this method turns a whole true region in a 2D boolean array to false
     *
     * @param mat    a square 2D boolean array
     * @param row    the row value of the true point
     * @param column the column value of the true point
     */
    private static void eraseReg(boolean[][] mat, int row, int column) {
        final int MAX_VAL = mat.length - 1;
        if (row <= MAX_VAL && row >= 0 && column <= MAX_VAL && column >= 0) {  //t

            // he values are legal - check index validity before reaching array
            if (mat[row][column]) {
                mat[row][column] = false;
                // turn all subsequent values false - in all 4 directions
                eraseReg(mat, row, column + 1);
                eraseReg(mat, row, column - 1);
                eraseReg(mat, row + 1, column);
                eraseReg(mat, row - 1, column);
            }
        }
    }
}