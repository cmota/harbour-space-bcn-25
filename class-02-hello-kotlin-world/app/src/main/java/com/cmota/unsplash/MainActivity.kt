package com.cmota.unsplash

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.net.toUri
import com.cmota.unsplash.ui.theme.UnsplashTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show()
    Log.d("MainActivity", "onCreate")

    enableEdgeToEdge()
    setContent {
      UnsplashTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

          Column {
            Greeting(
              name = "Android",
              modifier = Modifier.padding(innerPadding)
            )

            Button(
              onClick = {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = "tel:1234567890".toUri()
                startActivity(intent)
                finish()
              }
            ) {
              Text(stringResource(R.string.btn_call_me))
            }
          }
        }
      }
    }
  }

  override fun onResume() {
    super.onResume()
    Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()
    Log.d("MainActivity", "onResume")
  }

  override fun onPause() {
    Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show()
    Log.d("MainActivity", "onPause")
    super.onPause()
  }

  override fun onDestroy() {
    Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show()
    Log.d("MainActivity", "onDestroy")
    super.onDestroy()
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!",
    modifier = modifier
  )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  UnsplashTheme {
    Greeting("Android")
  }
}