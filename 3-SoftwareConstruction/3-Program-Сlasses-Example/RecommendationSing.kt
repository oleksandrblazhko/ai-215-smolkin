package com.project.vocalmentor.model

data class RecommendationSing (
    val song: String,
    val recommendation: String,
    val analyzeVoice: AnalyzeVoice,
    val saveSong: SaveSong
)