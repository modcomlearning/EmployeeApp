package com.lit.employeeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import helper.ApiHelper
import org.json.JSONObject

class PostEmployee : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_employee)
        //Find All 5 Edittexts and 1 Button
        val id_number = findViewById<EditText>(R.id.id_number)
        val username = findViewById<EditText>(R.id.username)
        val others = findViewById<EditText>(R.id.others)
        val salary = findViewById<EditText>(R.id.salary)
        val department = findViewById<EditText>(R.id.department)
        val btnsave = findViewById<Button>(R.id.btnsave)
        btnsave.setOnClickListener {
            //Create a JSON Object that will Hold input values from Edit Texts.
            val body = JSONObject() //add phone and amount to json object
            body.put("id_number", id_number.text.toString())
            body.put("username", username.text.toString())
            body.put("others", others.text.toString())
            body.put("salary", salary.text.toString())
            body.put("department", department.text.toString())

            //Base API URL
            val api = "https://modcom.pythonanywhere.com/employees"

            //Access helper
            val helper = ApiHelper(applicationContext)

            //Trigger the post fucntion in helper class
            // We provide the api link and data body.
            helper.post(api, body)
            //DONE
        }


    }
}