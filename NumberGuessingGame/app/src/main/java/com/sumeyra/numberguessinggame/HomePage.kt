package com.sumeyra.numberguessinggame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.sumeyra.numberguessinggame.databinding.FragmentHomePageBinding


class HomePage : Fragment() {

    private var _binding: FragmentHomePageBinding?=null
    private val binding get() =_binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomePageBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.oynaButton.setOnClickListener {
            findNavController().navigate(R.id.anaSayfaToTahmin)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}