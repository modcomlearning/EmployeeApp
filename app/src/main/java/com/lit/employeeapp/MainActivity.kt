package com.lit.employeeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Find POST Button
        val btnpost = findViewById<Button>(R.id.btnpost)
        btnpost.setOnClickListener {
            //Link to PostEmployee Page/Activity
            val x = Intent(applicationContext, PostEmployee::class.java)
            startActivity(x)
        }//end Listener

        //Find GET Button
        val btnget = findViewById<Button>(R.id.btnget)
        btnget.setOnClickListener {
            //Link to GetEmployee Page/Activity
            val x = Intent(applicationContext, GetEmployee::class.java)
            startActivity(x)
        }//end Listener

        //Find PUT Button
        val btnput = findViewById<Button>(R.id.btnput)
        btnput.setOnClickListener {
            //Link to UpdateEmployee Page/Activity
            val x = Intent(applicationContext, UpdateEmployee::class.java)
            startActivity(x)
        }//end Listener

        //Find DELETE Button
        val btndelete = findViewById<Button>(R.id.btndelete)
        btndelete.setOnClickListener {
            //Link to DeleteEmployee Page/Activity
            val x = Intent(applicationContext, DeleteEmployee::class.java)
            startActivity(x)
        }//end Listener


    }//end Oncreate Fun
}//end Class