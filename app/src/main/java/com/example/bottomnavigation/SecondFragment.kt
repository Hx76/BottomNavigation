package com.example.bottomnavigation

import android.animation.ObjectAnimator
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.second_fragment.*


class SecondFragment : Fragment() {

    companion object {
        fun newInstance() = SecondFragment()
    }

    private lateinit var viewModel: SecondViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.second_fragment, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SecondViewModel::class.java)
        imageView.scaleX = viewModel.scaleFactor
        imageView.scaleY = viewModel.scaleFactor
        // TODO: Use the ViewModel
        var objectAnimator1 = ObjectAnimator.ofFloat(imageView,"scaleX",0f,0f)
        var objectAnimator2 = ObjectAnimator.ofFloat(imageView,"scaleY",0f,0f)
        objectAnimator1.setDuration(500)
        objectAnimator2.setDuration(500)
        imageView.setOnClickListener(View.OnClickListener {
            if (!objectAnimator1.isRunning){
                objectAnimator1.setFloatValues(imageView.scaleX+0.1f)
                objectAnimator2.setFloatValues(imageView.scaleY+0.1f)
                viewModel.scaleFactor += 0.1f
                objectAnimator1.start()
                objectAnimator2.start()
            }
        })
    }

}
