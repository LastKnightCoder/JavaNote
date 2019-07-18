# final

`final`关键字可以修饰

- 一个类
  - 修饰一个类时，该类不能够被继承
  - 所以`final`不能和`abstract`关键字一起使用，因为抽象类不能自己创建对象，只能被继承
- 方法
  - 修饰一个方法时，子类不能重写该方法
- 局部变量
  - 修饰一个局部变量时，这个变量不能进行更改
  - 下面两种写法都可以

```java
final int num = 10;
```

```java
final int num;
num = 10;
```

- 成员变量
  - 因为成员变量有默认值，所以要手动赋值
  - 要么直接赋值，要么在构造方法中进行赋值，在构造方法中赋值时，所有的构造方法都要进行赋值，即使是无参构造方法，也要进行赋值

```java
final int num = 10;
//下面的写法是错误的
final int num;
num = 10;
```

```java
public Xxx() {
    num = 0;
}
public Xxx(int num) {
    this.num = num;
}
```