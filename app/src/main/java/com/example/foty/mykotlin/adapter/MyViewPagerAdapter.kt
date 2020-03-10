package com.example.foty.mykotlin.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter

/**
 * Create by lxx
 * Date : 2020/3/10 16:39
 * Use by
 */
class MyViewPagerAdapter(fManager: FragmentManager) : FragmentStatePagerAdapter(fManager) {
    private lateinit var fragments: List<Fragment>
    private lateinit var titles: List<String>

    /**
     *
     */
    fun setFragments(fragments: List<Fragment>) {
        this.fragments = fragments
    }

    /**
     *
     */
    fun setFragmentsAndTitles(fragments: List<Fragment>, titles: List<String>) {
        this.fragments = fragments
        this.titles = titles
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titles[position]
    }


    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    /**
     * POSITION_NONE 表示该 Item 会被 destroyItem方法remove 掉，然后重新加载，
     * POSITION_UNCHANGED 表示不会重新加载，默认是 POSITION_UNCHANGED
     */
    override fun getItemPosition(`object`: Any?): Int {
//        return super.getItemPosition(`object`)
        return PagerAdapter.POSITION_NONE
    }
}