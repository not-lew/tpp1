package br.unisanta.destinosturisticos

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DestinosActivity : AppCompatActivity() {

    private lateinit var adaptador: DestinoListAdapter
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destinos)

        listView = findViewById(R.id.listaDestinos)
        val botaoNovo = findViewById<Button>(R.id.botaoNovo)

        adaptador = DestinoListAdapter()
        listView.adapter = adaptador

        botaoNovo.setOnClickListener {
            startActivity(Intent(this, CadastroDestinoActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        adaptador.notifyDataSetChanged()
    }

    inner class DestinoListAdapter : BaseAdapter() {

        override fun getCount(): Int = GerenciadorDestinos.lista.size

        override fun getItem(pos: Int): Destino = GerenciadorDestinos.lista[pos]

        override fun getItemId(pos: Int): Long = pos.toLong()

        override fun getView(pos: Int, convertView: View?, parent: ViewGroup?): View {
            val view = convertView ?: layoutInflater.inflate(R.layout.item_destino, parent, false)

            val destino = getItem(pos)
            val tvTitulo = view.findViewById<TextView>(R.id.tvTitulo)
            val tvLocal = view.findViewById<TextView>(R.id.tvLocal)
            val btnAbrir = view.findViewById<Button>(R.id.btnAbrir)
            val btnRemover = view.findViewById<Button>(R.id.btnRemover)

            tvTitulo.text = destino.titulo
            tvLocal.text = destino.local

            btnAbrir.setOnClickListener {
                val intent = Intent(this@DestinosActivity, NavegadorActivity::class.java)
                intent.putExtra("link", destino.link)
                intent.putExtra("titulo", destino.titulo)
                startActivity(intent)
            }

            btnRemover.setOnClickListener {
                GerenciadorDestinos.lista.removeAt(pos)
                notifyDataSetChanged()
            }

            return view
        }
    }
}
