package com.lit.employeeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import helper.ApiHelper
import org.json.JSONArray

class GetEmployee : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_employee)
        val progress = findViewById<ProgressBar>(R.id.progress)
        //Base API URL
        val api = "https://modcom.pythonanywhere.com/employees"

        //Access the Helper
        val helper = ApiHelper(applicationContext)
        helper.get(api, object : ApiHelper.CallBack{
            override fun onSuccess(result: String?) {
                //Toast.makeText(applicationContext, ""+result.toString(), Toast.LENGTH_SHORT).show()
                //COnvert the GET results to JSON Array
                val booksJSONArray = JSONArray(result.toString())

                //Loop Each Object in the JSONArray
                (0 until booksJSONArray.length()).forEach {
                    val book = booksJSONArray.getJSONObject(it)
                    //FOr each Object Find the TextView and Append the 5 C0lumns
                    val empdata = findViewById<TextView>(R.id.empdata)
                    empdata.append("ID:"+book.get("id_number")+"\n")
                    empdata.append("Username:"+book.get("username")+"\n")
                    empdata.append("Others: "+book.get("others")+"\n")
                    empdata.append("Salary"+book.get("salary")+"\n")
                    empdata.append("Dept: "+book.get("department")+"\n")
                    empdata.append("\n\n")
                    //SInce its a Loop, ALl EMployees are Loaded in the TextView.
                }
                //Stop Progress
                progress.visibility = View.GONE
            }
        })
    }


}