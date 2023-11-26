package br.com.lucca.app4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class menuCorte : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_corte)

        val button: Button = findViewById(R.id.botaTelaInicialCorteParaMenu)

        button.setOnClickListener {
            intent = Intent(this, menuImpressao::class.java)
            startActivity(intent)

        }
    }
}