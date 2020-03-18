package com.example.foty.mykotlin.net

import com.example.foty.mykotlin.base.BasePresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Create by lxx
 * Date : 2020/3/18 17:17
 * Use by
 */
object RequestManager {

    fun <E> execute(presenter: BasePresenter<*>, observable: Observable<BaseResponse<E>>, observer: BaseObserver<E>) {
        observable.map(ResponseConvert())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }

}
