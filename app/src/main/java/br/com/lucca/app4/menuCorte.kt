package br.com.lucca.app4

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class menuCorte : AppCompatActivity() {

    override fun onResume() {
        super.onResume()
        // Atualiza os dados toda vez que a Activity é retomada.
        atualizarDados()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_corte)

        botaoMenuImpressao()
        atualizarDados()
    }

    fun botaoMenuImpressao() {

        val button: Button = findViewById(R.id.botaTelaInicialCorteParaMenu)

        button.setOnClickListener {
            intent = Intent(this, menuImpressao::class.java)
            startActivity(intent)

        }


    }

    fun atualizarDados() {
        val preferences = getSharedPreferences("SharedPreferencesCortes", Context.MODE_PRIVATE)

        val produtoCorteSelecionado1 = preferences.getString("produtoCorte1", "")
        findViewById<TextView?>(R.id.produtoCorte1).text = produtoCorteSelecionado1


    }
}