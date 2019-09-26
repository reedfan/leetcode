> 输出重定向     覆盖源文件
>>   追加到末尾
ls -l > a.txt

head  文件的前10行
tail   文件的末尾
tail -n 5  文件     文件的后5行
tail -f  文件  实时变化

top :按CPU使用、内存使用和执行时间对任务进行排序
ps：查看当前进程
free 内存使用情况
df-h  查看磁盘还剩多少空间
df：查看磁盘文件使用情况，被磁盘占用多少空间，还剩多少空间
du：查看磁盘空间的使用情况，统计目录或文件所占空间的大小


netstat  查看网络状态
-an  按一定序列排除
-p   显示哪个进程正在调用

rpm -qa|grep XX
查看linux下是否安装XX
删除   rpm -e rpm的包名 


vim模式下
/reed       就是去查找reed   
或者vi /reed  test.txt
:set nu  或者 set number 显示行号