package com.example.cp2_rm551534

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var taskAdapter: TaskAdapter

    private val tasks = mutableListOf<Task>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        tasks.add(Task("Tarefa 1", "Descrição da Tarefa 1", "Alta"))
        tasks.add(Task("Tarefa 2", "Descrição da Tarefa 2", "Média"))
        tasks.add(Task("Tarefa 3", "Descrição da Tarefa 3", "Baixa"))

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        taskAdapter = TaskAdapter(tasks)
        recyclerView.adapter = taskAdapter
    }
}
