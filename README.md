springCloud全家桶
=============================================================================================

*********************************************************************************************
## hello服务
在git上面有两个分支，master分支，s1分支  
启动两个服务，端口号8881，8882  
8882配置  
spring.cloud.config.profile=dev  
spring.cloud.config.label=master  
8881配置  
spring.cloud.config.profile=dev  
spring.cloud.config.label=s1  

分别修改master和s1分支下的application-dev.properties文件  
management.endpoints.web.base-path控制下面两个地址的前缀（默认是acturate，具体可以查看启动日志），下面配置的是management.endpoints.web.base-path=/  
1、使用post方法调用http://192.168.56.1:8882/bus-refresh，则所有的hello服务都会更新  
2、使用post方法调用http://192.168.56.1:8882/refresh，则只有8882会进行重新读取配置文件  
两者结合可以做到先修改一个服务的参数，查看效果，然后批量应用到所有服务上面  
******************************************************************************************************

*************************************************************************************
## config-server服务
spring.cloud.config.server.git.uri=file:D:/workspaces/springcloud/gitconfig该目录下面要是git的项目，  
即有.git文件（使用本地仓库，也可以配置远程仓库)  
spring.application.name=config-server  
server.port=7000  
actuator 开放控制节点使用，可以开放actuator访问指定的节点，也可以开放actuator的所有节点  
management.endpoints.web.exposure.include=*  
actuator 配置节点的访问方式，如果不配置，则默认为/actuator/  
management.endpoints.web.base-path=/  
eureka.instance.prefer-ip-address=true  
eureka.instance.ip-address=192.168.56.101  
eureka.instance.hostname=node1  
在配置中心用hostname:port展示节点,多个网卡的时候，可以通过这个来选择，
在hosts配置hostname对应的ip，在hostname文件中配置主机名称，其他服务通过注册中心拿到的conf地址是${eureka.instance.hostname}:${server.port}  
或者通过${eureka.instance.ip-address}:${server.port}指定在配置中心中的具体IP地址  
eureka.instance.instance-id=${eureka.instance.hostname}:${server.port}  
eureka.client.service-url.defaultZone=http://192.168.56.101:1111/eureka/,http://192.168.56.101:1111/eureka/  
spring.cloud.config.server.git.uri=file:D:/workspaces/git/configFileTest  
spring.cloud.config.server.git.search-paths={application}  
spring.rabbitmq.host=192.168.56.101  
spring.rabbitmq.port=5672   
spring.rabbitmq.username=yejy  
spring.rabbitmq.password=123456  
******************************************************************************************************

*************************************************************************************
## eureka-server服务
可以通过直接配置config-server地址，达到动态添加节点的目的  
*只需要通过spring.cloud.config.uri配置直接访问配置中心，在注册中心服务中需要注释掉这个选项，否则启动会失败  
*spring.cloud.config.discovery.enabled=false  
*直接查找配置服务  
spring.cloud.config.uri=http://192.168.56.101:7000  
spring.cloud.config.profile=dev  
spring.cloud.config.label=master  
******************************************************************************************************

******************************************************************************************************
## 多网卡配置，指定特定IP  
eureka.instance.prefer-ip-address=true  
eureka.instance.ip-address=192.168.56.101  
eureka.instance.hostname=node1  
在配置中心用hostname:port展示节点,多个网卡的时候，可以通过这个来选择，  
在hosts配置hostname对应的ip，在hostname文件中配置主机名称，其他服务通过注册中心拿到的conf地址是${eureka.instance.hostname}:${server.port}  
或者通过${eureka.instance.ip-address}:${server.port}指定在配置中心中的具体IP地址  
eureka.instance.instance-id=${eureka.instance.hostname}:${server.port}  
*#eureka.instance.instance-id=${eureka.instance.ip-address}:${server.port}  
******************************************************************************************************


