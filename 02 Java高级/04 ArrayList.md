# ArrayList

`ArrayList`可以看做是一个数组，因为数组的长度一旦创建就不可以改变，这很不方便，而`ArrayList`的长度可以改变，比较灵活，下面讲解如何使用`ArrayList`类。

## ArrayList对象的创建

`ArrayList`类位于`java.util`包下，所以在使用前需要导入该包。与一般类的创建稍有不同，`ArrayList`对象的创建如下

```java
ArrayList<数据类型> 变量名 = new ArrayList<>();
```

我们注意到与一般类的创建多了`<>`，这个叫做泛型。我们定义数组的话有不同的数据类型，同样的`ArrayList`也有不同的数据类型，而数据类型就是写在里面，目前我们就这么理解泛型。在`=`号的右边也有`<>`号，从`JDK 1.7`开始，右边的`<>`里面可以什么都不写，之前里面也要写数据类型，但是和右边的一样，所以没必要在写一遍。另一个需要注意的是，泛型（也就是`<>`里面的数据类型）必须是引用类型，不能是基本类型。



现在如果我们想创建一个`ArrayList`，里面存放的都是`String`类型，我们应该这么写

```java
ArrayList<String> list = new ArrayList<>();
```

## 常见的ArrayList方法

我们将介绍四个常见的方法

- `public boolean add(E e)`
  - 向`ArrayList`中添加一个元素，这里的`E`与泛型相同，如果之前在`<>`里面写的是`String`，那么`E`就是`String`。
  - 如果添加成功就返回`true`
  - 对于`ArrayList`添加动作一定成功，所以`add`方法的返回值可以不用
- `public E get(int index)`
  - 根据`index`获取`ArrayList`中的元素
- `public E remove(int index)`
  - 根据`index`删除`ArrayList`中的元素，并且返回删除的元素
- `public int size()`
  - 获得`ArrayList`的长度，即元素的个数



下面将简单的示例上述方法的使用

```java
import java.util.ArrayList;

public class TestArrayList {
    public static void main(String[] args) {
        //创建一个ArrayList对象 里面保存的都是String类型
        ArrayList<String> list = new ArrayList<>();

        //向列表中添加三个元素
        list.add("张三");
        list.add("李四");
        list.add("王五");

        //打印列表
        System.out.println(list);  //ArrayList对toString()方法重写了，所以打印输出不是地址值
        //获取列表里面的元素
        System.out.println("列表的第一个元素为：" + list.get(0));
        System.out.println("列表的第二个元素为：" + list.get(1));
        System.out.println("列表的第三个元素为：" + list.get(2));
        System.out.println("列表的长度为：" + list.size());  //获取列表的长度

        System.out.println("===============");
        
        //删除
        System.out.println("删除的元素为：" + list.remove(1)); //删除第二个元素，即删除李四
        System.out.println("列表的长度为：" + list.size()); //列表的长度
        System.out.println(list);
    }
}

```

输出为：

```java
[张三, 李四, 王五]
列表的第一个元素为：张三
列表的第二个元素为：李四
列表的第三个元素为：王五
列表的长度为：3
===============
删除的元素为：李四
列表的长度为：2
[张三, 王五]
```

上面代码的注释已经详细说明上面代码的功能，这里说一下一个特别的地方。当我们打印数组名时，会得到数组的地址，但是当我们打印`ArrayList`对象，输出的不是地址，而是里面的元素，这是因为`ArrayList`重写了`toString()`方法，当`System.out.println()`里面传入的是引用类型时，会调用该引用类型的`toString`方法，由于`ArrayList`重写了`toString()`方法，所以打印输出的不是地址，没有重写该方法的类，打印输出默认是地址。如果在这里你搞不懂什么重写，`toString()`方法都是什么，那么没关系，你只要知道**直接打印`ArrayList`对象名，输出的不是地址，而是里面包含的所有元素**，具体重写是什么，`toString()`是什么，在后面的继承部分将会有阐述。

## ArrayList存储基本数据类型

在上面我们提到过，泛型只能是引用类型，不能是基本数据类型，那么如果我们想要保存基本数据类型怎么办。当然是有办法的，`Java`中为每一个基本数据类型提供了一个包装类，它虽然是一个类，但是你在使用时完全把它当做基本数据类型就可以，因为泛型里面不能是基本数据类型，才会有这么一个包装类。下表是基本数据类型与包装类对应的名称

| 基本数据类型 | 包装类      |
| ------------ | ----------- |
| `byte`       | `Byte`      |
| `short`      | `Short`     |
| `int`        | `Integer`   |
| `long`       | `Long`      |
| `float`      | `Float`     |
| `double`     | `Double`    |
| `char`       | `Character` |
| `boolean`    | `Boolean`   |

上面除了`int`和`char`对应的包装类不只是首字母大写，其他都是只要首字母大写即可。



下面我将演示如何存储基本数据类型，以`int`类型为例

```java
import java.util.ArrayList;

public class BasicDataToArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        //把Integer当做int看待即可，我们不需要new 一个Integer对象 编译器会帮我们做处理，我们不需要担心
        list.add(100);
        list.add(25);
        list.add(15);

        //打印列表
        System.out.println(list);
    }
}

```

输出为

```java
[100, 25, 15]
```

在基本数据类型与包装类之间有自动装换，基本数据类型转换为包装类的过程叫做**装箱**，包装类转化为基本数据类型的过程叫做**拆箱**，从`JDK 1.5`开始就支持自动装箱和自动拆箱。即我们可以这么写

```java
Interger a = 12; //自动装箱 int -- Interger
int b = a; //自动拆箱 Interger -- int
```

所以我们在使用时把`Interger`看做`int`就可以了。

## ArrayList作为方法的参数与返回值

`ArrayList`作为一个引用数据类型，当然可以作为方法的参数与返回值，下面举两个小例子。



写一个方法，要求参数为一个`ArrayList<Interger>`的对象，将该列表中的所有元素都加`1`。

```java
import java.util.ArrayList;

public class PlayArrayList1 {
    public static void plusOne(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            //set方法接收两个参数
            //第一个参数是要更改元素的位置，第二个参数是要更改的元素
            //set方法的作用是，将指定位置的元素设置为要更改的元素
            list.set(i,list.get(i) + 1);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(1);
        list.add(2);
        list.add(3);
        
        System.out.println("加一前" + list);
        plusOne(list);
        System.out.println("加一后" + list);
    }
}

```

输出为

```java
加一前[1, 2, 3]
加一后[2, 3, 4]
```



写一个方法，接收一个`ArrayList<Interger>`，筛选出里面所有的偶数，放到另一个`ArrayList<Interger>`中，并返回该列表。

```java
import java.util.ArrayList;
import java.util.Random;

public class PlayArrayList2 {
    public static ArrayList<Integer> getEvenEle(ArrayList<Integer> list) {
        ArrayList<Integer> resList = new ArrayList<>(); //放偶数的数组

        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (num % 2 == 0) { //判断是否为偶数
                //是偶数就添加到resList中
                resList.add(num);
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        //我们使用Random产生20个1-100的随机数
        Random r = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        //将20个随机数放入list中
        for (int i = 0; i < 20; i++) {
            int num = r.nextInt(100) + 1; //产生1-100的随机数
            list.add(num); //将随机数放入list中
        }

        ArrayList<Integer> resList = getEvenEle(list); //调用方法

        //将两个列表都打印，进行对比
        System.out.println(list);
        System.out.println(resList);
    }
}
```

输出为

```java
[13, 39, 60, 81, 86, 69, 18, 60, 26, 95, 29, 53, 36, 38, 63, 41, 65, 52, 65, 41]
[60, 86, 18, 60, 26, 36, 38, 52]
```

