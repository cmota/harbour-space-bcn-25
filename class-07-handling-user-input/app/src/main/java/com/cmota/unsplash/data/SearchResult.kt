package com.cmota.unsplash.data

data class SearchResult(
  val total: Int? = 0,
  val total_pages: Int? = 0,
  val results: List<UnsplashItem>? = emptyList()
)