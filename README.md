《Effecive Java 3》个人学习注解版

官方源代码地址:https://github.com/jbloch/effective-java-3e-source-code

《Effective Java 3》

- 中文版：https://pan.baidu.com/s/1tzRKwdRTJuWMGOLSnmaYDQ 
  提取码：jrj9
- 英文版：https://pan.baidu.com/s/1iWqJJ7SYjA8uPl5rxRn1dQ 
  提取码：8wky

---
chapter2：创建和销毁对象

    1.考虑使用静态工厂方法替代构造方法--->无
    优点：
    - 静态工厂与构造器不同的第一大优势在于它们有名称
    - 不必在每次调用它们的时候都创建一个新对象
    - 它们可以返回原返回类型的任何子类型的对象
    - 所返回的对象的类可以随着每次调用而发生变化，这取决于静态工厂方法的参数值
    - 方法返回的对象所属类，在编写包含该静态工厂方法的类时可以不存在
    缺点：
    - 类如果不含公有或者受保护的构造器，就不能被子类化
    - 程序员很难发现它们，在API文档中，它们没有像构造器那样在API文档中明确标识出来
    2.当构造方法参数过多时使用 **builder** **模式**（建造者模式）--->chapter2.item
    3.用私有构造器或者枚举类型强化Singleton属性--->chapter2.item3
    4.通过私有构造器强化不可实例化的能力--->chapter2.item4
    5.优先考虑依赖注入来引用资源--->无
    不要用Singleton和静态工具类来实现依赖一个或者多个底层资源的类，且该资源的行为会影响
    到该类的行为；也不要直接用这个类来创建这些资源。而应该将这些资源或者工厂传给构造器，
    通过它们来创建类。
    6.避免创建不必要的对象--->chapter2.item6
    7.消除过期的对象引用--->chapter2.item7
    8.避免使用终结方法和消除方法--->chapter2.item8    
    9.try-with-resources优先与try-finally--->chapter2.item9
    
chapter3：对于所有对象都通用的方法

    10.覆盖equals时请遵守通用约定--->chapter3.item10
    11.覆盖equals时总要覆盖hashCode--->chapter3.item11
    12.始终要覆盖toString--->chapter3.item12
    13.谨慎地覆盖clone--->chapter3.item13
    14.考虑实现Comparable接口--->chapter3.item14