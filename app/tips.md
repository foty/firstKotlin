ViewPager  
* 滑动监听器(addOnPageChangeListener)
* 适配器(主要内容)。继承FragmentStatePagerAdapter(有两种超类)，超类构造方法需要一个FragmentManager的对象。一般情况下使用getSupportFragmentManager()获取即可，
但是如果在fragment中嵌套了fragment(与TabLayout连用很容易出现这种情况)就不是使用getSupportFragmentManager()了，而是使用一个专门针对fragment内嵌套fragment的
FragmentManager对象，叫 getChildFragmentManager()。随后实现父类的几个方法即可:getPageTitle设置TabLayout的标题
* 关联TabLayout。


TabLayout
* 使用 setupWithViewPager(ViewPager vp) 与viewPager关联