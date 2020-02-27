package com.example.bottomnavigation

import android.animation.ObjectAnimator
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.third_fragment.*
import kotlin.random.Random


class ThirdFragment : Fragment() {

    companion object {
        fun newInstance() = ThirdFragment()
    }

    private lateinit var viewModel: ThirdViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.third_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ThirdViewModel::class.java)
        // TODO: Use the ViewModel
        var objectAnimator = ObjectAnimator.ofFloat(imageView,"x",0f,0f)
        objectAnimator.setDuration(500)
        imageView.setOnClickListener(View.OnClickListener {
            if (!objectAnimator.isRunning){
                var dx = 10
                objectAnimator.setFloatValues(imageView.x,imageView.x+dx)
                objectAnimator.start()
            }
        })
    }

}
