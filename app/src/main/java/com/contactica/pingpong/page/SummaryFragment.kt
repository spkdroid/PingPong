package com.contactica.pingpong.page

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.contactica.pingpong.R
import com.contactica.pingpong.model.Radio
import com.contactica.pingpong.model.adapter.RadioViewAdapter
import com.contactica.pingpong.viewmodel.MainViewModel
import com.contactica.pingpong.viewmodel.SummaryViewModel
import kotlinx.android.synthetic.main.summary_fragment.*

class SummaryFragment : Fragment() {

    companion object {
        fun newInstance() = SummaryFragment()
    }

    private lateinit var radioStation: ArrayList<Radio>

    private lateinit var viewModel: SummaryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.summary_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SummaryViewModel::class.java)
        // TODO: Use the ViewModel
        viewModel.getRadioList()
        viewModel.radioStation.observe(viewLifecycleOwner, {
            radioList.adapter = RadioViewAdapter(requireContext(),it)
        })

        radioList.layoutManager = androidx.recyclerview.widget.GridLayoutManager(context, 1)
        radioList.setHasFixedSize(true)

        addRadioStation.setOnClickListener {
            Navigation.findNavController(requireView())
                .navigate(R.id.action_summaryFragment_to_addRadioFragment)
        }
    }

}