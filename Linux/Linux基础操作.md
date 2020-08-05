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
```



## 三. Shell介绍

## 四. 执行命令

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