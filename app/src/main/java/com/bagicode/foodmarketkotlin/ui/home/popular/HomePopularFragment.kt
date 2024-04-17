package com.bagicode.foodmarketkotlin.ui.home.popular

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bagicode.foodmarketkotlin.R
import com.bagicode.foodmarketkotlin.model.dummy.HomeVerticalModel
import com.bagicode.foodmarketkotlin.model.response.home.Data
import com.bagicode.foodmarketkotlin.ui.detail.DetailActivity
import com.bagicode.foodmarketkotlin.ui.home.newtaste.HomeNewtasteAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomePopularFragment : Fragment(), HomeNewtasteAdapter.ItemAdapterCallback {

    private var popularList : ArrayList<Data>? = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_new_taste, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        popularList = arguments?.getParcelableArrayList("data")

        //initDataDummy()
        var adapter = HomeNewtasteAdapter(popularList!!, this)
        var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
        rcList.layoutManager = layoutManager
        rcList.adapter = adapter
    }

//    fun initDataDummy() {
//        foodList = ArrayList()
//        foodList.add(HomeVerticalModel("Cherry Healthy","10000","",5f))
//        foodList.add(HomeVerticalModel("Burger Tamayo","50000","",4f))
//        foodList.add(HomeVerticalModel("Bakhwan Cihuy","70000","",4.5f))
//
//    }

    override fun onClick(v: View, data: Data) {
        val detail = Intent(activity, DetailActivity::class.java).putExtra("data", data)
        startActivity(detail)
    }

}