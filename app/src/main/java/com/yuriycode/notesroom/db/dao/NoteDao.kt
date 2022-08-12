package com.yuriycode.notesroom.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.yuriycode.notesroom.model.NoteModel

@Dao
interface NoteDao {

    @Insert
    suspend fun insert(noteModel: NoteModel)

    @Insert
    suspend fun delete(noteModel: NoteModel)

    @Query("SELECT * from note_table")
    fun getAllNotes(): LiveData<List<NoteModel>>
}