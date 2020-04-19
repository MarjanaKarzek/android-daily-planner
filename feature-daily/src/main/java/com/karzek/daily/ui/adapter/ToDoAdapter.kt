package com.karzek.daily.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.karzek.daily.R
import com.karzek.daily.domain.todo.model.ToDo

class ToDoAdapter : RecyclerView.Adapter<ViewHolder>() {

    private var data = emptyList<ToDo>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ToDoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_todo, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        if (holder is ToDoViewHolder) {
            holder.bindType(data[position])
        }
    }

    fun setData(toDos: List<ToDo>) {
        data = toDos
        notifyDataSetChanged()
    }

}