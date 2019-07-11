# this关键字

考虑上例我们的`setter`方法

```java
public void setName(String who){
    name = who;
}
```

其实我一直想写成这样

```java
public void setName(String name){
    name = name;
}
```

我的想法是第一个`name`是成员变量`name`，第二个`name`是传入的参数，但是这样不行，因为这时的两个`name`的传入的参数，那有什么办法可以解决成员变量与局部变量重名的问题吗？方法就是使用`this`关键字，修改上面代码如下

```java
public void setName(String name){
    this.name = name;
}
```

这时`this.就第是`就代表的是成员变量`name`。那么`this`到底是个什么东西？**那个对象调用这个方法，那么`this`就是调用这个方法的对象**.

```java
per.setName("李四");
```

`per`这个对象调用`setName`方法，那么这时的`this`就是`per`。