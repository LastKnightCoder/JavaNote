# 第一个程序: HelloWorld

下面将书写`Java`的第一个程序，它的作用是在命令行输出`Hello World!`。



新建一个文件，文件名为`HelloWorld.java`，使用记事本或其他代码编辑工具打开，敲入以下代码

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
```

然后在命令行中输入

```powershell
javac HelloWorld.java
java HelloWorld
```

然后就可以在命令行中看到`Hello World!`输出了。



**注意事项：**

- `class`后面的`HelloWorld`要与文件名一样，包括大小写
- 在命令行使用`javac`或者`java`命令时，要保证所处的路径与文件`HelloWorld.java`在同一个路径，否则会报错，解决办法有两种
  - 第一种，使用`cd`命令切换到`HelloWorld.java`文件的目录
  - 第二种，`javac`或者`java`命令后跟上`HelloWorld.java`的完整路径名称
- `javac`命令后面有后缀`.java`，`java`命令后面没有任何的后缀



现在稍微解释上面程序的意思，因为刚刚起步，很多东西现在都解释不了，所以在这里并不要求弄懂。第一行

```java
public class HelloWorld
```

这里，我们只需要记住`HelloWorld`必须与文件名**相同**。第二行

```java
public static void main(String[] args)
```

这个是固定的写法，几乎每个程序都是这么写的，这个是程序的入口，程序从这里开始执行。第三行

```java
System.out.println("Hello World!");
```

这个语句是关键的程序，它的作用就是向屏幕输出字符，这里我们输入的是`Hello World!`，注意输出的语句需要被双引号括起来。