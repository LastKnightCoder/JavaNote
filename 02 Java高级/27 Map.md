# Map

之前我们介绍的集合如`List`，`Set`都是单列集合，下面我们将介绍双列集合`Map`，它是通过键`K`去寻找值`V`的，所以说它是一个双列集合。它是一个接口，它的常用子类有`HashMap`和`LinkedHashMap`。其中`HashMap`是无序的，即在集合中存储的顺序与你添加的顺序是不一致的。`LinkedHashMap`是有序，即添加顺序与保存的顺序相同。`LinkedHashMap`是`HashMap`的子类。我们之前介绍的`HashSet`类是调用`HashMap`实现的，它只利用了`HashMap`的`K`。

## Map集合的方法

下面介绍`Map`集合的常用方法

- `put(key, value)`
  - 向`Map`中添加一对键值对，由于`Map`集合中的`key`是不能重复的，如果`Map`中已经存在该`key`，那么将集合中该`key`所对应的`value`值替换为添加的`value`，即相当于更新，并且返回被替换的`value`值，如果该集合中不存在该`key`，那么将该键值对添加，并且返回`null`
- `get(key)`
  - 通过键值来获得对应的`value`值，如果集合不存在该`key`，那么返回`null`
- `remove(key)`
  - 根据键来删除该键值对，如果该`key`不存在，那么返回`null`，如果存在，那么返回对应的`value`值
- `containsKey(key)`
  - 判断集合中是否存在键`key`，有则返回`true`，否则返回`false`

下面简单演示这四个方法

```java
import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        //添加元素
        map.put("迪丽热巴",18);
        map.put("古力娜扎",19);
        map.put("佟丽娅",20);
        System.out.println(map); //{佟丽娅=20, 迪丽热巴=18, 古力娜扎=19}

        //这里已经有"迪丽热巴"这个键了，所以对应的值会被更改为20，并将该值18返回
        //这里最好使用Integer接收，因为可能返回null 而基本数据类型不能被赋值为null
        Integer val1 = map.put("迪丽热巴",20);
        System.out.println(val1); //18
        System.out.println(map); //{佟丽娅=20, 迪丽热巴=20, 古力娜扎=19}

        //通过键去获得值
        Integer val2 = map.get("古力娜扎");
        System.out.println(val2); //19

        //删除键"佟丽娅"对于的键值对
        Integer val3 = map.remove("佟丽娅");
        System.out.println(val3); //20
        System.out.println(map); //{迪丽热巴=20, 古力娜扎=19}

        //判断是否包含键"佟丽娅"
        System.out.println(map.containsKey("佟丽娅")); //false
    }
}
```

## 遍历Map集合

主要有两个方法用来遍历`Map`集合

- `keySet`
  - 该方法会返回`Set`集合，里面是`key`的值，然后我们可以遍历该`Set`集合来遍历`Map`集合
- `entrySet`
  - 该方法也返回一个`Set`集合，不过这个集合里面的是`Entry`对象，`Entry`是`Map`的内部类，该类会在添加键值对时创建一个`Entry`对象保存相应的`key`和`value`的信息，我们可以通过`Entry`对象的`getKey()`和`getValue()`方法来获得键和值。同样我们可以遍历该`Set`集合来遍历`Map`集合

下面演示两个方法的使用

- `keySet`

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        //添加元素
        map.put("迪丽热巴",18);
        map.put("古力娜扎",19);
        map.put("佟丽娅",20);
        System.out.println(map); //{佟丽娅=20, 迪丽热巴=18, 古力娜扎=19}

        //获得key的Set集合
        Set<String> set1 = map.keySet();
        //遍历Set集合
        for (String set: set1) {
            System.out.println(set + "=" + map.get(set));
        }

        //获得Entry对象组成的Set集合
        Set<Map.Entry<String,Integer>> set2 = map.entrySet();
        //遍历该集合
        for (Map.Entry<String, Integer> set : set2) {
            System.out.println(set.getKey() + "=" + set.getValue());
        }
    }
}

```

输出为

```java
佟丽娅=20
迪丽热巴=18
古力娜扎=19
佟丽娅=20
迪丽热巴=18
古力娜扎=19
```



