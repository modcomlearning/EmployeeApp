package com.lit.employeeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import helper.ApiHelper
import org.json.JSONObject

class UpdateEmployee : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_employee)

        //Find All 2 Edittexts and 1 Button
        val id_number = findViewById<EditText>(R.id.id_number)
        val salary = findViewById<EditText>(R.id.salary)
        val btnupdate = findViewById<Button>(R.id.btnupdate)
        btnupdate.setOnClickListener {
            //Create a JSON Object that will Hold input values from Edit Texts.
            val body = JSONObject() //add phone and amount to json object
            body.put("id_number", id_number.text.toString())
            body.put("salary", salary.text.toString())

            //Base API URL
            val api = "https://modcom.pythonanywhere.com/employees"

            //Access the Helper
            val helper = ApiHelper(applicationContext)

            //Trigger the put fucntion in helper class
            // We provide the api link and data body
            helper.put(api, body)
            //DONE
        }
    }
}