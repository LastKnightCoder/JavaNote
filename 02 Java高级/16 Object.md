# Object

`Object`类是所有类的父类，所有类都默认继承了（直接或间接）`Object`类。所以所有的类都默认有`Object`类中的成员方法。这里介绍两个比较重要的`Object`类的成员方法

- `toString()`
- `equals(Object object)`

## toString

我们在之前一直有用`System.out.println()`语句打印信息到控制台，当我们传入一个引用类型变量的时候，它会调用该对象的`toString()`方法，由于`Object`类的`toString`方法是默认打印堆内存的地址值，所以这也是为什么我们在打印数组时，打印出的是地址值。而我们打印`String`类型时，打印出的却是它的内容，这时因为`String`重写`toString()`方法。

为了验证我们的猜想，我们看下面这么一个类

```java
public class Person {

}
```

我们现在创建一个`Person`对象，并且打印出来，然后调用`toString()`方法，在打印一遍

```java
public class TestToString {
    public static void main(String[] args) {
        Person per = new Person();
        System.out.println(per);
        System.out.println(per.toString());
    }
}
```

输出为

```java
Person@4554617c
Person@4554617c
```

我们发现结果是一样的，现在我们在`Person`类中重写`toString()`方法

```java
public class Person {
    @Override
    public String toString() {
        return "I'm a Person object";
    }
}
```

在运行一遍，输出为

```java
I'm a Person object
I'm a Person object
```

## equals

在前面我们比较字符串时，我们说`==`是对象的地址值进行比较，而`equals`方法是基于内容的比较。事实上，`Object`类的`equals`方法也是进行对象地址值的比较，只不过是**`String`类重写了`equals`方法**。

我们可以通过重写`equals`方法来设置怎样两个对象才是相等的。比如还是以`Person`类进行举例，它有姓名和年龄两个成员变量，我们认为如果两个人的姓名和年龄都是一样的，那么我们就认为这两个人的对象是相同的

```java
public class Person {

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        //因为要使用Person对象的name和age属性，所以要向下转型
        if (obj instanceof Person) {
            Person person = (Person) obj;
            //如果姓名和年龄相同，就认为对象是相同的
            if (this.name == person.name && this.age == person.age) {
                return true;
            }
        }
        return false;
    }
}

```

现在我们在测试类类中测试一下

```java
public class TestEquals {
    public static void main(String[] args) {
        Person person1 = new Person("迪丽热巴",20);
        Person person2 = new Person("古力娜扎",28);
        Person person3 = new Person("迪丽热巴",20);

        System.out.println(person1.equals(person2));  //年龄和姓名不一样，返回false
        System.out.println(person1.equals(person3)); //名字和年龄一样，返回true
        System.out.println(person1 == person3); //地址值是不同的，所以是false
    }
}
```

输出为

```java
false
true
false
```

