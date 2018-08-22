#简介
本项目主要用于学习spring-boot的使用，在此基础上，结合购买的阿里云服务器，搭建个人服务器。

#点滴
![](https://xnstatic-1253397658.file.myqcloud.com/SpringBootBucket.png)

##jsp
application.properties中配置前向及后向拦截。
```text
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
```
此时的return会映射index.jsp
```text
@Controller
```








#参考
基于sb的博客系统 https://blog.csdn.net/u013967175/article/details/77429622
Quartz使用 https://blog.csdn.net/u012907049/article/details/73801122