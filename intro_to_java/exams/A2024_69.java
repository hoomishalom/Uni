public class A2024_69 {
    public static int count(int sum) {
        System.out.println("called");
        return count(sum, 1, 1);
    }

    public static int count(int sum, int first, int d) {
        int newFirst;
        int newD;

        // System.out.println("first: " + first);
        // System.out.println("D: " + d);
        if (first == sum) return 1;

        if(d >= sum - 2) {
            if(first == sum) {
                return 1;
            } else {
                newFirst = first + 1;
                newD = 0;
            }
        } else {
            newFirst = first;
            newD = d + 1;
        }

        // System.out.println("newFirst: " + newFirst);
        // System.out.println("newD: " + newD);

        if (first == sum) {
            return 1;
        }

        if(sequenceSumEqual(sum, first, d)) {
            System.out.println("first: " + first);
            System.out.println("d: " + d);
            return 1 + count(sum, newFirst, newD);
        } else {
            return count(sum, newFirst, newD);
        }
    }

    public static boolean sequenceSumEqual(int sum, int first, int d) {
        if(sum == 0) return true;
        if(sum < 0) return false;

        return sequenceSumEqual(sum - first, first + d, d);
    }

    public static void minNumWithSum(int[]arr, int s) {
        int left = s - arr.length;
        if(arr.length > s) {
            for(int i = arr.length - 1; i >= 0; i--) {
                if(left >= 8) arr[i] = 1 + 8;
                else arr[i] = 1 + (left >= 0 ? left : 0);
                left -= 8;
            }
        }
    }
}