package com.lit.employeeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import org.json.JSONObject

class DeleteEmployee : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_employee)

        //Find All 1 Edittext and 1 Button
        val id_number = findViewById<EditText>(R.id.id_number)
        val btndelete = findViewById<Button>(R.id.btndelete)
        btndelete.setOnClickListener {
            //Create a JSON Object that will Hold input values from Edit Texts.
            val body = JSONObject() //add phone and amount to json object
            body.put("id_number", id_number.text.toString())

            //Base API URL
            val api = "https://modcom.pythonanywhere.com/employees"

            //Access Helper class
            val helper = ApiHelper(applicationContext)

            //Trigger the delete fucntion in helper class
            // We provide the api link and data body
            helper.delete(api, body)
            //DONE
        }
    }
}