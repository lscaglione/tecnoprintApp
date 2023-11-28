package br.com.lucca.app4

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class menuImpressao : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_impressao)

        botoes()
        pegaProduto()
        pegaFuncionario()
        pegaMaquina()

    }

    //Funções para exibir o valor digitado no menu inserirImpressao
    private fun pegaFuncionario() {
        val funcionario1: TextView = findViewById(R.id.funcionario1)
        val preferences = getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE)
        val funcionarioSalvo = preferences.getString("funcionarioNovo", "")
        funcionario1.text = funcionarioSalvo
    }

    private fun pegaProduto() {
        val produto1: TextView = findViewById(R.id.produto1)
        val preferences = getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE)
        val produtoSalvo = preferences.getString("produtoNovo", "")
        produto1.text = produtoSalvo
    }

    private fun pegaMaquina(){
        val maquina1: TextView = findViewById(R.id.maquina1)
        val preferences = getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE)
        val maquinaSalvo = preferences.getString("maquinaEscolhida", "")
        maquina1.text = maquinaSalvo
    }

    private fun botoes() {
        val botao1: Button = findViewById(R.id.botaoInserirImpressao)
        botao1.setOnClickListener {
            val intent = Intent(this, inserirImpressao::class.java)
            startActivity(intent)
        }

        val botao2: Button = findViewById(R.id.botaoInserirCorte)
        botao2.setOnClickListener {
            val intent = Intent(this, inserirCorte::class.java)
            startActivity(intent)
        }

        val botao3: Button = findViewById(R.id.botaoMenuCorte)
        botao3.setOnClickListener {
            val intent = Intent(this, menuCorte::class.java)
            startActivity(intent)
        }



    }
}