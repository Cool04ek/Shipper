package demo.shipper.flow.main.swap

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper


class SwipeHelper(private val swipeListener: SwipeListener) : ItemTouchHelper.Callback() {

    override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
        val dragFlags = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        val swipeFlags = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        return makeMovementFlags(dragFlags, swipeFlags)
    }

    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
        swipeListener.onViewSwiped(viewHolder.adapterPosition)
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        swipeListener.onViewSwiped(viewHolder.adapterPosition)
    }
}