package com.yuriycode.notesroom.db.repository

import androidx.lifecycle.LiveData
import com.yuriycode.notesroom.model.NoteModel

interface NoteRepository {
    val allNotes: LiveData<List<NoteModel>>
    suspend fun insertNotes(noteModel: NoteModel, onSuccess:() -> Unit)
    suspend fun deleteNotes(noteModel: NoteModel, onSuccess:() -> Unit)
}