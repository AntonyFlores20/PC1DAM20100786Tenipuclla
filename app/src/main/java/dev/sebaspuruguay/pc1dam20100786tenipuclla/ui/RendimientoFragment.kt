package dev.sebaspuruguay.pc1dam20100786tenipuclla.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.sebaspuruguay.pc1dam20100786tenipuclla.R
import android.widget.EditText
import android.widget.TextView

class RendimientoFragment : Fragment() {

    private lateinit var etKilometros: EditText
    private lateinit var etMinutos: EditText
    private lateinit var btnCalcular: Button
    private lateinit var tvRendimiento: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_rendimiento, container, false)

        etKilometros = view.findViewById(R.id.etKilometros)
        etMinutos = view.findViewById(R.id.etMinutos)
        btnCalcular = view.findViewById(R.id.btnCalcular)
        tvRendimiento = view.findViewById(R.id.tvRendimiento)

        btnCalcular.setOnClickListener {
            calcularRendimiento()
        }

        return view
    }

    private fun calcularRendimiento() {
        val kilometros = etKilometros.text.toString().toFloatOrNull() ?: 0f
        val minutos = etMinutos.text.toString().toFloatOrNull() ?: 0f

        if (minutos > 0) {
            val rendimiento = kilometros / minutos
            tvRendimiento.text = "Rendimiento: %.2f km/min".format(rendimiento)
        } else {
            tvRendimiento.text = "Ingrese minutos válidos"
        }
    }
}