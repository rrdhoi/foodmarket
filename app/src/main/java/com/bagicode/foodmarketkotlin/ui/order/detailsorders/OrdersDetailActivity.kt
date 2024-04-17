package com.bagicode.foodmarketkotlin.ui.order.detailsorders

import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.bagicode.foodmarketkotlin.R
import kotlinx.android.synthetic.main.layout_toolbar.*

class OrdersDetailActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_orders)

        intent.extras?.let {
            val navController = Navigation.findNavController(findViewById(R.id.detailOrdersHostFragment))
            val bundle = Bundle()
            bundle.putParcelable("data", it.get("data") as Parcelable?)
            navController.setGraph(navController.graph, bundle)
        }
    }

    fun toolbarPayment() {
        toolbar.visibility = View.VISIBLE
        toolbar.title = "Payment"
        toolbar.subtitle = "You deserve better meal"
        toolbar.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_000)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }
}