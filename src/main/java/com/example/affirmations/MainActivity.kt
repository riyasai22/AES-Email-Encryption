package com.example.affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDataSet= Datasource().loadAffirmations()
        val recyclerView=findViewById<RecyclerView>(R.id.rv_affirmations)
        recyclerView.adapter=ItemAdapter(this,myDataSet)
        recyclerView.setHasFixedSize(true) //since we are have fixed number items in list(affirmations)
    }
}