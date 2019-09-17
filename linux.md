> 输出重定向     覆盖源文件
>>   追加到末尾
ls -l > a.txt

head  文件的前10行
tail   文件的末尾
tail -n 5  文件     文件的后5行
tail -f  文件  实时变化

free 查看内存


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