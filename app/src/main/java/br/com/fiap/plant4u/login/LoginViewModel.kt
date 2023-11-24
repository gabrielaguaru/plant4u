package br.com.fiap.plant4u.login

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import br.com.fiap.plant4u.model.LoginUser
import br.com.fiap.plant4u.model.User
import br.com.fiap.plant4u.service.RetrofitFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _loginState = MutableLiveData<User>()
    val loginState: LiveData<User> = _loginState

    private val _showError = MutableLiveData<Boolean>()
    val showError: LiveData<Boolean> = _showError

    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
    }

    fun onShowErrorChange(newShowError: Boolean) {
        _showError.value = newShowError
    }
}

fun performLogin(email: String, password: String, context: Context, navController: NavController) {
    val user = LoginUser(email = email, password = password)

    GlobalScope.launch(Dispatchers.IO) {
        try {
            val response = RetrofitFactory().getAuthService().authenticateUser(user)

            if (response.isSuccessful) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Login bem sucedido", Toast.LENGTH_SHORT).show()
                    navController.navigate("home/${response.body()?.fullName}/${response.body()?.userId?.toLong()}")
                }
            } else {
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Erro no login. Tente novamente", Toast.LENGTH_SHORT).show()
                }
            }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                Toast.makeText(context, "Ops! Ocorreu um erro. Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}