package com.cmota.unsplash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import com.cmota.unsplash.data.images.UnsplashItem
import com.cmota.unsplash.repository.AppPreferences
import com.cmota.unsplash.ui.theme.UnsplashTheme

class ImageActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val image = intent.getParcelableExtra<UnsplashItem>("image") ?: return

    setContent {
      UnsplashTheme(
        darkTheme = AppPreferences(baseContext).isDarkTheme()
      ) {
        ImageScreen(image)
      }
    }
  }
}

@Composable
fun ImageScreen(image: UnsplashItem) {
  val painter = rememberAsyncImagePainter(
    model = ImageRequest.Builder(LocalContext.current)
      .data(image.urls?.regular)
      .build()
  )

  Image(
    painter = painter,
    contentDescription = stringResource(R.string.description_bcn_sagrada_familia),
    modifier = Modifier.fillMaxSize(),
    contentScale = ContentScale.Crop
  )
}