# System

`System`是有关于系统的类，这里不会介绍那么高深的内容，主要介绍两个静态方法

- `currentTimeMillis()`
  - 获得当前系统距时间原点的毫秒值
  - 这个方法可以用来计算程序损耗的实践
  - 在程序开始执行前获取一个时间，在程序执行完成获取一个时间，两个时间相减就可以知道程序执行的时间，就可以知道程序的哪一部分最耗时，从而做出优化
- `arraycopy()`
  - 该方法的作用是将源数组从指定位置开始复制，有一个参数规定了复制的长度，复制到另一个数组，这个数组也规定了起始的位置
  - 该方法接收五个参数
  - 第一个参数是一个源数组`src`，第二个参数是源数组的起始位置，第三个参数是目的数组，第四个参数是目的数组的起始位置，第五个参数是复制的长度
  - 如果你在这里没有理解，请看下面的例子



下面简单演示这两个方法的使用

```java
import java.util.Arrays;

public class TestSystem {
    public static void main(String[] args) {
        long start = System.currentTimeMillis(); //循环执行前获取一次时间
        int sum = 0;
        for (int i = 0; i < 10000000; i++) { //1000万次
            sum = sum + i;
        }
        long end = System.currentTimeMillis();  //循环结束后获取一次时间
        double time = (end - start) / 1000.0;  //将单位转化为s
        System.out.println("共花费" + time + "s");

        //我们将源数组的前三个元素替换目的数组的前三个元素
        int[] array1 = {1, 2, 3, 4, 5};      //源数组
        int[] array2 = {6, 7, 8, 9, 10};     //目的数组
        System.out.println("转换前");
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.arraycopy(array1, 0, array2, 0, 3); //前三个元素，所以都是从索引0开始
        System.out.println("转换后");
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }
}
```

输出为

```java
共花费0.011s
转换前
[1, 2, 3, 4, 5]
[6, 7, 8, 9, 10]
转换后
[1, 2, 3, 4, 5]
[1, 2, 3, 9, 10]
```

可见程序是执行的相当的快。