package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var textView2: TextView
    private lateinit var textView3: TextView
    private lateinit var textView4: TextView
    private lateinit var textView5: TextView
    private lateinit var textView6: TextView
    private lateinit var etnama: EditText
    private lateinit var etberat: EditText
    private lateinit var ettinggi: EditText
    private lateinit var radiolaki: RadioButton
    private lateinit var radioperempuan: RadioButton
    private lateinit var btnHitung: Button
    private lateinit var btnReset: Button
    private lateinit var btnKeluar: Button
    private lateinit var tvNama: TextView
    private lateinit var tvAnalisa: TextView
    private lateinit var tvBeratIdeal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView2 = findViewById(R.id.textview2)
        textView3 = findViewById(R.id.textview3)
        textView4 = findViewById(R.id.textview4)
        textView5 = findViewById(R.id.textview5)
        textView6 = findViewById(R.id.textview6)
        etnama = findViewById(R.id.etnama)
        etberat = findViewById(R.id.etberat)
        ettinggi = findViewById(R.id.ettinggi)
        radiolaki = findViewById(R.id.radiolaki)
        radioperempuan = findViewById(R.id.radioperempuan)
        btnHitung = findViewById(R.id.btnHitung)
        btnReset = findViewById(R.id.btnReset)
        btnKeluar = findViewById(R.id.btnKeluar)
        tvNama = findViewById(R.id.tvNama)
        tvAnalisa = findViewById(R.id.tvAnalisa)
        tvBeratIdeal = findViewById(R.id.tvBeratIdeal)
        btnHitung.setOnClickListener(this)

    }
    override fun onClick(v: View?) {
        if(v?.id == R.id.btnHitung){
            val inputNama = etnama.text.toString().trim()
            val inputBerat = etberat.text.toString().trim()
            val inputTinggi = ettinggi.text.toString().trim()
            val inputLaki = radiolaki.isChecked
            val inputPerempuan = radioperempuan.isChecked
            var tinggi = inputTinggi.toDouble()
            var berat = inputBerat.toDouble()

            if (radiolaki.isChecked){
                var hasil = (tinggi - 100) - ((tinggi - 100) * 10 / 100)
                tvNama.text = "Nama : $inputNama"
                tvBeratIdeal.text = "Berat Ideal : ${hasil.toString()}"
                if (berat < hasil){
                    tvAnalisa.text = "Berat badan anda kurang"
                } else if (berat > hasil){
                    tvAnalisa.text = "Beras badan anda berlebih"
                } else {
                    tvAnalisa.text = "Selamat berat badan anda ideal"
                }
            } else if (radioperempuan.isChecked){
                var hasil = (tinggi - 100) - ((tinggi - 100) * 15 / 100)
                tvNama.text = "Nama : $inputNama"
                tvBeratIdeal.text = "Berat badan ideal anda adalah ${hasil.toString()}"
                if (berat < hasil){
                    tvAnalisa.text = "Berat badan anda kurang"
                } else if (berat > hasil){
                    tvAnalisa.text = "Berat badan anda berlebih"
                } else {
                    tvAnalisa.text = "Berat badan anda ideal"
                }
            }
        }
    }
}