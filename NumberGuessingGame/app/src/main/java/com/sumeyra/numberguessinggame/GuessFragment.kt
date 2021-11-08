package com.sumeyra.numberguessinggame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.sumeyra.numberguessinggame.databinding.FragmentGuessBinding


class GuessFragment : Fragment() {
    private var _binding: FragmentGuessBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGuessBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var hak = 10
        binding.kalanHakText.text = "Kalan Hak: $hak"

        val randomSayi = (0..100).random()

        var tahmin = 0

        binding.tahminButton.setOnClickListener {

            if (binding.tahminEditText.text.toString().isEmpty() || binding.tahminEditText.text.toString() == "") {

                Toast.makeText(context, "Lütfen bir tahminde bulunun!", Toast.LENGTH_SHORT).show()

            }   else {

                hak -= 1
                binding.kalanHakText.text = "Kalan Hak: $hak"
                tahmin = binding.tahminEditText.text.toString().toInt()

                if (tahmin > randomSayi) {

                    binding.yardimciText.text = "Yardım: Azalt"

                }   else if (tahmin < randomSayi) {

                    binding.yardimciText.text = "Yardım: Artır"

                }   else if (tahmin == randomSayi) {

                    val gecis = GuessFragmentDirections.tahminToSonuc("KAZANDIN")
                    findNavController().navigate(gecis)

                }

                if (hak == 0) {

                    val gecis = GuessFragmentDirections.tahminToSonuc("KAYBETTİN")
                    findNavController().navigate(gecis)

                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null

    }
}