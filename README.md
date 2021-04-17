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
```

## ffmpeg
```
MP4 转 MP3
ffmpeg -i videoplayback.mp4  videoplayback.mp3
```

