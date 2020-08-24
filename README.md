springCloud全家桶

************************************************hello服务*********************************************
## 在git上面有两个分支，master分支，s1分支

启动两个服务，端口号8881，8882
8882配置
spring.cloud.config.profile=dev
spring.cloud.config.label=master
8881配置
spring.cloud.config.profile=dev
spring.cloud.config.label=s1

分别修改master和s1分支下的application-dev.properties文件
1、使用post方法调用http://192.168.56.1:8882/bus-refresh，则所有的hello服务都会更新
2、使用post方法调用http://192.168.56.1:8882/refresh，则只有8882会进行重新读取配置文件
两者结合可以做到先修改一个服务的参数，查看效果，然后批量应用到所有服务上面
******************************************************************************************************

*******************************************config-server服务******************************************
spring.cloud.config.server.git.uri=file:D:/workspaces/springcloud/gitconfig该目录下面要是git的项目，
即有.git文件（使用本地仓库，也可以配置远程仓库)
******************************************************************************************************