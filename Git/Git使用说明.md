

# Git使用说明

## Git工作流程图

<img src="https://developer.aliyun.com/files/course/2017/09-25/174429daa761260095.png" alt="img"  />



## Git工作区，暂存区和版本库

### 基本概念

* 工作区：git使用的目录。
* 暂存区：也叫索引，是.git文件夹下的index文件。
* 版本库：.git目录就是版本库。

### 关系图展示及说明

![img](https://developer.aliyun.com/files/course/2017/09-25/1745459ca252743119.jpg)

图中左侧为工作区，右侧为版本库。在版本库中标记为 "index" 的区域是暂存区（stage, index），标记为 "master" 的是 master 分支所代表的目录树。

图中我们可以看出此时 "HEAD" 实际是指向 master 分支的一个"游标"。所以图示的命令中出现 HEAD 的地方可以用 master 来替换。

图中的 objects 标识的区域为 Git 的对象库，实际位于 ".git/objects" 目录下，里面包含了创建的各种对象及内容。

当对工作区修改（或新增）的文件执行 "git add" 命令时，暂存区的目录树被更新，同时工作区修改（或新增）的文件内容被写入到对象库中的一个新的对象中，而该对象的ID被记录在暂存区的文件索引中。

当执行提交操作（git commit）时，暂存区的目录树写到版本库（对象库）中，master 分支会做相应的更新。即 master 指向的目录树就是提交时暂存区的目录树。

当执行 "git reset HEAD" 命令时，暂存区的目录树会被重写，被 master 分支指向的目录树所替换，但是工作区不受影响。

当执行 "git rm --cached <file>" 命令时，会直接从暂存区删除文件，工作区则不做出改变。

当执行 "git checkout ." 或者 "git checkout -- <file>" 命令时，会用暂存区全部或指定的文件替换工作区的文件。这个操作很危险，会清除工作区中未添加到暂存区的改动。

当执行 "git checkout HEAD ." 或者 "git checkout HEAD <file>" 命令时，会用 HEAD 指向的 master 分支中的全部或者部分文件替换暂存区和以及工作区中的文件。这个命令也是极具危险性的，因为不但会清除工作区中未提交的改动，也会清除暂存区中未提交的改动。



## Git创建仓库

### 使用当前目录作为仓库git init 

* 在哪个目录下使用这个命令，就会在哪个目录下生产.git目录，标志这个目录是git仓库，目录下会包含资源的所有元数据。
* 指定特定的目录则使用**git init repoName**

### 从现有git仓库中拷贝git clone

* git clone [repo] 默认拷贝到当前目录下，指定目录则git clone [repo] dictionary
* 例如：git clone https://github.com/PeiChangqiang/StudySpace 



## Git基本操作

<font color='red'>Git 的工作就是创建和保存你项目的快照及与之后的快照进行对比。</font>

### 获取与创建仓库命令

* git init 
* git clone

### 基本快照

* **git add：**将当前文件添加至暂存区。

  * git add fileName, 如果想添加所有的改动到暂存区，则执行**git add .**
* **git status：**查看当前版本库中的状态。
* **git diff：**查看git status结果的详细信息。即查看当前改动和暂缓区的区别。
* git diff --cached：查看暂存区和版本库的区别。
  
* git diff head：查看当前改动和暂存区，版本库的区别。
* **git commit：**将缓存区内容添加到版本库中。

  * 如果add 再提交觉得繁琐，可以git commit -am 'note'
* **git reset head：**撤销**git add**操作。

  * git reset head -- fileName，撤销某个文件的暂存区提交。
* **git rm：**删除文件。

  * git rm fileName，从工作区中删除某个文件，如果暂存区也有该文件，则一并删除。如果仅仅删除暂存区的而保留工作区中的则使用 git rm --cached fileName。
* **git mv：**git mv 命令做得所有事情就是 **git rm --cached** 命令的操作， 重命名磁盘上的文件，然后再执行 git add 把新文件添加到缓存区。



## Git分支管理

<font color='red'>从git主线上分支开来，不影响主线上的工作。</font>

### 分支管理常见命令

* ##### 列出当前分支，git branch

* ##### 创建分支,git branch branchName

* ##### 切换分支,git checkout baranchName，或者 git checkout -b branchName创建新分支并且切换到该分支下。

* ##### 删除分支，git branch -d branchName

* ##### 分支合并：git merge branchName 将分支合并到当前分支中。

* ##### 合并冲突：冲突的内容需要手动改掉，之后通过git add命令告知git冲突已经解决。



## Git查看提交历史

### Git log使用

* 该命令查看提交历史
* 参数说明
  * --oneline 简洁输出模式
  * --graph 查看分支、合并的历史
  * --reverse 逆向查看历史日志
  * --author 查看指定用户的提交历史，例如 git log --author=peichangqiang
  * 指定历史日志的日期可以使用：--since  --before  --until  --after。例如：查看一周前并且十二月一日之后的提交，则：git log --oneline --before={1.weeks.ago} --after={2019-12-01}
  * --no-merges 可以隐藏合并提交
* [更多git log说明](http://git-scm.com/docs/git-log)



## Git标签
<font color='red'>如果项目到了一个特别的阶段,希望Git总能记住当前这个快照，就可以给它打标签，也就是版本。</font>

* 查看仓库所有标签：git tag
* 打标签：git tag -a -m,  -a的意思是添加注解，会记录谁在什么时候打的标签,-m是添加注释信息。 例如 git tag -a V1.0.0 -m '打基线版本'
* 删除标签：git tag -d ,如果删除后需要推送到远程仓库，则git push origin --delete。例如 git tag -d V1.0.0 , git  push origin --delete V1.0.0




## Git远程仓库(GitHub)

