package br.com.fiap.plant4u.register

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import br.com.fiap.plant4u.model.User
import br.com.fiap.plant4u.service.RetrofitFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterViewModel {

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _confirmEmail = MutableLiveData<String>()
    val confirmEmail: LiveData<String> = _confirmEmail

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _confirmPassword = MutableLiveData<String>()
    val confirmPassword: LiveData<String> = _confirmPassword

    private val _showErrorEmailOrPassword = MutableLiveData<Boolean>()
    val showErrorEmailOrPassword: LiveData<Boolean> = _showErrorEmailOrPassword

    private val _showError = MutableLiveData<Boolean>()
    val showError: LiveData<Boolean> = _showError

    fun onNameChange(newName: String) {
        _name.value = newName
    }

    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
    }

    fun onConfirmEmailChange(newConfirmEmail: String) {
        _confirmEmail.value = newConfirmEmail
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
    }

    fun onConfirmPasswordChange(newConfirmPassword: String) {
        _confirmPassword.value = newConfirmPassword
    }

    fun onShowErrorEmailOrPasswordChange(newShowError: Boolean) {
        _showErrorEmailOrPassword.value = newShowError
    }

    fun onShowErrorChange(newShowError: Boolean) {
        _showError.value = newShowError
    }

    fun performRegistration(name: String, email: String, password: String, context: Context, navController: NavController) {
        val user = User(fullName = name, email = email, password = password)

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = RetrofitFactory().getAuthService().registerUser(user)

                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(context, "Cadastro concluído! Faça o login para continuar", Toast.LENGTH_SHORT).show()
                        navController.navigate("login")
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(context, "Erro no cadastro. Tente novamente", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Ops! Ocorreu um erro. Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}