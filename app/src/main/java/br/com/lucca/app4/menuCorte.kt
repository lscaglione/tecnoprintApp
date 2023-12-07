package br.com.lucca.app4

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class menuCorte : AppCompatActivity() {


    override fun onResume() {
        super.onResume()
        atualizarDadosCorte()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_corte)



        botaoMenuImpressao()
        atualizarDadosCorte()

    }

    fun botaoMenuImpressao() {

        val button: Button = findViewById(R.id.botaTelaInicialCorteParaMenu)

        button.setOnClickListener {
            intent = Intent(this, menuImpressao::class.java)
            startActivity(intent)

        }
    }

    private fun atualizarDadosCorte() {
        val preferences = getSharedPreferences("SharedPreferencesCortes", Context.MODE_PRIVATE)

        // Atualizar para Máquina 1
        atualizarDadosMaquina(
            preferences, "maquina1_", listOf(
                R.id.produtoCorte1, R.id.produtoCorte2, R.id.produtoCorte3, R.id.produtoCorte4,
                R.id.produtoCorte5, R.id.produtoCorte6, R.id.produtoCorte7, R.id.produtoCorte8
            )
        )

        // Atualizar para Máquina 2
        atualizarDadosMaquina(
            preferences, "maquina2_", listOf(
                R.id.produtoCorte9, R.id.produtoCorte10, R.id.produtoCorte11, R.id.produtoCorte12,
                R.id.produtoCorte13, R.id.produtoCorte14, R.id.produtoCorte15, R.id.produtoCorte16
            )
        )
    }

    private fun atualizarDadosMaquina(
        preferences: SharedPreferences,
        prefixo: String,
        textViews: List<Int>
    ) {
        for (i in 1..8) {
            val corte = preferences.getString("${prefixo}produtoCorte$i", "")
            findViewById<TextView>(textViews[i - 1]).text = corte
        }
    }




}
