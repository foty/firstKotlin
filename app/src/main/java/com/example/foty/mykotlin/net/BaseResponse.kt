package com.example.foty.mykotlin.net

data class BaseResponse<T>(val errorMsg: String, val errorCode: String, var data: T)