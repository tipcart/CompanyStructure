package com.wywrot.companystructure

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_employee_item.view.*
import java.util.*

class EmployeeItemAdapter(private val employees: ArrayList<Person>) :
    RecyclerView.Adapter<EmployeeItemAdapter.ToDoItemViewHolder>() {

    class ToDoItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(employee: Person) {
            itemView.apply {
                tvName.text = employee.name
                tvEmployeeId.text = itemView.context
                    .getString(R.string.employee_id, employee.employeeId.toString())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoItemViewHolder =
        ToDoItemViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_employee_item, parent, false)
        )

    override fun getItemCount(): Int = employees.size

    override fun onBindViewHolder(holder: ToDoItemViewHolder, position: Int) =
        holder.bind(employees[position])
}
