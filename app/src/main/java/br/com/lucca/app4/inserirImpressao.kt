package br.com.lucca.app4

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast


class inserirImpressao : AppCompatActivity() {

    lateinit var editTextFuncionario: EditText
    lateinit var editTextProduto: EditText
    lateinit var botaoConfirma: Button
    lateinit var selecionarMaquina: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inserir_impressao)


        editTextFuncionario = findViewById(R.id.selecionarFuncionario)
        editTextProduto = findViewById(R.id.selecionarProduto)
        botaoConfirma = findViewById(R.id.botaoConfirmar)
        selecionarMaquina = findViewById(R.id.selecionarMaquina)

        botao()
        botaoConfirma()
        listaDeMaquinasLista()


    }


    private fun botao() {
        val botaoTelaInicial: Button = findViewById(R.id.botaoTelaInicial)
        botaoTelaInicial.setOnClickListener {
            intent = Intent(this, menuImpressao::class.java)
            startActivity(intent)
        }
    }

    private fun botaoConfirma() {
        //Usando o getSharedPreferences para modificar e guardar os dados digitados
        val preferences = getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE)
        val editor = preferences.edit()

        //Aplicando a lógica pra quando o usuário apertar em confirmar para obter os dados
        botaoConfirma.setOnClickListener {
            val funcionarioDigitado = editTextFuncionario.text.toString()
            editor.putString("funcionarioNovo", funcionarioDigitado)
            editor.apply()

            val produtoDigitado = editTextProduto.text.toString()
            editor.putString("produtoNovo", produtoDigitado)
            editor.apply()

            val maquinaEscolhida = selecionarMaquina.selectedItem.toString()
            editor.putString("maquinaEscolhida", maquinaEscolhida)
            editor.apply()
//
        }
    }

    private fun listaDeMaquinasLista() {
        val listaMaquinas = arrayOf("Selecione a maquina", "1", "2", "3", "4", "5", "6")
        val adaptar = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, listaMaquinas)
        selecionarMaquina.setAdapter(adaptar)
    }

}


