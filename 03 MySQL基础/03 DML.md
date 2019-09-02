# DML

`DML`是与修改数据有关的`sql`语句。修改数据主要包括的是增删改数据。为了查看修改数据的效果，这里介绍一个查询数据的命令

```mysql
select * from 表名;
```

现在创建一个`student`的表

```mysql
CREATE TABLE
    student (
        name varchar(10), -- 名字长度最大10个字符
        age int, -- 年龄
        math_score double(3,1), -- 数学成绩
        english_score double(3,1), -- 英语成绩
        insert_time timestamp); -- 数据加入的时间
```

```mysql
DESC student; -- 查看表的结构
```

<img src="images/02.png">

## 添加数据

向表中添加数据的写法为

```mysql
insert into 表名(列名1, 列名2, ..., 列名n) values(值1, 值2, ..., 值n); -- 列名和值要一一对应
```

例如向表中添加数据

```mysql
INSERT INTO student (name, age, math_score, english_score) VALUES ('dilireba', 27, 60, 70);
INSERT INTO student (name, age, math_score, english_score) VALUES ('gulinazha', 28, 62, 68);
```

使用`SELECT * FROM student;`得到数据为

<img src="images/03.png">

注意：

- 列名和值名要一一对应
- 如果表名后不定义列名，则默认为给所有列添加，如
  - `INSERT INTO student VALUES ('dilireba', 27, 60, 70);`
- 除了数字类型，其他类型要用引号(`'`)括起来

## 删除数据

删除数据的格式为

```mysql
delete from 表名 [where 条件]; -- 删除满足条件的行
```

其中`[]`代表的是里面的内容可省略，如果不加条件的话，默认为删除表中的所有数据，现在我们删除上例中`age > 27`的行，如下

```mysql
DELETE FROM student WHERE age > 27;
```

得到的结果为

<img src="images/04.png">

如果要删除表中的所有数据的话，不推荐使用

```mysql
delete from 表名;
```

因为它会将表中的数据一行一行的删除，效率较慢，推荐使用

```mysql
truncate table 表名;
```

它会直接删除这个表，然后创建一个空表，这个表的名字和结构与删除的表相同，从效果上就相当于是删除了表中所有的数据，但是它的效率比`delete from 表名;`快。

## 更新数据

更新数据的语法为

```mysql
update 表名 set 列名1 = 值1, ..., 列名n = 值n [where 条件]; -- 当符合条件时，更新值
```

如何省略条件，那么会修改所有的行，如现在我要更新，如何符合条件`age = 27`，那么将`age`修改为`28`，如下

```mysql
UPDATE student set age = 28 WHERE age = 27;
```

<img src="images/05.png">

