# SOSSpringCore
Containing Spring IOC container configuration, bean lifecycle management and dependency injection examples.  

There are three ways to configure a bean 

1) Using <bean> Tag 
Account, Customer, Role and User beans are configured using bean tags. 
Role and Acount beansa are injected using <property> tags.
  
2) Using Annotation  
Payment, Inventory, Order, UserDAO and UserService beans are configured using @Component, @Service and @Repository annotation. 
Payment and Inventory beans are injected in Order beans using @Autowired annotation.


3) Java based configuration 
Student bean is configured in com.sunilos.spring.ConfigContext java class using @Bean annotation 


#Import and Run project in Eclipse

Read URL http://www.sunilos.com/Home/java-development-environment-setup/import-an-eclipse-project#TOC-Import-Eclipse-Project-from-GitHub
