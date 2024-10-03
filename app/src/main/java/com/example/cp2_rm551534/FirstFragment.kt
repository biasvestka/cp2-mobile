package com.example.cp2_rm551534

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {
    private val tasks = mutableListOf<Task>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editTextTaskName: EditText = view.findViewById(R.id.editTextTaskName)
        val editTextTaskDescription: EditText = view.findViewById(R.id.editTextTaskDescription)
        val spinnerPriority: Spinner = view.findViewById(R.id.spinnerPriority)
        val submitButton: Button = view.findViewById(R.id.submitButton)
        val buttonViewTasks: Button = view.findViewById(R.id.button_view_tasks)

        val priorities = arrayOf("Baixa", "Média", "Alta")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, priorities)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerPriority.adapter = adapter

        submitButton.setOnClickListener {
            val taskName = editTextTaskName.text.toString()
            val taskDescription = editTextTaskDescription.text.toString()
            val priority = spinnerPriority.selectedItem.toString()

            tasks.add(Task(taskName, taskDescription, priority))
            editTextTaskName.text.clear()
            editTextTaskDescription.text.clear()
            spinnerPriority.setSelection(0)
        }

        buttonViewTasks.setOnClickListener {
            val intent = Intent(requireContext(), SecondActivity::class.java)
            startActivity(intent)
        }
    }
}
