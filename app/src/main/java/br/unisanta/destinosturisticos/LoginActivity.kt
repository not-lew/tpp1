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

        val campoUsuario = findViewById<EditText>(R.id.campoUsuario)
        val campoSenha = findViewById<EditText>(R.id.campoSenha)
        val botaoLogin = findViewById<Button>(R.id.botaoLogin)
        val linkCadastro = findViewById<TextView>(R.id.linkCadastro)

        botaoLogin.setOnClickListener {
            val usuario = campoUsuario.text.toString()
            val senha = campoSenha.text.toString()

            if (usuario == "admin" && senha == "1234") {
                startActivity(Intent(this, DestinosActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Login ou senha errados", Toast.LENGTH_SHORT).show()
            }
        }

        linkCadastro.setOnClickListener {
            startActivity(Intent(this, CadastroDestinoActivity::class.java))
        }
    }
}
