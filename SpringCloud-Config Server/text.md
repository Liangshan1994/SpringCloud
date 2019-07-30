## 1. Config介绍
在分布式中我们会有很多服务，每个服务都有配置文件，如果修改了某个在多个服务中用到的配置项，那么就需要去各个服务中更改，非常麻烦。
而且在开发，测试，生产三个场景用到的配置也是不同的，为了方便这些配置的管理，就用到了配置中心。  
配置中心分为了服务端和客户端，服务端主要是读取git/svn仓库中的配置项，然后客户端会去从服务端获取配置。

## 2. 准备工作
一个注册中心，一个Config Server，一个Config Client，不同环境的配置文件
```
config-dev.properties
config-pro.properties
config-test.properties
```
内容分别是
```
hello=this is dev
hello=this is pro
hello=this is test
```
## 3. 代码实现
### 3.1 注册中心
这里就不介绍怎么新建注册中心了
### 3.2 Config Server
- pom.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.6.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.pikaqiu.springcloud</groupId>
    <artifactId>config</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>SpringCloud-Config</name>
    <description>Demo project for Spring Boot</description>
    <properties>
        <java.version>1.8</java.version>
        <spring-cloud.version>Greenwich.SR2</spring-cloud.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-config-server</artifactId>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```
- application.yml
```
server:
  port: 5006
spring:
  application:
    name: config
  cloud:
    config:
      server:
        git:
          uri: https://github.com/Liangshan1994/SpringCloud
          search-paths: SpringCloud-Config-Repo
          username:
          password:
eureka:
  client:
    service-url:
        defaultZone: http://eureka-server1:3001/eureka/
  instance:
    instance-id: 配置中心-5006
```
- SpringCloudConfigApplication.java
```java
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class SpringCloudConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigApplication.class, args);
    }
}
```
- 启动注册中心和配置中心  
访问http://127.0.0.1:5006/config/dev  
返回
```json
{
    "name":"config",
    "profiles":[
        "dev"
    ],
    "label":null,
    "version":"99f25c23da606d7588299151d64737ccbf4c544c",
    "state":null,
    "propertySources":[
        {
            "name":"https://github.com/Liangshan1994/SpringCloud/SpringCloud-Config-Repo/config-dev.properties",
            "source":{
                "hello":"this is dev"
            }
        }
    ]
}
```
请求地址规则是/{application}/{profile}[/{label}]，根据文件的命名去定义
```
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties
```
我的文件名是config-dev.properties,符合第三种{application}是config，{profile}是dev


