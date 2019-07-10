public class TestArray {
    public static void printArray (int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static double[] getSumAndAvg (int[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        double avg = sum / array.length;
        double[] result = { sum, avg };
        return result;
    }

    public static void main(String[] args) {
        int[] array1 = new int[3];
        System.out.println(array1); // 猜猜打印出什么

        array1[0] = 10;
        System.out.println(array1[0]);

        int[] array2 = array1;
        System.out.println(array2); 
        array2[1] = 200;
        System.out.println(array1[1]);

        int[] array = { 1, 4, 7, 9, 5};
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        int max = array[0]; //擂主为第一个元素
        for (int i = 1; i < array.length; i++) { //挑战者不断挑战
            if (array[i] > max) {
                max = array[i];      //如果挑战者比擂主强，那么换擂主，否则擂主不变
            }
        }
        System.out.println(max); //此刻的擂主就是最强的

        int len = array.length;
        for (int i = 0; i < (len - 1) / 2; i++) {
            int temp = array[i];
            array[i] = array[len -1 -i];
            array[len -1 -i] = temp;
        }
        for (int i = 0; i < len; i++) {
            System.out.println(array[i]);
        }
        System.out.println("============");
        printArray(array);

        double[] resArr = getSumAndAvg(array);
        System.out.println("Sum is " + resArr[0]);
        System.out.println("Average is " + resArr[1]);
    }
}