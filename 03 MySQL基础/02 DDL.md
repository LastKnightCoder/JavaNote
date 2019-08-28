# DDL

这里来介绍操作数据库和表的`SQL`语句，这些操作一般就是`C(Create), R(Retrieve), U(Update), D(Delete)`。

## 操作数据库

### 查询

首先介绍查询数据库的语句，连接上`MySQL`后，在命令行中输入(这里关键字没有大写)

```mysql
show databases;
```

这个语句的作用是显示出所有的数据库

```mysql
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| sakila             |
| sys                |
| world              |
+--------------------+
6 rows in set (0.31 sec)
```

下面这条语句的作用是显示出某数据库所用的字符集

```mysql
show create database 数据库名;
```

比如

```mysql
show create database world;
```

输出为

```mysql
+----------+------------------------------------------------------------------+
| Database | Create Database                                                  |
+----------+------------------------------------------------------------------+
| world    | CREATE DATABASE `world` /*!40100 DEFAULT CHARACTER SET latin1 */ |
+----------+------------------------------------------------------------------+
1 row in set (0.05 sec)
```

可见`world`数据库所用的字符集为`latin1`。

### 创建

创建数据库的语句为

```mysql
create database 数据库名;
```

如

```mysql
create database db1; -- 创建一个名为db1的数据库
```

如果数据库已经存在，那么会发生错误，例如再次执行上面的命令`create database db1;`会发生如下错误

```mysql
ERROR 1007 (HY000): Can't create database 'db1'; database exists
```

这个时候我们可以使用

```mysql
create database if not exists db1; -- 如果db1不存在，那么创建db1，否则什么也不做
```

我们还可以在创建数据库时指定字符集，如

```mysql
create database db2 character set gbk;
```

使用`show create database db2;`查看字符集

```
+----------+-------------------------------------------------------------+
| Database | Create Database                                             |
+----------+-------------------------------------------------------------+
| db2      | CREATE DATABASE `db2` /*!40100 DEFAULT CHARACTER SET gbk */ |
+----------+-------------------------------------------------------------+
1 row in set (0.03 sec)
```

### 修改

我们可以通过下面的命令修改数据库的字符集

```mysql
alter database 数据库名 character set 字符集;
```

例如修改`db2`数据库为`utf8`编码

```mysql
alter database db2 character set utf8;
```

### 删除

我们可以使用`drop`命令删除数据库，例如

```mysql
drop database db2;
```

使用`show databases;`查看数据库，发现`db2`已经被删除了

```
+--------------------+
| Database           |
+--------------------+
| information_schema |
| db1                |
| mysql              |
| performance_schema |
| sakila             |
| sys                |
| world              |
+--------------------+
```

如果数据库不存在，那么会报错，比如在删除一次`db2`

```mysql
ERROR 1008 (HY000): Can't drop database 'db2'; database doesn't exist
```

这个时候我们可以使用下面的语句

```mysql
drop database if exists db2; -- 如果db2存在则删除db2，否则什么也不做
```

### 使用数据库

通过`select database();`命令可以查看我们正在使用哪一个数据库

```mysql
+------------+
| database() |
+------------+
| NULL       |
+------------+
1 row in set (0.00 sec)
```

因为我们没有使用数据库，所以这里显示的是`NULL`，可以通过`use 数据库名;`来使用数据库，比如使用`db1`数据库

```mysql
use db1;
```

再次执行`select database();`输出为

```mysql
+------------+
| database() |
+------------+
| db1        |
+------------+
1 row in set (0.00 sec)
```

## 操作表

### 查询

可以使用`show tables`查询某数据库中所有的表，例如现在我们使用`world`数据库，然后查询其中所有的表

```mysql
use world;
show tables;
```

结果为

```mysql
+-----------------+
| Tables_in_world |
+-----------------+
| city            |
| country         |
| countrylanguage |
+-----------------+
3 rows in set (0.09 sec)
```

我们还可以使用`desc 表名;`来查询某表的结构，我们来查询`city`表的结构

```mysql
desc city;
```

```mysql
+-------------+----------+------+-----+---------+----------------+
| Field       | Type     | Null | Key | Default | Extra          |
+-------------+----------+------+-----+---------+----------------+
| ID          | int(11)  | NO   | PRI | NULL    | auto_increment |
| Name        | char(35) | NO   |     |         |                |
| CountryCode | char(3)  | NO   | MUL |         |                |
| District    | char(20) | NO   |     |         |                |
| Population  | int(11)  | NO   |     | 0       |                |
+-------------+----------+------+-----+---------+----------------+
5 rows in set (0.65 sec)
```

使用`show create table 表名;`查看表的字符集。

### 创建

创建表的语法为

```mysql
create table 表名(列名1 数据类型1, ..., 列名n 数据类型n);
```

`MySQL`中常用的数据类型有

- `int`
  - 整数类型
- `double`
  - 浮点数类型，接收两个参数，如`double(5,2)`，5代表数字的总长度，2代表小数点后的位数
- `date`
  - 日期类型，格式为`yy-MM-dd`
- `datetime`
  - 日期类型，格式为`yy-MM-dd HH:mm:ss`
- `timestamp`
  - 时间戳，格式为`yy-MM-dd HH:mm:ss`，当不赋值或赋值为`NULL`时，自动使用当前的时间作为值
- `varchar`
  - 字符串类型，接收一个参数表示字符串的最大长度，如`varchar(20)`

现在我们在`db1`中创建一个`student`表

```mysql
use db1; -- 使用数据库db1
create table student(name varchar(10), age int, score double(4,1), insert_time timestamp); -- 创建表student 里面包括name age score insert_time 等列
desc student; -- 查看student表的结构
```

```mysql
+-------------+-------------+------+-----+-------------------+-----------------------------+
| Field       | Type        | Null | Key | Default           | Extra                       |
+-------------+-------------+------+-----+-------------------+-----------------------------+
| name        | varchar(10) | YES  |     | NULL              |                             |
| age         | int(11)     | YES  |     | NULL              |                             |
| score       | double(4,1) | YES  |     | NULL              |                             |
| insert_time | timestamp   | NO   |     | CURRENT_TIMESTAMP | on update CURRENT_TIMESTAMP |
+-------------+-------------+------+-----+-------------------+-----------------------------+
4 rows in set (0.07 sec)
```

### 删除

同删除数据库一样，有两种用法

```mysql
drop table 表名;
drop table if exists 表名;
```

这里不多做解释。

### 修改

- 重命名表名

```mysql
alter table 表名 rename to 新表名;
```

- 修改表的字符集

```mysql
alter table 表名 character set 字符集;
```

- 添加一列

```mysql
alter table 表名 add 列名 数据类型;
```

- 修改列名及其类型

```mysql
alter table 表名 change 列名 新列名 新数据类型;
```

- 修改列的数据类型

```mysql
alter table 表名 modify 列名 新数据类型;
```

- 删除列

```mysql
alter table 表名 drop 列名;
```

