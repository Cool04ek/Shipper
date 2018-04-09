package demo.shipper.data.source.shipment

import io.reactivex.Single
import demo.shipper.data.model.Shipment
import demo.shipper.data.source.base.BaseRemoteDataSource
import java.util.*

/**
 * Created by roma on 8/3/17.
 */
class ShipmentsRemoteDataSource : BaseRemoteDataSource() {

    companion object {
        val LONG_DESCRIPTION = "Some kinda long long long long long long long long long long long long long long description"
    }

    fun getShipments(): Single<List<Shipment>> {
        return Single.just(initMockShipments())
    }

    private fun initMockShipments(): List<Shipment> {
        val result = ArrayList<Shipment>()
        var index = 0
        while (index++ < 20) {
            result.add(Shipment(index, "Test + ${index}", Date(), Date(), LONG_DESCRIPTION, "Dnipro", "Dnipro", "Kiev", "Kiev",
                    "", listOf<String>(), "Kiev", 4f))
        }
        return result
    }
}