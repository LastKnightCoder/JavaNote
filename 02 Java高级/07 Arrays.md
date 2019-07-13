# Arrays

`Arrays`位于`java.util`包中。这个类提供了很多的静态方法，实现数组的常见操作。在这里我们介绍两个常用的方法

- `toString`
  - 接收一个数组参数
  - 将参数数组变成字符串 [元素1，元素2， ...]
- `sort`
  - 按默认升序（从小到大）对数组进行排序
  - 对于`String`，按字母在`Unicode`表中的大小排序
  - 对于自定义的类型，需要`Comparable`或`Comparator`接口的支持



下面演示两个方法的使用

```java
import java.util.Arrays;

public class TestArrays {
    public static void main(String[] args) {
        //创建一个整型数组
        int[] arrays = {5, 8, 4, 12, 3, 7};
        //调用Arrays.toString() 我们不用遍历数组打印了
        System.out.println(Arrays.toString(arrays));
        
        //对数组进行排序 这里不是返回一个新的数组 而是对原有数组进行排序
        Arrays.sort(arrays);
        //将排序后的数组打印出来
        System.out.println(Arrays.toString(arrays));
    }
}
```

输出为

```java
[5, 8, 4, 12, 3, 7]
[3, 4, 5, 7, 8, 12]
```

