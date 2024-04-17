package com.bagicode.foodmarketkotlin.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.bagicode.foodmarketkotlin.R
import com.bagicode.foodmarketkotlin.model.response.home.Data
import com.bagicode.foodmarketkotlin.utils.Helpers.formatPrice
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : Fragment() {

    var bundle:Bundle ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as DetailActivity).toolbarDetail()

        arguments?.let {
            DetailFragmentArgs.fromBundle(it).data.let {
                initView(it)
            }

        }

        btnOrderNow.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_payment, bundle)
        }
    }

    private fun initView(data: Data?) {

        bundle = bundleOf("data" to data)

        Glide.with(requireContext())
            .load(data?.picturePath)
            .into(ivPoster)

        tvTitle.text = data?.name
        tvDesc.text = data?.description
        tvIngredients.text = data?.ingredients

        tvTotal.formatPrice(data?.price.toString())
    }


}