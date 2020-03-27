ViewPager  
* 滑动监听器(addOnPageChangeListener)
* 适配器(主要内容)。继承FragmentStatePagerAdapter(有两种超类)，超类构造方法需要一个FragmentManager的对象。一般情况下使用getSupportFragmentManager()获取即可，
但是如果在fragment中嵌套了fragment(与TabLayout连用很容易出现这种情况)就不是使用getSupportFragmentManager()了，而是使用一个专门针对fragment内嵌套fragment的
FragmentManager对象，叫 getChildFragmentManager()。随后实现父类的几个方法即可:getPageTitle设置TabLayout的标题
* 关联TabLayout。
* 涉及到一个体验的操作: Viewpager.offscreenPageLimit,设置预加载数量，提升用户体验。

TabLayout
* 使用 setupWithViewPager(ViewPager vp) 与viewPager关联  
* 要想让TabLayout水平滚动，注意添加属性: ``app:tabMode="scrollable"``,如果tab太多又没有设置这个属性可能会导致tab上的
tittle显示不出来。


FlexboxLayout(弹性布局)  可以理解为强大的LinearLayout 布局，在16年google I/O 大会上开源的控件，同时开源的还有ConstraintLayout。
FlexboxLayout 与 LinearLayout的区别在与FlexboxLayout具有换行属性。
* 注意，如果你的项目没有迁移到android X，请使用 1.0.0版本，如果已经使用了android X，请使用1.1.0版本  
* 添加依赖 : compile 'com.google.android:flexbox:1.0.0'
下面是关于这个控件的属性说明:
* flexDirection : 此属性决定主轴项目排列方向。预备值有: row(默认)：水平方向，起点为左边；column：竖直方向，起点在上方；row_reverse：
水平方向，起点在右边；column_reverse : 竖直方向，起点在下方。
* flexWrap ： 决定是否换行以及换行格式。值有 nowrap : 不换行(默认)；wrap：顺方向换行；wrap_reverse : 逆方向=换行。
* justifyContent： 对齐方式。flex_start : 左对齐(默认)；flex_end : 右对齐；center : 居中；space_between ： 
两端对齐，内容之间距离相等；space_around ： 只有两侧距离相等，内容之间距离比两侧距离大。


retrofit的使用
* 创建retrofit对象
* 创建请求的服务


OkHttp创建: 都是通过OkHttpClient.Builder()对象来完成一系列的构建，最后调用build()方法转换成
OkHttpClient对象。  
* 设置连接超时
* 设置读，写连接超时
* 设置连接重定向(看需求)
* 设置log拦截器
* 设置cookie拦截器(看需求)