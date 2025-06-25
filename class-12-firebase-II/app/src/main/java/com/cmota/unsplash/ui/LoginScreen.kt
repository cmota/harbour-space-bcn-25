package com.cmota.unsplash.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.cmota.unsplash.R

@Composable
fun LoginScreen(
  error: MutableState<String?>,
  onLoginAction: (String, String) -> Unit,
  onCreateAction: (String, String) -> Unit
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

    OutlinedTextField(
      value = username.value,
      onValueChange = { username.value = it },
      label = {
        Text(text = stringResource(id = R.string.login_username))
      },
      modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(8.dp))

    OutlinedTextField(
      value = password.value,
      onValueChange = { password.value = it },
      label = {
        Text(text = stringResource(id = R.string.login_username))
      },
      visualTransformation = PasswordVisualTransformation(),
      modifier = Modifier.fillMaxWidth()
    )

    AnimatedVisibility(visible = error != null) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
      ) {
        Text(
          text = error.value ?: "",
          color = MaterialTheme.colorScheme.error
        )
      }
    }

    Spacer(modifier = Modifier.height(16.dp))

    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.End
    ) {

      Button(
        onClick = {
          onLoginAction(username.value, password.value)
        }) {
        Text(
          text = stringResource(id = R.string.login_account)
        )
      }

      Spacer(modifier = Modifier.width(16.dp))

      Button(
        onClick = {
          onCreateAction(username.value, password.value)
        }) {
        Text(
          text = stringResource(id = R.string.login_create)
        )
      }
    }
  }

  if (error.value != null) {
    ErrorDialog(
      error = error.value ?: stringResource(R.string.info_placeholder),
      onCancelAction = { error.value = null},
      onRetryAction = {
        error.value = null
        onLoginAction(username.value, password.value)
      }
    )
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ErrorDialog(
  error: String,
  onCancelAction: () -> Unit = {},
  onRetryAction: () -> Unit = {}
) {
  AlertDialog(
    onDismissRequest = { onCancelAction() },
    title = { Text(stringResource(R.string.login_error)) },
    text = { Text(error) },
    confirmButton = {
      TextButton(
        onClick = { onRetryAction() }
      ) {
        Text(stringResource(R.string.login_action_retry))
      }
    },
    dismissButton = {
      TextButton(
        onClick = { onCancelAction() }
      ) {
        Text(stringResource(R.string.login_action_cancel))
      }
    }
  )
}