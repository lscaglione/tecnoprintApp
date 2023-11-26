package br.com.lucca.app4

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class menuImpressao : AppCompatActivity() {

    private val PREFS_NAME = "MinhasPreferencias"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_impressao)

        val botao1: Button = findViewById(R.id.botao1)
        botao1.setOnClickListener {
            val intent = Intent(this, inserirImpressao::class.java)
            startActivity(intent)
        }

        val botao2: Button = findViewById(R.id.botao2)
        botao2.setOnClickListener {
            val intent = Intent(this, inserirCorte::class.java)
            startActivity(intent)
        }

        val botao3:Button = findViewById(R.id.botao3)
        botao3.setOnClickListener {
            val intent = Intent(this, menuCorte::class.java)
            startActivity(intent)
        }

        atualizarProduto1()
    }

    private fun atualizarProduto1() {
        val sharedPreferences: SharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val textView: TextView = findViewById(R.id.produto1)


        // Obtém o valor armazenado no SharedPreferences
        val textoArmazenado = sharedPreferences.getString("chave_texto", "")

        // Exibe o valor no TextView
        textView.text = textoArmazenado
    }


}