package br.unisanta.destinosturisticos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CadastroDestinoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_destino)

        val etNome = findViewById<EditText>(R.id.etNome)
        val etPaisRegiao = findViewById<EditText>(R.id.etPaisRegiao)
        val etUrl = findViewById<EditText>(R.id.etUrl)
        val btnSalvar = findViewById<Button>(R.id.btnSalvar)
        val tvVerLista = findViewById<TextView>(R.id.tvVerLista)

        btnSalvar.setOnClickListener {
            val nome = etNome.text.toString()
            val paisRegiao = etPaisRegiao.text.toString()
            val url = etUrl.text.toString()

            if (nome.isEmpty() || paisRegiao.isEmpty() || url.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            } else {
                val destino = Destino(nome, paisRegiao, url)
                GerenciadorDestinos.destinos.add(destino)
                Toast.makeText(this, "Destino salvo!", Toast.LENGTH_SHORT).show()
                etNome.text.clear()
                etPaisRegiao.text.clear()
                etUrl.text.clear()
            }
        }

        tvVerLista.setOnClickListener {
            val intent = Intent(this, DestinosActivity::class.java)
            startActivity(intent)
        }
    }
}
