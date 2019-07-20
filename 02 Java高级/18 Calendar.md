# Calendar

`Calendar`是一个有关于日期的类，它提供了一些操作日历的方法，它是一个抽象类，所以不能创建`Calendar`对象，我们可以通过它的静态方法`getInstance()`得到它的一个子类对象，如下

```java
Calendar calendar = Calendar.getInstance();
```

这里仅简单介绍它的四个方法

- `get(int field)`
  - 根据指定`field`值获取日历信息，`field`值一般为`Calendar`类的静态常量，如`get(Calendar.YEAR)`可以获得有关于年份的信息
- `set(int field, int value)`
  - 设置指定的`field`为指定的`value`
- `add(int field, int amount)`
  - 为指定`field`加上`amount`
  - 这里需要注意的是，如果加上数值之后超过范围之后，会有进位。比如现在为`7`月，我给`MONTH`加上了`10`，那么现在年份会加`1`年，并且此时的月份为`7 + 10 -12 = 5`。
- `getTime()`
  - 返回当前日历对应得`Date`对象



下面简单演示方法的使用

```java
import java.util.Calendar;
import java.util.Date;

public class TestCalendar {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar); //打印出的不是地址，可见Calendar也重写了toString()方法

        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH) + 1); //西方的月份是从0开始的，所以这里我加1
        System.out.println(calendar.get(Calendar.DATE));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH)); //与上面DATE的效果是一样的
        System.out.println(calendar.get(Calendar.HOUR));
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));

        System.out.println("=============");
        calendar.set(Calendar.YEAR, 2020);  //设置年份为2020年
        System.out.println(calendar.get(Calendar.YEAR));
        calendar.add(Calendar.MONTH,10);  //给月份加10个月，现在为2021年5月了
        System.out.println(calendar.get(Calendar.MONTH) + 1);
        Date dateAgain = calendar.getTime();  //得到一个日期对象
        System.out.println(dateAgain);
    }
}
```

输出为

```java
java.util.GregorianCalendar[time=1563623852127,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,transitions=29,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2019,MONTH=6,WEEK_OF_YEAR=29,WEEK_OF_MONTH=3,DAY_OF_MONTH=20,DAY_OF_YEAR=201,DAY_OF_WEEK=7,DAY_OF_WEEK_IN_MONTH=3,AM_PM=1,HOUR=7,HOUR_OF_DAY=19,MINUTE=57,SECOND=32,MILLISECOND=127,ZONE_OFFSET=28800000,DST_OFFSET=0]
2019
7
20
20
7
57
32
=============
2020
5
Thu May 20 19:57:32 CST 2021
```

