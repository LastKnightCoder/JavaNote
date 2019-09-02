# DQL

查询数据的基本语法为

```mysql
SELECT 
    字段列表
FROM 
    表名列表
WHERE 
    条件列表
GROUP BY 
    分组字段
HAVING 
    分组后的条件限定
ORDER BY 
    排序
LIMIT 
    分页限定
```

下面会详细的讲解其中各个关键字的意思。创建一个`student`表如下

```mysql
CREATE TABLE student (
id int,  --  编号
name varchar(20), --  姓名
age int, --  年龄
sex varchar(5),  --  性别
address varchar(100),  --  地址
math int, --  数学
english int --  英语
);
```

向其中插入以下数据

```mysql
INSERT INTO student(id,name,age,sex,address,math,english)
VALUES (1,'马云',55,'男', '杭州 ',66,78),
       (2,'马化腾 ',45,'女 ','深圳 ',98,87),
       (3,'马景涛 ',55,'男 ','香港 ',56,77),
       (4,'柳岩',20,'女 ','湖南 ',76,65),
       (5,'柳青 ',20,'男 ','湖南 ',86,NULL),
       (6,'刘德华 ',57,'男 ','香港',99, 99),
       (7,'马德',22,'女','香港',99,99),
       (8,'德玛西亚',18,'男','南京',56,65);
```

如果提示

```mysql
Incorrect string value: '\xE9\xA9\xAC\xE4\xBA\x91' for column 'name' at row 1
```

那么就是因为字符编码的问题，这时可以修改`name,address,sex`的字符集为`utf8`

```mysql
alter table student change name name char(20) character set utf8;
alter table student change address address char(100) character set utf8;
alter table student change sex sex char(5) character set utf8;
```

<img src="images/06.png">

## 基础查询

### 查询多个字段

```mysql
SELECT 
	name, age 
FROM 
	student; -- 查询name和age字段
```

<img src="images/07.png">

### 去重

查询`address`字段时，发现有相同的，如"香港"

```mysql
SELECT 
	address 
FROM 
	student;
```

<img src="images/08.png">

如果希望重复出现的只出现一次，那么可以使用`DISTINCT`

```mysql
SELECT DISTINCT 
	address 
FROM 
	student;
```

<img src="images/09.png">

### 计算列

现在要计算它们的数学成绩和英语成绩的和

```mysql
SELECT 
	name, math, english, math+english 
FROM 
	student; -- 为了看出是谁的总分，这里加上一个name字段
```

<img src="images/10.png">

我们发现第`5`行的结果为`null`，这是因为`null`+其它数得到的结果都是`null`，但是这里我们应该把`null`当做`0`处理 ，这样加出来的就是总分，而不是`null`

```mysql
SELECT 
	name, math, english, math+ifnull(english,0) 
FROM 
	student;
```

这里使用了`ifnull(english)`，如果`english`的值是`null`，那么就替换为`0`，所以我们得到的结果为

<img src="images/11.png">

### 起别名

我们注意到上面的最后一列的列名为`math+ifnull(english,0)`，这个列名没有什么意义，我们应该为它起个别名，如`score`

```mysql
SELECT 
	name, math, english, math+ifnull(english,0) AS score 
FROM 
	student;
```

<img src="images/12.png">

其中`AS`作为一个起别名的作用，`AS`其实可以省略，使用空格替代即可，如

```mysql
SELECT 
	name, math, english, math+ifnull(english,0) score 
FROM 
	student;
```

该句得到的结果与上面的相同

<img src="images/12.png">

## 条件查询

我们使用`WHERE`来指明条件查询，比如我要查询年龄在`20`岁以上的

```mysql
SELECT 
	name,age 
FROM 
	student 
WHERE 
	age > 20;
```

<img src="images/13.png">

可见`WHERE`后面跟的是一个逻辑值，既然是逻辑值就可以使用与或非运算

- `AND`
- `OR`
- `NOT`

```mysql
SELECT 
	name,age 
FROM 
	student 
WHERE 
	age > 20 AND age < 50; -- 年龄在20-50之间的
```

<img src="images/14.png">

我们可以使用`BETWEEN ... AND ...`来简化上面的操作

```mysql
SELECT 
	name,age 
FROM 
	student 
WHERE 
	age BETWEEN 20 AND 50; -- 在20-50之间，包括20和50
```

<img src="images/15.png">

```mysql
SELECT 
	name,age 
FROM 
	student 
WHERE 
	age = 18 OR age = 20 OR age = 25; -- 查询年龄为18或20或25的
```

<img src="images/16.png">

我们可以使用`IN`达到相同的效果

```mysql
SELECT 
	name,age 
FROM 
	student 
WHERE 
	age IN (18,20,25); -- 查询年龄为18或20或25的
```

## 排序查询

使用`ORDER BY`来对查询结果进行排序，后面跟要排序的字段，默认对字段进行升序排序。

- `ASC`：升序
- `DESC`：降序

```mysql
SELECT 
	name,math 
FROM 
	student 
ORDER BY 
	math; -- 默认为升序
```

<img src="images/17.png">

```mysql
SELECT 
	name,math 
FROM 
	student 
ORDER BY 
	math DESC; -- 降序
```

<img src="images/18.png">

`ORDER BY`可以对多个字段进行排序，先对前面的字段进行排序，如果前面的字段相对，在根据后面的字段排序，比如按照数学和英语成绩排名，优先按数学成绩来，如果数学成绩相对则按英语成绩来

```mysql
SELECT 
	name,math,english 
FROM 
	student 
ORDER BY 
	math DESC, english DESC;
```

<img src="images/19.png">

## 模糊查询

使用`LIKE`进行模糊查询，比如记不住全称，这时可以使用模糊查询，比如想查询姓马的，在查询之前要介绍占位符

- `_`：表示单个任意字符
- `%`：表示多个任意字符

```mysql
SELECT 
	name 
FROM 
	student 
WHERE 
	name LIKE '马%';
```

<img src="images/20.png">

如果我想查询名字中带有"德"字的

```mysql
SELECT 
	name 
FROM 
	student 
WHERE 
	name LIKE '%德%';
```

<img src="images/21.png">

## 聚合函数

聚合函数将一列作为整体，进行纵向计算。聚合函数有

- `count`：统计个数，不包括`NULL`。
- `max`：计算最大值
- `min`：计算最小值
- `sum`：计算总和
- `avg`：计算平均值

```mysql
SELECT count(math) FROM student;
SELECT max(math) FROM student;
SELECT min(math) FROM student;
SELECT sum(math) FROM student;
SELECT avg(math) FROM student;
```

## 分组查询

使用`GROUP BY`进行分组查询，比如我想男生和女生的数学平均分，那么可以使用

```mysql
SELECT 
       sex,avg(math) avg  -- avg是别名
FROM 
     student 
GROUP BY 
         sex;
```

<img src="images/22.png">

如果我想对分数在`70`以上的人计算平均分，并且统计人数，可以这么写

```mysql
SELECT 
       sex,avg(math) avg, count(id) count -- avg和count是别名
FROM 
     student 
WHERE 
      math > 70 
GROUP BY 
         sex;
```

<img src="images/23.png">

如果分组后的还要进行筛选，那么可以使用`HAVING`，比如这里我要筛选分组后人数大于`2`的才进行统计

```mysql
SELECT
       sex,avg(math) avg, count(id) count
FROM
     student
WHERE
      math > 70
GROUP BY
         sex
HAVING
    count(id) > 2;
```

<img src="images/24.png">

## 分页查询

当我们查询数据时，如果我们一页只能显示几行数据，我们就要进行分页查询，使用`LIMIT`，后面跟两个数，第一个数代表查询的起始位置，从`0`开始，第二个代表一页显示的行数，如

```mysql
SELECT
       *
FROM
    student
LIMIT
    0,3; -- 查询中0开始的3行数据
```

<img src="images/25.png">

如果我们要查询第二页，可以怎么写

```mysql
SELECT
       *
FROM
    student
LIMIT
    3,3;
```

<img src="images/26.png">