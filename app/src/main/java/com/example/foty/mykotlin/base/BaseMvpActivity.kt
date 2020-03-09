package com.example.foty.mykotlin.base

import android.os.Bundle
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Create by lxx
 * Date : 2020/3/9 14:47
 * Use by
 */
abstract class BaseMvpActivity<P : BasePresenter<*>> : BaseActivity() {
    lateinit var presenter: P

    abstract fun initPresenter(): P

    override fun onCreate(savedInstanceState: Bundle?) {
        presenter = initPresenter()
        super.onCreate(savedInstanceState)
    }

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    /**
     * 添加到订阅
     */
    fun addDisposable(disposable: Disposable) {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.add(disposable)
        }
    }

    /**
     * 移除订阅
     */
    fun removeDisposable(disposable: Disposable) {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.remove(disposable)
        }
    }

    /**
     * 清空
     */
    fun detach() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.clear()
        }
    }
}