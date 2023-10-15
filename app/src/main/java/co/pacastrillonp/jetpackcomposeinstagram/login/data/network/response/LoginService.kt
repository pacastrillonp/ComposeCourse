package co.pacastrillonp.jetpackcomposeinstagram.login.data.network.response

import android.util.Log
import co.pacastrillonp.jetpackcomposeinstagram.login.data.network.LoginClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginService @Inject constructor(private val loginClient: LoginClient) {

    suspend fun doLogin(user: String, password: String): Boolean {
        Log.i("pablo", "user: $user")
        Log.i("pablo", "password: $password")
        return withContext(Dispatchers.IO) {
            val response = loginClient.doLogin()
            response.body()?.success ?: false
        }
    }
}