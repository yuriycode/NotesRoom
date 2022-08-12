package com.yuriycode.notesroom.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yuriycode.notesroom.REPOSITORY
import com.yuriycode.notesroom.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel: ViewModel() {

    fun insert(noteModel: NoteModel, onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO){
            REPOSITORY.insertNotes(noteModel){
                onSuccess()
            }
        }
}