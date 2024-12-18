package com.example.readerapp.screens.login



data class LoadingState(val Statuse: Status,val message:String?=null) {

   companion object{
       val IDLE = LoadingState(Status.IDLE)
       val SUCCESS = LoadingState(Status.SUCCESS)
       val LOADING = LoadingState(Status.LOADING)
       val FAILED = LoadingState(Status.FAILED)
   }
    enum class Status{

        SUCCESS,
        FAILED,
        LOADING,
        IDLE
    }

}