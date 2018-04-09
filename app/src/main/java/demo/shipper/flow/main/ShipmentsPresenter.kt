package demo.shipper.flow.main

import android.util.Log
import demo.shipper.base.BasePresenterImplementation
import demo.shipper.data.source.shipment.ShipmentsRepository

/**
 * Created by roma on 8/3/17.
 */
class ShipmentsPresenter : BasePresenterImplementation<ShipmentsContract.View>(), ShipmentsContract.Presenter {

    private val shipmentsRepository = ShipmentsRepository()

    override fun fetchNextPage() {
        view?.showProgress()
        addDisposable(shipmentsRepository.getShipments().subscribe({ shipments ->
            view?.showShipments(shipments)
            view?.hideProgress()
        }, { error ->
            view?.showError(error.localizedMessage)
            view?.hideProgress()
            Log.i("Shipper", error.localizedMessage)
        }))
    }
}