package com.android.jetpacknavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation


class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            SecondFragmentArgs.fromBundle(it).age.let { age ->
                view.findViewById<TextView>(R.id.tv_second_fragment).apply {
                    text = age.toString()
                    visibility = View.VISIBLE
                }
            }
        }

        view.findViewById<Button>(R.id.btn_fragment_second).setOnClickListener {
            Navigation.findNavController(it)
                .navigate(SecondFragmentDirections.actionSecondFragmentToFirstFragment())
        }
    }
}