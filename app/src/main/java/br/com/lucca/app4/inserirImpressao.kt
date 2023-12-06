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
import android.widget.TextView
import android.widget.Toast


class inserirImpressao : AppCompatActivity() {


    // Declaração de variáveis para os elementos da interface do usuário.
    lateinit var selecionarFuncionario: Spinner
    lateinit var editTextProduto: EditText
    lateinit var botaoConfirma: Button
    lateinit var selecionarMaquina: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inserir_impressao)

        // Inicialização dos elementos da interface com os seus respectivos IDs.
        selecionarFuncionario = findViewById(R.id.selecionarFuncionario)
        editTextProduto = findViewById(R.id.selecionarProduto)
        botaoConfirma = findViewById(R.id.botaoConfirmar)
        selecionarMaquina = findViewById(R.id.selecionarMaquina)



        botaoConfirma()
        listaDeFuncionarios()
        listaDeMaquinasLista()




    }

    // Método para salvar os dados inseridos pelo usuário.
    private fun botaoConfirma() {
        val preferences = getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE)
        val editor = preferences.edit()

        botaoConfirma.setOnClickListener {
            val produtoDigitado = editTextProduto.text.toString()
            val funcionarioSelecionado = selecionarFuncionario.selectedItem.toString()
            val maquinaEscolhida = selecionarMaquina.selectedItem.toString()
            val maquinaIndex = maquinaEscolhida.replace("Máquina ", "")

            // Verifica se o funcionário selecionado é diferente da opção padrão.
            if (funcionarioSelecionado != "Selecione o funcionário") {
                editor.putString("funcionarioMaquina$maquinaIndex", funcionarioSelecionado)
            }

            editor.putString("produtoMaquina$maquinaIndex", produtoDigitado)
            editor.apply()

            Toast.makeText(this, "Dados salvos para $maquinaEscolhida", Toast.LENGTH_SHORT).show()
        }
    }



    // Método para inicializar o Spinner com a lista de máquinas.
    private fun listaDeMaquinasLista() {
        // Define a lista de opções para o Spinner.
        val listaMaquinas = arrayOf(
            "Selecione a maquina",
            "Máquina 1",
            "Máquina 2",
            "Máquina 3",
            "Máquina 4",
            "Máquina 5",
            "Máquina 6"
        )
        // Cria um ArrayAdapter para exibir as opções no Spinner.
        val adaptar = ArrayAdapter(this, R.layout.spinner_style, listaMaquinas)
        // Configura o ArrayAdapter no Spinner.
        adaptar.setDropDownViewResource(R.layout.dropdown_spinner)
        selecionarMaquina.adapter = adaptar
    }

    private fun listaDeFuncionarios(){

        val listaFuncionarios = arrayOf(
            "Selecione o funcionário",
            "Fernando",
            "João Batalha",
            "João Arana",
            "Lucca",
            "Ricardo",
            "Rodrigo"
        )

        val adaptar = ArrayAdapter(this, R.layout.spinner_style, listaFuncionarios)
        adaptar.setDropDownViewResource(R.layout.dropdown_spinner)
        selecionarFuncionario.adapter = adaptar



    }

}


