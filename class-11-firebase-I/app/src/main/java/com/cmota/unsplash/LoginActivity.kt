package com.cmota.unsplash

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.cmota.unsplash.repository.AppPreferences
import com.cmota.unsplash.ui.LoginScreen
import com.cmota.unsplash.ui.theme.UnsplashTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class LoginActivity: ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val auth = Firebase.auth
    if (auth.currentUser != null) {
      startActivity(Intent(this, MainActivity::class.java))
      finish()
      return
    }

    enableEdgeToEdge()

    setContent {
      UnsplashTheme(
        darkTheme = AppPreferences(baseContext).isDarkTheme()
      ) {
        Scaffold { innerPadding ->
          Column(
            modifier = Modifier.padding(innerPadding)
          ) {

            val error = remember { mutableStateOf<String?>(null) }

            LoginScreen(
              error = error.value,
              onLoginAction = { username, password ->
                auth
                  .signInWithEmailAndPassword(username, password)
                  .addOnCompleteListener {
                    if (it.isSuccessful) {
                      startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                      finish()
                    } else {
                      error.value = it.exception?.message
                    }
                  }
              },
              onCreateAction = { username, password ->
                auth
                  .createUserWithEmailAndPassword(username, password)
                  .addOnCompleteListener {
                    if (it.isSuccessful) {
                      startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                      finish()
                    } else {
                      error.value = it.exception?.message
                    }
                  }
              }
            )
          }
        }
      }
    }
  }
}