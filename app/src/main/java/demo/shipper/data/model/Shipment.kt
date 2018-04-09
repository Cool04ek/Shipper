package demo.shipper.data.model

import java.util.*


class Shipment(var id: Int,
               var name: String,
               var startDate: Date = Date(),
               var endDate: Date = Date(),
               var description: String,
               var cityFrom: String,
               var regionFrom: String = "",
               var cityTo: String,
               var client: String = "",
               var paymentDescription: String = "",
               var body: List<String> = listOf<String>(),
               var regionTo: String = "",
               var weight: Float)