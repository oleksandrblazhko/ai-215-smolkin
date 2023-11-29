package com.project.vocalmentor.model

data class SaveSong (
    val song: String,
    val time: Int,
    val author: String,
    val user: User
)