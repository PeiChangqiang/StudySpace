git init：初始化git仓库。
git add [fileName]：添加文件
git commit -m [annotation]：提交文件到仓库，后面的参数是添加注释
git status：查看当前版本库的状态


git diff：查看修改了哪些内容（工作区和暂缓区之间的区别）
git diff HEAD：查看工作区和版本区之间的区别
git diff --cached：查看暂缓区和版本区之间的

git reset --hard HEAD[^...]：版本回退。HEAD当前版本,几个^就回退几个版本，回退多个版本也可以HEAD~num
如果回退后返回了想再回来，可以使用git reset --hard [版本id]。
git reflog：查看自己使用过的命令


如果没有git add，那么撤销修改，使得工作区和版本库一致则只用git checkout -- [fileName]
如果git add到暂存区但是没有git commit，那么需要git reset HEAD [fileName]

git rm [fileName]：删除文件




和远程版本库协作：
	git remote add origin git@github.com:peichangqiang/gitTest.git   将当前目录和远程的版本库相关联。远程库的名字这里设置成origin了
	git push -u origin master	把本地master分支推送到了远程(第一次使用需要-u)
	git clone git@github.com:peichangqiang/project.git