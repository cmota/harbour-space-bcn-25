package com.cmota.unsplash.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun LoginScreen(
  onAction: (String, String) -> Unit
) {
  val username = remember { mutableStateOf("") }
  val password = remember { mutableStateOf("") }

  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(16.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {

    AddCustomTextField(
      text = username,
      hint = R.string.login_username_hint,
      visualTransformation = VisualTransformation.None,
    )

    Spacer(modifier = Modifier.height(8.dp))

    AddCustomTextField(
      text = password,
      hint = R.string.login_password_hint,
      visualTransformation = PasswordVisualTransformation(),
    )

    Spacer(modifier = Modifier.height(16.dp))

    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.End
    ) {

      Button(
        onClick = {
          onAuthenticateUser(username.value, password.value)
        }) {
        Text(
          text = stringResource(id = R.string.login_sign_in)
        )
      }

      Spacer(modifier = Modifier.width(16.dp))

      Button(
        onClick = {
          onRegisterUser(username.value, password.value)
        }) {
        Text(
          text = stringResource(id = R.string.login_register)
        )
      }
    }
  }
}