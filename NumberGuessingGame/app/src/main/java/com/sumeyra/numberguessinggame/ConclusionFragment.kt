package com.sumeyra.numberguessinggame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.sumeyra.numberguessinggame.databinding.FragmentConclusionBinding



class ConclusionFragment : Fragment() {

    private var _binding: FragmentConclusionBinding? = null
    private val binding get() = _binding!!

    private val args: ConclusionFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConclusionBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sonuc = args.sonuc

        if (sonuc == "KAZANDIN") {
            binding.sonucText.text = "KAZANDIN"
            binding.sonucImage.setImageResource(R.drawable.smile)
        }   else if (sonuc == "KAYBETTİN") {
            binding.sonucText.text = "KAYBETTİN"
            binding.sonucImage.setImageResource(R.drawable.sad)
        }   else {
            binding.sonucText.text = "NULL"
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null

    }

}