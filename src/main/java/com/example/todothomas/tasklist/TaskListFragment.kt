package com.example.todothomas.tasklist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todothomas.R
import kotlinx.android.synthetic.main.fragment_task_list.*
import java.util.*


class TaskListFragment : Fragment() {

    lateinit var taskListAdapter: TaskListAdapter

    private val taskList = mutableListOf(
        Task(id = "id_1", title = "Task 1", description = "description 1"),
        Task(id = "id_2", title = "Task 2"),
        Task(id = "id_3", title = "Task 3")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_task_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(recyclerView, savedInstanceState)
        taskListAdapter = TaskListAdapter(taskList)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = taskListAdapter

        floatingActionButton.setOnClickListener {
            val newTask = Task(id = UUID.randomUUID().toString(), title = "Task ${taskList.size + 1}")
            taskList.add(newTask)

            taskListAdapter.notifyDataSetChanged()
        }


    }




}