public class tmp {
    public static int main(String[] args){
        Box3D p = new Box3D();
        System.out.println(p);
        System.out.println(p.getBase());
        Point3D testgetBase = p.getBase();
        testgetBase = new Point3D(9,9,9);
        System.out.println(p + "testgetBase");
        return 1;
    }
}
