package demo.shipper.flow.main

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.cell_post.view.*
import demo.shipper.R
import demo.shipper.data.model.Shipment
import demo.shipper.flow.main.swap.SwipeListener
import java.util.*

/**
 * Created by roma on 8/3/17.
 */
class ShipmentsAdapter(val shipmentClick: (Shipment) -> Unit) : RecyclerView.Adapter<ShipmentsAdapter.PostViewHolder>(), SwipeListener {

    private val shipments = ArrayList<Shipment>()

    fun addShipments(postList: List<Shipment>) {
        shipments.addAll(postList)
        notifyDataSetChanged()
    }

    fun setShipments(postList: List<Shipment>) {
        shipments.clear()
        shipments.addAll(postList)
        notifyDataSetChanged()
    }

    override fun onViewSwiped(position: Int) {
        shipments.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bindData()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PostViewHolder {
        return PostViewHolder(View.inflate(parent?.context, R.layout.cell_post, null))
    }

    override fun getItemCount(): Int {
        return shipments.size
    }

    inner class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindData() {
            with(shipments[adapterPosition]) {
                itemView.tvName.text = name
                itemView.tvFrom.text = cityFrom
                itemView.tvTo.text = cityTo
                itemView.tvWeight.text = itemView.context.getString(R.string.weight_pattern, weight)

                itemView.setOnClickListener({ shipmentClick(this) })
            }
        }
    }

    fun getShipments(): List<Shipment> {
        return Collections.unmodifiableList(shipments)
    }
}