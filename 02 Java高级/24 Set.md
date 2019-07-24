# Set

`Set`接口也是`Collection`的子接口，它的实现类有`HaseSet`，`LinkedHashSet`，`HashSet`是无序的，`LinkedHashSet`是有序的。

## Set集合的特点

- 集合中的元素不能重复
- 没有索引

下面看一个例子

```java
import java.util.HashSet;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(1);
        System.out.println(set); //无序且不能重复 [1, 2, 3]
    }
}
```

可见集合的顺序与添加的顺序无关，并且添加重复的元素是不行的。

> `Set`集合不能添加重复元素的原理：`Set`集合的底层原理是`Hash`表，首先会根据要添加的元素计算出它的哈希值，根据哈希值添加到数组中，数组中存储的是链表或者红黑树，元素会添加到数组里面的链表或者红黑树中。一般不同的元素会添加到数组的不同索引中，即不同的链表或红黑树中，但是也有可能虽然元素不同，但是它们的哈希值相同，这个就叫做哈希冲突。如果发生了哈希冲突，那么会使用`equals()`方法判断该链表或红黑树中是否存在与这个元素相同的元素，如果有，那么就不添加，如果没有，那么就添加。

所以如果你要添加自定义的类型，那么就要重写`Object`类的`hashCode()`方法和`equals()`方法。

## Set集合的遍历

`Set`由于它是无序的，所以它不能使用普通`for`循环遍历，所以只能使用

- 迭代器
- 增强`for`

由于与`List`差不多，这里就不在演示了。

## LinkedHashSet

`LinkedHashSet`是`HashSet`的子类，它是有序的。如

```java
import java.util.LinkedHashSet;
import java.util.Set;

public class TestLinkedHashSet {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        set.add("aaa");
        set.add("ccc");
        set.add("bbb");
        System.out.println(set); //[aaa, ccc, bbb] 与添加的顺序相同
    }
}
```

