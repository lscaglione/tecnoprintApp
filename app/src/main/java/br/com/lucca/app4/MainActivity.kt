package br.com.lucca.app4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botao1: Button = findViewById(R.id.botao1)
        botao1.setOnClickListener {
            val intent = Intent(this, inserirImpressao::class.java)
            startActivity(intent)

        }


    }
}