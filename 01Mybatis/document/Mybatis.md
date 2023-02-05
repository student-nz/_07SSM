# SSM

# 

# 1. 什么是框架？

​	框架( Framework  )是构成一类特定软件可复用设计的一组相互协作的类，框架规定了你的应用的体系结构。

​	它定义了整体结构，类和对象的分割，各部分的主要责任，类和对象怎么协作，以及控制流程。

​	框架预定义了这些设计参数，以便于应用设计者或实现者能集中精力于应用本身的特定细节

​	摘自：https://baike.baidu.com/item/%E6%A1%86%E6%9E%B6/1212667?fr=aladdin

# 2. 为什么使用框架

- ​	因为软件系统发展到今天已经很复杂了，特别是服务器端软件，涉及到的知识，内容，问题太多

  ​	在某些方面使用别人成熟的框架，就相当于让别人帮你完成一些基础工作，你只需要集中精力完成系统的业务逻辑设计

- ​    而且框架一般是成熟，稳健的，它可以处理系统很多细节问题，比如，事务处理，安全性，数据流控制等问题

- ​    还有框架一般都经过很多人使用，所以结构很好，所以扩展性也很好，而且它是不断升级的，

  ​	你可以直接享受别人升级代码带来的好处

# 3. 软件开发的三层结构

​		我们用三层结构主要是使项目结构更清楚，分工更明确，有利于后期的维护和升级

​		三层结构包含：表现层，业务层，持久层（前面MVC和三层架构，本人有所概述）

![image-20221128225759407](assets\image-20221128225759407.png)



# 

# 持久化层之Mybatis框架

# 1. Mybatis历史

​	**MyBatis**最初是**Apache**的一个开源项目**iBatis**, 2010年6月这个项目由**Apache Software Foundation**迁移到了**Google Code**。

​	随着开发团队转投**Google Code**旗下，**iBatis3.x**正式更名为**MyBatis**。代码于2013年11月迁移到**Github**。

​	**iBatis**一词来源于**“internet”**和**“abatis”**的组合，是一个基于Java的**持久层框架**

​	 **iBatis**提供的**持久层框架**包括**SQL Maps**和**Data Access Objects（DAO）**

# 2. MyBatis特性

- MyBatis 是一款优秀的持久层框架，它支持自定义 SQL、存储过程以及高级映射


- MyBatis 避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集


- MyBatis可以使用简单的XML或注解用于配置和原始映射，


- 将接口和Java的POJO（Plain Old JavaObjects，普通的Java对象）映射成数据库中的记录


- ​	MyBatis 是一个 半自动的ORM（Object Relation Mapping）框架

  - ​	**全自动化和半自动的ORM框架区别以及举例？**


​				Hibernate属于全自动 ORM 映射工具，使用 Hibernate 查询关联对象或者关联集合对象时，

​				可以根据对象关系模型直接获取，所以它是全自动的，

​				而 Mybatis 在查询关联对象或关联集合对象时，需要手动编写 sql 来完成，所以，称之为半自动 ORM 映射工具

- **本人摘自百度：**

​		虽然本人没学习过Hibernate，但是本人**逆向思维可猜测：**

​			全自动化就是完全自动化，不需要自己手写SQL，也就是说查询关联对象或者关联集合对象时，只需要根据对象关系模型获取

​			半自动化意味着除了写查询关联对象或关联集合对象外，还需自己动手写SQL，

​			然后本人想到以前学过的 JDBC 不也是跟 Mybatis 一样是手写 SQL？

- **为什么不采用JDBC去操作呢？**
  - **原因很简单：**

​				首先，本人从刚入SSM开始就介绍了什么是框架，既然框架都是已经为我们封装好的工具，难道还需要自己再次封装一次？

​				二次封装也不是不行，但是代价和精力耗费巨大，而且你也不能保证你设计的框架就比市场推出的框架优秀，

​				**得出结论：**

​					Mybatis为例：Mybatis是基于JDBC封装而来，采用了各种设计模式以及考虑了各种情况，何乐而不为，难道还用JDBC？

​					当然某些公司需要手动封装或某些需求框架实现不了，这时候，迫不得己，你就可以基于底层 JDBC 封装属于自己的工具类！

​				**设计封装框架前言？**

​					我们都清楚学习框架容易，但是要理解框架设计思想却困难，

​					因为设计框架不仅要考虑一个程序员技术水平，而且还要考虑框架的可扩展性、可维护性、高内聚、低耦合等特性，

​					要想设计框架，技术水平也是一个非常大的一个问题，

​					例如：JavaSE你很熟悉？数据库你很熟悉？JDBC你很熟悉？Web核心技术你很熟悉？

​					由此可见，设计框架，技术上就绝对压死一片人，别说技术连贯使用的思想了！

​				**那我们到底该如何设计框架呢？**

​					**本人理解：**

​						若想设计一款框架，那你首先必须需要学会使用框架，学会使用框架后，还需要解读框架的源代码从中获取设计思想，

​						从框架源代码中获取思想后，你还需要简单模拟手写这款框架！

​						**例如：**

​							你想设计一款框架干掉Mybatis，那你肯定要设计的这款框架要比Mybatis更优秀才行！

​						**知道为什么框架应用容易，要学会设计思想却难？**

​							首先框架是封装好的工具，用别人的东西，那肯定容易，遵守规则就行，

​							但是要你学会框架设计思想呢，你就需要阅读源代码和模拟别人如何去封装，、

​							这就需要考虑技术储备，那肯定就难了！

​				**ORM又是什么？**

​					对象-关系映射（OBJECT/RELATIONALMAPPING，简称ORM），

​					用来把对象模型表示的对象映射到基于SQL 的关系模型数据库结构中去

​					这样，我们在具体的操作实体对象的时候，就不需要再去和复杂的 SQL 语句打交道，只需简单的操作实体对象的属性和方法

 					ORM 技术是在对象和关系之间提供了一条桥梁，前台的对象型数据和数据库中的关系型的数据通过这个桥梁来相互转化

- **ORM框架和MyBatis的区别**

| 对比项       | Mybatis                | Hibernate              |
| ------------ | ---------------------- | ---------------------- |
| 市场占有率   | 高                     | 高                     |
| 适合的行业   | 互联网 电商 项目       | 传统的(ERP CRM OA)     |
| 性能         | 高                     | 低                     |
| Sql灵活性    | 高                     | 低                     |
| 学习门槛     | 低                     | 高                     |
| Sql配置文件  | 全局配置文件、映射文件 | 全局配置文件、映射文件 |
| ORM          | 半自动化               | 完全的自动化           |
| 数据库无关性 | 低                     | 高                     |

# 3. Mybatis下载

​	Mybatis官网：https://mybatis.org/mybatis-3/

​	Mybatis中文官网：http://www.mybatis.org/mybatis-3/zh/index.html

​	Github源码地址：https://github.com/mybatis/mybatis-3

![image-20221127205318257](assets\image-20221127205318257.png)

![image-20221127205518719](assets\image-20221127205518719.png)

# 4. 和其它持久化层技术对比

## 4.1 JDBC

- SQL 夹杂在Java代码中耦合度高，导致硬编码内伤


- 维护不易且实际开发需求中 SQL 有变化，频繁修改的情况多见


- 代码冗长，开发效率低


## 4.2 Hibernate 和 JPA

- 操作简便，开发效率高


- 程序中的长难复杂 SQL 需要绕过框架


- 内部自动生产的 SQL，不容易做特殊优化


- 基于全映射的全自动框架，大量字段的 POJO 进行部分映射时比较困难


- 反射操作太多，导致数据库性能下降


## 4.3 MyBatis

- 轻量级，性能出色


- SQL 和 Java 编码分开，功能边界清晰，Java代码专注业务、SQL语句专注数据


- 开发效率稍逊于HIbernate，但是完全能够接受

## 4.4 ORM框架和MyBatis的区别

| 对比项       | Mybatis                | Hibernate              |
| ------------ | ---------------------- | ---------------------- |
| 市场占有率   | 高                     | 高                     |
| 适合的行业   | 互联网 电商 项目       | 传统的(ERP CRM OA)     |
| 性能         | 高                     | 低                     |
| Sql灵活性    | 高                     | 低                     |
| 学习门槛     | 低                     | 高                     |
| Sql配置文件  | 全局配置文件、映射文件 | 全局配置文件、映射文件 |
| ORM          | 半自动化               | 完全的自动化           |
| 数据库无关性 | 低                     | 高                     |

# 5. 搭建MyBatis

​			https://mybatis.org/mybatis-3/zh/getting-started.html

## 5.1 开发环境

- IDE：idea 2021

- 构建工具：apache-maven-3.6.1

- MySQL版本：MySQL 8

- MyBatis版本：MyBatis 3.5.11

- 数据库客户端工具：Navicat Premium 16


- MySQL不同版本的注意事项

  - 驱动类driver-class-name

    - MySQL 5版本使用jdbc5驱动，驱动类使用：com.mysql.jdbc.Driver


    - MySQL 8版本使用jdbc8驱动，驱动类使用：com.mysql.cj.jdbc.Driver

  - 连接地址url

    - MySQL 5 版本的 url：jdbc:mysql://localhost:3306/ssm


  - MySQL 8 版本的 url：jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC

    - 否则运行测试用例报告如下错误：（因为更高 MySQL版本 之后要加时区，设置表）

      - java.sql.SQLException: The server time zone value 'ÖÐ¹ú±ê×¼Ê±¼ä' is unrecognized orrepresents more

## 5.2 创建maven工程

​	**1. 打包方式：jar**

​	**2. 引入依赖**

```
 <dependencies>
        <!-- Mybatis核心 -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.7</version>
        </dependency>

        <!-- junit测试 -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>

        <!-- MySQL驱动 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.16</version>
        </dependency>

        <!-- log4j日志 -->
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
    </dependencies>
```

## 	5.3 创建数据库表

​	![image-20221128231520033](assets\image-20221128231520033.png)

![image-20221129222836217](assets\image-20221129222836217.png)

## 5.4 创建实体类 User

## 5.5 创建MyBatis的核心配置文件

- 创建核心配置文件mybatis-config.xml（习惯上命名mybatis-config.xml，并不一定是mybatis-config.xml命名）

- 将来整合Spring之后，这个配置文件可以省略，

- 核心配置文件主要用于配置连接数据库的环境以及MyBatis的全局配置信息

- 核心配置文件存放的位置是src/main/resources目录下

![image-20221128232940444](assets\image-20221128232940444.png)

中文官网复制粘贴以上代码进行修改：

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
"https://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

	<!--设置连接数据库的环境-->
	<environments default="development">
 	<environment id="development">
   		<transactionManager type="JDBC"/>
   		<dataSource type="POOLED">
     		<property name="driver" value="com.mysql.cj.jdbc.Driver"/>
     		<property name="url" value="jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC"/>
     		<property name="username" value="root"/>
     		<property name="password" value="root"/>
   		</dataSource>
 	</environment>
	</environments>

	<!--引入mybatis的映射文件-->
	<mappers>
 	<mapper resource="mappers/UserMapper.xml"/>
	</mappers>
</configuration>
```

## 5.6 创建mapper接口

​	MyBatis中的mapper接口相当于以前的dao，但是区别在于，mapper仅仅是接口，我们不需要提供实现类

## 5.7 创建MyBatis的映射文件

相关概念：ORM（Object Relationship Mapping）对象关系映射

- 对象：Java的实体类对象
- 关系：关系型数据库
- 映射：二者之间的对应关系

| Java概念 | 数据库概念 |
| -------- | ---------- |
| 类       | 表         |
| 属性     | 字段/列    |
| 对象     | 记录/行    |

- 映射文件的命名规则：

​		表所对应的实体类的类名+Mapper.xml	

​		例如：

​				表t_user，映射的实体类为User，所对应的映射文件为UserMapper.xml

​				因此一个映射文件对应一个实体类，对应一张表的操作

​				MyBatis映射文件用于编写SQL，访问以及操作表中的数据

​				MyBatis映射文件存放的位置是src/main/resources/mappers目录下

- MyBatis中可以面向接口操作数据，要保证两个一致：

​		a>  mapper接口的全类名和映射文件的命名空间（namespace）保持一致

​		b>  mapper接口中方法的方法名和映射文件中编写SQL的标签的id属性保持一致

## 5.8 创建sqlSessionUtil

```
            //读取MyBatis的核心配置文件
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //创建SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            //通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            //创建SqlSession对象，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
            //SqlSession sqlSession = sqlSessionFactory.openSession();
            //创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
            sqlSession = sqlSessionFactory.openSession(true);
```

​	SqlSession：代表Java程序和数据库之间的会话（HttpSession是Java程序和浏览器之间的会话）

​	SqlSessionFactory：是“生产”SqlSession的“工厂”

​	工厂模式：

​			如果创建某一个对象，使用的过程基本固定，那么我们就可以把创建这个对象的相关代码封装到一个“工厂类”中，

​			以后都使用这个工厂类来“生产”我们需要的对象

## 5.9 通过junit测试功能

**1. 加入依赖**

```
        <!-- junit测试 -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
```

## 5.9 加入log4j日志功能

- **1. 加入依赖**

```
        <!-- log4j日志 -->
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
```

- **2. 加入log4j的配置文件**

log4j的配置文件名为log4j.xml，存放的位置是src/main/resources目录下

日志的级别：

FATAL(致命)>ERROR(错误)>WARN(警告)>INFO(信息)>DEBUG(调试)

从左到右打印的内容越来越详细

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE log4j:configuration SYSTEM "log4j.dtd">

<log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">

 <appender name="STDOUT" class="org.apache.log4j.ConsoleAppender">
     <param name="Encoding" value="UTF-8" />
     <layout class="org.apache.log4j.PatternLayout">
         <param name="ConversionPattern" value="%-5p %d{MM-dd HH:mm:ss,SSS} %m  (%F:%L) \n" />
     </layout>
 </appender>
 <logger name="java.sql">
     <level value="debug" />
 </logger>
 <logger name="org.apache.ibatis">
     <level value="info" />
 </logger>
 <root>
     <level value="debug" />
     <appender-ref ref="STDOUT" />
 </root>
</log4j:configuration>
```

# 6. 核心配置文件详解

​	https://mybatis.org/mybatis-3/zh/configuration.html

​	**核心配置文件中的标签必须按照固定的顺序：**

properties?,settings?,typeAliases?,typeHandlers?,objectFactory?,objectWrapperFactory?,reflectorFactory?,plugins?,environments?,databaseIdProvider?,mappers?

## 6.1 属性 properties

​		https://mybatis.org/mybatis-3/zh/configuration.html#properties

​		这些属性可以在外部进行配置，并可以进行动态替换，也可以在 properties 元素的子元素中设置！

- **配置加载顺序，官网参考**

  - 方法参数传递的属性具有最高优先级，

  - resource/url  属性中指定的配置文件次之，

  - 最低优先级的则是 properties 元素中指定的属性

​	也就是说：

- 先读取在 properties 元素体内指定的属性，

- 然后根据 properties 元素中的 resource 属性读取类路径下属性文件，

​		或根据 url 属性指定的路径读取属性文件，并覆盖之前读取过的同名属性

- 最后读取作为方法参数传递的属性，并覆盖之前读取过的同名属性

- **MyBatis 3.4.2 起，可以为占位符指定一个默认值，官网参考：**

  - 该特性默认是关闭的，启用这个特性，需要添加一个特定的属性来开启这个特性

  - 修改分隔属性名和默认值的字符

  - 若属性名使用了`“:”` 字符，或者在 SQL 映射中使用了 OGNL 表达式的三元运算符，

​				需设置特定的属性来修改分隔属性名和默认值的字符！

## 6.2 设置 settings

​	https://mybatis.org/mybatis-3/zh/configuration.html#settings

​	MyBatis 中极为重要的调整设置，它们会改变 MyBatis 的运行时行为		

​	各项设置的含义、默认值：官网参考！

## 6.3 类型别名（typeAliases）

​	https://mybatis.org/mybatis-3/zh/configuration.html#typeAliases

​	类型别名可为 Java 类型设置一个缩写名字，仅用于 XML 配置，意在降低冗余的全限定类名书写

​	**抽取官网例子，如下设置别名：**

​	<typeAlias alias="Blog" type="domain.blog.Blog"/>

- 当这样配置时，`Blog` 可以用在任何使用 `domain.blog.Blog` 的地方

- 也可以指定一个包名，MyBatis 会在包名下面搜索需要的 Java Bean

​		<package name="domain.blog"/>

- 每一个在包 `domain.blog` 中的 Java Bean，

​		在没有注解的情况下，会使用 Bean 的首字母小写的非限定类名来作为它的别名，

​		比如 `domain.blog.Author` 的别名为 `author`

- 若有注解，则别名为其注解值

​		@Alias("author")

- **内建的类型别名：**

​			常见的 Java 类型内建的类型别名，它们都是不区分大小写的，为了应对原始类型的命名重复，采取了特殊的命名风格！

## 6.4 类型处理器（typeHandlers）

​		https://mybatis.org/mybatis-3/zh/configuration.html#typeHandlers

- MyBatis 在设置预处理语句（PreparedStatement）中的参数或从结果集中取出一个值时，

​		都会用类型处理器将获取到的值以合适的方式转换成 Java 类型，官网提供了一些默认的类型处理器，

​		官网参考：从 3.4.5 开始，MyBatis 默认支持 JSR-310（日期和时间 API）

​		JSR参考：https://baike.baidu.com/item/jsr/4388424

- 以重写已有的类型处理器或创建自己的类型处理器来处理不支持的或非标准的类型

​		具体做法为：

​			实现 `org.apache.ibatis.type.TypeHandler` 接口，或继承一个很便利的类 `org.apache.ibatis.type.BaseTypeHandler`，

​			并且可以（可选地）将它映射到一个 JDBC 类型						

## 6.5 对象工厂（objectFactory）

​	https://mybatis.org/mybatis-3/zh/configuration.html#objectFactory

- 每次 MyBatis 创建结果对象的新实例时，它都会使用一个对象工厂（ObjectFactory）实例来完成实例化工作

- 默认的对象工厂需要做的仅仅是实例化目标类，要么通过默认无参构造方法，要么通过存在的参数映射来调用带有参数的构造方法

- 如果想覆盖对象工厂的默认行为，可以通过创建自己的对象工厂来实现

## 6.6 插件（plugins）

​	https://mybatis.org/mybatis-3/zh/configuration.html#plugins

## 6.7 环境配置（environments）

​	https://mybatis.org/mybatis-3/zh/configuration.html#environments

## 6.8 数据库厂商标识（databaseIdProvider）

​	https://mybatis.org/mybatis-3/zh/configuration.html#databaseIdProvider

## 6.9 映射器（mappers）

​	https://mybatis.org/mybatis-3/zh/configuration.html#mappers

# 7. MyBatis的增删改查

​	https://mybatis.org/mybatis-3/zh/sqlmap-xml.html

## 7.1 新增

```
<!--int insertUser();--> 
<insert id="insertUser">    
	insert into t_user values(null,'admin','123456',23,'男') 
</insert>
```

## 7.2 删除

```
<!--int deleteUser();--> 
<delete id="deleteUser">    
	delete from t_user where id = 7 
</delete>
```

## 7.3 修改

```
<!--int updateUser();--> 
<update id="updateUser">  
	update t_user set username='ybc',password='123' where id = 6 
</update>
```

## 7.4 查询一个实体类对象

```
<!--User getUserById();--> 
<select id="getUserById" resultType="com.atguigu.mybatis.bean.User">    
	select * from t_user where id = 2 
</select>
```

## 7.5 查询list集合

```
<!--List<User> getUserList();--> 
<select id="getUserList" resultType="com.atguigu.mybatis.bean.User">
	select * from t_user
</select>
```

**注意：**

- 查询的标签select必须设置属性resultType或resultMap，用于设置实体类和数据库表的映射关系

  - resultType：自动映射，用于属性名和表中字段名一致的情况


  - resultMap：自定义映射，用于一对多或多对一或字段名和属性名不一致的情况

# 8. MyBatis获取参数值的两种方式

​	MyBatis获取参数值的两种方式：${}和#{}

- ${}的本质就是字符串拼接，#{}的本质就是占位符赋值

- ${}使用字符串拼接的方式拼接sql，若为字符串类型或日期类型的字段进行赋值时，需要手动加单引号；

- 但是#{}使用占位符赋值的方式拼接sql，此时为字符串类型或日期类型的字段进行赋值时，可以自动添加单引号

## 8.1 单个字面量类型的参数

- 若mapper接口中的方法参数为单个的字面量类型

- 此时可以使用${}和#{}以任意的名称获取参数的值，

  **注意：${}需要手动加单引号**

## 8.2 多个字面量类型的参数

​	若mapper接口中的方法参数为多个时，此时MyBatis会自动将这些参数放在一个map集合中，

​	以arg0,arg1...为键，以参数为值；以param1,param2...为键，以参数为值；

​	因此只需要通过${}和#{}访问map集合的键就可以获取相对应的值

​	**注意：**${}需要手动加单引号

## 8.3 map集合类型的参数

​	若mapper接口中的方法需要的参数为多个时，此时可以手动创建map集合，将这些数据放在map中

​	只需要通过${}和#{}访问map集合的键就可以获取相对应的值

​	**注意：**${}需要手动加单引号

## 8.4 实体类类型的参数

​	若mapper接口中的方法参数为实体类对象时

​	此时可以使用${}和#{}，通过访问实体类对象中的属性名获取属性值

​	**注意：**${}需要手动加单引号

## 8.5 使用@Param标识参数

​	可以通过@Param注解标识mapper接口中的方法参数，

​	此时，会将这些参数放在map集合中，以@Param注解的value属性值为键，以参数为值；

​	以param1,param2...为键，以参数为值；

​	只需要通过${}和#{}访问map集合的键就可以获取相对应的值，

​	**注意：${}需要手动加单引号**

## 8.6 综合所述

​		${}都提到过要加单引号，可以回顾 JDBC 的 Statement 和 PreparedStatement 的定义方式！（Mybatis底层就是基于JDBC封装）

# 9. MyBatis的各种查询功能

## 9.1 查询一个实体类对象

```
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User getUserById(@Param("id") Integer id);
```

```
    <!--User getUserById(@Param("id") Integer id);-->
    <select id="getUserById" resultType="User">
        select * from t_user where id = #{id}
    </select>
```

## 9.2 查询一个list集合

```
    /**
     * 查询所有的用户信息
     * @return
     */
    List<User> getAllUser();
```

```
    <!--List<User> getAllUser();-->
    <select id="getAllUser" resultType="User">
        select * from t_user
    </select>
```

> 当查询的数据为多条时，用集合作为返回值，不能使用实体类作为返回值，否则会抛出异常
>
> TooManyResultsException；
>
> 但是若查询的数据只有一条，可以使用实体类或集合作为返回值

## 9.3 查询单个数据

```
    /**
     * 查询用户的总数量
     * @return
     */
    Integer getCount();
```

```
    <!--Integer getCount();-->
    <!--
        MyBatis中为Java中常用的类型设置了类型别名
        Integer：Integer，int
        int：_int,_integer
        Map：map
        String：string
    -->
    <select id="getCount" resultType="int">
        select count(*) from t_user
    </select>
```

## 9.4 查询一条数据为map集合

```
    /**
     * 根据id查询用户信息为map集合
     * @param id
     * @return
     */
    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);
```

```
    <!--Map<String, Object> getUserByIdToMap(@Param("id") Integer id);-->
    <select id="getUserByIdToMap" resultType="map">
        select * from t_user where id = #{id}
    </select>
```

## 9.5 查询多条数据为map集合

​	**方式一**

```
/**                                                                             
* 查询所有用户信息为map集合                                                                

* @return                                                                      
* 将表中的数据以map集合的方式查询，一条数据对应一个map；若有多条数据，就会产生多个map集合，
	此时可以将这些map放在一个list集合中获取 
*/
List<Map<String, Object>> getAllUserToMap();
```

```
    <!--Map<String, Object> getAllUserToMap();-->
    <select id="getAllUserToMap" resultType="map">
        select * from t_user
    </select>
```

**方式二**

```
/**                                                                             
* 查询所有用户信息为map集合     

* @return                                                                      
* 将表中的数据以map集合的方式查询，一条数据对应一个map；若有多条数据，就会产生多个map集合，
	并且最终要以一个map的方式返回数据，此时需要通过@MapKey注解设置map集合的键，值是每条数据所对应的 map集合 
*/

@MapKey("id")
Map<String, Object> getAllUserToMap();
```

```
<!--Map<String, Object> getAllUserToMap();-->
<!-- 
{     
	1={password=123456, sex=男, id=1, age=23, username=admin},     
	2={password=123456, sex=男, id=2, age=23, username=张三},     
	3={password=123456, sex=男, id=3, age=23, username=张三} 
}
-->
<select id="getAllUserToMap" resultType="map"> 
	select * from t_user
</select>
```

# 10. 特殊SQL的执行

## 10.1 模糊查询

```
    /**
     * 通过用户名模糊查询用户信息
     * @param mohu
     * @return
     */
    List<User> getUserByLike(@Param("mohu") String mohu);
```

```
    <!--List<User> getUserByLike(@Param("mohu") String mohu);-->
    <select id="getUserByLike" resultType="User">
        <!--select * from t_user where username like '%${mohu}%'-->
        <!--select * from t_user where username like concat('%',#{mohu},'%')-->
        select * from t_user where username like "%"#{mohu}"%"
    </select>
```

## 10.2 批量删除

```
    /**
     * 批量删除
     * @param ids
     */
    void deleteMoreUser(@Param("ids") String ids);
```

```
    <!--void deleteMoreUser(@Param("ids") String ids);//ids:9,10-->
    <delete id="deleteMoreUser">
        delete from t_user where id in(${ids})
    </delete>
```

## 10.3 动态设置表名

```
    /**
     * 动态设置表名，查询用户信息
     * @param tableName
     * @return
     */
    List<User> getUserList(@Param("tableName") String tableName);
```

```
    <!--List<User> getUserList(@Param("tableName") String tableName);-->
    <select id="getUserList" resultType="User">
        select * from ${tableName}
    </select>
```

## 10.4 添加功能获取自增的主键

```
    /**
     * 添加用户信息并获取自增的主键
     * @param user
     */
    void insertUser(User user);
```

```
    <!--void insertUser(User user);-->
    <!--
        useGeneratedKeys:表示当前添加功能使用自增的主键
        keyProperty:将添加的数据的自增主键为实体类类型的参数的属性赋值
    -->
    <insert id="insertUser" useGeneratedKeys="true" keyProperty="id">
        insert into t_user values(null,#{username},#{password},#{age},#{gender},#{email})
    </insert>
```

# 11. 自定义映射resultMap

## 11.1 创建表

**1. 创建t_emp表**

![image-20221129221803421](assets\image-20221129221803421.png)

**2. 创建t_dept表**

![image-20221129222342766](assets\image-20221129222342766.png)

## 11.2 resultMap处理字段和属性的映射关系

若字段名和实体类中的属性名不一致，则可以通过resultMap设置自定义映射

```
<!--
        resultMap：设置自定义的映射关系
        id：唯一标识
        type：处理映射关系的实体类的类型
        常用的标签：
        id：处理主键和实体类中属性的映射关系
        result：处理普通字段和实体类中属性的映射关系
        association：处理多对一的映射关系（处理实体类类型的属性）
        collection：处理一对多的映射关系（处理集合类型的属性）
        column：设置映射关系中的字段名，必须是sql查询出的某个字段
        property：设置映射关系中的属性的属性名，必须是处理的实体类类型中的属性名
    -->
    <resultMap id="empResultMap" type="Emp">
        <id column="emp_id" property="empId"></id>
        <result column="emp_name" property="empName"></result>
        <result column="age" property="age"></result>
        <result column="gender" property="gender"></result>
    </resultMap>
```

```
    <!--Emp getEmpByEmpId(@Param("empId") Integer empId);-->
    <select id="getEmpByEmpId" resultMap="empResultMap">
        select * from t_emp where emp_id = #{empId}
    </select>
```

- 若字段名和实体类中的属性名不一致，但是字段名符合数据库的规则（使用_），实体类中的属性名符合Java的规则（使用驼峰）

- 此时也可通过以下两种方式处理字段名和实体类中的属性的映射关系

  - a> 可以通过为字段起别名的方式，保证和实体类中的属性名保持一致

  - b> 可以在MyBatis的核心配置文件中设置一个全局配置信息mapUnderscoreToCamelCase，

    可以在查询表中数据时，自动将_类型的字段名转换为驼峰

- 例如：

  字段名user_name，设置了mapUnderscoreToCamelCase，此时字段名就会转换为userName

## 11.2  多对一映射处理

​	场景模拟：查询员工信息以及员工所对应的部门信息

### 11.2.1 级联方式处理映射关系

```
<resultMap id="empDeptMap" type="Emp">     
	<id column="eid" property="eid"></id>     
	<result column="ename" property="ename"></result>    
	<result column="age" property="age"></result>    
	<result column="sex" property="sex"></result>    
	<result column="did" property="dept.did"></result>    
	<result column="dname" property="dept.dname"></result>
</resultMap>
<!--Emp getEmpAndDeptByEid(@Param("eid") int eid);-->
<select id="getEmpAndDeptByEid" resultMap="empDeptMap">   
	select emp.*,dept.* from t_emp emp left join t_dept dept on emp.did = dept.did where emp.eid = #{eid}</select>
```

### 11.2.2 使用association处理映射关系

```
<resultMap id="empDeptMap" type="Emp">    
	<id column="eid" property="eid"></id>    
	<result column="ename" property="ename"></result>    
	<result column="age" property="age"></result>    
	<result column="sex" property="sex"></result>    
	<association property="dept" javaType="Dept">        
		<id column="did" property="did"></id>        
		<result column="dname" property="dname"></result>    
	</association>
</resultMap>
<!--Emp getEmpAndDeptByEid(@Param("eid") int eid);-->
<select id="getEmpAndDeptByEid" resultMap="empDeptMap"> 
	select emp.*,dept.* from t_emp emp left join t_dept dept on emp.did = dept.did where emp.eid = #{eid}</select>
```

### 11.2.3 分步查询

​	**1）查询员工信息**

```
/** * 通过分步查询查询员工信息 
* @param eid 
* @return  
*/
Emp getEmpByStep(@Param("eid") int eid);
```

```
<resultMap id="empDeptStepMap" type="Emp">    
	<id column="eid" property="eid"></id>    
	<result column="ename" property="ename"></result>    
	<result column="age" property="age"></result>    
	<result column="sex" property="sex"></result>    
	<!--        
		select：设置分步查询，查询某个属性的值的sql的标识（namespace.sqlId）         
		column：将sql以及查询结果中的某个字段设置为分步查询的条件    
	-->    
	<association property="dept" 
		select="com.yj.nz.MyBatis.mapper.DeptMapper.getEmpDeptByStep" column="did"> 
	</association>
</resultMap>
<!--Emp getEmpByStep(@Param("eid") int eid);-->
<select id="getEmpByStep" resultMap="empDeptStepMap"> 
	select * from t_emp where eid = #{eid}
</select>
```

​	**2）根据员工所对应的部门id查询部门信息**

```
/** 
* 分步查询的第二步： 根据员工所对应的did查询部门信息 
* @param did 
* @return  
*/
Dept getEmpDeptByStep(@Param("did") int did);
```

```
<!--Dept getEmpDeptByStep(@Param("did") int did);-->
<select id="getEmpDeptByStep" resultType="Dept"> 
	select * from t_dept where did = #{did}
</select>
```

## 11.3 一对多映射处理

### 11.3.1 collection

```
/** 
* 根据部门id查新部门以及部门中的员工信息 
* @param did 
* @return  
*/
Dept getDeptEmpByDid(@Param("did") int did);
```

```
<resultMap id="deptEmpMap" type="Dept">    
	<id property="did" column="did"></id>    
	<result property="dname" column="dname"></result>    
	<!--   
		ofType：设置collection标签所处理的集合属性中存储数据的类型
	-->    
	<collection property="emps" ofType="Emp">        
		<id property="eid" column="eid"></id>        
		<result property="ename" column="ename"></result>        
		<result property="age" column="age"></result>        
		<result property="sex" column="sex"></result>    
	</collection>
</resultMap>
<!--Dept getDeptEmpByDid(@Param("did") int did);-->
<select id="getDeptEmpByDid" resultMap="deptEmpMap">   
	select dept.*,emp.* from t_dept dept left join t_emp emp on dept.did = emp.did where dept.did = #{did}</select>
```

### 11.3.2 分步查询

**1）查询部门信息**

```
/** 
* 分步查询部门和部门中的员工 
* @param did 
* @return  
*/
Dept getDeptByStep(@Param("did") int did);
```

```
<resultMap id="deptEmpStep" type="Dept"> 
	<id property="did" column="did"></id> 
	<result property="dname" column="dname"></result> 
	<collection property="emps"  fetchType="eager"	
		select="com.yj.nz.MyBatis.mapper.EmpMapper.getEmpListByDid" column="did">    
	</collection>
</resultMap>
<!--Dept getDeptByStep(@Param("did") int did);-->
<select id="getDeptByStep" resultMap="deptEmpStep"> 
	select * from t_dept where did = #{did}
</select>
```

**2）根据部门id查询部门中的所有员工**

```
/** 
* 根据部门id查询员工信息 
* @param did 
* @return 
*/
List<Emp> getEmpListByDid(@Param("did") int did);
```

```
<!--List<Emp> getEmpListByDid(@Param("did") int did);-->
<select id="getEmpListByDid" resultType="Emp"> 
	select * from t_emp where did = #{did}
</select>
```

## 11.4 分步查询中的延迟加载与按需加载

分步查询的优点：可以实现延迟加载

**1）**若想对所有分步查询进行配置，可以在核心配置文件中设置全局配置信息：

​	**lazyLoadingEnabled：**

​		延迟加载的全局开关，当开启时，所有关联对象都会延迟加载

​	**aggressiveLazyLoading：**

​		当开启时，任何方法的调用都会加载该对象的所有延迟加载属性，

​		否则，每个属性会按需加载此时就可以实现按需加载，获取的数据是什么，就只会执行相应的sql

**2）**若执行对某个分步查询进行配置：

​		可以通过**fetchType**属性进行配置：

​		通过association和collection中的fetchType属性设置当前的分步查询是否使用延迟加载， 

​		fetchType="lazy(延迟加载)|eager(立即加载)"

# 12. 动态SQL

​	**动态SQL的思想：**就是使用不同的动态SQL标签去完成字符串的拼接处理、循环判断。

## 12.1 if

​	if标签可通过test**属性的表达式进行判断**，若表达式的结果为true，则标签中的内容会执行；反之标签中的内容不会执行

```
<!--List<Emp> getEmpListByCondition(Emp emp);-->
<select id="getEmpListByMoreTJ" resultType="Emp">   
	select * from t_emp where 1=1     
	<if test="ename != '' and ename != null">        
		and ename = #{ename}     
	</if>     
	<if test="age != '' and age != null">        
		and age = #{age}     
	</if>     
	<if test="sex != '' and sex != null">        
		and sex = #{sex}     
	</if> 
</select>
```

## 12.2 where

where和if一般结合使用：

​	a> 若where标签中的if条件都不满足，则where标签没有任何功能，即不会添加where关键字

​	b> 若where标签中的if条件满足，则where标签会自动添加where关键字，并将条件最前方多余的and去掉

​	c> where标签不能去掉条件最后多余的and

```
<select id="getEmpListByMoreTJ2" resultType="Emp">    
	select * from t_emp     
	<where>         
		<if test="ename != '' and ename != null">            
			ename = #{ename}         
		</if>         
		<if test="age != '' and age != null">            
			and age = #{age}         
		</if>         
		<if test="sex != '' and sex != null">            
			and sex = #{sex}         
		</if>     
	</where> 
</select>
```

## 12.3 trim

trim用于去掉或添加标签中的内容

常用属性：

​	prefix：在trim标签中的内容的前面添加某些内容

​	prefixOverrides：在trim标签中的内容的前面去掉某些内容

​	suffix：在trim标签中的内容的后面添加某些内容

​	suffixOverrides：在trim标签中的内容的后面去掉某些内容

```
<select id="getEmpListByMoreTJ" resultType="Emp"> 
	select * from t_emp 
	<trim prefix="where" suffixOverrides="and"> 
		<if test="ename != '' and ename != null">
			ename = #{ename} and 
		</if>        
		<if test="age != '' and age != null">       
			age = #{age} and        
		</if> 
		<if test="sex != '' and sex != null">   
			sex = #{sex} 
		</if> 
	</trim>
</select>
```

## 12.4 choose、when、otherwise

​	choose、when、 otherwise相当于if...else if..else

​	when至少设置一个，otherwise最多设置一个

```
<!--List<Emp> getEmpListByChoose(Emp emp);-->
<select id="getEmpListByChoose" resultType="Emp"> 
	select <include refid="empColumns"></include> from t_emp 
	<where> 
		<choose> 
			<when test="ename != '' and ename != null"> 
				ename = #{ename} 
			</when> 
			<when test="age != '' and age != null"> 
				age = #{age} 
			</when>            
			<when test="sex != '' and sex != null">           
				sex = #{sex}            
			</when>            
			<when test="email != '' and email != null">           
				email = #{email}            
			</when> 
		</choose> 
	</where>
</select>
```

## 12.5 foreach

collection：设置要循环的数组或集合
item：用一个字符串表示数组或集合中的每一个数据
separator：设置每次循环的数据之间的分隔符
open：循环的所有内容以什么开始
close：循环的所有内容以什么结束

```
<!--int insertMoreEmp(List<Emp> emps);-->
<insert id="insertMoreEmp">   
	insert into t_emp values    
	<foreach collection="emps" item="emp" separator=",">       
		(null,#{emp.ename},#{emp.age},#{emp.sex},#{emp.email},null)    
	</foreach>
</insert>
<!--int deleteMoreByArray(int[] eids);-->
<delete id="deleteMoreByArray"> 
	delete from t_emp where 
	<foreach collection="eids" item="eid" separator="or"> 
		eid = #{eid} 
	</foreach>
</delete>
<!--int deleteMoreByArray(int[] eids);-->
<delete id="deleteMoreByArray"> 
	delete from t_emp where eid in 
	<foreach collection="eids" item="eid" separator="," open="(" close=")"> 
       #{eid} 
	</foreach>
</delete>
```

## 12.6 SQL片段

sql片段，可以记录一段公共sql片段，在使用的地方通过include标签进行引入

```
<sql id="empColumns"> 
	eid,ename,age,sex,did
</sql>
select <include refid="empColumns"></include> from t_emp
```

# 13. MyBatis的缓存

## 13.1 MyBatis的一级缓存

​		一级缓存是SqlSession级别的，通过同一个SqlSession查询的数据会被缓存，

​		下次查询相同的数据，就会从缓存中直接获取，不会从数据库重新访问

​	**使一级缓存失效的四种情况：**

​		1）不同的SqlSession对应不同的一级缓存

​		2）同一个SqlSession但是查询条件不同

​		3）同一个SqlSession两次查询期间执行了任何一次增删改操作

​		4）同一个SqlSession两次查询期间手动清空了缓存

## 13.2 MyBatis的二级缓存

​		二级缓存是SqlSessionFactory级别，通过同一个SqlSessionFactory创建的SqlSession查询的结果会被缓存；

​		此后若再次执行相同的查询语句，结果就会从缓存中获取

​	二级缓存开启的条件：

​		a> 在核心配置文件中，设置全局配置属性cacheEnabled="true"，默认为true，不需要设置

​		b> 在映射文件中设置标签<cache/>

​		c> 二级缓存必须在SqlSession关闭或提交之后有效

​		d> 查询的数据所转换的实体类类型必须实现序列化的接口

​	使二级缓存失效的情况：

​		两次查询之间执行了任意的增删改，会使一级和二级缓存同时失效

## 13.3 二级缓存的相关配置

​	在mapper配置文件中添加的cache标签可以设置一些属性：

- eviction属性：缓存回收策略，默认的是 LRU。

  - LRU（Least Recently Used） 	– 最近最少使用的：移除最长时间不被使用的对象。


  - FIFO（First in First out） 			– 先进先出：按对象进入缓存的顺序来移除它们。


  - SOFT – 软引用：移除基于垃圾回收器状态和软引用规则的对象。


  - WEAK – 弱引用：更积极地移除基于垃圾收集器状态和弱引用规则的对象。


- flushInterval属性：刷新间隔，单位毫秒

  - 默认情况是不设置，也就是没有刷新间隔，缓存仅仅调用语句时刷新


- size属性：引用数目，正整数

  - 代表缓存最多可以存储多少个对象，太大容易导致内存溢出


- readOnly属性：只读， true/false

  - true：只读缓存；	会给所有调用者返回缓存对象的相同实例。因此这些对象不能被修改。这提供了 很重要的性能优势。


  - false：读写缓存；会返回缓存对象的拷贝（通过序列化），这会慢一些，但是安全，因此默认是false。


## 13.4 MyBatis缓存查询的顺序

​		先查询二级缓存，因为二级缓存中可能会有其他程序已经查出来的数据，可以拿来直接使用。

​		如果二级缓存没有命中，再查询一级缓存，

​		如果一级缓存也没有命中，则查询数据库，

​		SqlSession关闭之后，一级缓存中的数据会写入二级缓存	

## 13.5 整合第三方缓存EHCache

### 	13.5.1 添加依赖

```
<!-- Mybatis EHCache整合包 -->
<dependency>    
	<groupId>org.mybatis.caches</groupId>    
	<artifactId>mybatis-ehcache</artifactId>    
	<version>1.2.1</version>
</dependency>
<!-- slf4j日志门面的一个具体实现 -->
<dependency>    
	<groupId>ch.qos.logback</groupId>    
	<artifactId>logback-classic</artifactId>    
	<version>1.2.3</version>
</dependency>
```

### 	13.5.2 各jar包功能

| jar包名称       | 作用                            |
| --------------- | ------------------------------- |
| mybatis-ehcache | Mybatis和EHCache的整合包        |
| ehcache         | EHCache核心包                   |
| slf4j-api       | SLF4J日志门面包                 |
| logback-classic | 支持SLF4J门面接口的一个具体实现 |

### 	13.5.3 创建EHCache的配置文件ehcache.xml

```
<?xml version="1.0" encoding="utf-8" ?>
<ehcache xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:noNamespaceSchemaLocation="../config/ehcache.xsd">    
	<!-- 磁盘保存路径 -->    
	<diskStore path="D:\yjxz\ehcache"/>    
	<defaultCache        
		maxElementsInMemory="1000"        
		maxElementsOnDisk="10000000"        
		eternal="false"        
		overflowToDisk="true"        
		timeToIdleSeconds="120"        
		timeToLiveSeconds="120"        
		diskExpiryThreadIntervalSeconds="120"        
		memoryStoreEvictionPolicy="LRU">    
	</defaultCache>
</ehcache>
```

### 	13.5.4 设置二级缓存的类型

```
<cache type="org.mybatis.caches.ehcache.EhcacheCache"/>
```

### 	13.5.5 加入logback日志

​	存在SLF4J时，作为简易日志的log4j将失效，此时我们需要借助SLF4J的具体实现logback来打印日志。 

​	创建logback的配置文件logback.xml

### 13.5.6 EHCache配置文件说明

| 属性名                          | 是否必须 | 作用                                                         |
| ------------------------------- | -------- | ------------------------------------------------------------ |
| maxElementsInMemory             | 是       | 在内存中缓存的element的最大数目                              |
| maxElementsOnDisk               | 是       | 在磁盘上缓存的element的最大数目，若是0表示无穷大             |
| eternal                         | 是       | 设定缓存的elements是否永远不过期。 如果为true，则缓存的数据始终有效， 如果为false那么还要根据timeToIdleSeconds、timeToLiveSeconds判断 |
| overflowToDisk                  | 是       | 设定当内存缓存溢出的时候是否将过期的element缓存到磁盘上      |
| timeToIdleSeconds               | 否       | 当缓存在EhCache中的数据前后两次访问的时间超过timeToIdleSeconds的属性取值时， 这些数据便会删除，默认值是0,也就是可闲置时间无穷大 |
| timeToLiveSeconds               | 否       | 缓存element的有效生命期，默认是0.,也就是element存活时间无穷大 |
| diskSpoolBufferSizeMB           | 否       | DiskStore(磁盘缓存)的缓存区大小。默认是30MB。每个Cache都应该有自己的一个缓冲区 |
| diskPersistent                  | 否       | 在VM重启的时候是否启用磁盘保存EhCache中的数据，默认是false。 |
| diskExpiryThreadIntervalSeconds | 否       | 磁盘缓存的清理线程运行间隔，默认是120秒。每个120s， 相应的线程会进行一次EhCache中数据的清理工作 |
| memoryStoreEvictionPolicy       | 否       | 当内存缓存达到最大，有新的element加入的时候， 移除缓存中element的策略。 默认是LRU （最近最少使用），可选的有LFU （最不常使用）和FIFO （先进先出） |

# 14. MyBatis的逆向工程

正向工程：先创建Java实体类，由框架负责根据实体类生成数据库表。 Hibernate是支持正向工程的。

逆向工程：先创建数据库表，由框架负责根据数据库表，反向生成如下资源：

- Java实体类

Mapper接口

- Mapper映射文件

## 14.1 创建逆向工程的步骤

### 	1.  添加依赖和插件

```
<!-- 依赖MyBatis核心包 -->
 <dependencies>
     <dependency>
         <groupId>org.mybatis</groupId>
         <artifactId>mybatis</artifactId>
         <version>3.5.7</version>
     </dependency>
     <!-- junit测试 -->
     <dependency>
         <groupId>junit</groupId>
         <artifactId>junit</artifactId>
         <version>4.12</version>
         <scope>test</scope>
     </dependency>

     <!-- log4j日志 -->
     <dependency>
         <groupId>log4j</groupId>
         <artifactId>log4j</artifactId>
         <version>1.2.17</version>
     </dependency>

     <dependency>
         <groupId>mysql</groupId>
         <artifactId>mysql-connector-java</artifactId>
         <version>8.0.16</version>
     </dependency>
     <dependency>
         <groupId>com.github.pagehelper</groupId>
         <artifactId>pagehelper</artifactId>
         <version>5.2.0</version>
     </dependency>
 </dependencies>

 <!-- 控制Maven在构建过程中相关配置 -->
 <build>

     <!-- 构建过程中用到的插件 -->
     <plugins>

         <!-- 具体插件，逆向工程的操作是以构建过程中插件形式出现的 -->
         <plugin>
             <groupId>org.mybatis.generator</groupId>
             <artifactId>mybatis-generator-maven-plugin</artifactId>
             <version>1.3.0</version>

             <!-- 插件的依赖 -->
             <dependencies>

                 <!-- 逆向工程的核心依赖 -->
                 <dependency>
                     <groupId>org.mybatis.generator</groupId>
                     <artifactId>mybatis-generator-core</artifactId>
                     <version>1.3.2</version>
                 </dependency>

                 <!-- MySQL驱动 -->
                 <dependency>
                     <groupId>mysql</groupId>
                     <artifactId>mysql-connector-java</artifactId>
                     <version>8.0.16</version>
                 </dependency>
             </dependencies>
         </plugin>
     </plugins>
 </build>

```

### 2. 创建MyBatis的核心配置文件

### 3. 创建逆向工程的配置文件

​	文件名必须是：generatorConfig.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
     PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
     "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
<generatorConfiguration>
 <!--
         targetRuntime: 执行生成的逆向工程的版本
                 MyBatis3Simple: 生成基本的CRUD（清新简洁版）
                 MyBatis3: 生成带条件的CRUD（奢华尊享版）
  -->
 <context id="DB2Tables" targetRuntime="MyBatis3">
     <!-- 数据库的连接信息 -->
     <jdbcConnection driverClass="com.mysql.cj.jdbc.Driver"
                     connectionURL="jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC"
                     userId="root"
                     password="123456">
     </jdbcConnection>
     <!-- javaBean的生成策略-->
     <javaModelGenerator targetPackage="com.atguigu.mybatis.pojo" targetProject=".\src\main\java">
         <property name="enableSubPackages" value="true" />
         <property name="trimStrings" value="true" />
     </javaModelGenerator>
     <!-- SQL映射文件的生成策略 -->
     <sqlMapGenerator targetPackage="com.atguigu.mybatis.mapper"  targetProject=".\src\main\resources">
         <property name="enableSubPackages" value="true" />
     </sqlMapGenerator>
     <!-- Mapper接口的生成策略 -->
     <javaClientGenerator type="XMLMAPPER" targetPackage="com.atguigu.mybatis.mapper"  targetProject=".\src\main\java">
         <property name="enableSubPackages" value="true" />
     </javaClientGenerator>
     <!-- 逆向分析的表 -->
     <!-- tableName设置为*号，可以对应所有表，此时不写domainObjectName -->
     <!-- domainObjectName属性指定生成出来的实体类的类名 -->
     <table tableName="t_emp" domainObjectName="Emp"/>
     <table tableName="t_dept" domainObjectName="Dept"/>
 </context>
</generatorConfiguration>
```

​	**4. 执行MBG插件的generate目标**

![image-20221202085711948](assets\image-20221202085711948.png)

**5. 效果**

![image-20221202085759803](assets\image-20221202085759803.png)

## 14.2 QBC查询

​	**介绍：**

​		https://www.ngui.cc/el/989351.html?action=onClick

```
@Test
public void testMBG(){    
	try {        
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");        
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);        
		SqlSession sqlSession = sqlSessionFactory.openSession(true);        
		EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);        
		//查询所有数据        
		/*List<Emp> list = mapper.selectByExample(null);        
		list.forEach(emp -> System.out.println(emp));*/        
		//根据条件查询        
		/*EmpExample example = new EmpExample();
			example.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThanOrEqualTo(20);       		
            example.or().andDidIsNotNull();        
            List<Emp> list = mapper.selectByExample(example);        
            list.forEach(emp -> System.out.println(emp));*/        
            mapper.updateByPrimaryKeySelective(new Emp(1,"admin",22,null,"456@qq.com",3));   
	} catch (IOException e) {        
		e.printStackTrace();   
		}
}
```

# 15. 分页插件

​	https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/en/HowToUse.md

​	limit index,pageSize

​	pageSize：每页显示的条数

​	pageNum：当前页的页码

​	index：当前页的起始索引，index=(pageNum-1)*pageSize

​	count：总记录数

​	totalPage：总页数

​	totalPage = count / pageSize;

​		if(count % pageSize != 0){

​			totalPage += 1;

​		}

​	pageSize=4，pageNum=1，index=0 limit 0,4

​	pageSize=4，pageNum=3，index=8 limit 8,4

​	pageSize=4，pageNum=6，index=20 limit 8,4

​	**首页 上一页 2 3 4 5 6 下一页 末页**

## 15.1 分页插件的使用步骤

### 1. 添加依赖

```
<dependency>    
	<groupId>com.github.pagehelper</groupId>    
	<artifactId>pagehelper</artifactId>    
	<version>5.2.0</version>
</dependency>
```

### 2. 配置分页插件

​	在MyBatis的核心配置文件中配置插件

```
<plugins>    
	<!--设置分页插件-->    
	<plugin interceptor="com.github.pagehelper.PageInterceptor"></plugin>
</plugins>
```

## 15.2 分页插件的使用

**a>在查询功能之前使用PageHelper.startPage(int pageNum, int pageSize)开启分页功能**

​	pageNum：当前页的页码

​	pageSize：每页显示的条数

**b>在查询获取list集合之后，使用PageInfo<T> pageInfo = new PageInfo<>(List<T> list, int navigatePages)获取分页相关数据**

​	list：分页之后的数据

​	navigatePages：导航分页的页码数

**c>分页相关数据**

​	PageInfo{

​		pageNum=1, pageSize=4, size=4,

​		startRow=1, endRow=4, total=30,

​		pages=8,

​		list=Page{count=true, pageNum=1, pageSize=4, startRow=0, endRow=4, total=30, pages=8, reasonable=false, 		

​		pageSizeZero=false}[Emp{empId=1, empName='aaa', age=null, gender='null', deptId=null}, Emp{empId=2, empName='a', 

​		age=null, gender='null', deptId=null}, Emp{empId=3, empName='a', age=null, gender='null', deptId=null}, Emp{empId=4, 

​		empName='a', age=null, gender='null', deptId=null}],

​		prePage=0, nextPage=2, isFirstPage=true,

​		isLastPage=false, hasPreviousPage=false,

​		hasNextPage=true, navigatePages=5,

​		navigateFirstPage=1, navigateLastPage=5, navigatepageNums=[1, 2, 3, 4, 5]

​	}



​	pageNum：当前页的页码

​	pageSize：每页显示的条数

​	size：当前页显示的真实条数

​	total：总记录数

​	pages：总页数

​	prePage：上一页的页码

​	nextPage：下一页的页码

​	isFirstPage/isLastPage：是否为第一页/最后一页

​	hasPreviousPage/hasNextPage：是否存在上一页/下一页

​	navigatePages：导航分页的页码数

​	navigatepageNums：导航分页的页码，[1,2,3,4,5]

# 

# 查漏补缺

# 1. Mybatis代理开发方式

​	此处使用的是JDK的动态代理方式伪代码介绍，延迟加载使用的cglib动态代理方式

## 1.1 代理理解

​	代理分为静态代理和动态代理。此处先不说静态代理，因为Mybatis中使用的代理方式是动态代理。

> **注意：**本人的设计模式章节思想整理中，有详细介绍代理模式！

## 1.2 动态代理分为两种方式：

- 基于JDK的动态代理--针对有接口的类进行动态代理
- 基于CGLIB的动态代理--通过子类继承父类的方式去进行代理。

## 1.3 XML方式

- 开发方式
  - 只需要开发Mapper接口（dao接口）和 Mapper映射文件，不需要编写实现类。
- 开发规范
  - Mapper接口开发方式需要遵循以下规范：
    - Mapper接口的类路径与Mapper.xml文件中的namespace相同。
    - Mapper接口方法名称和Mapper.xml中定义的每个statement的id相同。
    - Mapper接口方法的输入参数类型和mapper.xml中定义的每个 sql 的parameterType的类型相同。
    - Mapper接口方法的返回值类型和mapper.xml中定义的每个sql的resultType的类型相同。

### 1. mapper映射文件

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.yj.nz.mybatis.mapper.UserMapper">
<!-- 根据id获取用户信息 -->
	<select id="findUserById" parameterType="int" resultType="com.yj.nz.mybatis.po.User">
		select * from user where id = #{id}
	</select>
</mapper>
```

### 2. mapper接口

```
/**
 * 用户管理mapper
*/
public interface UserMapper {
	//根据用户id查询用户信息
	public User findUserById(int id) throws Exception;
}
```

### 3. 全局配置文件中加载映射文件

```
<!-- 加载映射文件 -->
 <mappers>
 	<mapper resource="mapper/UserMapper.xml"/>
 </mappers>
```

### 4. 测试代码

```
public class UserMapperTest{

	private SqlSessionFactory sqlSessionFactory;

	@Before 
	public void setUp() throws Exception {
		//mybatis配置文件 String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//使用SqlSessionFactoryBuilder创建sessionFactory 
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); 
	} 

	@Test 
	public void testFindUserById() throws Exception { 
		//获取session 
		SqlSession session = sqlSessionFactory.openSession(); 
		//获取mapper接口的代理对象 
		UserMapper userMapper = session.getMapper(UserMapper.class); 
		//调用代理对象方法 
		User user = userMapper.findUserById(1); 
		System.out.println(user); 
		//关闭session session.close();  
	}

}
```

> **注意：**
>
> ​	经过了解，前面的演示都是基于代理开发方式，而非代理开发方式本人并未介绍，
>
> ​	但是本人有了解过，因为开发基本不用，所以本人为了防止扰乱我自己的思想，本人不想去整理了，
>
> ​	如果要整理，本人也能做到！

## 1.4 注解方式

- 开发方式
  - 只需要编写mapper接口，然后方法上添加注解。

> **注意：**
>
> ​	本人未整理，如果真用到，也不难，本人学习过，也代码实现过，自然懂点这个玩意，上述思想都会，这玩意特好上手，
>
> ​	况且这注解开发，更特么封装的离谱，非常不方面我们理解 Mybatis 框架思想！

- Mybatis 针对 CURD 操作都提供了对应的注解，已经做到见名知意

  - 简单介绍：

    - 查询 ：@Select

    * 添加 ：@Insert

    * 修改 ：@Update

    * 删除 ：@Delete

# 2. 延迟加载

## 2.1 什么是延迟加载

- MyBatis中的延迟加载，也称为懒加载，是指在进行关联查询时，按照设置延迟规则推迟对关联对象的select查询。

  延迟加载可以有效的减少数据库压力。

- Mybatis的延迟加载，需要通过resultMap标签中的association和collection子标签才能演示成功。
- Mybatis的延迟加载，也被称为是嵌套查询，对应的还有嵌套结果的概念，可以参考一对多关联的案例。

- **注意：**MyBatis的延迟加载只是对关联对象的查询有延迟设置，对于主加载对象都是直接执行查询语句的。

## 2.2 延迟加载的分类

​		MyBatis根据对关联对象查询的select语句的执行时机，分为三种类型：直接加载、侵入式延迟与深度延迟加载

- **直接加载：** 执行完对主加载对象的select语句，马上执行对关联对象的select查询。
- **侵入式延迟：**执行对主加载对象的查询时，不会执行对关联对象的查询，但当要访问主加载对象的某个属性（该属性不是关联对象的属性）时，就会马上执行关联对象的select查询。

- **深度延迟：**执行对主加载对象的查询时，不会执行对关联对象的查询，访问主加载对象的详情时也不会执行关联对象的select查询。只有当真正访问关联对象的详情时，才会执行对关联对象的select查询。

## 2.3 延迟加载策略配置

​	延迟加载策略需要在Mybatis的全局配置文件中，通过标签进行设置。

### 1. 直接加载

​	通过对全局参数：lazyLoadingEnabled进行设置，默认就是false。

```
<settings>    
	<!-- 延迟加载总开关 -->    
	<setting name="lazyLoadingEnabled" value="false"/>
</settings>
```

### 2. 侵入式延迟加载

```
<settings>    
	<!-- 延迟加载总开关 -->    
	<setting name="lazyLoadingEnabled" value="true"/>    
	<!-- 侵入式延迟加载开关 -->    
	<setting name="aggressiveLazyLoading" value="true"/>
</settings>
```

### 3.深度延迟加载

```
<settings>    
	<!-- 延迟加载总开关 -->    
	<setting name="lazyLoadingEnabled" value="true"/>    
	<!-- 侵入式延迟加载开关 -->    
	<setting name="aggressiveLazyLoading" value="false"/>
</settings>
```

## 2.4 N+1问题

- 深度延迟加载的使用会提升性能。
- 如果延迟加载的表数据太多，此时会产生N+1问题，主信息加载一次算1次，而从信息是会根据主信息传递过来的条件，去查询从表多次。

> **注意：**上述案例中，分步查询这一块有介绍过延迟加载，但是跟我现在整理所讲的配置

# 3. Mybatis缓存

## 3.1 缓存介绍

​	Mybatis提供查询缓存，如果缓存中有数据就不用从数据库中获取，用于减轻数据压力，提高系统性能。

​	Mybatis的查询缓存总共有两级，我们称之为一级缓存和二级缓存，

​	如图：

![image-20230102122728925](assets\image-20230102122728925.png)

- 一级缓存是**SqlSession**级别的缓存。

  ​	在操作数据库时需要构造 sqlSession对象，在对象中有一个数据结构（HashMap）用于存储缓存数据。

  ​	不同的sqlSession之间的缓存数据区域（HashMap）是互相不影响的。(因为属于不同的sqlSession对象)

- 二级缓存是Mapper（namespace）级别的缓存。

  多个SqlSession去操作同一个Mapper的sql语句，多个SqlSession可以共用二级缓存，二级缓存是跨SqlSession的。

## 3.2 一级缓存

**Mybatis默认开启了一级缓存**

**原理图：**

​		![image-20230102123011454](assets\image-20230102123011454.png)

## 3.3 二级缓存

​	**原理图：**

​	二级缓存是mapper（namespace）级别的。

​	下图是多个sqlSession请求UserMapper的二级缓存图解。

​	![image-20230102123142961](assets\image-20230102123142961.png)

### 1. 开启二级缓存

​	**Mybatis默认是没有开启二级缓存，开启步骤如下：**

- 1、在核心配置文件SqlMapConfig.xml中加入以下内容（开启二级缓存总开关）：

  - ```
    <!-- 开启二级缓存总开关 -->
    <settings>    
    	<setting name="cacheEnabled" value="true"/>
    </settings>
    ```

- 2、在UserMapper映射文件中，加入以下内容，开启二级缓存：

  - ```
    <!-- 开启本mapper下的namespace的二级缓存，默认使用的是mybatis提供的PerpetualCache -->
    <cache></cache>
    ```

​	**查询的数据所转换的实体类类型要实现序列化：**

​		由于二级缓存的数据不一定都是存储到内存中，它的存储介质多种多样，

​		比如说存储到文件系统中，所以需要给缓存的对象执行序列化，如果该类存在父类，那么父类也要实现序列化

​		**为什么提到存储到文件系统中，所以说要给缓存对象执行序列化呢？**

​		原因很简单，本人IO流中有了解过序列化与反序列相关知识，了解过这个思想！

### 2. 禁用二级缓存

​	默认二级缓存的粒度是Mapper级别的，但是如果在同一个Mapper文件中某个查询不想使用二级缓存的话，

​	就需要对缓存的控制粒度更细。

​	在select标签中设置useCache=false，可以禁用当前select语句的二级缓存，即每次查询都是去数据库中查询，

​	默认情况下是true，即该statement使用二级缓存。

```
<select id="findUserById" parameterType="int" resultType="com.yj.nz.mybatis.po.User" useCache="true">   
	SELECT * FROM user WHERE id = #{id}
</select>
```

### 3. 刷新二级缓存

​	**通过flushCache属性，可以控制select、insert、update、delete标签是否刷新二级缓存	**

​	**默认设置**

- 默认情况下如果是select语句，那么flushCache是false。
-  如果是insert、update、delete语句，那么flushCache是true。

**默认配置解读**

- 如果查询语句设置成true，那么每次查询都是去数据库查询，即意味着该查询的二级缓存失效。
- 如果增删改语句设置成false，即使用二级缓存，那么如果在数据库中修改了数据，而缓存数据还是原来的，这个时候就会出现脏读。

**flushCache设置如下：**

```
<select id="findUserById" parameterType="int" resultType="com.kkb.mybatis.po.User" useCache="true" flushCache="true">       
	SELECT * FROM user WHERE id = #{id}
</select>
```

### 4. 应用场景

- 使用场景：
  - 对于访问响应速度要求高，但是实时性不高的查询，可以采用二级缓存技术。

- 注意事项：

  - 在使用二级缓存的时候，要设置一下刷新间隔（cache标签中有一个flashInterval属性）来定时刷新二级缓存，

    这个刷新间隔根据具体需求来设置，比如设置30分钟、60分钟等，单位为毫秒。

### 5. 局限性

**Mybatis二级缓存对细粒度的数据级别的缓存实现不好。**

- **场景：**
  - 对商品信息进行缓存，由于商品信息查询访问量大，但是要求用户每次查询都是最新的商品信息，此时如果使用二级缓存，就无法实现当一个商品发生变化只刷新该商品的缓存信息而不刷新其他商品缓存信息，因为二级缓存是mapper级别的，当一个商品的信息发送更新，所有的商品信息缓存数据都会清空

- **解决方法：**

  - 此类问题，需要在业务层根据需要对数据有针对性的缓存,

    比如可以对经常变化的 数据操作单独放到另一个namespace的mapper中。

# 4. 查漏补缺说明

​	这里演示的都是伪代码，我是参考某个资料进行思想训练，然后根据我自己这套代码演示进行补充理解，思想才是王道，会用就行！

