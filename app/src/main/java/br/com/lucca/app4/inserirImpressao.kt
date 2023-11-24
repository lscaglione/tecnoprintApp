package br.com.lucca.app4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class inserirImpressao : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inserir_impressao)


        val botaoTelaInicial: Button = findViewById(R.id.botaoTelaInicial)



        botaoTelaInicial.setOnClickListener {
            val intent = Intent(this, menuImpressao::class.java)
            startActivity(intent)

        }


    }


}