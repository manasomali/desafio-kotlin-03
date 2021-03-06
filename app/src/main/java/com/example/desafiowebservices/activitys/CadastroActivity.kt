package com.example.desafiowebservices.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafiowebservices.R
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        button_cadastrotohqs.setOnClickListener {
            startActivity(Intent(this, HqsActivity::class.java))
        }
        button_cadastrotologin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}