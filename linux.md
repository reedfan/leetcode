> 输出重定向     覆盖源文件
>>   追加到末尾
ls -l > a.txt

head  文件的前10行
tail   文件的末尾
tail -n 5  文件     文件的后5行
tail -f  文件  实时变化


## uptime
15:10:24 up 288 days(系统运行时间), 21:23(当前时间),  1 user(当前登录用户数),  load average: 0.04, 0.11, 0.09
0.04, 0.11, 0.09 分别记录了一分钟、五分钟、以及十五分钟的系统平均负载

## top 
按CPU使用、内存使用和执行时间对任务进行排序
第一行同uptime
Tasks 任务（进程）:  73 total(进程总数),   2 running(正在运行的进程数),  71 sleeping(睡眠的进程数),   0 stopped(停止的进程数),   0 zombie(僵尸进程数)
%Cpu(s)CPU信息统计数据：:  1.0 us用户空间占用CPU百分比,  1.0 sy内核(系统)空间占用CPU百分比,  0.0 ni用户进程空间内改变过优先级的进程占用CPU百分比, 
98.0 id空闲CPU百分比,  0.0 wa等待输入输出的CPU时间百分比,  0.0 hi硬件CPU中断占用百分比,  0.0 si软中断占用百分比,  0.0 st虚拟机(虚拟化技术)占用百分比
第四、五行为内存信息系统数据：
KiB Mem :  1883724 total 物理内存总量,   121748 free空闲内存总量,   822620 used使用的物理内存总量,   939356 buff/cache 用作内核缓存的内存量
KiB Swap:        0 total,        0 free,        0 used.   791600 avail Mem 

在平时的运维工作中，当一台服务器的性能出现问题时，通常会去看当前的CPU使用情况，尤其是看下CPU的负载情况(load average)。对一般的系统来说，根据cpu数量去判断。比如有2颗cup的机器。如果平均负载始终在1.2以下，那么基本不会出现cpu不够用的情况。也就是Load平均要小于Cpu的数量。

## ps
查看当前进程
ps -ef #显示所有当前进程
ps aux #显示所有当前进程
## free 
内存使用情况
              total        used        free      shared              buff/cache   available
        总计物理内存的大小  已使用多大   可用有多少  多个进程共享的内存总额。  缓存内存数
Mem:        1883724      821980      122304       96708               939440      792232
Swap:             0           0           0
第二部分(-/+ buffers/cache):

    (-buffers/cache) used内存数：1.2G (指的第一部分Mem行中的used – buffers – cached)
    (+buffers/cache) free内存数: 14.4G (指的第一部分Mem行中的free + buffers + cached)

可见-buffers/cache反映的是被程序实实在在吃掉的内存，而+buffers/cache反映的是可以挪用的内存总数.

对应用程序来讲是(-/+ buffers/cach).buffers/cached 是等同可用的，因为buffer/cached是为了提高程序执行的性能，当程序使用内存时，buffer/cached会很快地被使用。

## vmstat 
虚拟内存


## df-h  
查看磁盘还剩多少空间
df：查看磁盘文件使用情况，被磁盘占用多少空间，还剩多少空间
du：查看磁盘空间的使用情况，统计目录或文件所占空间的大小

## lsof
命令用于查看你进程开打的文件，打开文件的进程，进程打开的端口(TCP、UDP)。找回/恢复删除的文件。是十分方便的系统监视工具

lsof -c mysql ,列出某个程序所打开的文件信息
lsof -i :3306 列出谁在使用某个端口

## netstat  
查看网络状态
-an  按一定序列排除
-p   显示哪个进程正在调用

rpm -qa|grep XX
查看linux下是否安装XX
删除   rpm -e rpm的包名 

使用netstat命令查询端口占用
netstat -nap | grep [pid]

## 在/home目录下查找以.txt结尾的文件名

find /home -name "*.txt"

同上，但忽略大小写

find /home -iname "*.txt"

vim模式下
/reed       就是去查找reed   
或者vi /reed  test.txt
:set nu  或者 set number 显示行号