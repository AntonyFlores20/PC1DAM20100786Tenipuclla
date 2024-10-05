package dev.sebaspuruguay.pc1dam20100786tenipuclla.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class EquiposFragment : Fragment() {

    private lateinit var listView: ListView
    private val equipos = arrayOf(
        "FC Barcelona",
        "Real Madrid",
        "Manchester United",
        "Bayern Munich",
        "Paris Saint-Germain",
        "Juventus",
        "Manchester City",
        "Chelsea",
        "Inter de Milán",
        "Ajax"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_equipos, container, false)

        listView = view.findViewById(R.id.listView)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, equipos)
        listView.adapter = adapter

        return view
    }
}