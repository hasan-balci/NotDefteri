package com.example.notdefteri
import android.widget.Button

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class NoteAdapter(
    context: Context,
    private val notes: MutableList<Note>
) : ArrayAdapter<Note>(context, 0, notes) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.note_item, parent, false)

        val titleText = view.findViewById<TextView>(R.id.titleText)
        val contentText = view.findViewById<TextView>(R.id.contentText)
        val deleteBtn = view.findViewById<Button>(R.id.deleteBtn)

        val note = notes[position]
        titleText.text = note.title
        contentText.text = note.content

        deleteBtn.setOnClickListener {
            notes.removeAt(position)
            notifyDataSetChanged()
        }

        return view
    }

}
