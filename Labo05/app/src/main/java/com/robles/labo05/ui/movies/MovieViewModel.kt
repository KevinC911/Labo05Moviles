package com.robles.labo05.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.robles.labo05.MovieReviewerApplication
import com.robles.labo05.data.model.MovieModel
import com.robles.labo05.repository.MovieRepository

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {

    fun getMovies() = repository.getMovies()

    fun addMovies(movie:MovieModel) = repository.addMovies(movie)

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.movieRepository)
            }
        }
    }
}