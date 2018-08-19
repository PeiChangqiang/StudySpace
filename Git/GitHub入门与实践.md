### 一、GitHub的世界

##### 	1.github提供的主要功能

​		1）Git仓库
		2）Organization：如果公司使用，则需要使用Organization账号。
		3）Issue：将一个任务或者问题分配给一个Issue进行追踪和管理的功能。
4）Wiki：通过此功能任何人可以随时对一篇文章进行更改并且保存。常用在开发文档或者手册的编写中。
		5）Pull Request：向GitHub推送更新，请求别人合并。



### 二、Git的导入

##### 	1.git的初始设置

​		1)设置姓名和邮箱地址：git config --global user.name ""     git config --global user.email ""
		2)设置ui让命令输出更有可读性：git config --global color.ui auto

### 三、使用GitHub的准备

##### 	1.设置SSH Key

​	通过SSH的公开密钥认证方式，可以连接github上已有的仓库。
命令：	ssh -keygen -t rsa -C "account"   引号中输入自己的github账号。之后命令行提示要求输入密码，然后输入密码即可。
	之后，windows操作系统的账户(Administrator)文件夹下会默认生成.ssh文件夹。其中会有id_rsa.pub文件，就是ssh生成的公钥。

##### 2.GitHub的个人账户SSH Keys设置
​	在github个人账户的设置下，找到SSH and GPG Keys菜单栏，然后New SSH Key,给自己的连接设置一个title，然后把公钥粘贴在key输入框中即可。

##### 3.连接远程仓库

​		1）先远程创建仓库
		2）GitHub Flavored Markdown：GitHub上用到的Issue、评论、Wiki，都用Markdown语法表述。很简    		单，请务必自行学会该语法。
		3）git clone git@github.com:peichangqing/repository-name 从远程把建立的仓库克隆下来。
		4）本地git自行管理仓库，例如使用命令git status;git add;git log;git commit -m ""  等等。当本地clean的时候。可以push到远程
		5）git push：推送到远程服务器对应的仓库中。

### 四、实际操作Git

##### 1.git的基本操作

###### 	1）初始化仓库：git init 

​	初始化成功后会有一个.git目录。这个目录内容为“附属于该仓库的工作  树” 。文件的编辑等工作在            工作树中进行，然后记录到仓库中。以此管理文件的历史快照。恢复以前的状态可以使用历史快照。

###### 	2）显示git仓库的状态 ：git status

​        当我们做一些操作的时候，git仓库和工作树的状态会发生改变。该命令可以查看。

###### 	3）向暂缓存区中添加文件 ：git add

​        如果只是用git仓库的工作树创建文件，该文件不会被记入版本管理对象中。

###### 	4）提交到仓库：git commit 

​        将暂缓存区的文件实际保存到仓库的历史记录中。这些记录可以在工作树中复原文件。-m 参数来添加提交的注释内容 git commit -m "first commit"
	如果不加-m参数，则会自动启动编辑器，让你输入详细的注释内容。编辑器中记述提交信息的格式是：第一行：用文字简述提交的更改内容。第二行为空行。第三行之后：记述更改的原因和详细内容。
	编辑启动后想中止提交，就提交信息留空并直接关闭编辑器。提交就会中止。

注：git add 和 git commit 可以一起操作 : ==git commit -am ""==

###### 	5）查看提交的日志：git log 

​	如果加上--pretty=short参数就会只显示简述信息。
	git log后面加上目录名或者是文件名，则只显示与该目录或者文件相关的日志。
	如果加上-p参数，文件的前后差别则会显示在提交信息之后。例如git log -p Git

###### 	6）查看各区域的区别：git diff

 	查看工作树，暂缓存区，以及最新提交之间的区别。“+”号标出的是新添加的行。“-”标出的是被删除的行。不加任何参数就是查看工作树（工作区）和暂缓存区的差别。加上HEAD，则查看本次工作区和上次提交版本库中的区别。HEAD是指向分支中最新一次提交的指针。
git diff --cached，可以查看暂缓区和版本区之间的区别。

##### 2.分支的操作

###### 	1）显示分支：git branch 

​	显示分支一览表，带*号的是当前所在的分支。

###### 	2）创建并且切换分支：git checkout - b 

​	相当于git branch + git checkout。例如 git checkout -b A = git branch A(创建分支A) + git checkout A(切换到分支A)。git checkout - 其中的 “-”可以表示上一个分支

###### 	3）合并分支：git merge 

​	git checkout master先切换到主分支master上。然后git merge --no-ff feature-A：将feature-A分支合并到主分支上。参数--no-ff为了明确在历史记录中记下本次分支合并。

###### 	4）查看分支历史操作：git log --graph 

​	以图表方式查看分支的历史操作信息。

###### 	5）删除分支：git branch -d branch_name

​	删除一个分支。如果删除的是当前所在的分支，则使用-D大写D参数来强制删除。

###### 	6）恢复被删除的分支：git branch branch_name hash_val 

 	恢复一个被删除的分支。需要知道它的散列值，如果不知道它的散列值，可以使用git reflog命令寻找出来。

##### 3.更改提交的操作

​	想要仓库的HEAD，暂存区，当前工作树回溯到指定状态，只要提供目标时间点的哈希值，就能完全恢复到那个时间的状态。

###### 1)回到某个时间点

​	git reset --hard [hash]：恢复到该哈希值的时间点。

###### 2)查看仓库操作日志

​	git reflog：通过该命令能够找到操作的哈希值。

##### 4.推送至远程仓库

###### 1)添加远程仓库

​	git remote add：git remote add origin [远程仓库路径名]，git就会自动将远程仓库名称设置为origin。即一	  个标识符。

###### 2）推送至远程仓库

​	git push：git push -u origin master，将当前分支的内容推送给远程仓库origin的master分支。-u参数是在推送的同时，将origin仓库的master分支设置为本地仓库当前分支的upstream（上游）。添加了这个参数，以后git pull命令从远程仓库获取内容时，本地仓库的这个分支就可以直接从origin的master分支获取内容。

##### 5.从远程仓库获取

###### 1）git clone

​	这个命令默认处于master下，同时系统自动将origin设置成该远程仓库的标识符。

###### 2）同时显示本地仓库和远程仓库的分支信息

​	git branch -a。

###### 3)获取远程分支

​	git checkout -b feature-D[^1]  origin/feature-D

​        提交本地分支的修改到远程只需要在本地分支上进行命令git push即可。

###### 4）获取最新的远程仓库分支

​	git pull：如果远程做了修改，可以通过该命令来同步更新到最新状态，和远程保持一致。







---

[^1]: 这里是拉分支到本地起的名字，后面接远程仓库名称。这里保持了名称一致。 