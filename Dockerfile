#指定基础镜像
FROM java:8 
#维护者信息
MAINTAINER yashisoft
# VOLUME 指定了临时文件目录为/tmp。 其效果是在主机 /var/lib/docker 目录下创建了一个临时文件，并链接到容器的/tmp,用于指定持久化目录
VOLUME /sardline
# 将jar包添加到容器中并更名为app.jar
ADD my-security-0.0.1-SNAPSHOT.jar app.jar
#暴露端口
EXPOSE 8099
# 运行jar包
RUN bash -c 'touch /app.jar' 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

