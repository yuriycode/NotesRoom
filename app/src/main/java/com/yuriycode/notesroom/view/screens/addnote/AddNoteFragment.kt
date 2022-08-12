package com.yuriycode.notesroom.view.screens.addnote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.RecyclerView
import com.yuriycode.notesroom.APP
import com.yuriycode.notesroom.R
import com.yuriycode.notesroom.databinding.FragmentAddNoteBinding
import com.yuriycode.notesroom.model.NoteModel
import com.yuriycode.notesroom.view.adapters.NoteAdapter
import com.yuriycode.notesroom.viewmodel.AddNoteViewModel

class AddNoteFragment : Fragment() {

    lateinit var binding: FragmentAddNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(AddNoteViewModel::class.java)
        binding.btnAddNote.setOnClickListener {
            val title = binding.etAddTitle.text.toString()
            val description = binding.etAddDesc.text.toString()
            viewModel.insert(NoteModel(title = title, description = description)){}
            APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)
        }
        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)
        }
    }
}