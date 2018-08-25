# Linux下的软件安装

### 一、源码包编译安装

?	典型的源码编译安装软件的过程：
	1.运行configure，结合必要参数生成Makefile；
	2.运行make命令生成模块和主程序。
	3.make install命令将必要的文件复制到安装目录中。
	注：以上三步都需要在软件包目录的根目录下运行。

源码包编译安装Apache示例：
	1.官方找到最新版本的apache下载路径。（一般源码包都放在/usr/local/src目录下）
	2.运行命令：wget http://mirror.bit.edu.cn/apache/httpd/httpd-2.4.33.tar.gz
	3.解压:tar zxvf httpd-2.4.33.tar.gz 并进入解压后的目录 cd httpd-2.4.33
	4.运行命令./concigure --prefix=/usr/local/apache/ --enable-modules=most   //--prefix指定安装路径（一般建议安装在/usr/local/下） 后面启用绝大部分模块
	5.以上如果顺利，将会生成Makefile文件，然后执行make && make install
	注：我在安装的时候第四步出现 APR not found.  Please read the documentation错误，是因为环境中没有APR，此时需要安装APR。

### 二、RPM安装软件

?	RPM是集成了文件管理和软件版本控制的工具。
	RPM分为两类：

?		1）先预编译好软件，并将所需要的其它文件整体打包。其它主机安装该包时，将文件解压并且复制到特定的目录中去。
		2）RMP源码包，希望自定义编译参数，自行制作二进制安装包的时候使用。

1.RPM包管理命令rpm:实际它有很多安装参数，实际需要组合使用，下面列出常见参数使用方法
		1）安装软件包:rpm -ivh package-version.rpm。
		2）测试安装软件包，不做真实的安装:rpm -ivh --test package-version.rpm
		3）安装软件包并重新定义安装路径: rpm -ivh --relocate /=/usr.../package-version.rpm
		4）强行安装软件包，忽略依赖关系：rpm -ivh package-version.rpm  --force --nodeps
		5）升级软件包：rpm -Uvh package-version.rpm
		6）




