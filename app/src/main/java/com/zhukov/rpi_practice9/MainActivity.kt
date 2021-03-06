package com.zhukov.rpi_practice9

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zhukov.rpi_practice9.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CustomAdapter(fillList())

        pressedButtonName()
        pressedButtonPhone()
        pressedButtonSex()
    }

    private fun fillList(): List<Person> {
        val data = mutableListOf<Person>()
        data.apply{
            add(Person("male","Pasha","4361"))
            add(Person("male","Sasha","1235"))
            add(Person("male","Zhenia","125"))
            add(Person("male","Misha","39573"))
            add(Person("male","Nikita","1683"))
            add(Person("male","Vadim","147"))
            add(Person("female","Ulia","811"))
            add(Person("female","Sasha","1244"))
            add(Person("female","Masha","8356"))
            add(Person("female","Zina","852"))
            add(Person("female","Margo","26"))
            add(Person("male","Pasha","3236"))
            add(Person("female","Masha","346"))
            add(Person("male","Fedia","421"))
            add(Person("female","Igrid","1123"))
        }
        Log.d("ggs",data.toString())
        return data
    }

    private fun pressedButtonName(){
        binding.btnName.setOnClickListener {
            sortedBy(fillList(),1)
        }
    }

    private fun pressedButtonPhone(){
        binding.btnPhone.setOnClickListener {
            sortedBy(fillList(),2)
        }
    }

    private fun pressedButtonSex(){
        binding.btnSex.setOnClickListener {
            sortedBy(fillList(),3)
        }
    }

    private fun sortedBy(arList: List<Person>, sortBy: Int){
        when (sortBy) {
            1 -> {
                recyclerView.adapter = CustomAdapter(arList.sortedBy { it.name })
            }
            2 -> {
                recyclerView.adapter = CustomAdapter(arList.sortedBy { it.phoneNumber })
            }
            else -> {
                recyclerView.adapter = CustomAdapter(arList.sortedBy { it.sex })
            }
        }
    }
}