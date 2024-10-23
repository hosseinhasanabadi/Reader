package com.example.readerapp.screens.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class LoginScreenViewModel:ViewModel() {
//    val loadingState = MutableStateFlow(LoadingState.IDLE)
    private val auth:FirebaseAuth =Firebase.auth
    private val _loading = MutableLiveData(false)
    val loading:LiveData<Boolean> =_loading


    fun singUserWithEmailAndPassword(email:String,password:String,home:()->Unit)
    =viewModelScope.launch{
        try {
            auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener { task->
                    if (task.isSuccessful){
                        Log.d("FB","singUserWithEmailAndPassword:yasssss ${task.result.toString()}")
                       // TODO("take them home")
                        home()
                    }else
                        Log.d("FB","singUserWithEmailAndPassword: ${task.result.toString()}")

                }

        }catch (ex:Exception){
            Log.d("FB","singUserWithEmailAndPassword:${ex.message}")
        }

    }
fun createUserWithEmailAndPassword(email: String,
                                   password: String,
                                   home: () -> Unit) {
    if (_loading.value == false) {
        _loading.value = true
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    //me
                  //  val displayName = task.result?.user?.email?.split('@')?.get(0)
                 //   createUser(displayName)
                    home()
                }else {
                    Log.d("FB", "createUserWithEmailAndPassword: ${task.result.toString()}")

                }
                _loading.value = false


            }
    }