/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter to find the
 * most up to date changes to the libraries and their usages.
 */

package com.capstone.ssw.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import androidx.wear.tooling.preview.devices.WearDevices
import com.capstone.ssw.presentation.theme.SSWTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)

        setContent {
            WearApp()
        }
    }
}

@Composable
fun WearApp() {
    SSWTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            contentAlignment = Alignment.Center
        ) {
            WearableButtons()
        }
    }
}

@Composable
fun WearableButtons() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        // Emergency Button (Triangle Shape)
        Box(
            modifier = Modifier
                .width(145.dp)
                .height(100.dp)
                .clickable {
                    Toast.makeText(context, "Emergency Button Pressed", Toast.LENGTH_SHORT).show()
                }
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val trianglePath = androidx.compose.ui.graphics.Path().apply {
                    moveTo(size.width / 2, 0f) // Top of the triangle
                    lineTo(size.width, size.height) // Bottom-right
                    lineTo(0f, size.height) // Bottom-left
                    close()
                }
                drawPath(
                    path = trianglePath,
                    color = Color.Red
                )
            }

            // Add text below the triangle
            Text(
                text = "Emergency",
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 8.dp) // Space between triangle and text
            )

        }

        Spacer(modifier = Modifier.height(10.dp))

        // Assistance Button (Rounded Rectangle)
        Box(
            modifier = Modifier
                .width(140.dp)
                .height(90.dp)
                .background(Color.Yellow, shape = RoundedCornerShape(12.dp))
                .clickable {
                    Toast.makeText(context, "Assistance Button Pressed", Toast.LENGTH_SHORT).show()
                },
            contentAlignment = Alignment.Center // Align content (text) at the center
        ) {
            Text(
                text = "Assistance",
                color = Color.Black,
                fontSize = 16.sp
            )
        }

    }
}

@Preview(device = WearDevices.SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    WearApp()
}