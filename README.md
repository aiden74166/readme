# readme

## 打包

 javac -classpath hutool-all-5.5.7.jar SayThirdTest.java
 
 java -cp hutool-all-5.5.7.jar:. SayThirdTest
 
## 检查线路

traceroute      127.0.0.1

mtr  127.0.0.1


## firewall
```
开放端口
永久的开放需要的端口
sudo firewall-cmd --zone=public --add-port=80/tcp --permanent
sudo firewall-cmd --reload

之后检查新的防火墙规则
firewall-cmd --list-all

//临时关闭防火墙,重启后会重新自动打开
systemctl restart firewalld
//检查防火墙状态
firewall-cmd --state

//Disable firewall
systemctl disable firewalld
systemctl stop firewalld
systemctl status firewalld
//Enable firewall
systemctl enable firewalld
systemctl start firewalld
systemctl status firewalld
```

## freemarker

```
${(data.createTime?datetime)!}
```

## telegram
```
https://api.telegram.org/bot1111114:AAGuf-qMzKxxxxxxxxxxxxrBVBW_zBs/sendMessage

curl -X POST "${TELEGRAM_EXE}"  -d "chat_id=-4251111111&text=操作成功"

<dependency>
   <groupId>com.github.pengrad</groupId>
   <artifactId>java-telegram-bot-api</artifactId>
   <version>5.1.0</version>
</dependency>
https://github.com/pengrad/java-telegram-bot-api
```

## ffmpeg
```
MP4 转 MP3
ffmpeg -i videoplayback.mp4  videoplayback.mp3
```
## Jenkins

```
Subversion @HEAD

节点列表 master 节点属性 环境变量 BUILD_ID DontKillMe

ps -ef |grep java| grep "server.port=8080" | grep -v grep |awk '{print $2}'|xargs kill -9 1>/dev/null 2>&1 | exit 0
nohup java -jar ${appweb}.jar --server.port=8080 --spring.profiles.active=${spring_profiles_active} >/dev/null 2>&1 &

```
## springboot

@ 标签

```
@Profile(value = { "task", "local" })

@EnableScheduling
@Scheduled(fixedDelay = 1000 * 60 * 5L, initialDelay = 30 * 1000)
@Scheduled(cron = "0 15 4 * * ?")

@Configuration
//定时任务调用一个线程池中的线程。
public class ScheduleConfig implements SchedulingConfigurer {
	@Override
	public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
		// 参数传入一个size为10的线程池
		scheduledTaskRegistrar.setScheduler(Executors.newScheduledThreadPool(10));
	}
}
```


## ip

```
	https://github.com/out0fmemory/qqwry.dat.git
```

## 图片压缩

https://tinypng.com/

## jdk版本切换

alternatives --config java

## 纸飞机

https://api.telegram.org/bot6141414:AAGRf4vg139CxQogNru_Z7Uw/getUpdates
nodeid=`cat test.txt`
curl -X POST "https://api.telegram.org/bot6114:AAGRf9CxQogNru_Z7Uw/sendMessage" -d "chat_id=-937075&text=$nodeid"

## 图片在linux不显示

···
yum install fontconfig
fc-cache --force
···

## centos 只有root进桌面_物理机安装Centos7后，空间只有50G问题

原文链接：https://blog.csdn.net/weixin_29603829/article/details/112148313

## cmd 复制

cd D:\游戏服务器 && for /d %i in (*) do XCOPY D:\游戏登录服务器\ServerParameter.ini "D:\游戏服务器\%i"
