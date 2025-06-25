package com.cmota.unsplash.repository

import android.content.Context

private const val KEY_DARK_THEME = "dark_theme"
private const val KEY_DARK_THEME_DEFAULT = false

class AppPreferences (context: Context) {

  val preferences = context.getSharedPreferences("config", Context.MODE_PRIVATE)

  fun isDarkTheme(): Boolean {
    return preferences.getBoolean(KEY_DARK_THEME, KEY_DARK_THEME_DEFAULT)
  }

  fun setDarkTheme(value: Boolean) {
    val editor = preferences.edit()
    editor.putBoolean(KEY_DARK_THEME, value)
    editor.apply()
  }
}