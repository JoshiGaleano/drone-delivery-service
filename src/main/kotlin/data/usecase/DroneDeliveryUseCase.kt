package data.usecase

import data.repository.DroneDeliveryRepository
import domain.Drone
import domain.Location

class DroneDeliveryUseCase(
    private val droneDeliveryRepository: DroneDeliveryRepository
) {

    fun getData(path: String): Pair<List<Drone>, List<Location>> {
        return droneDeliveryRepository.getData(path)
    }
}
