package br.unisanta.destinosturisticos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etUsuario = findViewById<EditText>(R.id.etUsuario)
        val etSenha = findViewById<EditText>(R.id.etSenha)
        val btnEntrar = findViewById<Button>(R.id.btnEntrar)
        val tvCadastrese = findViewById<TextView>(R.id.tvCadastrese)

        btnEntrar.setOnClickListener {
            val usuario = etUsuario.text.toString()
            val senha = etSenha.text.toString()

            if (usuario == "admin" && senha == "1234") {
                val intent = Intent(this, DestinosActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuário ou senha incorretos!", Toast.LENGTH_SHORT).show()
            }
        }

        tvCadastrese.setOnClickListener {
            val intent = Intent(this, CadastroDestinoActivity::class.java)
            startActivity(intent)
        }
    }
}
