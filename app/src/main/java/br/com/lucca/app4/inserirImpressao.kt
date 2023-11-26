package br.com.lucca.app4

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class inserirImpressao : AppCompatActivity() {

    private val PREFS_NAME = "MinhasPreferencias"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inserir_impressao)

        val botaoTelaInicial: Button = findViewById(R.id.botaoTelaInicial)
        val botaoConfirmar: Button = findViewById(R.id.botaoConfirmar)

        botaoTelaInicial.setOnClickListener {
            val intent = Intent(this, menuImpressao::class.java)
            startActivity(intent)
        }

        botaoConfirmar.setOnClickListener {
            var editText: EditText = findViewById(R.id.inserirProdutoImpressao)
            var textoDoEditText = editText.text.toString()

            // Salva o valor no SharedPreferences
            val sharedPreferences: SharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("chave_texto", textoDoEditText)
            editor.apply()


        }
    }
}


