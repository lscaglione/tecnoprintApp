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

        botaoConfirma()
        listaDeMaquinasCorte()


    }

    private fun botaoConfirma() {
        val preferences = getSharedPreferences("SharedPreferencesCortes", Context.MODE_PRIVATE)
        val editor = preferences.edit()

        botaoConfirma.setOnClickListener {

            val maquinaCorteSelecionada = selecionarMaquinaCorte.selectedItem.toString()
            val prefixo = when (maquinaCorteSelecionada) {
                "Máquina 1" -> "maquina1_"
                "Máquina 2" -> "maquina2_"
                else -> ""
            }

            editor.putString("maquinaAtual", maquinaCorteSelecionada)

            if (maquinaCorteSelecionada != "Selecione a maquina") {

                val corteSelecionado1 = selecionarProdutoCorte1.text.toString()
                editor.putString("${prefixo}produtoCorte1", corteSelecionado1)

                val corteSelecionado2 = selecionarProdutoCorte2.text.toString()
                editor.putString("${prefixo}produtoCorte2", corteSelecionado2)

                val corteSelecionado3 = selecionarProdutoCorte3.text.toString()
                editor.putString("${prefixo}produtoCorte3", corteSelecionado3)

                val corteSelecionado4 = selecionarProdutoCorte4.text.toString()
                editor.putString("${prefixo}produtoCorte4", corteSelecionado4)

                val corteSelecionado5 = selecionarProdutoCorte5.text.toString()
                editor.putString("${prefixo}produtoCorte5", corteSelecionado5)

                val corteSelecionado6 = selecionarProdutoCorte6.text.toString()
                editor.putString("${prefixo}produtoCorte6", corteSelecionado6)

                val corteSelecionado7 = selecionarProdutoCorte7.text.toString()
                editor.putString("${prefixo}produtoCorte7", corteSelecionado7)

                val corteSelecionado8 = selecionarProdutoCorte8.text.toString()
                editor.putString("${prefixo}produtoCorte8", corteSelecionado8)

                editor.apply()

                Toast.makeText(this, "Selecionado a ${maquinaCorteSelecionada}", Toast.LENGTH_SHORT)
                    .show()

                val intent = Intent(this, menuCorte::class.java)
                startActivity(intent)


            } else {

                Toast.makeText(this, "Selecione a máquina!", Toast.LENGTH_SHORT).show()
            }


        }

    }

    private fun listaDeMaquinasCorte() {
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