package co.pacastrillonp.jetpackcomposeinstagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.pacastrillonp.jetpackcomposeinstagram.login.data.LoginRepository
import co.pacastrillonp.jetpackcomposeinstagram.login.data.network.LoginClient
import co.pacastrillonp.jetpackcomposeinstagram.login.data.network.response.LoginService
import co.pacastrillonp.jetpackcomposeinstagram.login.domain.LoginUseCase
import co.pacastrillonp.jetpackcomposeinstagram.login.ui.LoginScreen
import co.pacastrillonp.jetpackcomposeinstagram.login.ui.LoginViewModel
import co.pacastrillonp.jetpackcomposeinstagram.ui.theme.JetpackComposeInstagramTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val loginViewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeInstagramTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen(loginViewModel)
                }
            }
        }
    }
}