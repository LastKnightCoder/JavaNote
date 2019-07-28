# Collections

`Collections`是一个工具类，它提供了很多的静态方法用来对`Collection`集合进行操作。像这样的类我们在之前有接触过，比如`Arrays`就是一个工具类，它提供了很多静态方法用来操作数组。我们下面就简单介绍`Collections`类的三个方法

- `addAll(Collection<? super T> c, T... elements)`
  - 接收两个参数，第一个为`Collection`集合，第二个参数为可变参数
  - 为集合添加多个元素，如`addAll(list, 1, 2, 3)`
- `shuffle(List<?> list)`
  - 接收一个`List`集合，将集合里面的元素随机打乱
- `sort(List<T> list)`
  - 接收一个`list`集合，将按照默认升序的规则排序
  - 如果集合里面装的是自定义的类的对象，那么该类要实现`Comaprable`接口，并且要重写`compareTo()`方法
- `sort(List<T> list, Comparator<? super T> c)`
  - 接收一个`List`集合和一个实现`Comparator`接口的类的对象，可以传入匿名类



下面演示方法的使用

- `addAll`

```java
List<Integer> list1 = new ArratList<>();
Collections.addAll(list1, 1, 2, 3);
System.out.println(list1); //[1, 2, 3]
```

- `shuffle`

```java
List<Integer> list2 = new ArrayList<>();
Collections.addAll(list2, 1, 2, 3, 4, 5, 6);
Collections.shuffle(list2);
System.out.println(list2);  //[6, 4, 3, 5, 2, 1]
```

- `sort(List<T> list)`

```java
//先演示对Integer类的排序
List<Integer> list3 = new ArrayList<>();
Collections.addAll(list3, 1, 7, 10, 5, 6, 4);
Collections.sort(list3);
System.out.println(list3); //[1, 4, 5, 6, 7, 10]
```

下面演示自定义类的排序，首先我们定义一个`Person`类，它有`name`和`age`属性，我们根据`age`的大小进行升序排序，如下

```java
public class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        //升序
        return this.age - o.age; //降序o.age - this.age
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
```

`测试该类

```java
Person p1 = new Person("古力娜扎",20);
Person p2 = new Person("迪丽热巴", 18);
Person p3 = new Person("刘亦菲", 21);
List<Person> list4 = new ArrayList<>();
Collections.addAll(list4, p1, p2, p3);
Collections.sort(list4);
System.out.println(list4);
```

输出为

```java
[Person{name='迪丽热巴', age=18}, Person{name='古力娜扎', age=20}, Person{name='刘亦菲', age=21}]
```

- `sort(List<T> list, Comparator<? super T> c)`

这次我们不需要实现`Comparable`接口，只需要传入一个`Comparator`的实现类对象就可以，该类重写`Comparator`中的`compare`方法，在该方法中规定了排序的规则，我们可以传入一个匿名类

```java
List<Person> list5 = new ArrayList<>();
Collections.addAll(list5, p1, p2, p3);
Collections.sort(list5, new Comparator<Person>() {
    @Override
    public int compare(Person o1, Person o2) {
        //升序
        return o1.age - o2.age;
    }
});
System.out.println(list5);
```

输出为

```java
[Person{name='迪丽热巴', age=18}, Person{name='古力娜扎', age=20}, Person{name='刘亦菲', age=21}]
```

