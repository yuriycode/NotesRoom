package com.yuriycode.notesroom.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.yuriycode.notesroom.REPOSITORY
import com.yuriycode.notesroom.db.NoteDatabase
import com.yuriycode.notesroom.db.repository.NoteRealization
import com.yuriycode.notesroom.model.NoteModel


class StartViewModel(application: Application): AndroidViewModel(application)  {

    val context = application

    fun initDatabase() {
        val daoNote = NoteDatabase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealization(daoNote)
    }

    fun getAllNotes(): LiveData<List<NoteModel>>{
        return REPOSITORY.allNotes
    }
}