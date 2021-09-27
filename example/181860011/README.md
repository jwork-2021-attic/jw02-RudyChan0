# W02
**181860011 陈彦如**

## task1

### 类图
![](https://github.com/jwork-2021/jw02-RudyChan0/blob/master/example/181860011/uml/example.png)

### 时序图
![](https://github.com/jwork-2021/jw02-RudyChan0/blob/master/example/181860011/uml/timeLine.png)

### 设计理念

**关键点**
- Position类和Gourd的互相引用，通过Position作为Gourd的成员变量，Gourd的父接口作为Position的成员变量，来实现Positoin和Gourd的互相引用，使得位置和内容始终可以一一对应并且可以互相调用。

- 排序的实现：先将队列顺序直接作为int数组传入sorter，sorter对数组排序后，输出以两个数一对为单位的置换序列 sortSteps，再调用Geezer的execute函数实现对positions里Gourd的对换排序。好处是使得可以让sorter忽略被排序对象的实现，只需要获得int数组，就能输出排序的方式。使得排序器和被排序对象之间的消息传递简单易用。

- 面向对象的理念，将操作者Geezer，排序器sorter，队列整体Line（内部类Position），队列单元Gourd封装成类（或Enum），使用接口Linable和Sorter来实现灵活引用。

## task2

将Gourd设置为class，定义静态变量gourds，通过调用Gourd.generateGourds(num)，生成所需的随机颜色单位。  
在Line中调用randomPut(Gourd.getGourds())实现随机位置的排布。

### 类图

![](https://github.com/jwork-2021/jw02-RudyChan0/blob/master/example/181860011/uml/task2.png)



### 可视化结果链接
    https://asciinema.org/a/UzCoJZuV3R5i89iTPEegj1J6e

[![asciicast](https://asciinema.org/a/UzCoJZuV3R5i89iTPEegj1J6e)