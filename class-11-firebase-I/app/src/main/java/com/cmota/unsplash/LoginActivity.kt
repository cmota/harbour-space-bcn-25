package com.cmota.unsplash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.cmota.unsplash.repository.AppPreferences
import com.cmota.unsplash.ui.theme.UnsplashTheme

class LoginActivity: ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      UnsplashTheme(
        darkTheme = AppPreferences(baseContext).isDarkTheme()
      ) {
        Scaffold { innerPadding ->
          Column(
            modifier = Modifier.padding(innerPadding)
          ) {

          }
        }
      }
    }
  }
}