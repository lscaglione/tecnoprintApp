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


    // Declaração de variáveis para os elementos da interface do usuário.
    lateinit var editTextFuncionario: EditText
    lateinit var editTextProduto: EditText
    lateinit var botaoConfirma: Button
    lateinit var selecionarMaquina: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inserir_impressao)

        // Inicialização dos elementos da interface com os seus respectivos IDs.
        editTextFuncionario = findViewById(R.id.selecionarFuncionario)
        editTextProduto = findViewById(R.id.selecionarProduto)
        botaoConfirma = findViewById(R.id.botaoConfirmar)
        selecionarMaquina = findViewById(R.id.selecionarMaquina)

        // Chamadas de métodos para a funcionalidade dos botões e inicialização do spinner.
        botao()
        botaoConfirma()
        listaDeMaquinasLista()


    }


    // Método para configurar a ação do botão de retornar à tela inicial.
    private fun botao() {
        val botaoTelaInicial: Button = findViewById(R.id.botaoTelaInicial)
        botaoTelaInicial.setOnClickListener {
            // Cria uma intenção para abrir a Activity menuImpressao.
            intent = Intent(this, menuImpressao::class.java)
            // Inicia a Activity.
            startActivity(intent)
        }
    }


    // Método para salvar os dados inseridos pelo usuário.
    private fun botaoConfirma() {
        // Acesso ao sistema SharedPreferences para guardar os dados.
        val preferences = getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE)
        val editor = preferences.edit()

        botaoConfirma.setOnClickListener {
            // Obtém os valores digitados pelo usuário.
            val funcionarioDigitado = editTextFuncionario.text.toString()
            val produtoDigitado = editTextProduto.text.toString()
            // Obtém a máquina selecionada no Spinner.
            val maquinaEscolhida = selecionarMaquina.selectedItem.toString()

            // Salva os dados específicos para a máquina escolhida no SharedPreferences.
            val maquinaIndex = maquinaEscolhida.replace("Máquina ", "")
            editor.putString("funcionarioMaquina$maquinaIndex", funcionarioDigitado)
            editor.putString("produtoMaquina$maquinaIndex", produtoDigitado)
            editor.apply()

            // Exibe uma mensagem para o usuário indicando que os dados foram salvos.
            Toast.makeText(this, "Dados salvos para $maquinaEscolhida", Toast.LENGTH_SHORT).show()
        }
    }

    // Método para inicializar o Spinner com a lista de máquinas.
    private fun listaDeMaquinasLista() {
        // Define a lista de opções para o Spinner.
        val listaMaquinas = arrayOf("Selecione a maquina", "Máquina 1", "Máquina 2", "Máquina 3", "Máquina 4", "Máquina 5", "Máquina 6")
        // Cria um ArrayAdapter para exibir as opções no Spinner.
        val adaptar = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, listaMaquinas)
        // Configura o ArrayAdapter no Spinner.
        selecionarMaquina.setAdapter(adaptar)
    }

}


