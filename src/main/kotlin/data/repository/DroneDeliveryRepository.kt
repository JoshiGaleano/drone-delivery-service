package data.repository

import domain.Drone
import domain.Location

interface DroneDeliveryRepository {

    fun getData(path: String): Pair<List<Drone>, List<Location>>
}
