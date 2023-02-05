# SSM

# 业务层之Spring框架

# 1. Spring概述

​	官网地址：https://spring.io/

Spring 是最受欢迎的企业级 **Java 应用程序**开发框架，数以百万的来自世界各地的开发人员使用

Spring 框架来创建**性能好**、**易于测试**、**可重用的代码**

Spring 框架是一个**开源**的 Java 平台，它最初是由 **Rod Johnson** 编写的，并且于 2003 年 6 **首次**在 **Apache 2.0 **许可下发布

Spring 是**轻量级**的框架，其**基础版本**只有 **2 MB 左右**的大小

Spring 框架的**核心特性**是可以用于**开发任何 Java 应用程序**，但是在 Java EE 平台上构建 web 应用程序是需要扩展的。 

Spring 框架的**目标**是使 **J2EE 开发变得更容易使用**，通过启用**基于 POJO 编程模型**来促进良好的编程实践

# 2. Spring家族

​	项目列表：https://spring.io/projects

# 3. Spring Framework

## 3.1 Spring Framework 概述

​	Spring 基础框架，可以视为 Spring 基础设施，基本上任何其他 Spring 项目都是以 Spring Framework为基础的

## 3.2 Spring Framework特性

​	**非侵入式：**

​		使用 Spring Framework 开发应用程序时，Spring 对应用程序本身的结构影响非常小，

​		对领域模型可以做到零污染；

​		对功能性组件也只需要使用几个简单的注解进行标记，完全不会破坏原有结构，反而能将组件结构进一步简化

​		这就使得基于 Spring Framework 开发应用程序时结构清晰、简洁优雅

​	**控制反转：**

​		IOC——Inversion of Control，翻转资源获取方向

​		把自己创建资源、向环境索取资源变成环境将资源准备好，我们享受资源注入

​	**面向切面编程：**

​		AOP——Aspect Oriented Programming，在不修改源代码的基础上增强代码功能

​	**容器：**

​		Spring IOC 是一个容器，因为它包含并且管理组件对象的生命周期

​		组件享受到了容器化的管理，替程序员屏蔽了组件创建过程中的大量细节，极大的降低了使用门槛，大幅度提高了开发效率

​	**组件化：**

​		Spring 实现了使用简单的组件配置组合成一个复杂的应用

​		在 Spring 中可以使用 XML和 Java 注解组合这些对象

​		这使得我们可以基于一个个功能明确、边界清晰的组件有条不紊的搭建超大型复杂应用系统

​	**声明式：**

​		很多以前需要编写代码才能实现的功能，现在只需要声明需求即可由框架代为实现

​	**一站式：**

​		在 IOC 和 AOP 的基础上可以整合各种企业应用的开源框架和优秀的第三方类库

​		而且Spring 旗下的项目已经覆盖了广泛领域，

​		很多方面的功能性需求可以在 Spring Framework 的基础上全部使用 Spring 来实现

## 3.3 Spring Framework 五大功能模块

| 功能模块                | 功能介绍                                                  |
| ----------------------- | --------------------------------------------------------- |
| Core Container          | 核心容器，在 Spring 环境下使用任何功能都必须基于 IOC 容器 |
| AOP&Aspects             | 面向切面编程                                              |
| Testing                 | 提供了对 junit 或 TestNG 测试框架的整合                   |
| Data Access/Integration | 提供了对数据访问/集成的功能                               |
| Spring MVC              | 提供了面向Web应用程序的集成功能                           |

# 4. Spring Framework 之 IOC

## 4.1 IOC容器

### 4.1.1 IOC思想

​		IOC：Inversion of Control，翻译过来是反转控制

**1. 获取资源的传统方式**

​	自己做饭：买菜、洗菜、择菜、改刀、炒菜，全过程参与，费时费力，必须清楚了解资源创建整个过程中的全部细节且熟练掌握

​	在应用程序中的组件需要获取资源时，传统的方式是组件**主动**的从容器中获取所需要的资源，

​	在这样的模式下开发人员往往需要知道在具体容器中特定资源的获取方式，

​	增加了学习成本，同时降低了开发效率

**2. 控制反转方式获取资源**

​	点外卖：下单、等、吃，省时省力，不必关心资源创建过程的所有细节

​	反转控制的思想完全颠覆了应用程序组件获取资源的传统方式：

​		反转了资源的获取方向——改由容器主动的将资源推送给需要的组件，

​		开发人员不需要知道容器是如何创建资源对象的，

​		只需要提供接收资源的方式即可，极大的降低了学习成本，提高了开发的效率，

​		这种行为也称为查找的被动形式！

**3. DI**

​	DI：Dependency Injection，翻译过来是依赖注入

​	DI 是 IOC 的另一种表述方式：

​		即组件以一些预先定义好的方式（例如：setter 方法）接受来自于容器的资源注入，相对于IOC而言，这种表述更直接

**结论：**

​	所以结论是：IOC 就是一种反转控制的思想， 而 DI 是对 IOC 的一种具体实现

### 4.1.2 IOC容器在Spring中的实现

​		Spring 的 IOC 容器就是 IOC 思想的一个落地的产品实现，

​		IOC 容器中管理的组件也叫做 bean，

​		在创建bean 之前，首先需要创建 IOC 容器

**Spring 提供了 IOC 容器的两种实现方式：**

​	**1. BeanFactory**

​		这是 IOC 容器的基本实现，是 Spring 内部使用的接口

​		面向 Spring 本身，不提供给开发人员使用

​	**2. ApplicationContext**

​		BeanFactory 的子接口，提供了更多高级特性，

​		面向 Spring 的使用者，几乎所有场合都使用ApplicationContext 而不是底层的 BeanFactory

​	**3. ApplicationContext的主要实现类**

​		![image-20221202192121667](assets\image-20221202192121667.png)

| 类型名                          | 简介                                                         |
| ------------------------------- | ------------------------------------------------------------ |
| ClassPathXmlApplicationContext  | 通过读取类路径下的 XML 格式的配置文件创建 IOC 容器对象       |
| FileSystemXmlApplicationContext | 通过文件系统路径读取 XML 格式的配置文件创建 IOC 容器对象     |
| ConfigurableApplicationContext  | ApplicationContext 的子接口，包含一些扩展方法refresh() 和 close() ，<br />让 ApplicationContext 具有启动、关闭和刷新上下文的能力 |
| WebApplicationContext           | 专门为 Web 应用准备，基于 Web 环境创建 IOC 容器对象，<br />并将对象引入存入 ServletContext 域中 |

## 4.2 基于XML管理bean

### 4.2.1 实验一：入门案例

#### 	1. 创建Maven Module

#### 	2. 引入依赖

```
<dependencies>    
	<!-- 基于Maven依赖传递性，导入spring-context依赖即可导入当前所需所有jar包 -->    
	<dependency>        
		<groupId>org.springframework</groupId>        
		<artifactId>spring-context</artifactId>        
		<version>5.3.1</version>    
	</dependency>    
	<!-- junit测试 -->    
	<dependency>        
		<groupId>junit</groupId>        
		<artifactId>junit</artifactId>
		<version>4.12</version>        
		<scope>test</scope>    
	</dependency>
</dependencies>
```

![image-20221202200929044](assets\image-20221202200929044.png)

#### 	3. 创建类HelloWorld

```
public class HelloWorld {  

	public void sayHello(){        
		System.out.println("helloworld");   
	}
	
}
```

#### 	4. 创建Spring的配置文件

![image-20221202201113061](assets\image-20221202201113061.png)

#### 	5. 在Spring的配置文件中配置bean

```
    <!--
        bean：配置一个bean对象，将对象交给IOC容器管理
        属性：
        id：bean的唯一标识，不能重复
        class：设置bean对象所对应的类型
    -->
    <bean id="helloworld" class="com.yj.nz.spring.pojo.HelloWorld"></bean>
```

#### 	6. 创建测试类测试

```
    @Test
    public void test(){
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取IOC容器中的bean
        HelloWorld helloworld = (HelloWorld) ioc.getBean("helloworld");
        helloworld.sayHello();
    }
```

#### 	7. 思路

![image-20221202194436045](assets\image-20221202194436045.png)

#### 	8. 注意

​		Spring 底层默认通过反射技术调用组件类的无参构造器来创建组件对象，

​		如果在需要无参构造器时，没有无参构造器，则会抛出下面的异常：

> org.springframework.beans.factory.BeanCreationException: 
>
> Error creating bean with name'helloworld' defined in class path resource [applicationContext.xml]: 
>
> Instantiation of beanfailed; 
>
> nested exception is org.springframework.beans.BeanInstantiationException: 
>
> Failedto instantiate [com.yj.nz.spring.bean.HelloWorld]: 
>
> No default constructor found; 
>
> nestedexception is java.lang.NoSuchMethodException: com.yj.nz.spring.bean.HelloWorld.<init>()

### 4.2.2 实验二：获取bean

#### 	1. 方式一：根据id获取

​			由于 id 属性指定了 bean 的唯一标识，所以根据 bean 标签的 id 属性可以精确获取到一个组件对象，

​			上个实验中本人使用的就是这种方式

#### 	2. 方式二：根据类型获取

```
    @Test
    public void testIOC(){
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //获取bean
        Person person = ioc.getBean(Person.class);
        System.out.println(person);
    }
```

> 当根据类型获取bean时，要求IOC容器中指定类型的bean有且只能有一个
>
> 当IOC容器中一共配置了两个：
>
> ```
> <bean id="helloworldOne" class="com.yj.nz.spring.bean.HelloWorld"></bean>
> <bean id="helloworldTwo" class="com.yj.nz.spring.bean.HelloWorld"></bean>
> ```
>
> 根据类型获取时会抛出异常：
>
> org.springframework.beans.factory.NoUniqueBeanDefinitionException: 
>
> No qualifying bean of type 'com.yj.nz.spring.bean.HelloWorld' available: 
>
> expected single matching bean but found 2: helloworldOne,helloworldTwo
>
> 
>
> 根据类型来获取bean时，在满足bean唯一性的前提下，
>
> 其实只是看：[ 对象 instanceof 指定的类型 ] 的返回结果，只要返回的是true就可以认定为和类型匹配，能够获取到

#### 	3. 方式三：根据id和类型

```
    @Test
    public void testIOC(){
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //获取bean
        Student student = ioc.getBean("studentOne", Student.class);
        System.out.println(student);
    }
```

#### 	4. 查漏补缺

​		如果组件类实现了接口，根据接口类型可以获取 bean 吗？

> 可以，前提是bean唯一

​	如果一个接口有多个实现类，这些实现类都配置了 bean，根据接口类型可以获取 bean 吗？

> 不行，因为bean不唯一

### 4.2.3 实验三：依赖注入之setter注入

#### 	1. 创建学生类Student

```
public class Student implements Person {

    private Integer sid;

    private String sname;

    private Integer age;

    private String gender;

    private Double score;

    private String[] hobby;

    private Clazz clazz;

    private Map<String, Teacher> teacherMap;

    public Student() {
    }

    public Student(Integer sid, String sname, String gender, Double score) {
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
        this.score = score;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", score=" + score +
                ", hobby=" + Arrays.toString(hobby) +
                ", clazz=" + clazz +
                ", teacherMap=" + teacherMap +
                '}';
    }
```

#### 	2. 配置bean时为属性赋值

```
 <bean id="studentTwo" class="com.yj.nz.spring.pojo.Student">
        <!--
            property：通过成员变量的set方法进行赋值
            name：设置需要赋值的属性名（和set方法有关）
            value：设置为属性所赋的值
        -->
        <property name="sid" value="1001"></property>
        <property name="sname" value="张三"></property>
        <property name="age" value="23"></property>
        <property name="gender" value="男"></property>
    </bean>
```

#### 	3. 测试

```
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //获取bean
        Student studentTwo = ioc.getBean("studentTwo", Student.class);
        System.out.println(studentTwo);
```

### 4.2.4 实验四：依赖注入之构造器注入

#### 	1. 在Student类中添加有参构造

```
    public Student(Integer sid, String sname, String gender, Integer age) {
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
        this.age = age;
    }
```

#### 	2. 配置bean

```
    <bean id="studentThree" class="com.yj.nz.spring.pojo.Student">
        <constructor-arg value="1002"></constructor-arg>
        <constructor-arg value="李四"></constructor-arg>
        <constructor-arg value="女"></constructor-arg>
        <constructor-arg value="24" name="age"></constructor-arg>
    </bean>
```

> constructor-arg标签还有两个属性可以进一步描述构造器参数：
>
> ​	index属性：指定参数所在位置的索引（从0开始）
>
> ​	name属性：指定参数名

#### 	3. 测试

```
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //获取bean
        Student studentThree = ioc.getBean("studentThree", Student.class);
        System.out.println(studentThree);
```

### 4.2.5 实验五：特殊值处理

#### 	1. 字面量赋值

> 什么是字面量？
>
> ​	int a = 10;
>
> ​	声明一个变量a，初始化为10，此时a就不代表字母a了，而是作为一个变量的名字。
>
> ​	当我们引用a的时候，我们实际上拿到的值是10。
>
> ​	而如果a是带引号的：'a'，那么它现在不是一个变量，它就是代表a这个字母本身，这就是字面量。
>
> ​	所以字面量没有引申含义，就是我们看到的这个数据本身
>
> ```
> 	<!-- 使用value属性给bean的属性赋值时，Spring会把value属性的值看做字面量 -->
> 	<property name="name" value="张三"/>
> ```

#### 	2. null值

> ```
> 	<property name="name">    
> 		<null />
> 	</property>
> ```
>
> 注意：
>
> ```
> 	<property name="name" value="null"></property>
> ```
>
> 以上写法，为name所赋的值是字符串null

#### 	3. xml实体

```
	<!-- 小于号在XML文档中用来定义标签的开始，不能随便使用 -->
	<!-- 解决方案一：使用XML实体来代替 -->
	<property name="expression" value="a &lt; b"/>
```

#### 	4. CDATA节

```
	<property name="expression">    
		<!-- 解决方案二：使用CDATA节 -->    
		<!-- CDATA中的C代表Character，是文本、字符的含义，CDATA就表示纯文本数据 -->    
		<!-- XML解析器看到CDATA节就知道这里是纯文本，就不会当作XM L标签或属性来解析 -->    
		<!-- 所以CDATA节中写什么符号都随意 -->    
		<value><![CDATA[a < b]]></value>
	</property>
```

### 4.2.6 实验六：为类类型属性赋值

#### 	1. 创建班级类Clazz

```
public class Clazz {

    private Integer cid;

    private String cname;

    @Override
    public String toString() {
        return "Clazz{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", students=" + students +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Clazz() {
    }

    public Clazz(Integer cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }
```

#### 	2. 修改Student类

​		在Student类中添加以下代码：

```
    private Clazz clazz;

	public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }
```

##### 	2.1 方式一：引用外部已声明的bean

​		配置Clazz类型的bean：

```
	<bean id="clazzOne" class="com.yj.nz.spring.bean.Clazz">    
		<property name="cid" value="1111"></property>    
		<property name="cname" value="财源滚滚班"></property>、
	</bean>
```

​		为Student中的clazz属性赋值：

```
	<bean id="studentFour" class="com.yj.nz.spring.bean.Student">    
		<property name="id" value="1004"></property>    
		<property name="name" value="赵六"></property>    
		<property name="age" value="26"></property>    
		<property name="sex" value="女"></property>    
		<!-- ref属性：引用IOC容器中某个bean的id，将所对应的bean为属性赋值 -->    
		<property name="clazz" ref="clazzOne">
		</property>
	</bean>
```

​		错误演示：

```
<bean id="studentFour" class="com.yj.nz.spring.bean.Student">    
	<property name="id" value="1004"></property>    
	<property name="name" value="赵六"></property>    
	<property name="age" value="26"></property>    
	<property name="sex" value="女"></property>    
	<property name="clazz" value="clazzOne"></property>
</bean>
```

> 如果错把ref属性写成了value属性，会抛出异常： 
>
> Caused by: java.lang.IllegalStateException:
>
> Cannot convert value of type 'java.lang.String' to required type'com.yj.nz.spring.bean.Clazz' for property 'clazz': no matching editors or conversionstrategy found
>
> 意思是不能把String类型转换成我们要的Clazz类型，
>
> 说明我们使用value属性时，Spring只把这个属性看做一个普通的字符串，
>
> 不会认为这是一个bean的id，更不会根据它去找到bean来赋值

##### 2.2 方式二：内部bean

```
<bean id="studentFour" class="com.yj.nz.spring.bean.Student">    
	<property name="id" value="1004"></property>    
	<property name="name" value="赵六"></property>    
	<property name="age" value="26"></property>    
	<property name="sex" value="女"></property>    
	<property name="clazz">        
		<!-- 在一个bean中再声明一个bean就是内部bean -->        
		<!-- 内部bean只能用于给属性赋值，不能在外部通过IOC容器获取，因此可以省略id属性 -->        
		<bean id="clazzInner" class="com.yj.nz.spring.bean.Clazz">            
			<property name="cid" value="2222"></property>            
			<property name="cname" value="远大前程班"></property>        
		</bean>    
	</property>
</bean>
```

##### 2.3 方式三：级联属性赋值

```
<bean id="studentFour" class="com.atguigu.spring.bean.Student">    
	<property name="id" value="1004"></property>    
	<property name="name" value="赵六"></property>    
	<property name="age" value="26"></property>    
	<property name="sex" value="女"></property>    
	<!-- 一定先引用某个bean为属性赋值，才可以使用级联方式更新属性 -->    
	<property name="clazz" ref="clazzOne"></property>    
	<property name="clazz.cid" value="3333"></property>    
	<property name="clazz.cname" value="最强王者班">
	</property>
</bean>
```

### 4.2.7 实验七：为数组类型属性赋值

#### 	1. 修改Student类

```
	private String[] hobby;

    public String[] getHobby() {
        return hobby;
    }
    
	public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }
```

#### 	2. 配置bean

```
<bean id="studentFour" class="com.yj.nz.spring.bean.Student">    
	<property name="id" value="1004"></property>    
	<property name="name" value="赵六"></property>    
	<property name="age" value="26"></property>    
	<property name="sex" value="女"></property>    
	<!-- ref属性：引用IOC容器中某个bean的id，将所对应的bean为属性赋值 -->    
	<property name="clazz" ref="clazzOne"></property>    
	<property name="hobby">        
		<array>            
			<value>抽烟</value>            
			<value>喝酒</value>            
			<value>烫头</value>        
		</array>    
	</property>
</bean>
```

### 4.2.8 实验八：为集合类型属性赋值

#### 	1. 为List集合类型属性赋值

##### 		1. 在Clazz类中添加以下代码：

```
private List<Student> students;

public List<Student> getStudents() {    
	return students;
}

public void setStudents(List<Student> students) {    
	this.students = students;
}
```

##### 	2. 配置bean：

```
<bean id="clazzTwo" class="com.yj.nz.spring.bean.Clazz">    
	<property name="clazzId" value="4444"></property>    
	<property name="clazzName" value="Javaee0222"></property>    
	<property name="students">        
		<list>            
			<ref bean="studentOne"></ref>            
			<ref bean="studentTwo"></ref>            
			<ref bean="studentThree"></ref>        
		</list>    
	</property>
</bean>
```

> 若为Set集合类型属性赋值，只需要将其中的list标签改为set标签即可

#### 2. 为Map集合类型属性赋值

##### 		1. 创建教师类Teacher：

```
public class Teacher {

    private Integer tid;

    private String tname;

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                '}';
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Teacher() {
    }

    public Teacher(Integer tid, String tname) {
        this.tid = tid;
        this.tname = tname;
    }
}
```

##### 	2. 在Student类中添加以下代码：

```
private Map<String, Teacher> teacherMap;

public Map<String, Teacher> getTeacherMap() {    
	return teacherMap;
}

public void setTeacherMap(Map<String, Teacher> teacherMap) {    
	this.teacherMap = teacherMap;
}
```

##### 	3. 配置bean：

```
<bean id="teacherOne" class="com.yj.nz.spring.bean.Teacher">    
	<property name="teacherId" value="10010"></property>    
	<property name="teacherName" value="大宝">
	</property></bean><bean id="teacherTwo" class="com.atguigu.spring.bean.Teacher">    
	<property name="teacherId" value="10086"></property>    
	<property name="teacherName" value="二宝"></property>
</bean>

<bean id="studentFour" class="com.yj.nz.spring.bean.Student">    
	<property name="id" value="1004"></property>    
	<property name="name" value="赵六"></property>    
	<property name="age" value="26"></property>    
	<property name="sex" value="女"></property>    
	<!-- ref属性：引用IOC容器中某个bean的id，将所对应的bean为属性赋值 -->    
	<property name="clazz" ref="clazzOne"></property>    
	<property name="hobby">        
		<array>            
			<value>抽烟</value>            
			<value>喝酒</value>            
			<value>烫头</value>        
		</array>    
	</property>    
	<property name="teacherMap">        
		<map>            
			<entry>                
				<key>
				   <value>10010</value>                
				 </key>                
				 <ref bean="teacherOne"></ref>            
			</entry>            
			<entry>                
				<key>                    
					<value>10086</value>                
				</key>                
				<ref bean="teacherTwo"></ref>            
			</entry>        
		</map>    
	</property>
</bean>
```

#### 3. 引用集合类型的bean

```
<!--list集合类型的bean-->
<util:list id="students">    
	<ref bean="studentOne"></ref>    
	<ref bean="studentTwo"></ref>    
	<ref bean="studentThree"></ref>
</util:list>
<!--map集合类型的bean-->
<util:map id="teacherMap">    
	<entry>        
		<key>            
			<value>10010</value>        
		</key>        
		<ref bean="teacherOne"></ref>    
	</entry>    
	<entry>        
		<key>            
			<value>10086</value>        
		</key>        
		<ref bean="teacherTwo"></ref>    
	</entry>
</util:map>

<bean id="clazzTwo" class="com.atguigu.spring.bean.Clazz">    
	<property name="clazzId" value="4444"></property>    
	<property name="clazzName" value="Javaee0222"></property>    
	<property name="students" ref="students"></property>
</bean>

<bean id="studentFour" class="com.atguigu.spring.bean.Student">    
	<property name="id" value="1004"></property>    
	<property name="name" value="赵六"></property>    
	<property name="age" value="26"></property>    
	<property name="sex" value="女"></property>    
	<!-- ref属性：引用IOC容器中某个bean的id，将所对应的bean为属性赋值 -->    
	<property name="clazz" ref="clazzOne"></property>    
	<property name="hobbies">        
		<array>            
			<value>抽烟</value>            
			<value>喝酒</value>            
			<value>烫头</value>        
		</array>    
	</property>    
	<property name="teacherMap" ref="teacherMap"></property>
</bean>
```

> 使用util:list、util:map标签必须引入相应的命名空间，可以通过idea的提示功能选择

###  4.2.9 实验九：p命名空间

​	引入p命名空间后，可以通过以下方式为bean的各个属性赋值

```
<bean id="studentSix" class="com.yj.nz.spring.bean.Student"    
	p:id="1006" p:name="小明" p:clazz-ref="clazzOne" p:teacherMap
	ref="teacherMap">
</bean>
```

### 4.2.10 实验十：引入外部属性文件

#### 	1. 加入依赖

```
        <!-- MySQL驱动 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.16</version>
        </dependency>
        <!-- 数据源 -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.0.31</version>
        </dependency>
```

#### 	2. 创建外部属性文件

![image-20221202224713023](assets\image-20221202224713023.png)

```
jdbc.user=root
jdbc.password=root
jdbc.url=jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC
jdbc.driver=com.mysql.cj.jdbc.Driver
```

#### 3. 引入属性文件

```
<!-- 引入外部属性文件 -->
<context:property-placeholder location="classpath:jdbc.properties"/>
```

#### 4. 配置bean

```
<bean id="druidDataSource" class="com.alibaba.druid.pool.DruidDataSource">    
	<property name="url" value="${jdbc.url}"/>    
	<property name="driverClassName" value="${jdbc.driver}"/>    
	<property name="username" value="${jdbc.user}"/>    
	<property name="password" value="${jdbc.password}"/>
</bean>
```

#### 5. 测试

```
@Test
public void testDataSource() throws SQLException {    
	ApplicationContext ac = new ClassPathXmlApplicationContext("spring-datasource.xml");    
	DataSource dataSource = ac.getBean(DataSource.class);    
	Connection connection = dataSource.getConnection();    
	System.out.println(connection);
}
```

### 4.2.11 实验十一：bean的作用域

#### 1. 概述

​	在Spring中可以通过配置bean标签的scope属性来指定bean的作用域范围，各取值含义参加下表：

| 取值              | 含义                                    | 创建对象的时机  |
| ----------------- | --------------------------------------- | --------------- |
| singleton（默认） | 在IOC容器中，这个bean的对象始终为单实例 | IOC容器初始化时 |
| prototype         | 这个bean在IOC容器中有多个实例           | 获取bean时      |

​	如果是在WebApplicationContext环境下还会有另外两个作用域（但不常用）：

| 取值    | 含义                 |
| ------- | -------------------- |
| request | 在一个请求范围内有效 |
| session | 在一个会话范围内有效 |

#### 2. 创建类User

```
public class User {

    private Integer id;

    private String username;

    private String password;

    private Integer age;

    public User() {
        System.out.println("生命周期1：实例化");
    }

    public User(Integer id, String username, String password, Integer age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        System.out.println("生命周期2：依赖注入");
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }

    public void initMethod(){
        System.out.println("生命周期3：初始化");
    }

    public void destroyMethod(){
        System.out.println("生命周期4：销毁");
    }

}
```

#### 3. 配置bean

```
<!-- scope属性：取值singleton（默认值），bean在IOC容器中只有一个实例，IOC容器初始化时创建对象 -->
<!-- scope属性：取值prototype，bean在IOC容器中可以有多个实例，getBean()时创建对象 -->
<bean class="com.yj.nz.bean.User" scope="prototype"></bean>
```

#### 4. 测试

```
@Test
public void testBeanScope(){    
	ApplicationContext ac = new ClassPathXmlApplicationContext("spring-scope.xml");    
	User user1 = ac.getBean(User.class);    
	User user2 = ac.getBean(User.class);    
	System.out.println(user1==user2);
}
```

### 4.2.12 实验十二：bean的生命周期

#### 	1. 具体的生命周期过程

> ​		1. bean对象创建（调用无参构造器）
>
> ​		2. 给bean对象设置属性
>
> ​		3. bean对象初始化之前操作（由bean的后置处理器负责）
>
> ​		4. bean对象初始化（需在配置bean时指定初始化方法）
>
> ​		5. bean对象初始化之后操作（由bean的后置处理器负责）
>
> ​		6. bean对象就绪可以使用
>
> ​		7. bean对象销毁（需在配置bean时指定销毁方法）
>
> ​		8. IOC容器关闭

#### 2. 修改类User

​		添加如下初始化和销毁方法：

```
    public void initMethod(){
        System.out.println("生命周期3：初始化");
    }

    public void destroyMethod(){
        System.out.println("生命周期4：销毁");
    }
```

> 注意其中的initMethod()和destroyMethod()，可以通过配置bean指定为初始化和销毁的方法

#### 3. 配置bean

```
<!-- 使用init-method属性指定初始化方法 -->
<!-- 使用destroy-method属性指定销毁方法 -->
<bean class="com.atguigu.bean.User" scope="prototype" init-method="initMethod" destroy-
method="destroyMethod">    
	<property name="id" value="1001"></property>    
	<property name="username" value="admin"></property>    
	<property name="password" value="123456"></property>    
	<property name="age" value="23"></property>
</bean>
```

#### 4. 测试

```
@Test
public void testLife(){    
	ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-lifecycle.xml");    
	User bean = ac.getBean(User.class);    
	System.out.println("生命周期：4、通过IOC容器获取bean并使用");    
	ac.close();
}
```

#### 5. bean的后置处理器

​	bean的后置处理器会在生命周期的初始化前后添加额外的操作，需要实现BeanPostProcessor接口，且配置到IOC容器中，

​	需要注意的是，bean后置处理器不是单独针对某一个bean生效，而是针对IOC容器中所有bean都会执行创建

​	bean的后置处理器：

```
package com.yj.nz.spring.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //此方法在bean的生命周期初始化之前执行
        System.out.println("MyBeanPostProcessor-->后置处理器postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //此方法在bean的生命周期初始化之后执行
        System.out.println("MyBeanPostProcessor-->后置处理器postProcessAfterInitialization");
        return bean;
    }
}
```

在IOC容器中配置后置处理器：

```
<!-- bean的后置处理器要放入IOC容器才能生效 -->
<bean id="myBeanProcessor" class="com.yj.nz.spring.process.MyBeanProcessor"/>
```

### 4.2.13 实验十三：FactoryBean

#### 	1. 概述

​			FactoryBean是Spring提供的一种整合第三方框架的常用机制。

​			和普通的bean不同，配置一个FactoryBean类型的bean，

​			在获取bean的时候得到的并不是class属性中配置的这个类的对象，而是getObject()方法的返回值。

​			通过这种机制，Spring可以帮我们把复杂组件创建的详细过程和繁琐细节都屏蔽起来，只把最简洁的使用界面展示给我们。

​			将来我们整合Mybatis时，Spring就是通过FactoryBean机制来帮我们创建SqlSessionFactory对象的。

#### 	2. 创建类UserFactoryBean

```
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
```

#### 3. 配置bean

```
<bean id="user" class="com.yj.nz.bean.UserFactoryBean"></bean>
```

#### 4. 测试

```
@Testpublic void testUserFactoryBean(){    
	//获取IOC容器    
	ApplicationContext ac = new ClassPathXmlApplicationContext("spring-factorybean.xml");   
	User user = (User) ac.getBean("user");    
	System.out.println(user);
}
```

### 4.2.14 实验十四：基于xml的自动装配

> 自动装配：
>
> 根据指定的策略，在IOC容器中匹配某一个bean，自动为指定的bean中所依赖的类类型或接口类型属性赋值

#### 	1. 场景模拟

##### 		1. 创建类UserController

```
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void saveUser(){
        userService.saveUser();
    }
```

##### 		2.创建接口UserService

```
public interface UserService {

    /**
     * 保存用户信息
     */
    void saveUser();
}

```

##### 		3. 创建类UserServiceImpl实现接口UserService

```
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}

```

##### 		4. 创建接口UserDao

```
public interface UserDao {

    /**
     * 保存用户信息
     */
    void saveUser();
}

```

##### 		5. 创建类UserDaoImpl实现接口UserDao

```
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
```

#### 	2. 配置bean

使用bean标签的autowire属性设置自动装配效果

自动装配方式：byType

​	byType：根据类型匹配IOC容器中的某个兼容类型的bean，为属性自动赋值

若在IOC中，没有任何一个兼容类型的bean能够为属性赋值，则该属性不装配，即值为默认值null

若在IOC中，有多个兼容类型的bean能够为属性赋值，则抛出异常NoUniqueBeanDefinitionException

```
<bean id="userController" 
	class="com.yj.nz.autowire.xml.controller.UserController" autowire="byType">
</bean>

<bean id="userService" 
	class="com.yj.nz.autowire.xml.service.impl.UserServiceImpl" autowire="byType">
</bean>

<bean id="userDao" class="com.yj.nz.autowire.xml.dao.impl.UserDaoImpl"></bean>
```

自动装配方式：byName

​	byName：将自动装配的属性的属性名，作为bean的id在IOC容器中匹配相对应的bean进行赋值

```
<bean id="userController" 
	class="com.yj.nz.autowire.xml.controller.UserController" autowire="byName">
</bean>

<bean id="userService" 
	class="com.yj.nz.autowire.xml.service.impl.UserServiceImpl" autowire="byName">
</bean>

<bean id="userServiceImpl" 
	class="com.yj.nz.autowire.xml.service.impl.UserServiceImpl" autowire="byName">
</bean>

<bean id="userDao" 
	class="com.yj.nz.autowire.xml.dao.impl.UserDaoImpl">
</bean>

<bean id="userDaoImpl" 
	class="com.yj.nz.autowire.xml.dao.impl.UserDaoImpl">
</bean>
```

#### 3. 测试

```
@Test
public void testAutoWireByXML(){    
	ApplicationContext ac = new ClassPathXmlApplicationContext("autowire-xml.xml");
	UserController userController = ac.getBean(UserController.class);    
	userController.saveUser();
}
```

## 4.3 基于注解管理bean

### 4.3.1 实验一：标记与扫描

#### 1. 注解

​	和 XML 配置文件一样，注解本身并不能执行，注解本身仅仅只是做一个标记，

​	具体的功能是框架检测到注解标记的位置，然后针对这个位置按照注解标记的功能来执行具体操作

​	本质上：所有一切的操作都是Java代码来完成的，XML和注解只是告诉框架中的Java代码如何执行

​	举例：元旦联欢会要布置教室，蓝色的地方贴上元旦快乐四个字，红色的地方贴上拉花，黄色的地方贴上气球

![image-20221203123320360](assets\image-20221203123320360.png)

​		班长做了所有标记，同学们来完成具体工作。墙上的标记相当于我们在代码中使用的注解，

​		后面同学们做的工作，相当于框架的具体操作

#### 	2. 扫描

​		Spring 为了知道程序员在哪些地方标记了什么注解，就需要通过扫描的方式，来进行检测，

​		然后根据注解进行后续操作

#### 	3. 新建Maven Module

```
    <dependencies>
        <!-- 基于Maven依赖传递性，导入spring-context依赖即可导入当前所需所有jar包 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.3.1</version>
        </dependency>
        <!-- junit测试 -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
```

#### 4. 创建Spring配置文件

![image-20221203123730376](assets\image-20221203123730376.png)

#### 5. 标识组件的常用注解

@Component：将类标识为普通组件 

@Controller：将类标识为控制层组件 

@Service：将类标识为业务层组件 

@Repository：将类标识为持久层组件

问：以上四个注解有什么关系和区别？

![image-20221203123901171](assets\image-20221203123901171.png)

通过查看源码我们得知，@Controller、@Service、@Repository这三个注解只是在@Component注解的基础上起了三个新的名字

对于Spring使用IOC容器管理这些组件来说没有区别

所以@Controller、@Service、@Repository这三个注解只是给开发人员看的，让我们能够便于分辨组件的作用

注意：虽然它们本质上一样，但是为了代码的可读性，为了程序结构严谨我们肯定不能随便胡乱标记

#### 6. 创建组件

##### 	1. 创建控制层组件

```
@Controller
public class UserController {    

}
```

##### 	2. 创建接口UserService

```
public interface UserService {    

}
```

##### 	3. 创建业务层组件UserServiceImpl

```
@Service
public class UserServiceImpl implements UserService {    

}
```

##### 	4. 创建接口UserDao

```
public interface UserDao {

}
```

##### 	5.  创建持久层组件UserDaoImpl

```
@Repository
public class UserDaoImpl implements UserDao {

}
```

#### 7 . 扫描组件

##### 	1. 情况一：最基本的扫描方式

```
<context:component-scan base-package="com.yj.nz"></context:component-scan>
```

##### 	2. 情况二：指定要排除的组件

```
<context:component-scan base-package="com.yj.nz">    
	<!-- context:exclude-filter标签：指定排除规则 -->    
	<!--  
		type：设置排除或包含的依据 
		type="annotation"，根据注解排除，expression中设置要排除的注解的全类名 
		type="assignable"，根据类型排除，expression中设置要排除的类型的全类名 
	-->    
	<context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
		<!--<context:exclude-filter type="assignable" expression="com.yj.nz.controller.UserController"/>-->
</context:component-scan>
```

##### 	3. 情况三：仅扫描指定组件

```
<context:component-scan base-package="com.yj.nz" use-default-filters="false">    
	<!-- context:include-filter标签：指定在原有扫描规则的基础上追加的规则 -->    
	<!-- use-default-filters属性：取值false表示关闭默认扫描规则 -->    
	<!-- 此时必须设置use-default-filters="false"，因为默认规则即扫描指定包下所有类 -->    
	<!--  
		type：设置排除或包含的依据 
		type="annotation"，根据注解包含，expression中设置要包含的注解的全类名 
		type="assignable"，根据类型包含，expression中设置要包含的类型的全类名 
	-->    
	<context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/> 
	<!--<context:include-filter type="assignable" expression="com.yj.nz.controller.UserController"/>--></context:component-scan>
```

#### 8. 测试

```
@Test
public void testAutowireByAnnotation(){    
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");    
	UserController userController = ac.getBean(UserController.class);    
	System.out.println(userController);    
	UserService userService = ac.getBean(UserService.class);    
	System.out.println(userService);    
	UserDao userDao = ac.getBean(UserDao.class);    
	System.out.println(userDao);
}
```

#### 9. 组件所对应的bean的id

​	在我们使用XML方式管理bean的时候，每个bean都有一个唯一标识，便于在其他地方引用。

​	现在使用注解后，每个组件仍然应该有一个唯一标识。

**默认情况**

​	类名首字母小写就是bean的id。例如：UserController类对应的bean的id就是userController

**自定义bean的id**

​	可通过标识组件的注解的value属性设置自定义的bean的id

​	@Service("userService") // 默认为userServiceImpl 

​	public class UserServiceImpl implementsUserService {}

### 4.3.2 实验二：基于注解的自动装配

#### 1. 场景模拟

参考基于xml的自动装配

在UserController中声明UserService对象

在UserServiceImpl中声明UserDao对象

#### 2. @Autowired注解

​	在成员变量上直接标记@Autowired注解即可完成自动装配，不需要提供setXxx()方法

​	以后我们在项目中的正式用法就是这样

```
@Controller
public class UserController {    

	@Autowired    
	private UserService userService;    
	
	public void saveUser(){        
		userService.saveUser();   
	}
	
}
```

```
public interface UserService {    
	void saveUser();
}
```

```
@Service
public class UserServiceImpl implements UserService {    
	
	@Autowired    
	private UserDao userDao;    
	
	@Override    
	public void saveUser() {        
		userDao.saveUser();   
	}
	
}
```

```
public interface UserDao {    
	void saveUser();
}
```

```
@Repository
public class UserDaoImpl implements UserDao {    

	@Override    
	public void saveUser() {        
		System.out.println("保存成功");   
	}
	
}
```

#### 3. @Autowired注解其他细节

@Autowired注解可以标记在构造器和set方法上

```
@Controller
public class UserController {    

	private UserService userService;        
	
	@Autowired    
	public UserController(UserService userService){        
		this.userService = userService;   
	}    

	public void saveUser(){        
		userService.saveUser();   
	}
	
}
```

```
@Controller
public class UserController {    
	
	private UserService userService;        
	
	@Autowired    
	public void setUserService(UserService userService){        
		this.userService = userService;   
	}    
	
	public void saveUser(){
		userService.saveUser();   
	}
	
}
```

#### 4. @Autowired工作流程

![image-20221203130850464](assets\image-20221203130850464.png)

​	首先根据所需要的组件类型到IOC容器中查找

- 能够找到唯一的bean：直接执行装配

- 如果完全找不到匹配这个类型的bean：装配失败

- 和所需类型匹配的bean不止一个

  - 没有@Qualifier注解：根据@Autowired标记位置成员变量的变量名作为bean的id进行匹配

    - 能够找到：执行装配

    - 找不到：装配失败

  - 使用@Qualifier注解：根据@Qualifier注解中指定的名称作为bean的id进行匹配

    - 能够找到：执行装配

    - 找不到：装配失败

```
@Controller
public class UserController {    
	
	@Autowired    
	@Qualifier("userServiceImpl")    
	private UserService userService;    
	
	public void saveUser(){        
		userService.saveUser();   
	}
	
}
```

@Autowired中有属性required，默认值为true，因此在自动装配无法找到相应的bean时，会装配失败

此时抛出异常：NoSuchBeanDefinitionException

可以将属性required的值设置为false，则表示能装就装，装不上就不装，此时自动装配的属性为默认值

但是实际开发时，基本上所有需要装配组件的地方都是必须装配的，用不上这个属性
