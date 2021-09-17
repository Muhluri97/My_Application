package com.example.functionalityapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.functionalityapp.core.adapter.UserAdpter
import com.example.functionalityapp.core.model.User

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar

        actionBar!!.title = "Destination"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val users = ArrayList<User>()

        users.add(User("Muhluri", "UI Designer"))
        users.add(User("Mixo", "Software Developer"))
        users.add(User("Katlego", "IT Specialist"))

        val adapter = UserAdpter(users)

        recyclerView.adapter = adapter

        adapter.onItemClick = { users ->

            val intent = Intent(this, UsersActivity::class.java)
            intent.putExtra("User", users)
            startActivity(intent)
        }

    }

}