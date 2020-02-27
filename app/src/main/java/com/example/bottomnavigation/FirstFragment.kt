package com.example.bottomnavigation

import android.animation.ObjectAnimator
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.first_fragment.*


class FirstFragment : Fragment() {

    companion object {
        fun newInstance() = FirstFragment()
    }

    private lateinit var viewModel: FirstViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.first_fragment, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FirstViewModel::class.java)//this换成require之后切换页面也能保存数据
        // TODO: Use the ViewModel
        imageView.rotation = viewModel.rotation
        var objectAnimator = ObjectAnimator.ofFloat(imageView,"rotation",0f,0f)
        objectAnimator.duration = 500
        imageView.setOnClickListener(View.OnClickListener {
            if (!objectAnimator.isRunning){
                objectAnimator.setFloatValues(viewModel.rotation,viewModel.rotation+90)
                viewModel.rotation+=100
                objectAnimator.start()
            }
        })
    }

}
