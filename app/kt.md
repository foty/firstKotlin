lateinit 延迟初始化  
一般地，属性声明为非空类型必须在构造函数中初始化。但是这样非常的不方便。为处理这种情况，
用 lateinit 修饰符标记该属性。该修饰符只能用于在类体中的属性（不是在主构造函数中声明的 var属性，并且仅当该属性没有自定义 getter 或 setter 时），
而自 Kotlin 1.2 起，也用于顶层属性与局部变量。该属性或变量必须为非空类型，并且不能是原生类型。   

kotlin中的泛型          
泛型擦除  
真泛型(伪泛型)  

扩展函数:
Kotlin 能够扩展一个类的新功能而无需继承该类或者使用像装饰者这样的设计模式。 这通过叫做 扩展 的特殊声明完成。 
例如，你可以为一个你不能修改的、来自第三方库中的类编写一个新的函数。 这个新增的函数就像那个原始类本来就有的函数一样，
可以用普通的方法调用。 这种机制称为 扩展函数 。此外，也有 扩展属性 ， 允许你为一个已经存在的类添加新的属性。
声明一个扩展函数，我们需要用一个 接收者类型 也就是被扩展的类型来作为他的前缀。 
下面代码为 MutableList<Int> 添加一个swap 函数
```
fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // “this”对应该列表
    this[index1] = this[index2]
    this[index2] = tmp
}
```  

内联函数:   
需要使用inline 修饰


 
kotlin中的一些内置函数(let, with, run, apply, also):  
let:  
一个对象多次调用此对象内的多个方法时，
可以使用it代替此对象，返回值为函数最后一行或指定return表达式       
```
a.a1()
a.a2()
a.a3()
a.a4()
// 等价于
a.let{
it.a1()
it.a2()
it.a3()
it.a4()
}
```
with:   
跟let类似，也是适用一个对象多次调用该对象的多个方法时，将此对象以参数形式传入，函数块内以this代替
对象。返回值为函数最后一行或指定return表达式。
```
b.b1()
b.b2()
b.b3()
b.b4()

with(b){
b1()
b2()
b3()
b4()
}
```
run:
加强版的with,只接收一个lambda函数为参数，以闭包形式返回，返回值为最后一行的值或者指定的return的表达式。   
```

```
also:  
与let相似，唯一不同在于返回值是对象本身。适用let的所有场景
```
val i = a.also{
it.a1()
1000
}
// 最后返回1000赋值给i
```
apply:  
与run相似，唯一区别在apply返回值为本身对象。
```
// 假设 对象b有 b1,b2,b3,b4 4个属性，现在要对b实例的属性赋值并赋值给另一个相同对象c
val c = b.apply{
b1()
b2()
b3()
b4()
}
```
UI  
banner (轮播图片)   
FloatingActionButton  (材料设计)   

todo
从0开始写一个recycleviewadapter

git 相关
git config -l

查看此项目下的作者信息   
git config user.name    
git config user.email   

修改此项目下的git作者信息  
git config user.name "xxx"  
git config user.email "xxx"   

查看git全局作者信息  
git config --global user.name  
git config --global user.email  


kt序列化(有3种方式)   
资料参考： ``https://blog.csdn.net/sinat_31057219/article/details/96730938``