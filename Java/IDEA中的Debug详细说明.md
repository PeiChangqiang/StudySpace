## IDEA中的Debug详细说明

#### Debug窗口介绍

<img src="C:\Users\pcq\AppData\Roaming\Typora\typora-user-images\1574997305534.png" alt="1574997305534"  />





---

#### 按钮的用法说明和快捷键

* **调试按钮**

<img src="C:\Users\pcq\AppData\Roaming\Typora\typora-user-images\1575007048847.png" alt="1575007048847" style="zoom:200%;" />



| 名称                                          | 快捷键               | 用意                                     |
| --------------------------------------------- | -------------------- | ---------------------------------------- |
| <font color='red'>Show Execution Point</font> | **Alt + F10**        | 跳转至当前执行代码行                     |
| <font color='red'>Step Over</font>            | **F8**               | 一行一行执行，不会步入方法内             |
| <font color='red'>Step Into</font>            | **F7**               | 一般步入自定义方法内，而不会步入官方类库 |
| <font color='red'>Force Step Into</font>      | **Alt + Shift + F7** | 强制步入任何方法内，包括官方类库         |
| <font color='red'>Step Out</font>             | **Shift + F8**       | 从步入的方法内步出至方法调用出           |
| <font color='red'>Drop Frame</font>           | 默认无               | 回退断点                                 |
| <font color='red'>Run to Cursor</font>        | **Alt + F9**         | 运行至光标处而无需打断点                 |
| <font color='red'>Evaluate Expression</font>  | **Alt + F8**         | 计算表达式                               |



* **服务按钮**

<img src="C:\Users\pcq\AppData\Roaming\Typora\typora-user-images\1575007091565.png" alt="1575007091565" style="zoom:150%;" />



| 名称                                      | 快捷键                | 用意                   |
| ----------------------------------------- | --------------------- | ---------------------- |
| <font color='red'>Rerun</font>            | **Ctrl + F5**         | 关闭服务后重新启动程序 |
| <font color='red'>Resume Program </font>  | **F9**                | 运行至下一个断点       |
| <font color='red'>Pause Program</font>    | 默认无                | 暂停                   |
| <font color='red'>Stop</font>             | **Ctrl + F2**         | 关闭程序               |
| <font color='red'>View Breakpoints</font> | **Ctrl + Shift + F8** | 查看所有断点           |
| <font color='red'>Mute Breakpoint</font>  | 默认无                | 使所有断点失效         |



---

#### 查看变量的几种方式

* 代码行后自动显示

![1575005497084](C:\Users\pcq\AppData\Roaming\Typora\typora-user-images\1575005497084.png)

* 鼠标悬停在变量上后点击加号

![1575005552013](C:\Users\pcq\AppData\Roaming\Typora\typora-user-images\1575005552013.png)

* 变量区中查看当前方法中所有变量

<img src="C:\Users\pcq\AppData\Roaming\Typora\typora-user-images\1575005604048.png" alt="1575005604048" style="zoom: 80%;" />



---

#### 计算表达式

* 选中表达式后点击“**Evaluate Expression**”按钮或者按快捷键**Alt+F8**

![1575005891473](C:\Users\pcq\AppData\Roaming\Typora\typora-user-images\1575005891473.png)



* **通过设置变量参数值查看表达式结果**

点击加号查看变量后右键变量可以**Set Value**，之后再点击**Evaluate**按钮即可查看表达式结果。

![1575006331295](C:\Users\pcq\AppData\Roaming\Typora\typora-user-images\1575006331295.png)



---

#### 智能步入

有时候一行代码调用了多个方法，想智能选择步入哪个方法可以通过以下方式

![1575007691408](C:\Users\pcq\AppData\Roaming\Typora\typora-user-images\1575007691408.png)

快捷键**shift + F7**,自动定位到当前断点行，并列出需要进入的方法，之后手动选择即可。如果只有一个方法，那么它和普通步入作用是一样的，直接进入到该方法中。



---

#### 断点条件设置

只要当断点的条件满足时，才停留在断点处，否则直接运行。这对于遍历数组或者集合时十分有用。因为不可能每次循环都看一下变量的值。

* 单行断点条件设置

右键断点设置条件，之后当i的值为10的时候，才停留在该断点处。

![1575008450589](C:\Users\pcq\AppData\Roaming\Typora\typora-user-images\1575008450589.png)



* **全局断点设置**

**View Breakpoints（Ctrl + Shift + F8）**，打开以下窗口

![1575009377581](C:\Users\pcq\AppData\Roaming\Typora\typora-user-images\1575009377581.png)

1. 条件设置

2. Log message to console:当前断点行输出到控制台。

3. Evaluate and log:执行断点行代码时计算表达式的值并且输出到控制台。

4. 过滤器

   - Instance filters：实例过滤，输入实例ID进行过滤
   - Class filters：根据类名进行过滤
   - Pass count：循环中使用，设置循环多少次后停在该断点处，之后循环都停在断点处。

   5.异常断点

点击上图左上角 “+”号添加异常类

![1575010174031](C:\Users\pcq\AppData\Roaming\Typora\typora-user-images\1575010174031.png)

   添加好需要拦截的异常类后，当程序运行出现该异常时，则会自动定位到异常行。



---

#### 多线程调试

IDEA在Debug时默认阻塞级别是ALL，可以在"View Breakpoints"中设置，

![1575011099594](C:\Users\pcq\AppData\Roaming\Typora\typora-user-images\1575011099594.png)

点击“**Make Default**”可设置为默认值。



这样当多个线程执行的时候，就可以切换线程调试。

![1575018225819](C:\Users\pcq\AppData\Roaming\Typora\typora-user-images\1575018225819.png)



---



#### 回退断点

就是回退到上一个方法调用处。回退的方式有2种

* 通过按钮“**Drop Frame**”。
* 在方法调用栈中右键方法选择回退。





---

#### 中断Debug

![1575020225643](C:\Users\pcq\AppData\Roaming\Typora\typora-user-images\1575020225643.png)

在方法栈中右键方法选择“**Force Return**”可以强制中断Debug，而不用走后续代码。这样避免了调试中总是重启服务。