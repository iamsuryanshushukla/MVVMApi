package com.example.newapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class MainActivity : AppCompatActivity() {
    lateinit var recyclerAdapter: RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView=findViewById<RecyclerView>(R.id.recylvvein)


        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = RecyclerViewAdapter()
        recyclerView.adapter = recyclerAdapter

        initViewModel()


    }

    fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getRecyclereListObserver().observe(this, Observer<ApiModel> {
            if (it != null){
                recyclerAdapter.setUpdateData(items = it.entries)
            }else{
                Toast.makeText(this,"Error os coming",Toast.LENGTH_LONG).show()
            }
        })
        viewModel.makeApiCall()
    }
}