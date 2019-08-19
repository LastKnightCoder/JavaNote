# Java中的常量

`Java`中的常量分为：

- 字符串常量：使用双引号括起来的，如`"Hello World!"`
- 整型常量：其实就是整数，如`5`
- 浮点数：小数，如`2.5`
- 字符常量：用单引号括起来的，单引号里面必须有一个字符，不可以没有，也不可以多于一个，如`'ab',''`都是错误的，另外这个字符可以是中文，如`'中'`
- 布尔常量：只有两个值`true`和`false`
- 空常量：`null`，这个在这里不多做介绍

在前面我们学习了向屏幕输出`Hello World!`，类似的，在这里我们可以尝试着把常量输出出来，新建一个文件为`Constant.java`，注意前面提及的命名规范，`Constant`是类名，所以首字母需要大写，然后在该文件中敲入

```java
public class Constant {
    public static void main(String[] args) {
        //下面我将输出一些常量
        System.out.println("Hello"); //输出字符串常量
        System.out.println(5); //输出整型常量
        System.out.println(2.5); //输出浮点型常量
        System.out.println('a'); //输出字符型常量
        System.out.println(true); //输出布尔型常量
    }
}
```

输出为：

```java
Hello
5
2.5
a
true
```

**注意：**

- 不能打印出`null`，如`System.out.println(null)`会报错
- 上面`//`后面的内容为注释，编译器会自动的忽略，注释是对程序的解释，是为了帮助人看懂程序的

