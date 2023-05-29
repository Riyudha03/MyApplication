package com.example.myapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ContentAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var contentAdapter: ContentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up the RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        contentAdapter = ContentAdapter(createDummyContentList(), this)
        recyclerView.adapter = contentAdapter

        // Set up the buttons
        val addButton: View = findViewById(R.id.addButton)
        addButton.setOnClickListener {
            Toast.makeText(this, "Add button clicked", Toast.LENGTH_SHORT).show()
        }

        val deleteButton: View = findViewById(R.id.deleteButton)
        deleteButton.setOnClickListener {
            Toast.makeText(this, "Delete button clicked", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.sidebarButton -> {
                Toast.makeText(this, "Sidebar button clicked", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onItemClick(position: Int) {
        // Handle item click, navigate to content view page
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        // Add your code here to start the content view activity with detailed information
    }

    private fun createDummyContentList(): List<String> {
        // Create a dummy list of content
        val contents = mutableListOf<String>()
        for (i in 1..10) {
            contents.add("Content $i")
        }
        return contents
    }
}