# Linux基本操作

## 一. 用户登录

### 1.root用户

* 特殊的管理用户，也叫超级用户。接近完整的系统控制。
* 除非必要否则不要登录root

### 2.普通用户

* 权限有限，因此造成损害的能力有限。

**判断是超级用户还是普通用户**

```shell
#id是0 则超级用户，非0则普通用户
id -u
```



## 二. 终端

设备终端、物理终端、虚拟终端、图形终端、串行终端、伪终端

**查看当前终端设备**

```shell
tty

#查看当前系统版本
cat /etc/centos-release
lsb_release -a

#查看内核版本
uname -r

#查看cpu信息
lscpu

#查看内存大小
free -h

#查看硬盘
lsblk

#查看网卡
mii-tool 网卡名

#查看主机名
hostname
```



## 三. Shell介绍

```shell
#查看系统支持哪些shell
cat /etc/shells
#查看当前系统使用的shell
echo $SHELL
```



## 四. 执行命令

* 输入命令回车后，就是shell程序找到键入命令对应的可执行程序或者代码，分析后交给内核分配资源运行。

* 命令的分类

  * 内部命令：shell自带的，通过某种命令形式提供

    * help ：内部命令列表
    * enable cmd ： 启动内部命令
    * enable -n cmd ：禁用内部命令
    * enable -n ：查看所有禁用的内部命令

  * 外部命令：在文件系统路径下对应的可执行程序文件

    * 查看路径：which -a|--skip-alias; whereis

    ```shell
    #查看外部命令init的文件路径
    which init
    whereis init
    ```

* 判断指定的命令是内部或者外部命令 type Command

```shell
#判断pwd是否是内部命令
type pwd
```

注：优先执行内部命令，然后执行外部命令。内部命令的执行更快，执行外部命令时需要找到这个外部命令的路径，因此耗时，效率低。

## 五. 简单命令

## 六. Tab键补全

## 七. 命令行历史

## 八. bash快捷键

## 九. 使用gnome-teminal

## 十. whatis

## 十一. command --help

## 十二. man and info

## 十三. 本地帮助文档 /usr/share/doc

## 14.官网在线文档

## 15.其它网站和搜索