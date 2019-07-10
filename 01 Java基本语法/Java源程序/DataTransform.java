public class DataTransform {
    public static int add (int i, double j) {
        return (int) (i + j);
    }
    // public static int add (double i, int j) {
    //     return (int) (i + j);
    // }
    public static void main(String[] args) {
        int res = add(1, 2);

        // char c = 'A';
        // int a = c;
        // System.out.println(a);
        // int i = 1;
        // String s1 = "Hello";
        // String s2 = i + s1;
        // System.out.println(s2);

        // int b = 10 / 3;
        // System.out.println(b);

        // int a= 3;
        // int b = 4;
        // int c = 4 > 3 ? a : b++;
        // System.out.println(b);

        // System.out.println("我是第一条语句");
        // System.out.println("我是第二条语句");

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d*%d=%2d  ",j,i,j*i);
            }
            System.out.println();
            
        }
    }
}