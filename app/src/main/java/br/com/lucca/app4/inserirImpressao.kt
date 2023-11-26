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


class inserirImpressao : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inserir_impressao)

        val botaoTelaInicial: Button = findViewById(R.id.botaoTelaInicial)
        botaoTelaInicial.setOnClickListener {
            intent = Intent(this, menuImpressao::class.java)
            startActivity(intent)
        }

        val editTextFuncionario: EditText = findViewById(R.id.selecionarFuncionario)
        val editTextProduto: EditText = findViewById(R.id.selecionarProduto)
        val editTextMaquina: EditText = findViewById(R.id.selecionarMaquina)
        val botaoConfirma: Button = findViewById(R.id.botaoConfirmar)

        val preferences = getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE)
        val editor = preferences.edit()




        botaoConfirma.setOnClickListener {
            val funcionarioDigitado = editTextFuncionario.text.toString()
            editor.putString("funcionarioNovo", funcionarioDigitado)
            editor.apply()


            val produtoDigitado = editTextProduto.text.toString()
            editor.putString("produtoNovo", produtoDigitado)
            editor.apply()

            val maquinaDigitado = editTextMaquina.text.toString()
            editor.putString("maquinaNovo", maquinaDigitado)
            editor.apply()

            val intent = Intent(this, menuImpressao::class.java)
            startActivity(intent)
        }
    }


}

