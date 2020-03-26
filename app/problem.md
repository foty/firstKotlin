1、 原来项目 as3.0 + kotlin 1.1.51 编译没有问题，修改为as 3.0 + kotlin 1.3.10编译失败，错误信息为   
`` Failed to resolve: org.jetbrains.kotlin:kotlin-stdlib-jre7:1.3.10``   
解决方案 : https://blog.csdn.net/mercyT/article/details/86586240 

2、Dex archives: setting .DEX extension only for .CLASS files    
这个错误大多是编译器抽风导致，实际项目没有问题，重新clean，build或者运行即可。

3、 ``java.lang.IllegalStateException: Fragment already added``   
处理方案： 一开始使用fragmentManager提交事务,后来修改使用childFragmentManager解决问题；tip:``fragment嵌套fragment一定
要使用childFragmentManager``