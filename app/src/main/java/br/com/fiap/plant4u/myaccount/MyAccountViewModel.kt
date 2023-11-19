package br.com.fiap.plant4u.myaccount

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MyAccountViewModel {

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _currPassword = MutableLiveData<String>()
    val currPassword: LiveData<String> = _currPassword

    private val _newPassword = MutableLiveData<String>()
    val newPassword: LiveData<String> = _newPassword


    fun onCurrPasswordChange(newCurrPassword: String) {
        _currPassword.value = newCurrPassword
    }

    fun onNewPasswordChange(newPassword: String) {
        _newPassword.value = newPassword
    }

}