# Collection

`Collection`是集合的意思，你可以把它看做一种装东西的容器，就像数组一样。它是一个接口，有很多的类实现了它，比如`Arralist`，`LinkedList`，`HashMap`，等等很多。不同的类使用不同的方法去实现，所以他们之间的某些性能是不同的。

## Collection中的方法

我们这次学习的是`Collection`接口中的方法，虽然实现它的类很多，但是它们实现的方法的功能都是一样。这里介绍七个方法

- `add(E e)`
  - 添加元素
- `clear()`
  - 清空集合中的所有元素
- `remove(E e)`
  - 删除元素
- `contains(E e)`
  - 查看是否包含某个元素
- `isEmpty()`
  - 查看数组是否为空
- `size()`
  - 返回集合的长度，即元素的个数
- `toArray`
  - 返回一个`Onject`类型的数组



下面我们以`ArrayList`为例来学习上面的方法

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class TestCollection {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>(); //多态写法
        //测试add
        collection.add("张无忌");
        collection.add("令狐冲");
        collection.add("郭靖");
        collection.add("杨过");
        System.out.println(collection);
        //测试contains
        System.out.println(collection.contains("杨过"));
        //测试size
        System.out.println(collection.size());
        //测试remove
        collection.remove("杨过");
        System.out.println(collection);
        //测试toArray
        Object[] objects = collection.toArray();
        System.out.println(Arrays.toString(objects));
        //测试clear
        collection.clear();
        System.out.println(collection);
        System.out.println(collection.size());
    }
}
```

输出为

```java
[张无忌, 令狐冲, 郭靖, 杨过]
true
4
[张无忌, 令狐冲, 郭靖]
[张无忌, 令狐冲, 郭靖]
[]
0
```

## Iterator

我们对集合一个重要的操作就是对集合进行遍历，不同于数组，集合不是所有的都是有序的，所以无法通过索引对集合进行遍历，那我们就只能通过迭代器`Iterator`来遍历集合，`Iterator`也是一个接口，集合有一个`iterator()`方法，可以获取迭代器实现类的对象。迭代器主要有两个方法

- `hasNext()`
  - 判断集合中是否还有下一个元素，有则返回`true`
- `next()`
  - 取出集合中的下一个元素，如何集合中没有元素，使用该方法会抛出异常，所以应该先进行判断是否还有下一个元素

下面我们来示例使用方法

```java
import java.util.Collection;
import java.util.HashSet;

public class TestIterator {
    public static void main(String[] args) {
        //HashSet是一个无序的集合
        Collection<String> collection = new HashSet<>();
        collection.add("亚瑟");
        collection.add("妲己");
        collection.add("安其拉");
        collection.add("狄仁杰");
        collection.add("李白");
        System.out.println(collection);
    }
}
```

输出为

```java
[李白, 妲己, 狄仁杰, 亚瑟, 安其拉]
```

可见`HashSet`是一个无序的集合，所以不能通过索引去获取集合中的元素，我们使用迭代器去遍历集合中的元素

```java
Iterator<String> iterator = collection.iterator(); //由集合的iterator()方法创建迭代器
while (iterator.hasNext()) { //判断集合中是否还有下一个元素
    String string = iterator.next(); //取出下一个元素，每取出一个元素，指针向后移动
    System.out.println(string);
}
```

输出为

```java
李白
妲己
狄仁杰
亚瑟
安其拉
```

## foreach循环

我们知道不能通过一般的`for`循环去遍历集合，所以`Java`中有一个增强的`for`循环，利用它可以遍历集合和数组，它的实现原理就是迭代器的原理，不过使用的是`for`循环的形式，我们把它叫做`foreach`循环，格式如下

```java
for (元素类型 变量名 : 集合)
```

它会自动的取出集合中的元素，并且赋值给变量，然后你就可以在`foreach`循环中对取出的元素进行操作了，还是以上面的集合为例，演示如何使用`foreach`循环

```java
for (String string : collection) {
    System.out.println(string);
}
```

输出为

```java
李白
妲己
狄仁杰
亚瑟
安其拉
```

