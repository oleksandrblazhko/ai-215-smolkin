package com.project.vocalmentor.model

data class SongList (
    val name: String,
    val time: Int,
    val author: String,
    val user: User,
    val recommendationSong: RecommendationSong
)