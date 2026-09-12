package mx.joshh.appsipinna

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import mx.joshh.appsipinna.ui.navigation.RietiNavGraph
import mx.joshh.appsipinna.ui.theme.RietiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // enableEdgeToEdge() permite que el contenido se dibuje bajo las barras del sistema.
        enableEdgeToEdge()
        
        setContent {
            RietiTheme {
                val navController = rememberNavController()
                RietiNavGraph(navController = navController)
            }
        }
    }
}
