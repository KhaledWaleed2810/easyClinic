package views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.example.clinic.navigation.navigationModel.Navigation

import com.example.clinic.ViewModel.MainViewModel



class MainActivity : ComponentActivity() {
    private val viewModel : MainViewModel by viewModels()
    lateinit var navController : NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
                viewModel.isLoading.value

        }
        setContent {

            navController = rememberNavController()
            Navigation(navController = navController)


        }
    }
}

