# SpringCore
This project contains Spring IOC container configuration, bean lifecycle management methods and dependency injection examples.  

## Configure a bean

There are two ways to configure a bean 

### 1) XML based configuration

`< bean >` tag is used to configure a bean in XML based configuration 
  
`#ApplicationContext.xml`

`<bean id="roleBean" class="com.sunilos.spring.bean.Role" />`

Account, Customer, Role and User beans are configured using bean tags. Role and Acount beans are injected using <property> tags.

See: https://github.com/sunilos/SpringCore/blob/master/src/main/java/applicationContext.xml

### 2) Java based configuration 

@Bean annotation is used to configuare a bean in Java based configuration 

`@Configuration`
`public class AppConfig {`

 `@Bean("student")`
 
 `public Student studentBean() {`
   `return new Student();`
 `}`
 
`}`

See: https://github.com/sunilos/SpringCore/blob/master/src/main/java/com/sunilos/spring/AppConfig.java


## Annotation based bean and Auto discovery 

A Java class can be defined as bean using @Component, @Service and @Repository annotations. Annotated classes are auto-discovered (auto-scan) and registered with IOC container.

Auto discovery is configured by  
1. `<context:component-scan base-package="com.sunilos.spring" />` tag in XML based configuration  and 
1. by `@ComponentScan(basePackages = { "com.sunilos.spring" })` in Java based configuration.

Payment, Inventory, Order, UserDAO and UserService beans are configured using @Component, @Service and @Repository annotation. 
Payment and Inventory beans are injected in Order beans using @Autowired annotation.

See wiki for more understanding 

https://github.com/sunilos/SOSSpringCore/wiki
