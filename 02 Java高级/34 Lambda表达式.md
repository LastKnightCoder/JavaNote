# Lambda表达式

我们在创建一个线程时，我们一般需要做一下的步骤

- 创建一实现类实现`Runnable`接口
- 重写`run`方法
- 创建实现类对象
- 将该对象传入`Thread`的构造方法中

上面的写法可以简化，省去创建一个实现类，直接创建一个匿名内部类

- 创建一个`Runnable`匿名内部类
- 重写`run`方法
- 将该对象传入`Thread`的构造方法中

其实上面有很多的代码是多余，真正有用的代码就是`run()`方法里面的代码，但是为了创建一个线程我们不得不要创建一个对象，然后巴拉巴拉。其实有时候我们不关心谁来做，只需要告诉我怎么做，比如一个线程你只需要告诉我`run()`方法就可以了，告诉我怎么做就可以了，但是我们却要创建一个对象等等一系列的操作才能达到这个目的。

## Lambda的使用

`Java`在`JDK 1.8`中引入了`Lambda`表达式，可以极大简化我们的编程，可以做到我上面所说的只关心怎么做的问题，不需要创建对象。我们来看看下面这段代码用`Lambda`怎么写

```java
Runnable run = new Runnable() {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
};
new Thread(run).start();
```

`Lambda`的写法为

```java
new Thread(() -> {
    for (int i = 0; i < 20; i++) {
        System.out.println(Thread.currentThread().getName() + " " + i);
    } 
});
```

现在你可能没有看懂这个写法，下面让我为你解释一番。

首先我们注意到

```java
new Runnable() {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
```

被简单的替换为了

```java
() -> {
    for (int i = 0; i < 20; i++) {
        System.out.println(Thread.currentThread().getName() + " " + i);
    } 
}
```

两段代码很像，但是`Lambda`省略了很多的东西。首先我们知道`Thread()`里面传的是一个`Runnable`实现类的对象，该类重写类`run`方法，真正有用的就是`run`方法，所以我们把这些全部省略了，直接传入一个`run()`就可以了，并且由于`run()`方法的方法名是确定，我们连`run`方法名都可以省去，返回值类型也是确定，所以我们也可以省去，最后只剩一个参数列表，在参数列表与方法体之间加入`->`就是`Lambda`表达式。使用`Lambda`不用创建对象，我们只需要传入一个方法，告诉它怎么做就可以了。这个也叫做函数式编程。

`Lambda`表达式的格式为

```java
(参数列表) -> {
    //方法体
}
```

为了熟悉`Lambda`表达式的使用，我们来看一个例子，定义一个`Calculator`的接口，里面有一个方法叫`calculate(int a, int b);`，如下

```java
public interface Calculator {
    int calculate(int a, int b);
}
```

在测试类中定义一个方法，该方法需要`Calculator`接口作为参数

```java
public static int cal(int a, int b, Calculator calculator) {
    int result = calculator.calculate(a,b);
    return result;
}
```

这个方法表示的是，`a,b`经过`Calculator`计算之后得到一个数，而计算方法，根据我们传入的`calculator`而定，这明显是我们只需要告诉计算器怎么做就行，我们把做的方法告诉它，使用`Lambda`表达式

```java
//加法计算器
int result1 = cal(2,3, (int a, int b) -> {
    return a + b;
});
System.out.println(result1);
//减法计算器
int result2 = cal(2,3, (int a, int b) -> {
    return a - b;
});
System.out.println(result2);
```

输出为

```java
5
-1
```

根据我们传入的方法不同，这个计算器就不同，计算器关心的就是怎么做，你告诉怎么做就可以。

## Lambda的省略格式

其实上面的`Lambda`还可以进行化简，因为还有很多是可以推断出来的，比如参数列表里面的参数类型可以省略，因为这个参数类型时确定的，不可能会变的。如

```java
int result1 = cal(2,3, (a, b) -> {
    return a + b;
});
```

如果方法体里面只有一条语句时，那么花括号也可以省略，这时分号也可以省略，如果这条语句是`return`语句，那么`return`也可以省略，因为必须是要返回一个值的，这个可以推断出来，所以可以省略，所以上面又可以简写为

```java
int result1 = cal(2,3, (a, b) -> a + b);
```

如果参数列表里面只有一个参数的话，那么小括号也可以省略

```java
param -> {
    //方法体
}
```

## Lambda表达式的使用前提

虽然`Lambda`表达式这么好用，但是是有使用前提的

- 使用Lambda必须具有接口，且要求**接口中有且仅有一个抽象方法**。
  - 比如`Runnable`接口，里面只有一个`run()`方法是抽象方法
  - 比如上面定义的`Calculator`接口，里面也只有一个抽象方法`calculate()`
- 使用Lambda必须具有**上下文推断**。
  - 也就是方法的参数或局部变量类型必须为Lambda对应的接口类型，才能使用Lambda作为该接口的实例。
  - 不能是我要一个`Calculator`接口的`calculate()`方法，你给我传一个`Runnable`的`run()`方法，兄弟，暗号对不上啊。