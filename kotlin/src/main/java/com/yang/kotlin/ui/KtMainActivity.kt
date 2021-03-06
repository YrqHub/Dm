package com.yang.kotlin.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.navigation.NavigationView
import com.hjq.toast.ToastUtils
import com.yang.kotlin.R
import com.yang.kotlin.base.KotlinActivity
import com.yang.kotlin.model.bean.SystemModel
import com.yang.kotlin.ui.home.KtHomeFragment
import com.yang.kotlin.ui.navigation.KtNavigationFragment
import com.yang.kotlin.ui.project.KtProjectFragment
import com.yang.kotlin.ui.search.KtSearchFragment
import com.yang.kotlin.ui.system.KtSystemFragment
import com.yang.kotlin.ui.system.KtSystemTypeFragment
import com.yang.kotlin.utils.Constants
import com.yang.sdk.arounter.ARouterConstant
import com.yang.sdk.utils.rxUtils.RxBus
import com.yang.sdk.utils.rxUtils.RxBusMessage
import com.yang.sdk.web.WebActivity
import kotlinx.android.synthetic.main.activity_kt_main.*

/**
 * Describe: kotlin玩安卓主界面
 * Created by Yang on 2019/6/20  16:51
 */
@Route(path = ARouterConstant.KotlinPath.ACTIVITY_KOTLIN_MAIN)
class KtMainActivity : KotlinActivity<KtMainViewModule>(), NavigationView.OnNavigationItemSelectedListener {


    override fun providerVMClass(): Class<KtMainViewModule>? = KtMainViewModule::class.java

    private lateinit var mTabRes: Array<String>
    private val mFragments = arrayListOf<Fragment>()
    private var mFragment: Fragment? = null

    override fun bindLayout(): Int {
        return R.layout.activity_kt_main
    }

    override fun initView() {
        mTabRes = resources.getStringArray(R.array.tab_title)
        navigationView.setNavigationItemSelectedListener(this)
        btnSearch.setOnClickListener {
            mFragment = KtSearchFragment()
            attachFragment()
        }
        initFragments()
        initViewPager()
        initRxBus()
    }

    private fun initRxBus() {
        RxBus.getInstanceBus().doSubscribe(RxBusMessage::class.java) {
            when (it.code) {
                Constants.RX_SYSTEM_TYPE_ATTACH -> {
                    mFragment = KtSystemTypeFragment(it.`object` as SystemModel)
                    attachFragment()
                }
                Constants.RX_SYSTEM_TYPE_DETACH -> detachFragment()
                Constants.RX_SEARCH_PAGE_DETACH -> detachFragment()
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_collect -> ToastUtils.show("Collect!")
            R.id.nav_tools -> goToWeb("https://www.wanandroid.com/tools", "工具")
            R.id.nav_todo -> goToWeb("https://www.wanandroid.com/lg/todo/list/0", "待办")
            R.id.nav_ask -> goToWeb("https://www.wanandroid.com/article/list_by_chapter/1?cid=440", "每日一问")
            R.id.nav_about -> ToastUtils.show("About!")
        }
        return true
    }

    /**
     * 跳转到WebActivity
     */
    private fun goToWeb(url: String, title: String) {
        val bundle = Bundle()
        bundle.putString(com.yang.sdk.constant.Constants.WEB_URL, url)
        bundle.putString(com.yang.sdk.constant.Constants.WEB_TITLE, title)
        readyGo(WebActivity::class.java, bundle)
    }

    /**
     * 初始化Fragments
     */
    private fun initFragments() {
        mFragments.add(KtHomeFragment())
        mFragments.add(KtSystemFragment())
        mFragments.add(KtProjectFragment())
        mFragments.add(KtNavigationFragment())
    }

    /**
     * viewPager绑定Fragment
     */
    private fun initViewPager() {
        viewPager.offscreenPageLimit = mTabRes.size
        viewPager.adapter = object : FragmentStatePagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            override fun getItem(position: Int) = mFragments[position]
            override fun getCount() = mTabRes.size
            override fun getPageTitle(position: Int) = mTabRes[position]
        }
        tabLayout.setupWithViewPager(viewPager)
    }

    /**
     * 添加Fragment
     */
    private fun attachFragment() {
        supportFragmentManager.beginTransaction().run {
            add(android.R.id.content, mFragment!!)
            setCustomAnimations(R.anim.pager_enter_animation, R.anim.pager_exit_animation)
            commitAllowingStateLoss()
        }
    }

    /**
     * 移除Fragment
     */

    private fun detachFragment() {
        supportFragmentManager.beginTransaction().run {
            remove(mFragment!!)
            commitAllowingStateLoss()
            mFragment = null
        }
    }

    override fun onBackPressed() {
        if (mFragment != null) {
            detachFragment()
        } else
            super.onBackPressed()
    }

    override fun onDestroy() {
        super.onDestroy()
        RxBus.getInstanceBus().unSubscribe(this)
    }
}
