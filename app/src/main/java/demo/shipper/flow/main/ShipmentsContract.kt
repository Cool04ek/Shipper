package demo.shipper.flow.main

import demo.shipper.base.BasePresenter
import demo.shipper.base.BaseView
import demo.shipper.data.model.Shipment

class ShipmentsContract {

    internal interface Presenter : BasePresenter {

        fun fetchNextPage()
    }

    interface View : BaseView {

        fun fetchNextPage()

        fun showShipments(shipments: List<Shipment>)
    }

}
