package com.example.calcbmi

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "محاسبه BMI"

        btnCalcBmi.setOnClickListener {

            val weight: Double = edWeight.text.toString().toDouble()
            val height: Double = (edHeight.text.toString().toDouble()) / 100

            val bmi: Double = weight / (height * height)

            when (bmi) {

                in 0.0..16.5 -> {
                    txtResult.text = "شما با کمبود شدید وزن رو به رو هستید"
                    txtResult.setTextColor(getColor(R.color.LightBlue))
                }
                in 16.5..18.5 -> {
                    txtResult.text = "شما با کمبود وزن رو به رو هستید"
                    txtResult.setTextColor(getColor(R.color.green))
                }
                in 18.5..25.0 -> {
                    txtResult.text = "وزن شما عادی است"
                    txtResult.setTextColor(getColor(R.color.violet))
                }
                in 25.0..30.0 -> {
                    txtResult.text = "شما اضافه وزن دارید"
                    txtResult.setTextColor(getColor(R.color.orange))
                }
                else -> {
                    txtResult.text = "شما با چاقی وزن رو به رو هستید"
                    txtResult.setTextColor(getColor(R.color.red))
                }

            }
        }

        txtWebsite.setOnClickListener {

            val url = Uri.parse("http://schoolhelp.ir")
            val intentWeb = Intent(Intent.ACTION_VIEW, url)
            if(intentWeb.resolveActivity(packageManager) != null){
                startActivity(intentWeb)
            }
        }

        btnMoreBmi.setOnClickListener {
            val intentBmi = Intent(this, bmiActivity::class.java)
            startActivity(intentBmi)
        }

    }
}
