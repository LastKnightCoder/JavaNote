# Date

`Date`是有关于日期的类，它位于`java.util`包中。现在主要介绍它的两种常用的构造方法，以及一个有关于格式化输出的类`SimpleDateFormat`。

## 构造方法

```java
Date date = new Date();  //默认得到的是当前时间的日期
Date date = new Date(long l); //接收一个毫秒值，该毫秒值代表的是距离时间原点消耗的毫秒值
```

时间原点规定为`1970年1月1日的00:00:00`时刻。现在简单演示`Date`类的使用

```java
import java.util.Date;

public class TestDate {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date);
    }
}
```

输出为

```java
Sat Jul 20 19:26:26 CST 2019
```

可见`Date`类重写了`toString()`方法。



`Date`类有一个`getTime`的方法，它可以获得该`date`对象对应的毫秒值，现在我们通过这个方法获得一个毫秒值，然后利用该毫秒值作为第二个构造函数的参数

```java
import java.util.Date;

public class TestDate {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date);
        
        long ms = date.getTime();
        Date date2 = new Date(ms);
        System.out.println(date2);
    }
}

```

输出为

```java
Sat Jul 20 19:29:24 CST 2019
Sat Jul 20 19:29:24 CST 2019
```

## SimpleDateFormat

上面的时间输出其实不符合我们的使用习惯，所以我们可以让输出的日期符合我们的使用习惯。`DateFormat`这个类是为此而存在的，不过它是一个抽象类，`SimpleDateFormat`类继承了该类，我们可以使用该类格式化日期输出。



首先就是如何创建一个对象，如下

```java
SimpleDateFormat simpleDateFormat = new SimpleDateFormat(模式);
```

可能这里还不能理解模式是个什么鬼，那么就要看下面这个例子

```java
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
```

`"yyyy年MM月dd日"`就是模式，差不多就是模板吧，也就是你想要格式化输出的格式，其中`yyyy`代表年，`MM`代表月，`dd`代表日，`HH`代表小时，`mm`代表分，`ss`代表秒。



这里主要介绍它的两个方法

- `format`
  - 接收一个日期对象，返回一个字符串，这个字符串的格式与你上面定义的模式相同
- `parse`
  - 接收一个字符串，这个字符串的格式必须与你定义的模式相同，否则会报错
  - 方法一个`Date`对象
  - `parse`方法会抛出一个异常，对于抛出异常的方法，要么继续抛出异常，要么使用`try-catch`处理

下面介绍这个类的使用

```java
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDate {
    public static void main(String[] args) throws ParseException {  //parse方法有可能抛出这个异常，这里我们不处理，继续抛出
        Date date = new Date();  //创建一个Date对象作为后面format方法的参数
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss"); //定义输出格式
        String formatDate = simpleDateFormat.format(date);  //获得由date转化得到的格式化输出字符串
        System.out.println(formatDate);

        Date dateAgain = simpleDateFormat.parse("2017年5月13日 15:23:14"); //根据指定的格式解析出一个Date对象
        System.out.println(dateAgain); //打印该Date对象
    }
}
```

输出为

```java
2019年07月20日 19:43:18
Sat May 13 15:23:14 CST 2017
```

