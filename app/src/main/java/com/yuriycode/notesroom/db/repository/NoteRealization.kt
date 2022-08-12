package com.yuriycode.notesroom.db.repository

import androidx.lifecycle.LiveData
import com.yuriycode.notesroom.db.dao.NoteDao
import com.yuriycode.notesroom.model.NoteModel

class NoteRealization(private val noteDao: NoteDao): NoteRepository {
    override val allNotes: LiveData<List<NoteModel>>
        get() = noteDao.getAllNotes()

    override suspend fun insertNotes(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.insert(noteModel)
        onSuccess
    }

    override suspend fun deleteNotes(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.delete(noteModel)
        onSuccess
    }


}