package com.example.rpg


import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders

import com.example.rpg.R
import com.example.rpg.databinding.FragmentTestBinding
import com.example.rpg.hero.HeroViewModel
import com.example.rpg.hero.TestViewModel
import kotlinx.android.synthetic.main.fragment_test.view.*

/**
 * A simple [Fragment] subclass.
 */
class TestFragment : Fragment() {

    private lateinit var binding: FragmentTestBinding
    private lateinit var viewModel: HeroViewModel
    private lateinit var testViewModel: TestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false)

        activity?.let {
            viewModel = ViewModelProviders.of(it).get(HeroViewModel::class.java)
        }
        testViewModel = ViewModelProviders.of(this).get(TestViewModel::class.java)

        setResultText()

        binding.easyStr.setOnClickListener {
            testViewModel.doTest(1, viewModel.hero.value!!.str)
            setResultText()
        }

        setButtonListners()

        return binding.root
    }

    private fun setResultText()
    {
        binding.result.text = testViewModel.result.value
        if (binding.result.text == "PASSED")
        {
           binding.result.setTextColor(Color.GREEN)
        }
        else if(binding.result.text == "FAILED")
        {
            binding.result.setTextColor(Color.RED)
        }
        if (testViewModel.number.value != 0)
        {
            binding.textInfo.text =
                "You've rolled: " + testViewModel.number.value.toString() + " You have:" + testViewModel.tested.value.toString()
        }
    }

    private fun setButtonListners() {
        binding.easyStr.setOnClickListener {
            testViewModel.doTest(1, viewModel.hero.value!!.str)
            setResultText()
        }
        binding.midStr.setOnClickListener {
            testViewModel.doTest(2, viewModel.hero.value!!.str)
            setResultText()
        }
        binding.hardStr.setOnClickListener {
            testViewModel.doTest(3, viewModel.hero.value!!.str)
            setResultText()
        }
        binding.easyDex.setOnClickListener {
            testViewModel.doTest(1, viewModel.hero.value!!.dex)
            setResultText()
        }
        binding.midDex.setOnClickListener {
            testViewModel.doTest(2, viewModel.hero.value!!.dex)
            setResultText()
        }
        binding.hardDex.setOnClickListener {
            testViewModel.doTest(3, viewModel.hero.value!!.dex)
            setResultText()
        }
        binding.easyInte.setOnClickListener {
            testViewModel.doTest(1, viewModel.hero.value!!.inte)
            setResultText()
        }
        binding.midInte.setOnClickListener {
            testViewModel.doTest(2, viewModel.hero.value!!.inte)
            setResultText()
        }
        binding.hardInte.setOnClickListener {
            testViewModel.doTest(3, viewModel.hero.value!!.inte)
            setResultText()
        }
    }
}

