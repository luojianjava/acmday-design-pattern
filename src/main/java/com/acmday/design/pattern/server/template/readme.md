
## 模板方法模式
- template模式在一个方法中定义一个算法的框架，而将一些步骤延迟到子类中实现。模板方法使得子类可以在不改变算法结构的情况下，重新定义算法中的某些步骤。
- template模式中有一个“钩子”的概念，当你的子类必须提供算法中某个方法的实现时，就使用抽象方法。如果算法的这个部分是可选的，那就使用钩子。
## 使用场景
（1）例如：在银行办理业务时，一般都包含几个基本固定步骤:  
> 取号排队->办理具体业务->对银行工作人员进行评分。  

取号取号排队和对银行工作人员进行评分业务逻辑是一样的。但是办理具体业务是个不相同的，具体业务可能取款、存款或者转账。

（2）咖啡不一样，但是煮各种咖啡的步骤是一样的。