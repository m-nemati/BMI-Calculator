package com.example.calcbmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bmi.*

class bmiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        title = "درباره شاخص BMI"

        btnReturn.setOnClickListener {

            val intentReturn = Intent(this, MainActivity::class.java)
            startActivity(intentReturn)
        }
    }
}
