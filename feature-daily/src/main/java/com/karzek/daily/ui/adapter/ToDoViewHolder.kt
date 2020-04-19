package com.karzek.daily.ui.adapter

import android.view.View
import com.karzek.core.ui.base.BaseViewHolder
import com.karzek.daily.domain.todo.model.ToDo
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.view_holder_todo.description

class ToDoViewHolder(
    override val containerView: View
) : BaseViewHolder<ToDo>(containerView), LayoutContainer {

    override fun bindType(model: ToDo) {
        description.text = model.description
    }

}