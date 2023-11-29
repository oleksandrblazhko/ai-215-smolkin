package com.project.vocalmentor

package com.project.vocalmentor.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.project.vocalmentor.constants.Song
import com.project.vocalmentor.databinding.ActivityMainBinding
import com.project.vocalmentor.model.SongList
import com.project.vocalmentor.repository.SongListRepository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.songList.setOnClickListener {
            makeSongList(5 , "Джаз")
        }
    }

    private fun makeSongList(numberSong: Int, genre: String): List<SongList> {

        var result: Int = 0
        var songs: List<SongList> = emptyList()

        if (numberSong <= 0) {
            Toast.makeText(this, "Введіть правильну кількість пісень", Toast.LENGTH_SHORT).show()
            result = -1
        }
        else {
            songs = when (genre) {
                "Джаз" -> {
                    result = 1
                    Song.getListSongJas(numberSong)
                }
                "Рок" -> {
                    result = 1
                    Song.getListSongRock(numberSong)
                }
                "Поп" -> {
                    result = 1
                    Song.getListSongPop(numberSong)
                }

                else -> {
                    result = -2
                    Toast.makeText(this, "Введіть існуючий жанр", Toast.LENGTH_SHORT).show()
                    emptyList()
                }
            }
            if (songs.isNotEmpty())
                SongListRepository().createSongList(songs)
            return songs
        }

        return songs
    }
}