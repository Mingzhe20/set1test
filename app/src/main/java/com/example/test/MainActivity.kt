package com.example.test

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var spinner: Spinner
    lateinit var score: EditText
    lateinit var grade: String
    lateinit var result: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.course_selection)
        name = findViewById(R.id.name_edit)
        score = findViewById(R.id.score_edit)
        result = findViewById(R.id.grade_result)

        ArrayAdapter.createFromResource(
            this, R.array.spinner_array, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        val button: Button = findViewById(R.id.btnSubmit)
        button.setOnClickListener { checkGrade() }


        val contactBtn: Button = findViewById(R.id.btnContact)
        contactBtn.setOnClickListener { call() }
    }

    fun checkGrade() {

        val scoreInt: Int = score.text.toString().toInt()
        if (scoreInt >= 80) {
            grade = "A"
        } else if (scoreInt >= 75) {
            grade = "A-"
        } else if (scoreInt >= 70) {
            grade = "B+"
        } else if (scoreInt >= 65) {
            grade = "B"
        } else if (scoreInt >= 60) {
            grade = "B-"
        } else if (scoreInt >= 55) {
            grade = "C+"
        } else if (scoreInt >= 50) {
            grade = "C"
        } else if (scoreInt >= 0) {
            grade = "D"
        }
        result.text = name.text.toString()+", your "+spinner.selectedItem.toString()+" grade is "+grade
        val message = "Graded"
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun call() {
        val phoneNumber="tel:03-3333 3333"
        val intent=Intent(Intent.ACTION_DIAL)
        intent.data= Uri.parse(phoneNumber)

//        val emailAddress = "example@gmail.com"
//        val intent = Intent(Intent.ACTION_SENDTO)
//        intent.data = Uri.parse("mailto:$emailAddress")

        startActivity(intent)

    }
}