package dev.sebaspuruguay.pc1dam20100786tenipuclla
import dev.sebaspuruguay.pc1dam20100786tenipuclla.Jugador
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListadoFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: JugadorAdapter
    private val jugadores = mutableListOf<Jugador>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Aquí agregas los jugadores
        jugadores.add(Jugador("Lionel Messi", 1987, "https://cdn.britannica.com/35/238335-050-2CB2EB8A/Lionel-Messi-Argentina-Netherlands-World-Cup-Qatar-2022.jpg"))
        jugadores.add(Jugador("Cristiano Ronaldo", 1985, "https://www.shutterstock.com/image-photo/leipzig-germany-june-18-2024-600nw-2480564705.jpg"))
        jugadores.add(Jugador("Neymar Jr.", 1992, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTPFuLZBCBkeuLWEF8e-Y4inaE7e4xlm0IhXw&s"))

        adapter = JugadorAdapter(jugadores)
        recyclerView.adapter = adapter

        return view
    }