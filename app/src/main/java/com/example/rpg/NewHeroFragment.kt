package com.example.rpg


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.ToggleButton
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

import com.example.rpg.databinding.FragmentNewHeroBinding
import com.example.rpg.hero.Hero

/**
 * A simple [Fragment] subclass.
 */
class NewHeroFragment : Fragment() {

    lateinit var binding: FragmentNewHeroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_new_hero, container, false)

        val createButton = binding.createButton
        createButton.setOnClickListener()
        {
            val editName = binding.editName
            val name = editName.text.toString()
            val radioGroup = binding.radioGroup

            val radioProffesion = radioGroup.checkedRadioButtonId
            val proffesion: Int
            if (radioProffesion == binding.radioWarrior.id){
                proffesion = 1
            }
            else if(radioProffesion == binding.radioMage.id) {
                proffesion = 2
            }
            else {
                proffesion = 3
            }
            val sex = binding.sexButton.isChecked
            it.findNavController().navigate(
                NewHeroFragmentDirections.actionNewHeroFragmentToHeroFragment(name, sex, proffesion))
        }
        return binding.root
    }
}
