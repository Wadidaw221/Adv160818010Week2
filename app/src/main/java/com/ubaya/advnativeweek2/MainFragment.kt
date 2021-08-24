package com.ubaya.advnativeweek2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*
import kotlin.random.Random


class MainFragment : Fragment() {

    var score = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var num1 = Random.nextInt(10,30)
        var num2 = Random.nextInt(20,40)
        txtQuestion.text = "$num1 + $num2"
        var result = num1 + num2


        btnSubmit.setOnClickListener{
        if(result.toString() == txtJawaban.text.toString()) {
            score++

            num1 = Random.nextInt(10, 30)
            num2 = Random.nextInt(20, 40)
            txtQuestion.text = "$num1 + $num2"
            result = num1 + num2

        }
        else{
            val action = MainFragmentDirections.actionHasil(score)
            Navigation.findNavController(it).navigate(action)
        }

        }
    }


}