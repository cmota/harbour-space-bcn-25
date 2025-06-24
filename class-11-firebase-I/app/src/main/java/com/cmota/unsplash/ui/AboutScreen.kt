package com.cmota.unsplash.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.cmota.unsplash.R
import com.cmota.unsplash.repository.AppPreferences

@Composable
fun AboutScreen(
  modifier: Modifier = Modifier,
  appPreferences: AppPreferences,
  isDarkTheme: MutableState<Boolean>
 ) {
  Column {
    Row(
      modifier = Modifier.padding(16.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        text = stringResource(R.string.about_dark_theme)
      )

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
      ) {
        Switch(
          checked = isDarkTheme.value,
          onCheckedChange = {
            isDarkTheme.value = !isDarkTheme.value
            appPreferences.setDarkTheme(isDarkTheme.value)
          }
        )
      }
    }

    Column(
      modifier = Modifier.fillMaxSize().padding(16.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
    ) {
      Text(
        text = stringResource(R.string.about_info),
        modifier = modifier,
        textAlign = TextAlign.Center
      )

      Spacer(modifier = Modifier.height(50.dp))


      Row {
        Image(
          painterResource(R.drawable.ic_android),
          modifier = Modifier
            .size(50.dp),
          contentDescription = "Android Logo"
        )

        Spacer(modifier = Modifier.width(32.dp))

        Image(
          painterResource(R.drawable.ic_kotlin),
          modifier = Modifier
            .size(50.dp),
          contentDescription = "Kotlin Logo"
        )
      }
    }
  }
}
