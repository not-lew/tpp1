package br.unisanta.destinosturisticos

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DestinosActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DestinoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destinos)

        recyclerView = findViewById(R.id.recyclerDestinos)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = DestinoAdapter()
        recyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }

    inner class DestinoAdapter : RecyclerView.Adapter<DestinoAdapter.DestinoViewHolder>() {

        inner class DestinoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val tvNome: TextView = view.findViewById(R.id.tvNome)
            val tvPaisRegiao: TextView = view.findViewById(R.id.tvPaisRegiao)
            val btnExplorar: Button = view.findViewById(R.id.btnExplorar)
            val btnExcluir: Button = view.findViewById(R.id.btnExcluir)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinoViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_destino, parent, false)
            return DestinoViewHolder(view)
        }

        override fun onBindViewHolder(holder: DestinoViewHolder, position: Int) {
            val destino = GerenciadorDestinos.destinos[position]

            holder.tvNome.text = destino.nome
            holder.tvPaisRegiao.text = destino.paisRegiao

            holder.btnExplorar.setOnClickListener {
                val intent = Intent(this@DestinosActivity, NavegadorActivity::class.java)
                intent.putExtra("url", destino.url)
                startActivity(intent)
            }

            holder.btnExcluir.setOnClickListener {
                GerenciadorDestinos.destinos.removeAt(position)
                notifyDataSetChanged()
            }
        }

        override fun getItemCount(): Int {
            return GerenciadorDestinos.destinos.size
        }
    }
}
