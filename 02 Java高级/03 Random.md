# Random

`Random`类的作用主要是用于产生随机数的，它位于`java.util`包下面。下面介绍它的两个主要的方法

- `nextInt()`：产生一个随机整数，范围时整个`int`的大小
- `nextInt(int n)`：产生一个`[0,n-1)`的整数，左闭右开。

下面将介绍`Random`的使用。下面这个程序将产生`10`个随机整数，范围为整个`int`整数的范围

```java
import java.util.Random;

public class TestRandom {
    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(r.nextInt());
        }
    }
}

```

程序输出为

<img src="images/TestRandom.gif">

可见产生的整数是随机的，并且范围时整个`int`的范围，正值和负值都有。

下面这个程序将产生`10`范围为`1-10`的随机整数

```java
import java.util.Random;

public class TestRandomAgain {
    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(r.nextInt(10) + 1); //nextInt(10)的范围为0-9，+1变为1-10
        }
    }
}

```

程序输出为

<img src="images/TestRandom2.gif">

输出的数字的范围在`1-10`之间，并且输出的数字是随机的。