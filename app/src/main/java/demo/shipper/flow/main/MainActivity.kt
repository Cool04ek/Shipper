package demo.shipper.flow.main

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.TouchDelegate
import android.view.View
import android.widget.Toast
import demo.shipper.R
import demo.shipper.data.model.Shipment
import demo.shipper.flow.main.swap.SwipeHelper
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ShipmentsContract.View {

    private val presenter = ShipmentsPresenter()
    private lateinit var adapter: ShipmentsAdapter

    private lateinit var touchHelper: ItemTouchHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attachView(this)
        adapter = ShipmentsAdapter({ shipment -> shipmentClick(shipment) })
        rvShipments.adapter = adapter
        rvShipments.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        touchHelper = ItemTouchHelper(SwipeHelper(adapter))
        touchHelper.attachToRecyclerView(rvShipments)
    }

    override fun onResume() {
        super.onResume()
        presenter.fetchNextPage()
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    override fun fetchNextPage() {
        presenter.fetchNextPage()
    }

    override fun getContext(): Context {
        return this@MainActivity
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun showError(strResId: Int) {
        Toast.makeText(this@MainActivity, strResId, Toast.LENGTH_SHORT).show()
    }

    override fun showError(error: String?) {
        Toast.makeText(this@MainActivity, error, Toast.LENGTH_SHORT).show()
    }

    override fun showShipments(shipments: List<Shipment>) {
        adapter.addShipments(shipments)
    }

    private fun shipmentClick(shipment: Shipment) {
        //TODO:
    }
}
