public class Ex13Tester {
    public static void main(String[] args) {
        // int[] a = {5, 1, 1, 2, 2, 2, 2};
        // System.out.println(Ex13.findSingle(a));

        // System.out.println(Ex13.createStr(0, 5));
        // int[] array2 = {2,1,1,4,1,1,2,3,2,3};
        // int[] array2 = {3,2,1,1,1,1,1,2,1,1,1};
        // System.out.println("Result is: "+Ex13.waterVolume(array2));
        // System.out.println();
        


        int len = 6;
        Password p = new Password(len);
        String getPassword=p.getPassword();
        String findPassword= Ex13.findPassword(p,len);
        System.out.println("getPassword returns: "+getPassword);
        System.out.println("findPassword returns: "+findPassword);
    
    }
}
