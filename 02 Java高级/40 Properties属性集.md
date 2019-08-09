# Properties属性集

`Properties`是继承至`HashTable`的一个集合。它是与`IO`流关联起来的，通过`load()`和`store()`方法可以读取特定格式的文件数据，和将`Properties`集合中的数据写入到文件中。

## store

下面介绍将`Properties`中的数据写入到文件中。首先介绍如何向`Properties`集合中添加数据

- `setProperty(String key, String value)`

`Properties`集合中的键和值都是`String`类型的。`store()`分为两种，一种是字节流，传入的是`OutputStream`对象，一种是字符流，传入的是`Writer`对象

- `store(OutputStream in, String comment)`
- `store(Writer writer, String comment)`

第二个参数`String comment`是注释，写入文件会写在第一行，并且以`#`开头，一般我们传入一个空字符串

```java
Properties properties = new Properties();
properties.setProperty("古力娜扎","18");
properties.setProperty("迪丽热巴","17");
properties.store(new FileWriter("properties.txt"), " ");
```

`properties.txt`文件里面的内容为

```java
# 
#Fri Aug 09 11:28:20 CST 2019
古力娜扎=18
迪丽热巴=17
```

## load

在介绍`load()`之前，说明一下如何获取`Properties`中的元素

- `getProperty(String key)`
  - 通过键获取值，相当于`Map`中的`get()`
- `stringPropertiesName()`
  - 相当于`Map`中的 `keySet()`，返回一个`Set`集合，泛型为`String`

下面介绍`load()`方法，`load()`就是读取指定格式的文件，比如

```java
古力娜扎=18
```

或者

```java
古力娜扎 18
```

中间的分隔符可以使用`=`或者空格，如果碰到以`#`开头的，则不会读取，我们来读取刚刚写的`properties.txt`文件

```java
Properties properties = new Properties();
//读取文件
properties.load(new FileReader("properties.txt"));
Set<String> propertiesName = properties.stringPropertyNames();
//遍历集合
for (String name : propertiesName) {
    System.out.println(name+"="+properties.getProperty(name));
}
```

输出为

```java
古力娜扎=18
迪丽热巴=17
```



