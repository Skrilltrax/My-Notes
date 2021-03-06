package me.skrilltrax.notes.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.skrilltrax.notes.MyApplication
import me.skrilltrax.notes.data.Repository
import me.skrilltrax.notes.data.model.NoteData
import me.skrilltrax.notes.utils.PreferenceUtils

class MainActivityViewModel : ViewModel() {

    private val repo: Repository =
        Repository(MyApplication.realm)

    private var _notesList: MutableLiveData<List<NoteData>> = MutableLiveData()
    private var _userName: MutableLiveData<String> = MutableLiveData("User")

    val notesList: LiveData<List<NoteData>>
        get() = _notesList
    val userName: LiveData<String>
        get() = _userName

    init {
        getUserName()
    }

    private fun getUserName() {
        _userName.postValue(PreferenceUtils.getUserName())
    }

    fun changeUserName(name: String) {
        _userName.postValue(name)
    }

    fun getAllNotes() {
        _notesList.postValue(repo.getAllNotes())
    }

    fun saveNote(note: NoteData) {
        repo.addNotes(note)
    }
}
