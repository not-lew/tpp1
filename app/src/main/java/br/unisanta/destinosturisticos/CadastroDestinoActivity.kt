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

        val campoTitulo = findViewById<EditText>(R.id.campoTitulo)
        val campoLocal = findViewById<EditText>(R.id.campoLocal)
        val campoLink = findViewById<EditText>(R.id.campoLink)
        val botaoGravar = findViewById<Button>(R.id.botaoGravar)
        val linkListagem = findViewById<TextView>(R.id.linkListagem)

        botaoGravar.setOnClickListener {
            val titulo = campoTitulo.text.toString().trim()
            val local = campoLocal.text.toString().trim()
            val link = campoLink.text.toString().trim()

            if (titulo.isEmpty() || local.isEmpty() || link.isEmpty()) {
                Toast.makeText(this, "Preencha tudo!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            GerenciadorDestinos.lista.add(Destino(titulo, local, link))
            Toast.makeText(this, "Destino gravado!", Toast.LENGTH_SHORT).show()

            campoTitulo.text.clear()
            campoLocal.text.clear()
            campoLink.text.clear()
        }

        linkListagem.setOnClickListener {
            startActivity(Intent(this, DestinosActivity::class.java))
        }
    }
}
