package com.example.functionalityapp.core.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.functionalityapp.R
import com.example.functionalityapp.core.model.User

class UserAdpter(val users: ArrayList<User>): RecyclerView.Adapter<UserAdpter.ViewHolder>() {

    var onItemClick: ((User) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdpter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.users, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: UserAdpter.ViewHolder, position: Int) {
        holder.bindItems(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        init {
            itemView.setOnClickListener{
                onItemClick?.invoke(users[adapterPosition])
            }
        }

        fun bindItems(user: User){
            val textViewName = itemView.findViewById(R.id.userName) as TextView
            val textViewRole = itemView.findViewById(R.id.userRole) as TextView
            textViewName.text = user.name
            textViewRole.text = user.roleName
        }
    }

}