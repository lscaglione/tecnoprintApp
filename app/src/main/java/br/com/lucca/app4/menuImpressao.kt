package br.com.lucca.app4

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class menuImpressao : AppCompatActivity() {

    override fun onResume() {
        super.onResume()
        // Atualiza os dados toda vez que a Activity é retomada.
        atualizarDados()
    }

    // Este método é chamado quando a Activity é criada.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_impressao)

        // Chamada de métodos para inicializar os botões e atualizar dados.
        botoes()


    }

    // Método para inicializar e definir ações para os botões.
    private fun botoes() {
        // Encontra o botão pelo ID e define um ouvinte de clique para ele.
        val botao1: Button = findViewById(R.id.botaoInserirImpressao)
        botao1.setOnClickListener {
            // Cria uma intenção para abrir a Activity inserirImpressao.
            val intent = Intent(this, inserirImpressao::class.java)
            // Inicia a Activity.
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

    // Método para atualizar os dados exibidos na tela.
    private fun atualizarDados() {
        // Acesso ao sistema SharedPreferences para ler os dados salvos.
        val preferences = getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE)

        // Loop para atualizar as views para cada máquina (de 1 a 6).
        for (i in 1..6) {

            // Obtém os dados salvos para cada máquina.
            val funcionario = preferences.getString("funcionarioMaquina$i", "")
            val produto = preferences.getString("produtoMaquina$i", "")
            val maquina = "Máquina $i"

            // Estrutura condicional para verificar qual máquina está sendo processada e atualizar as views correspondentes.
            when (maquina) {
                "Máquina 1" -> {
                    findViewById<TextView>(R.id.funcionario1).text = funcionario
                    findViewById<TextView>(R.id.produto1).text = produto
                    findViewById<TextView>(R.id.maquina1).text = maquina
                }

                "Máquina 2" -> {
                    findViewById<TextView>(R.id.funcionario2).text = funcionario
                    findViewById<TextView>(R.id.produto2).text = produto
                    findViewById<TextView>(R.id.maquina2).text = maquina
                }

                "Máquina 3" -> {
                    findViewById<TextView>(R.id.funcionario3).text = funcionario
                    findViewById<TextView>(R.id.produto3).text = produto
                    findViewById<TextView>(R.id.maquina3).text = maquina
                }

                "Máquina 4" -> {
                    findViewById<TextView>(R.id.funcionario4).text = funcionario
                    findViewById<TextView>(R.id.produto4).text = produto
                    findViewById<TextView>(R.id.maquina4).text = maquina
                }

                "Máquina 5" -> {
                    findViewById<TextView>(R.id.funcionario5).text = funcionario
                    findViewById<TextView>(R.id.produto5).text = produto
                    findViewById<TextView>(R.id.maquina5).text = maquina
                }

                "Máquina 6" -> {
                    findViewById<TextView>(R.id.funcionario6).text = funcionario
                    findViewById<TextView>(R.id.produto6).text = produto
                    findViewById<TextView>(R.id.maquina6).text = maquina
                }

            }

        }
    }
}