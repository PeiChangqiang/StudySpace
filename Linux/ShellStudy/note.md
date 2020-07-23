### 一、变量

 变量的作用域：linux系统中不同进程id的shell是一个命名空间。所以一个shell脚本中即使是函数里声明的变量这个shell全局中都可以使用。如果声明函数内局部变量，则使用关键字local。

#### 1.变量语法

* 赋值不允许等号左右有空格。

- 命名只能使用英文字母，数字和下划线，首个字符不能以数字开头。

- 不能使用标点符号。

- 不能使用bash里的关键字（可用help命令查看保留关键字）

- 单引号双引号都可以，但是当变量值引用其它变量时必须使用双引号,name="$name1"。所以推荐使用双引号。

- 取值使用$.严谨的写法加上{}。例如：${name}

#### 2.变量操作

* 只读变量：**readonly** a=100; 也就是常量，声明时必须赋值，之后无法修改。

* 删除变量：**unset** variable_name 。该命令对函数同样适用。**但是不能删除只读变量**。

#### 3.变量类型

* 局部变量：在脚本或者命令中定义，当前shell实例中有效。
* 环境变量：所有的脚本和程序都能访问环境变量，shell脚本中可以定义环境变量。
* shell变量：shell程序设置的特殊变量，包括环境变量和局部变量。

### 二、字符串操作

#### 1.定义

* 单引号

```shell
#单引号中的内容会原样输出不会转义，其中的变量无效
name='xxx'
```

* 双引号

```shell
#双引号中的内容可以转义；可以有变量
name="xxx"
str="你的名字是${name}"
```

#### 2.拼接

```shell
str1="xxx"
#双引号拼接两种方式都可
str2="yyy${str1}"
str3="yyy"$str1""
```

#### 3.获取字符串长度

```shell
string="abcd"
echo ${#string} #输出 4
```

#### 4.提取子字符串

```shell
string="runoob is a great site"
echo ${string:1:4} # 输出 unoo
```

#### 5.查找子字符串

```shell
string="runoob is a great site"
echo `expr index "$string" io`  # 输出 4  这里是反引号。
```



### 三、参数传递

执行可执行文件时，可以直接在后面传递参数

```shell
./test.sh param1 param2 param3...
```

脚本中可以像引用数组元素一样访问这些参数，其中$0代表当前执行的可执行文件名

```shell
#!/bin/bash
echo "当前可执行文件名是：$0"
echo "第一个参数：$1"
echo "第二个参数：$2"
```

其它特殊字符处理参数：

| 参数处理 | 说明                                                         |
| :------- | :----------------------------------------------------------- |
| $#       | 传递到脚本的参数个数                                         |
| $*       | 以一个单字符串显示所有向脚本传递的参数。 如"$*"用「"」括起来的情况、<br />以"$1 $2 … $n"的形式输出所有参数。 |
| $$       | 脚本运行的当前进程ID号                                       |
| $!       | 后台运行的最后一个进程的ID号                                 |
| $@       | 与$*相同，但是使用时加引号，并在引号中返回每个参数。 <br />如"$@"用「"」括起来的情况、以"$1" "$2" … "$n" 的形式输出所有参数。 |
| $-       | 显示Shell使用的当前选项，与[set命令](https://www.runoob.com/linux/linux-comm-set.html)功能相同。 |
| $?       | 显示最后命令的退出状态。0表示没有错误，其他任何值表明有错误。 |

**$* 与 $@ 区别：**

- 相同点：都是引用所有参数。
- 不同点：只有在双引号中体现出来。假设在脚本运行时写了三个参数 1、2、3，，则 " * " 等价于 "1 2 3"（传递了一个参数），而 "@" 等价于 "1" "2" "3"（传递了三个参数）。

### 四、数组

#### 	1.数组定义

​		使用declare命令定义数组:declare -a Array。定义名为Array的数组。
​		declare -a name=("aa" "bb");在创建name数组的同时赋值两个元素  注意两个元素中间是空格，不是逗号
​		不使用declare:name=("aa" "bb");
​		给特定的元素赋值:score=([2]=3,[4]=5);

#### 	2.数组的操作

##### 		1）取值

* 取某个元素：${数组名[索引]} 例如:${name[1]}

* 取出数组所有元素:${Array[@]}或者${Array[\*]}。两者的区别是前者是空格隔开的所有元素，第二个是所有元素组成的一整个字符串

* 获取数组的长度
  		${#Array[@]}或者${#Array[*]}。如果某个元素是字符串则可以${#Array[1]}来获得该字符串的长度

##### 2）数组的截取

  截取的对象可以是整个数组或者是数组的某个元素。

* ${Array[@]:1:2} : 截取数组的第二个到第三个元素

* ${Array[1]:0:5}: 截取数组第二个元素的从第0个字符开始连续的5个字符
  
##### 3）连接数组

  ​		将若干个数组进行拼接。Array=(${Array1[@]} ${Array2[@]});  注意中间仍然是空格

#####  4）替换元素

  ​		array=(${array[@]\a\b}) : 将array中的a元素替换成b

#####  5）取消数组或者数组中的元素

  ​		使用unset命令  unset array：取消数组。  unset array[1]：取消第二个元素



### 五、运算符

#### 1.算术运算符

原生bash不支持算术运算符，可以借助命令：expr、awk。

```shell
#要使用反引号；表达式和运算符之间要有空格
value=`expr 1 + 1`
echo ${value}
```

假定变量 a 为 10，变量 b 为 20：

| 运算符 | 说明                                          | 举例                          |
| :----- | :-------------------------------------------- | :---------------------------- |
| +      | 加法                                          | `expr $a + $b` 结果为 30。    |
| -      | 减法                                          | `expr $a - $b` 结果为 -10。   |
| *      | 乘法                                          | `expr $a \* $b` 结果为  200。 |
| /      | 除法                                          | `expr $b / $a` 结果为 2。     |
| %      | 取余                                          | `expr $b % $a` 结果为 0。     |
| =      | 赋值                                          | a=$b 将把变量 b 的值赋给 a。  |
| ==     | 相等。用于比较两个数字，相同则返回 true。     | [ $a == $b ] 返回 false。     |
| !=     | 不相等。用于比较两个数字，不相同则返回 true。 | [ $a != $b ] 返回 true。      |

```shell
a=10
b=20
echo `expr $a - $b`
echo `expr $a \* $b`
if [ $a == $b ]
then
echo "a等于b"
fi

if [ $a != $b ] 
then 
echo "a不等于b"
fi
```

#### 2.关系运算符

关系运算符只支持数字，不支持字符串，除非字符串的值是数字。

下表列出了常用的关系运算符，假定变量 a 为 10，变量 b 为 20：

| 运算符 | 说明                                                  | 举例                       |
| :----- | :---------------------------------------------------- | :------------------------- |
| -eq    | 检测两个数是否相等，相等返回 true。                   | [ $a -eq $b ] 返回 false。 |
| -ne    | 检测两个数是否不相等，不相等返回 true。               | [ $a -ne $b ] 返回 true。  |
| -gt    | 检测左边的数是否大于右边的，如果是，则返回 true。     | [ $a -gt $b ] 返回 false。 |
| -lt    | 检测左边的数是否小于右边的，如果是，则返回 true。     | [ $a -lt $b ] 返回 true。  |
| -ge    | 检测左边的数是否大于等于右边的，如果是，则返回 true。 | [ $a -ge $b ] 返回 false。 |
| -le    | 检测左边的数是否小于等于右边的，如果是，则返回 true。 | [ $a -le $b ] 返回 true。  |

#### 3.布尔运算符

下表列出了常用的布尔运算符，假定变量 a 为 10，变量 b 为 20：

| 运算符 | 说明                                                | 举例                                     |
| :----- | :-------------------------------------------------- | :--------------------------------------- |
| !      | 非运算，表达式为 true 则返回 false，否则返回 true。 | [ ! false ] 返回 true。                  |
| -o     | 或运算，有一个表达式为 true 则返回 true。           | [ $a -lt 20 -o $b -gt 100 ] 返回 true。  |
| -a     | 与运算，两个表达式都为 true 才返回 true。           | [ $a -lt 20 -a $b -gt 100 ] 返回 false。 |

#### 4.逻辑运算符

假定变量 a 为 10，变量 b 为 20:

| 运算符 | 说明       | 举例                                       |
| :----- | :--------- | :----------------------------------------- |
| &&     | 逻辑的 AND | [[ $a -lt 100 && $b -gt 100 ]] 返回 false  |
| \|\|   | 逻辑的 OR  | [[ $a -lt 100 \|\| $b -gt 100 ]] 返回 true |

#### 5.字符串运算符

下表列出了常用的字符串运算符，假定变量 a 为 "abc"，变量 b 为 "efg"：

| 运算符 | 说明                                         | 举例                     |
| :----- | :------------------------------------------- | :----------------------- |
| =      | 检测两个字符串是否相等，相等返回 true。      | [ $a = $b ] 返回 false。 |
| !=     | 检测两个字符串是否相等，不相等返回 true。    | [ $a != $b ] 返回 true。 |
| -z     | 检测字符串长度是否为0，为0返回 true。        | [ -z $a ] 返回 false。   |
| -n     | 检测字符串长度是否不为 0，不为 0 返回 true。 | [ -n "$a" ] 返回 true。  |
| $      | 检测字符串是否为空，不为空返回 true。        | [ $a ] 返回 true。       |

#### 6.文件测试运算符

文件测试运算符用于检测 Unix 文件的各种属性。

| 操作符  | 说明                                                         | 举例                      |
| :------ | :----------------------------------------------------------- | :------------------------ |
| -b file | 检测文件是否是块设备文件，如果是，则返回 true。              | [ -b $file ] 返回 false。 |
| -c file | 检测文件是否是字符设备文件，如果是，则返回 true。            | [ -c $file ] 返回 false。 |
| -d file | 检测文件是否是目录，如果是，则返回 true。                    | [ -d $file ] 返回 false。 |
| -f file | 检测文件是否是普通文件（既不是目录，也不是设备文件），<br />如果是，则返回 true。 | [ -f $file ] 返回 true。  |
| -g file | 检测文件是否设置了 SGID 位，如果是，则返回 true。            | [ -g $file ] 返回 false。 |
| -k file | 检测文件是否设置了粘着位(Sticky Bit)，如果是，则返回 true。  | [ -k $file ] 返回 false。 |
| -p file | 检测文件是否是有名管道，如果是，则返回 true。                | [ -p $file ] 返回 false。 |
| -u file | 检测文件是否设置了 SUID 位，如果是，则返回 true。            | [ -u $file ] 返回 false。 |
| -r file | 检测文件是否可读，如果是，则返回 true。                      | [ -r $file ] 返回 true。  |
| -w file | 检测文件是否可写，如果是，则返回 true。                      | [ -w $file ] 返回 true。  |
| -x file | 检测文件是否可执行，如果是，则返回 true。                    | [ -x $file ] 返回 true。  |
| -s file | 检测文件是否为空（文件大小是否大于0），不为空返回 true。     | [ -s $file ] 返回 true。  |
| -e file | 检测文件（包括目录）是否存在，如果是，则返回 true。          | [ -e $file ] 返回 true。  |

其他检查符：

- **-S**: 判断某文件是否 socket。
- **-L**: 检测文件是否存在并且是一个符号链接。

### 六、流程控制

#### 1.if语句

```shell
#if语句
if condition
then
 command...
fi

#if else
if condition
then
 command...
 else
 command...
fi

#if else if
if condition
then
command...
elif condition
then
command...
else
 command
 fi
```

#### 2.for循环

* 语法格式

```shell
for var in item1 item2....
do
 command...
done

#示例
#输出1 2 3 4 5
#!/bin/bash
for item in 1 2 3 4 5 5
do
echo ${item}
done


#输出 hello world
for item in "hello world"
do 
echo "${item}"
done

#!/bin/bash
for((i=1;i<=5;i++));do
    echo "这是第 $i 次调用";
done;
```



#### 3.while语句

* 语法格式

```shell
while condition
do
 command...
done
```

* 示例

```shell
echo "输入你最喜欢的网站"
while read website
do
echo "是的，${website}是最好的网站！"
echo "按下ctrl + d退出"
done
```

* 无限循环

```shell
#1
while : 
do 
command...
done

#2
while true
do
command...
done

#3
for(( ; ; ))
```



#### 4.until循环

* 语法格式

```shell
until condition
do
command...
done
```



#### 5.case语句

* 语法格式

```shell
#模式支持正则表达式
case value in
model1) command...
;;
model2) command...
;;
model3) command...
;;
esac
```

* 示例

```shell
echo "请输入一个0-3的数字"
read num
case ${num} in
0) echo "你输入了0"
;;
1) echo "你输入了1"
;;
2) echo "你输入了2"
;;
3) echo "你输入了3"
*) echo "输入不合法，请按照规定输入"
;;
esac
```

#### 6.跳出循环

* break 

```shell
while : 
do
echo "请输入1-3的数字"
read num
case ${num} in
1|2|3) echo "你输入了${num}"
;;
*) echo "你输入的数字不在1-3之内"
break
;;
esac
done
```

* continue

​	该语句只会跳出当前循环，不会跳出所有循环

```shell
#!/bin/bash
while :
do
    echo -n "输入 1 到 5 之间的数字: "
    read aNum
    case $aNum in
        1|2|3|4|5) echo "你输入的数字为 $aNum!"
        ;;
        *) echo "你输入的数字不是 1 到 5 之间的!"
            continue
            echo "游戏结束" #该语句永远不会被执行
        ;;
    esac
done
```

### 七、Shell函数

* 定义：funName() {}

  **函数的返回值可以通过return语句显示说明。如果不加return语句，将以最后一条命令的执行结果作为返回值**

  ```shell
  #!/bin/bash
  mutile() {
  	echo "请输入第一个数："
  	read num1
  	echo "请输入第二个数："
  	read num2
  	num=`expr ${num1} \* ${num2}`
  	return ${num}
  }
  mutile
  echo "函数的返回值是： $? !"
  ```

* 函数参数

```shell
funparam() {
	echo "第一个参数 ${1}"
	echo "第二个参数 ${2}"
}
funparam 1 2 #输出：第一个参数1 第二个参数2  当参数大于等于10时，获取参数必须加大括号
```

* 其它特殊字符处理参数

| 参数处理 | 说明                                                         |
| :------- | :----------------------------------------------------------- |
| $#       | 传递到脚本或函数的参数个数                                   |
| $*       | 以一个单字符串显示所有向脚本传递的参数                       |
| $$       | 脚本运行的当前进程ID号                                       |
| $!       | 后台运行的最后一个进程的ID号                                 |
| $@       | 与$*相同，但是使用时加引号，并在引号中返回每个参数。         |
| $-       | 显示Shell使用的当前选项，与set命令功能相同。                 |
| $?       | 显示最后命令的退出状态。0表示没有错误，其他任何值表明有错误。 |

### 八、输入输出重定向

* 重定向命令列表

| 命令            | 说明                                               |
| :-------------- | :------------------------------------------------- |
| command > file  | 将输出重定向到 file。                              |
| command < file  | 将输入重定向到 file。                              |
| command >> file | 将输出以追加的方式重定向到 file。                  |
| n > file        | 将文件描述符为 n 的文件重定向到 file。             |
| n >> file       | 将文件描述符为 n 的文件以追加的方式重定向到 file。 |
| n >& m          | 将输出文件 m 和 n 合并。                           |
| n <& m          | 将输入文件 m 和 n 合并。                           |
| << tag          | 将开始标记 tag 和结束标记 tag 之间的内容作为输入。 |

#### 1.输出重定向

```shell
#终端不会有任何输出，因为输出被默认的标准输出（终端）重定向到了test.txt文件中
echo "xxx" > test.txt
echo "yyy" > test.txt #会覆盖上一条xxx
echo "zzz" >> test.txt #以追加的方式输出zzz重定向到test.txt文件中
#其它实例
who > user.txt
date >> user.txt
```

#### 2.输入重定向

```shell
#统计user.txt文件的行数 终端会输出文件名
wc -l user.txt
#使用输入重定向的方式 终端不会输出文件名，它仅仅知道从标准输入读取内容
wc -l < user.txt
#也可以输入输出连用
wc -l < user.txt > result.txt #从user.txt读取内容执行命令 输出到result.txt中
```

#### 3./dev/null文件

* 如果想要禁止在屏幕输出命令执行结果，则可以

```shell
#/dev/null是一个特殊的文件，所有写到这个文件的内容都会被丢弃，如果去读取它，自然什么也读取不到
command > /dev/null 
```

### 九、文件包含

shell允许包含外部文件脚本，这样可以将公共的代码作为一个独立的文件被引用。

* 语法格式

```shell
#1
. filename #. 和filename之间有空格

#2
source filename
```