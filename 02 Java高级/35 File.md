# File

`File`类代表的是文件或者文件夹(目录)，将目录和文件抽象为一个类。`File`提供了很多方法用来操作文件夹或者文件。下面具体介绍该类。

## 静态成员变量

`File`类有四个成员变量

- `pathSeparator`
- `pathSeparatorChar`
  - 这两个保存的路径分隔符
  - `Windows`下为`;`，`Linux`下为`:`
- `separator`
- `separatorChar`
  - 这两个保存的是文件名称分隔符
  - `Windows`下为`\`反斜杠，`Linux`下为`/`正斜杠

下面看这个例子

```java
import java.io.File;

public class TestFile {
    public static void main(String[] args) {
        System.out.println(File.pathSeparator);
        System.out.println(File.pathSeparatorChar);

        System.out.println(File.separator);
        System.out.println(File.separatorChar);
    }

}
```

输出为

```java
;
;
\
\
```

## 构造方法

### File(String pathname)

- 传入一个字符串类型，这个字符串为第一个路径名
- 传入的路径可以是绝对路径，也可以是相对路径
- 传入的路径可以存在，也可以不存在
- 可以是文件结尾，也可以是文件夹结尾`\`

下面来看看该方法的使用

```java
File file1 = new File("G:\\JavaProject\\FirstProject"); //绝对路径写法
System.out.println(file1);
File file2 = new File("SecondProject"); //相对路径写法
System.out.println(file2);
```

输出为

```java
G:\JavaProject\FirstProject
SecondProject
```

**注意：**

- 由于`\`代表的是转义，所以要写两个`\\`
- 可见`File`类重写了`toString()`方法

### File(String parent,String child)

- 该构造方法需要传入两个参数，一个为父级目录的路径，一个为子级目录的路径
- 该种构造方法相比上面的要灵活一点

下面示例使用

```java
String parent = "C:\\JavaProject\\";
File file3 = new File(parent,"FirstProject");
System.out.println(file3);
File file4 = new File(parent,"SecondProject");
System.out.println(file4);
```

输出为

```java
C:\JavaProject\FirstProject
C:\JavaProject\SecondProject
```

### File(File parent, String child)

- 同上个构造方法，传入也是父级和子级的路径，不过传入的父级路径是一个`File`对象
- 这样可以调用`File`类的方法，更加灵活

下面示例使用

```java
File parent = new File("C:\\JavaProject");
File file5 = new File(parent,"FirstProject");
System.out.println(file5);
```

输出为

```java
C:\JavaProject\FirstProject
```

## 常用方法

按照功能不同分为了三类

- 获取功能
- 判断功能
- 创建删除

### 获取功能

与获取功能有关的方法有四个

- `getAbsolutePath()`
  - 获得文件或文件夹的绝对路径
  - 不论在构造方法中传入的是绝对路径还是相对路径，获得都是绝对路径
- `getPath()`
  - 在构造方法中传入的是什么，返回的就是什么
  - `toString()`调用的就是这个方法
- `getName()`
  - 获得文件或文件夹的名称，即路径的结尾部分
- `length()`
  - 获得文件的长度，以字节为单位
  - 如果该文件不存在，那么返回`0`

下面示例这四个方法的使用

```java
import java.io.File;

public class TestFile {
    public static void main(String[] args) {
        File file = new File("src\\Dog.java"); //传入的相对路径，获得是src目录下的Dog.java文件
        //打印绝对路径
        System.out.println(file.getAbsolutePath()); //G:\JavaProject\SecondProject\src\Dog.java
        //打印路径，传入什么打印什么
        System.out.println(file.getPath()); //src\Dog.java
        //获得文件的名称
        System.out.println(file.getName()); //Dog.java
        //获得文件的大小
        System.out.println(file.length()); //353
    }
}
```

### 判断功能

与判断功能有关的方法有三个

- `exists()`
  - 判断传入构造方法的路径是否存在
- `isDirectory()`

  - 判断是不是目录(文件夹)
  - 如果路径不存在，无论是否为目录(文件夹)，返回`false`
- `isFile()`
  - 判断是否为文件
  - 如果路径不存在，无论是否为文件，返回`false`

下面进行示例

```java
File file = new File("src\\Dog.java"); //传入的相对路径，获得是src目录下的Dog.java文件
//判断该路径是否存在
System.out.println(file.exists()); //true
//是否为文件夹
System.out.println(file.isDirectory()); //false
//是否为文件
System.out.println(file.isFile()); //true
```

### 创建删除

与创建和删除有关的方法有四个

- `createNewFile()`
  - 如果该文件不存在，则创建该文件，如果存在则不创建
  - 返回布尔值，创建返回`true`
  - 不能创建目录，所以该文件所在目录必须存在，否则会抛出异常
- `delete()`
  - 删除该类代表的文件或文件夹，直接从硬盘删除，不走文件夹，要小心
  - 删除成功返回`true`
- `makdir()`
  - 创建由此`File`类代表的目录，只能创建单级目录
- `makdirs()`
  - 创建由此`File`类代表的目录，包括必需但不存在的父级目录

下面演示使用

```java
import java.io.File;
import java.io.IOException;

public class TestFileMethod {
    public static void main(String[] args) throws IOException {
        //D:\\目录下没有1.txt
        File file1 = new File("D:\\1.txt");
        //createNewFile使用了throws抛出异常，需要处理，我们在main中直接抛出即可
        System.out.println(file1.createNewFile()); //true

        //D:\\下没有新建文件夹
        File file2 = new File("D:\\新建文件夹");
        //创建这个文件夹
        System.out.println(file2.mkdir());  //true

        File file3 = new File("D:\\abc\\def"); 
        //创建多级目录
        System.out.println(file3.mkdir()); //不能创建 mkdir只能创建单级目录 false
        System.out.println(file3.mkdirs()); //true

        //将上面创建的文件及文件夹全部删除
        System.out.println(file1.delete()); //true
        System.out.println(file2.delete()); //true
        System.out.println(file3.delete()); //true abc这个文件夹还在
    }
}
```

## 目录遍历

为了遍历目录，有两个方法

- `list()`
  - 返回一个字符串数组，这些字符串是文件名或文件夹名
- `listFiles()`
  - 返回时的`File`类对象

**注意：**

- 上面两个方法，如果目录不存在或者不是目录，那么会抛出空指针异常
- 隐藏文件和文件夹也能获取到

```java
File file = new File("G:\\JavaProject\\SecondProject\\src");
String[] filename = file.list();
for (int i = 0; i < filename.length; i++) {
    System.out.println(filename[i]);
}
File[] files = file.listFiles();
for (File file4 : files) {
    System.out.println(file4.getName());
}
```

输出为

```java
com
Dog.java
Doudizhu.java
GenericsDemo.java
JustForFun.java
MyException.java
MyThread.java
...
```

