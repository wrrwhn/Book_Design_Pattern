
# 设计模式


## 设计原则
- 找出应用中可能需要**变化**之处，把它们**独立**出来，不要和那些不需要变化的代码混在一起
	- 系统中**某部分改变不会影响其它部份**
- **针对接口编程**，而不是针对实现编程
	- 变量声明为抽象或接口，执行时动态赋值
- **多用组合**，少用继承
- 为了交互对象之间的**松耦合**设计而努力
- 类应该对**扩展开放**，对**修改关闭**
	- 根据业务和重要性，来取舍是否
- 依赖倒置原则
	- 要依赖抽象，不要依赖具体类
		- 变量不可以持有具体类的引用
			- 工厂
		- 不要让类派生自具体类
			- 派生至接口或抽象类
		- 不要覆盖基类中已实现的方法
			- 避免破坏基类中被继承的抽象
- **最少知识**原则
	- 减少对象之间的交互
- 好莱坞原则
	- 别调用（打电话给）我们，我们会调用（打电话给）你
	- 避免高、低层组件的相互依赖，导致依赖腐败
	- 低层组件挂靠在高层组件，高层组件决定调用时机和方式
- **单一责任**原则
	- 一个类应该只有一个引起变化的原因
	- 高内聚
		- 一个模块或一个类，被设计仅支持一组相关功能时

## 设计模式
### 策略模式
- 定义
	- 定义算法族；分别封装后，让它们之间**相互替换**
	- 行为被封装进一组类中，并于需要时**动态改变**
- UML
	- ![Strategy.jpg](http://doc.yqjdcyy.com/deba098a-00ec-401c-a036-4ea2b2a12d61.jpg)
- 场景
	- Java
		- `RejectedExecutionHandler`
		- ![Java.Concurrent.RejectedStatery.png](http://doc.yqjdcyy.com/0f364666-89ca-44a6-9aad-5efbd4cccf9c.png)
	- Spring
		- `Resource`
		- ![Spring.Resource.png](http://doc.yqjdcyy.com/6a0dbc2b-ba85-403f-b0c7-7f45bbd6e7d0.png)


### 观察者模式
- 定义
	- 定义对象之间的**一对多**依赖；当一个对象状态改变时，所有依赖者都会收到通知并自动更新
		- Java.Observervable
		- Java.Observer
- UML
	- ![Observer-basic.jpg](http://doc.yqjdcyy.com/d1bb01c5-5df5-4933-aabe-c6aa4a12e6a8.jpg)
	- ![Observer-java.jpg](http://doc.yqjdcyy.com/ce41ae37-8423-4360-81f4-36cec5a144ed.jpg)
- 示例
	- Spring 的事件机制
		- `ApplicationEvent`+ `ApplicationListener`+ `ApplicationEventMultiCast`
		- ![Spring.Event-Observer.png](http://doc.yqjdcyy.com/04dd5491-2d2b-4931-9423-837aea92a94e.png)


### 装饰者模式
- 定义
	- 动态地将责任附加到对象上，若要扩展功能，装饰者提供了比继承更为弹性的替代方案
		- 装饰者可在所委托被装饰者的行为之前有或之后，**加上自己的行为**，以达到特定的目的
- UML
	- ![Decorator.jpg](http://doc.yqjdcyy.com/6582eb45-313f-4a83-8981-4ab8d9ce6762.jpg)
	- ![Decorator-book.jpg](http://doc.yqjdcyy.com/a6ba0b19-ef4d-475f-b537-ad8bb36764b3.jpg)
- 示例
	- Java.IO
		- `Readable`+ `Reader`+ `InputStreamReader`
		- ![Java.IO.Readable.png](http://doc.yqjdcyy.com/bbe6fff2-acbf-4351-bf88-fe703ed1e57c.png)
	- Spring 场景
		- `ServletRequestWrapper`+= `ServletRequest`
		- ![Spring.ServletRequest.png](http://doc.yqjdcyy.com/a65243fd-a285-485a-9080-dff4a21d32ae.png)

### 工厂模式
- 定义
	- 定义创建对象的接口，用于创建相关或依赖对象的家族，而不需要明确指定具体类
		- 把类**实例化**推迟到子类
- 分类
	- 简单工厂
		- 根据 type 进行不同类型的创建
	- 工厂模式
		- 单一种类
	- 抽象工厂
		- 支持多种类型
- UML
	- ![Factory-simple.jpg](http://doc.yqjdcyy.com/6ed6929c-0d1f-429b-a434-7f03aecfd411.jpg)
	- ![Factory-abstract.jpg](http://doc.yqjdcyy.com/bc6647cb-199f-4826-ab3c-1a60c0814c24.jpg)
	- ![Factory-abstract-implement.jpg](http://doc.yqjdcyy.com/6a1797a8-d88d-4948-b1c9-cdbc21592115.jpg)
- 示例
	- Java.SQL
		- `Connection`+ `DriverManager/ DataSource`
		- ![Java.SQL.Connection.png](http://doc.yqjdcyy.com/68c7a1cd-be9b-46c0-9bb1-614028b2da4d.png)
	- Spring.AbstractFactoryBean
		- `FactoryBean.getObject()`+ `AbstractFactoryBean.createInstance()`+ `ListFactoryBean|AbstractServiceLoaderBasedFactoryBean`
		- ![Spring.FactoryBean.png](http://doc.yqjdcyy.com/386f6a0c-3251-43a4-84fd-b8f9ae49b25d.png)


### 单例模式
- 定义
	- 确保一个类**只有一个**实例，并提供**全局访问点**
- UML
	- ![Singleton-basic.jpg](http://doc.yqjdcyy.com/8511f4e7-3595-4ed3-8a9c-24ba3bf3cda3.jpg)
- 优化
	- 多线程
		- `synchronized getInstance()`
			- 性能效率降低非常
		- `private static Singleton ins= new Singleton();`
			- JVM 加载时即人创建唯一实例
		- `private volatile static VolatileSingleton ins;`
			- **双重检查加锁**，最大限度减少同步
			- volatile 可保障对应变量
- 场景
	- `Java.Runtime.getRuntime()`
		- 饿汉式，static 形式初始化
	- `Spring.AbstractFactoryBean.getObject()`


### 命令模式
- 定义
	- 将**请求**封装为**对象**，以便使用不同的请求、队列或者日志来参数化其它对象
		- 宏命令用于支持多个命令
	- 实现**行为请求者**和**行为执行者**之间的解耦
- UML
	- ![Command.jpg](http://doc.yqjdcyy.com/620058e8-776a-45d2-afd7-2b4eed251919.jpg)
- 场景
	- Java
		- `Runnable`
		- ![Java.Runnable.png](http://doc.yqjdcyy.com/db78fdc2-4fa0-4dc9-8410-1401d307ea9d.png)
	- Spring
		- `StatementCallback`+ `JdbcTemplate`
		- ![Spring.JDBC.StatementCallback.png](http://doc.yqjdcyy.com/23e36923-14ce-4445-be4b-bd4f87ca615d.png)



### 适配器模式
- 定义
	- 将一个类的接口，转换成客户期望的另一个接口
		- 让原本接口不**兼容**的类可以使用无间
		- 类型
			- 对象适配
			- 类适配，需要语言支持多重继承
- UML
	- ![Adapter-object.jpg](http://doc.yqjdcyy.com/9437f98b-3a64-44bb-85b1-9ad38e308adf.jpg)
	- ![Adapter-class.jpg](http://doc.yqjdcyy.com/f8d74cf8-4df6-474b-8df1-3a26e57ae646.jpg)


### 外观模式
- 定义
	- 提供统一的接口，用于访问子系统中的一群接口
		- **定义高层接口**，让子系统更容易使用
		- 提供简化接口的同时，依然将完整的功能暴露出来
		- 将业务从子系统中**解耦**出来，有调整需求时仅须调整外观代码
- UML
	- ![Facade.jpg](http://doc.yqjdcyy.com/baf5b3b8-f355-45f3-b792-573586e2eeba.jpg)


### 模板方法模式
- 定义
	- 在一个方法中定义一个**算法的框架**，将一些步骤延迟到子类中
		- 子类在不改变算法结构的前提下，重新定义算法的部分步骤
		- 通过预留**钩子**方法，保证算法的灵活性
- UML
	- ![Template-basic.jpg](http://doc.yqjdcyy.com/8edede61-1f49-4218-a97e-e4740d86069c.jpg)
	- ![Template-hook.jpg](http://doc.yqjdcyy.com/d100b46b-2499-4abf-b3a4-bfad0d0c5204.jpg)
- 示例
	- java
		- Arrays.sort
		- InputStream.read(byte b[], int off, int len)
	- 模式
		- 工厂模式


### 迭代器模式
- 定义
	- 提供一种方法**顺序访问**一个聚合对象中的各个元素，而不暴露其内部的表示
- UML
	- ![Iterator-basic.jpg](http://doc.yqjdcyy.com/9796fdda-c42d-43c7-94e1-3cc57d787686.jpg)
	- ![Iterator-java.jpg](http://doc.yqjdcyy.com/d78372a2-23f4-49cf-9819-15eee81fd0cd.jpg)


### 组合模式
- 定义
	- 允许将对象组合成树形结构来表现**整体/ 部分**的层次结构
	- 组合能让客户以**一致的方式处理**个别对象以及对象组合
- UML
	- ![Composite-basic.jpg](http://doc.yqjdcyy.com/b4294698-46e0-4964-b86b-d1d537a36a6f.jpg)
	- ![Composite-iterator.jpg](http://doc.yqjdcyy.com/11b4a6d6-1f29-4fcb-a802-0151f624c72f.jpg)


### 状态模式
- 定义
	- 允许对象在内部**状态**改变时改变它的**行为**
		- 对象看起来好像修改了它的类
		- 状态类可被多个 Context 实例共享
- UML
	- ![State.jpg](http://doc.yqjdcyy.com/33696565-246d-4865-bec5-a39d17e74389.jpg)


### 代理模式
- 定义
	- 为另一个对象提供一个替身或占位符以控件对这个对象的访问
		- 适合远程、创建开销大、需要安全控制的对象
		- 缓存代理、保护代理、虚拟代理
- 步骤
	- 启动 `rmiregistry` 服务
	- 编译并使用 `rmic proxy.proxy.ProxyRemoteImpl` 自动生成 `ProxyRemoteImpl_Stub`
	- 运行 `ProxyRemoteImpl` 服务
	- 运行 `ProxyRemoteClient` 请求服务
- 常见异常
	- 未在启动远程服务前**先启动 `rmiregistry` 服务**
	- 须确认变量和返回值类型**可序列化**
		- 编译时不可见，只在运行时发现
	- 未给客户端提供 **stub 类**
- UML
	- ![Proxy-RMI.jpg](http://doc.yqjdcyy.com/0ea20303-74c7-405b-8631-f0509c4aba51.jpg)
	- ![Proxy-protected.jpg](http://doc.yqjdcyy.com/1eb7bdbd-b35c-417a-bddb-ae8cb2a2add9.jpg)
	- ![Proxy-dynamic.jpg](http://doc.yqjdcyy.com/0c1e27cc-7e2c-413d-90af-0d273fd0f4aa.jpg)
- 场景
	- http://www.throwable.club/2018/12/16/cglib-dynamic-proxy-analyze/


### 复合模式
- 定义
	- 结合两个或以上的模式，组成一个解决方案
		- 解决一再发生的一般性问题
- UML
	- ![Compound-all.jpg](http://doc.yqjdcyy.com/984d367e-b636-4554-b11c-0004c89b4ed3.jpg)
	- ![Compound-mvc.jpg](http://doc.yqjdcyy.com/63c531c3-1fce-4f84-a415-0bd271665476.jpg)


### 桥接模式
- 定义
	- 将抽象部分与实现部分**分离**，保障它们**独立地变化**
- 实例
	- 跨平台视频播放器
		- 多平台：Windows、Linux、Unix 等
		- 多格式：MP4、AVI、RMVB 等
- UML
	- ![Bridge.jpg](http://doc.yqjdcyy.com/b4486594-1d3b-4af1-ba2f-7f5410449ad1.jpg)


### 生成器模式
- 定义
	- 封装产品的构造过程，并允许按步骤构造
- UML
	- ![Builder.jpg](http://doc.yqjdcyy.com/f1fa715b-7d6e-4f0f-a269-e734bc0919a6.jpg)


### 责任链模式
- 定义
	- 让一个以上对象都有机会能处理某个请求
- UML
	- ![Chain.jpg](http://doc.yqjdcyy.com/8f6a29f3-6e14-40a7-b395-978cde9d90eb.jpg)


### 绳量|享元模式
- 定义
	- 为某个类提供**多个虚拟**实例
- UML
	- ![FlyWeight.jpg](http://doc.yqjdcyy.com/c854aa9d-305a-404d-a9ad-15f195b1aacc.jpg)


### 解释器模式
- 定义
	- 定**义出其文法**的一种表示，并同时提供一个解释器
- UML
	- ![Interpreter.jpg](http://doc.yqjdcyy.com/8eeb011b-8b13-4c88-b974-b3cd7a6a3ab1.jpg)


### 中介者模式
- 定义
	- 集中相关对象之间复杂的沟通和控制方式
		- 通过将对象彼此解耦，增加对象的复用性
		- 将控制逻辑集中，简化系统维护
- UML
	- ![Mediator-basic.jpg](http://doc.yqjdcyy.com/f684fd68-9725-425c-bf79-5f7fe60eae0d.jpg)
	- ![Mediator-chatRoom.jpg](http://doc.yqjdcyy.com/c0a56875-8b15-4288-93da-e97c19895942.jpg)


### 备忘录
- 定义
	- 在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态
	- 可以将该对象**恢复**到原先保存的状态
- UML
	- ![Memento-basic.jpg](http://doc.yqjdcyy.com/a5499789-d257-4cac-9644-43ac0b653c60.jpg)
	- ![Memento-try.jpg](http://doc.yqjdcyy.com/f7e75659-1ec1-40e5-9757-958f33749217.jpg)



### 原型模式
- 定义
	- 用于在保证性能的前提下，创建重复的对象
	- java.**Clone**able
- UML
	- ![Prototype.jpg](http://doc.yqjdcyy.com/5a4901fb-cf0c-442a-9b5d-58c95195e23a.jpg)



### 访问者模式
- 定义
	- 封装某些作用于某种数据结构中各元素的操作，它可以在不改变数据结构的前提下定义作用于这些元素的新的操作
- UML
	- ![Visitor.jpg](http://doc.yqjdcyy.com/a183d53f-033f-44c8-8070-51eeee88634e.jpg)



## 注意事项
- `实现一个接口`，非特指利用`implement`关键词实现接口，泛指`实现某个超类型的某个方法`
- 模式是在某情境下，针对某问题的某种解决方案
	- 针对该问题约束的，可以解决此约束的通用设计
	- 关键词：问题、情境、解决方案
- 推荐书籍
	- 设计模式：可利用面向对象软件的基础
	- The Timeless Way of building
	- A Pattern Language


## 参考

### 书籍
- 《HEAD_FIRST 设计模式》
- [图说设计模式](http://design-patterns.readthedocs.io/zh_CN/latest/)
- [design pattern 包教不包会](https://wizardforcel.gitbooks.io/design-pattern-lessons/)

### 扩展
- [spring事件驱动模型--观察者模式在spring中的应用](https://www.cnblogs.com/fingerboy/p/6393644.html)

### 资源
- [yqjdcyy/设计模式](http://domain.yqjdcyy.com/post/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/)