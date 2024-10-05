package dev.sebaspuruguay.pc1dam20100786tenipuclla

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class JugadorAdapter(private val jugadores: List<Jugador>) :
    RecyclerView.Adapter<JugadorAdapter.JugadorViewHolder>() {

    class JugadorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombre: TextView = view.findViewById(R.id.tvNombre)
        val anioNacimiento: TextView = view.findViewById(R.id.tvAnioNacimiento)
        val imagen: ImageView = view.findViewById(R.id.ivImagen)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JugadorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_jugador, parent, false)
        return JugadorViewHolder(view)
    }

    override fun onBindViewHolder(holder: JugadorViewHolder, position: Int) {
        val jugador = jugadores[position]
        holder.nombre.text = jugador.nombre
        holder.anioNacimiento.text = "Año de Nacimiento: ${jugador.anioNacimiento}"

        // Cargar la imagen usando Glide
        Glide.with(holder.imagen.context)
            .load(jugador.imagenUrl)
            .into(holder.imagen)
    }

    override fun getItemCount(): Int = jugadores.size
}