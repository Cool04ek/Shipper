package demo.shipper.data.source.shipment

import io.reactivex.Single
import demo.shipper.data.model.Shipment

/**
 * Created by roma on 8/3/17.
 */
class ShipmentsRepository {

    private val shipmentRemoteDataSource: ShipmentsRemoteDataSource = ShipmentsRemoteDataSource().apply {
        init()
    }

    fun getShipments(): Single<List<Shipment>> {
        return shipmentRemoteDataSource.getShipments()
    }
}