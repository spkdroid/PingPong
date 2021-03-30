package com.contactica.pingpong.page

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.contactica.pingpong.R
import com.contactica.pingpong.viewmodel.AddRadioViewModel

class AddRadioFragment : Fragment() {

    companion object {
        fun newInstance() = AddRadioFragment()
    }

    private lateinit var viewModel: AddRadioViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.add_radio_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddRadioViewModel::class.java)
        // TODO: Use the ViewModel
    }

}