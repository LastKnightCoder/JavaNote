# List

`List`接口是`Collection`的子接口，实现它的类有`ArrayList`和`LinkedList`，`ArrayList`的底层实现原理是数组，所以它的查询速度快，但是它的增删操作很慢，`LinkedList`的底层实现原理是链表，所以它的查询操作很慢，它的增删操作很快。

## List集合的特点

`List`接口的特点有

- 有序，所以可以通过索引访问元素
- 集合中的元素允许重复

因为`List`接口可以有索引，所以除了`Collection`中的方法，`List`还有其特有的方法如下

- `add(int index, E e)`
  - 在指定索引中的位置添加元素，后面的元素向后推移
- `remove(int index)`
  - 删除指定索引的元素，并且返回删除的元素
- `get(int index)`
  - 获得指定索引处的元素
- `set(int index, E e)`
  - 将索引处为元素替换为`e`

下面示例上面的四个方法

```java
import java.util.ArrayList;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(7);
        System.out.println(list); //[1, 5, 7]

        //add(int index, E e)
        list.add(2,8); //在索引为2的地方插入8
        System.out.println(list); //[1, 5, 8, 7]
        //get(int index)
        int num1 = list.get(1); //获得索引为1的元素
        System.out.println(num1); //5
        //set(int index, E e)
        list.set(0, 4); //设置索引为0的元素为4
        System.out.println(list); //[4, 5, 8, 7]
        int num2 = list.remove(2); //删除索引为2的元素
        System.out.println(list); //[4, 5, 7]
    }
}
```

## List的遍历

因为`List`集合是有序的，所以有三种方法可以进行遍历

- 普通`for`循环
- 迭代器
- 增强`for`循环

下面进行示例

```java
//普通for写法
for (int i = 0; i < list.size(); i++) {
    System.out.println(list.get(i));
}

//迭代器写法
Iterator<Integer> iterator = list.iterator();
while (iterator.hasNext()) {
    Integer i = iterator.next();
    System.out.println(i);
}

//增强for写法
for (Integer i : list) {
    System.out.println(i);
}
```

## LinkedList

`LinkedList`是`List`的实现类，它的底层原理是基于链表实现的，所以除了`List`接口中的方法，它还提供了很多与头尾有关的方法，如

- `addFirst`
- `addLast`
- `removeFirst`
- `removeLast`
- `getFirst`
- `getLast`
- `push`
  - 同`addFirst`一样
- `pop`
  - 同`removeFirst`

下面进行示范

```java
import java.util.LinkedList;

public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("AAA");
        linkedList.add("BBB");

        //addFirst 在"AAA"前面添加元素"CCC"
        linkedList.addFirst("CCC");
        System.out.println(linkedList); //[CCC, AAA, BBB]
        //push 在"CCC"前面添加"DDD"
        linkedList.push("DDD");
        System.out.println(linkedList); //[DDD, CCC, AAA, BBB]
        //pop 删除"DDD"
        System.out.println(linkedList.pop()); //DDD
        //获得第一个元素 getFirst
        System.out.println(linkedList.getFirst()); //CCC
        //removeFirst 删除第一个元素
        System.out.println(linkedList.removeFirst()); //CCC
        System.out.println(linkedList); //[AAA, BBB]
        //removeLast 删除最后一个元素
        System.out.println(linkedList.removeLast()); //BBB
        System.out.println(linkedList); //[AAA]
    }
}
```

