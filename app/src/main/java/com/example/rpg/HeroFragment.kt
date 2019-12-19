package com.example.rpg


import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.rpg.databinding.FragmentHeroBinding
import com.example.rpg.hero.Hero
import com.example.rpg.hero.HeroViewModel
import android.util.TypedValue



/**
 * A simple [Fragment] subclass.
 */
class HeroFragment : Fragment() {

    lateinit var binding: FragmentHeroBinding
    private lateinit var viewModel: HeroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_hero, container, false)

        activity?.let {
            viewModel = ViewModelProviders.of(it).get(HeroViewModel::class.java)
        }

        if(arguments != null) {
            val args = HeroFragmentArgs.fromBundle(arguments!!)
            if(viewModel.hero.value!!.name != args.name) {
                viewModel.createHero(args.name, args.proffesion, args.sex)
            }
        }
        if(viewModel.hero.value!!.sex) {
            binding.imageView.setImageResource(R.drawable.woman)
        }
        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            binding.imageView.maxWidth = resources.getDimension(R.dimen.img_size_landscape).toInt()
        }

        binding.heroViewModel = viewModel

        binding.button.setOnClickListener {
            viewModel.levelUp()
            binding.heroViewModel = viewModel
        }
        return binding.root
    }
}
