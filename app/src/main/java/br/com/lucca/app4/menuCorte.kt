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
        atualizarDadosCorte()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_corte)



        botaoMenuImpressao()

    }

    fun botaoMenuImpressao() {

        val button: Button = findViewById(R.id.botaTelaInicialCorteParaMenu)

        button.setOnClickListener {
            intent = Intent(this, menuImpressao::class.java)
            startActivity(intent)

        }


    }

    fun atualizarDadosCorte() {
        val preferences = getSharedPreferences("SharedPreferencesCortes", Context.MODE_PRIVATE)

        val maquinaEscolhida = preferences.getString("maquinaCorte", "")

        val produtoCorteSelecionado1 = preferences.getString("produtoCorte1", "")
        val produtoCorteSelecionado2 = preferences.getString("produtoCorte2", "")
        val produtoCorteSelecionado3 = preferences.getString("produtoCorte3", "")
        val produtoCorteSelecionado4 = preferences.getString("produtoCorte4", "")
        val produtoCorteSelecionado5 = preferences.getString("produtoCorte5", "")
        val produtoCorteSelecionado6 = preferences.getString("produtoCorte6", "")
        val produtoCorteSelecionado7 = preferences.getString("produtoCorte7", "")
        val produtoCorteSelecionado8 = preferences.getString("produtoCorte8", "")

        val produtoCorteSelecionado9 = preferences.getString("produtoCorte9", "")
        val produtoCorteSelecionado10 = preferences.getString("produtoCorte10", "")
        val produtoCorteSelecionado11 = preferences.getString("produtoCorte11", "")
        val produtoCorteSelecionado12 = preferences.getString("produtoCorte12", "")
        val produtoCorteSelecionado13 = preferences.getString("produtoCorte13", "")
        val produtoCorteSelecionado14 = preferences.getString("produtoCorte14", "")
        val produtoCorteSelecionado15 = preferences.getString("produtoCorte15", "")
        val produtoCorteSelecionado16 = preferences.getString("produtoCorte16", "")

        if (maquinaEscolhida == "Máquina 1") {

            findViewById<TextView?>(R.id.produtoCorte1).text = produtoCorteSelecionado1


            findViewById<TextView?>(R.id.produtoCorte2).text = produtoCorteSelecionado2


            findViewById<TextView?>(R.id.produtoCorte3).text = produtoCorteSelecionado3


            findViewById<TextView?>(R.id.produtoCorte4).text = produtoCorteSelecionado4


            findViewById<TextView?>(R.id.produtoCorte5).text = produtoCorteSelecionado5


            findViewById<TextView?>(R.id.produtoCorte6).text = produtoCorteSelecionado6


            findViewById<TextView?>(R.id.produtoCorte7).text = produtoCorteSelecionado7


            findViewById<TextView?>(R.id.produtoCorte8).text = produtoCorteSelecionado8

        } else if (maquinaEscolhida == "Máquina 2") {

            findViewById<TextView?>(R.id.produtoCorte9).text = produtoCorteSelecionado9


            findViewById<TextView?>(R.id.produtoCorte10).text = produtoCorteSelecionado10


            findViewById<TextView?>(R.id.produtoCorte11).text = produtoCorteSelecionado11


            findViewById<TextView?>(R.id.produtoCorte12).text = produtoCorteSelecionado12


            findViewById<TextView?>(R.id.produtoCorte13).text = produtoCorteSelecionado13


            findViewById<TextView?>(R.id.produtoCorte14).text = produtoCorteSelecionado14


            findViewById<TextView?>(R.id.produtoCorte15).text = produtoCorteSelecionado15


            findViewById<TextView?>(R.id.produtoCorte16).text = produtoCorteSelecionado16

        }


    }
}