package br.com.lucca.app4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class menuImpressao : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_impressao)

        val botao1: Button = findViewById(R.id.botao1)
        botao1.setOnClickListener {
            val intent = Intent(this, inserirImpressao::class.java)
            startActivity(intent)

        }


    }
}