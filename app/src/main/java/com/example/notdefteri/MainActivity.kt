package com.example.notdefteri

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var titleInput: EditText
    private lateinit var noteInput: EditText
    private lateinit var addBtn: Button
    private lateinit var list: ListView

    private val notes = mutableListOf<Note>()
    private lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleInput = findViewById(R.id.titleInput)
        noteInput = findViewById(R.id.noteInput)
        addBtn = findViewById(R.id.addNoteButton)
        list = findViewById(R.id.notesListView)

        adapter = NoteAdapter(this, notes)
        list.adapter = adapter

        addBtn.setOnClickListener {
            val title = titleInput.text.toString()
            val content = noteInput.text.toString()

            if (title.isNotEmpty() && content.isNotEmpty()) {
                notes.add(Note(title, content))
                adapter.notifyDataSetChanged()

                titleInput.text.clear()
                noteInput.text.clear()
            }
        }
    }
}
