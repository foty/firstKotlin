package com.example.foty.mykotlin.net
import android.util.Log
import io.reactivex.functions.Function
import java.lang.RuntimeException

class ResponseConvert<E> : Function<BaseResponse<E>, E> {
    override fun apply(baseResponse: BaseResponse<E>): E {
        if ("0" != baseResponse.errorCode) {
            throw RuntimeException(baseResponse.errorCode) // baseResponse.errorMsg
        }
        if (baseResponse.data == null) {
            baseResponse.data = "" as E
        }
        return baseResponse.data
    }
}