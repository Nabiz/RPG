package com.example.rpg


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders

import com.example.rpg.R
import com.example.rpg.databinding.FragmentCreditsBinding
import com.example.rpg.hero.HeroViewModel

/**
 * A simple [Fragment] subclass.
 */
class CreditsFragment : Fragment() {

    lateinit var binding: FragmentCreditsBinding
    private lateinit var viewModel: HeroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_credits, container, false)
        return binding.root
    }
}
