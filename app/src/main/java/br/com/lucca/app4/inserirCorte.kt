package br.com.lucca.app4

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast

class inserirCorte : AppCompatActivity() {


    lateinit var selecionarMaquinaCorte: Spinner
    lateinit var selecionarProdutoCorte1: EditText
    lateinit var selecionarProdutoCorte2: EditText
    lateinit var selecionarProdutoCorte3: EditText
    lateinit var selecionarProdutoCorte4: EditText
    lateinit var selecionarProdutoCorte5: EditText
    lateinit var selecionarProdutoCorte6: EditText
    lateinit var selecionarProdutoCorte7: EditText
    lateinit var selecionarProdutoCorte8: EditText
    lateinit var botaoConfirma: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inserir_corte)


        selecionarMaquinaCorte = findViewById(R.id.spinnerSelecionarMaquinaCorte)
        selecionarProdutoCorte1 = findViewById(R.id.inserirProdutoCorte1)
        selecionarProdutoCorte2 = findViewById(R.id.inserirProdutoCorte2)
        selecionarProdutoCorte3 = findViewById(R.id.inserirProdutoCorte3)
        selecionarProdutoCorte4 = findViewById(R.id.inserirProdutoCorte4)
        selecionarProdutoCorte5 = findViewById(R.id.inserirProdutoCorte5)
        selecionarProdutoCorte6 = findViewById(R.id.inserirProdutoCorte6)
        selecionarProdutoCorte7 = findViewById(R.id.inserirProdutoCorte7)
        selecionarProdutoCorte8 = findViewById(R.id.inserirProdutoCorte8)
        botaoConfirma = findViewById(R.id.botaoConfirmarCorte1)

        listaDeMaquinasCorte()
        botaoConfirma()



    }

    private fun botaoConfirma(){
        val preferences = getSharedPreferences("SharedPreferencesCortes", Context.MODE_PRIVATE)
        val editor = preferences.edit()

        botaoConfirma.setOnClickListener {
            val maquinaSelecionadaCorte = selecionarMaquinaCorte.selectedItem.toString()
            editor.putString("maquinaCorte", maquinaSelecionadaCorte)
            editor.apply()

            if (maquinaSelecionadaCorte == "Máquina 1") {
            val corteSelecionado1 = selecionarProdutoCorte1.text.toString()
            editor.putString("produtoCorte1", corteSelecionado1)
            editor.apply()

            val corteSelecionado2 = selecionarProdutoCorte2.text.toString()
            editor.putString("produtoCorte2", corteSelecionado2)
            editor.apply()

            val corteSelecionado3 = selecionarProdutoCorte3.text.toString()
            editor.putString("produtoCorte3", corteSelecionado3)
            editor.apply()

            val corteSelecionado4 = selecionarProdutoCorte4.text.toString()
            editor.putString("produtoCorte4", corteSelecionado4)
            editor.apply()

            val corteSelecionado5 = selecionarProdutoCorte5.text.toString()
            editor.putString("produtoCorte5", corteSelecionado5)
            editor.apply()

            val corteSelecionado6 = selecionarProdutoCorte6.text.toString()
            editor.putString("produtoCorte6", corteSelecionado6)
            editor.apply()

            val corteSelecionado7 = selecionarProdutoCorte7.text.toString()
            editor.putString("produtoCorte7", corteSelecionado7)
            editor.apply()

            val corteSelecionado8 = selecionarProdutoCorte8.text.toString()
            editor.putString("produtoCorte8", corteSelecionado8)
            editor.apply()
            } else if (maquinaSelecionadaCorte == "Máquina 2"){
                val corteSelecionado9 = selecionarProdutoCorte1.text.toString()
                editor.putString("produtoCorte9", corteSelecionado9)
                editor.apply()

                val corteSelecionado10 = selecionarProdutoCorte2.text.toString()
                editor.putString("produtoCorte10", corteSelecionado10)
                editor.apply()

                val corteSelecionado11 = selecionarProdutoCorte3.text.toString()
                editor.putString("produtoCorte11", corteSelecionado11)
                editor.apply()

                val corteSelecionado12 = selecionarProdutoCorte4.text.toString()
                editor.putString("produtoCorte12", corteSelecionado12)
                editor.apply()

                val corteSelecionado13 = selecionarProdutoCorte5.text.toString()
                editor.putString("produtoCorte13", corteSelecionado13)
                editor.apply()

                val corteSelecionado14 = selecionarProdutoCorte6.text.toString()
                editor.putString("produtoCorte14", corteSelecionado14)
                editor.apply()

                val corteSelecionado15 = selecionarProdutoCorte7.text.toString()
                editor.putString("produtoCorte15", corteSelecionado15)
                editor.apply()

                val corteSelecionado16 = selecionarProdutoCorte8.text.toString()
                editor.putString("produtoCorte16", corteSelecionado16)
                editor.apply()

            }

            Toast.makeText(this, "Cortes atualizados", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, menuCorte::class.java)
            startActivity(intent)


        }

    }

    private fun listaDeMaquinasCorte (){
        val listaMaquinasCorte = arrayOf(
            "Selecione a maquina",
            "Máquina 1",
            "Máquina 2"
        )

        val adaptar = ArrayAdapter(this, R.layout.spinner_style, listaMaquinasCorte)
        adaptar.setDropDownViewResource(R.layout.dropdown_spinner)
        selecionarMaquinaCorte.adapter = adaptar

    }
}