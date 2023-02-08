package data.repository

import data.datasource.DroneDeliveryDataSource
import data.datasource.mapper.DroneDTOMapper
import data.datasource.mapper.LocationDTOMapper
import domain.Drone
import domain.Location

class DroneDeliveryRepositoryImpl(
    private val droneDeliveryDataSource: DroneDeliveryDataSource
): DroneDeliveryRepository {

    override fun getData(path: String): Pair<List<Drone>, List<Location>> {
        val data = droneDeliveryDataSource.getData(path)

        val drones = mapDataToDrones(data)
        val locations = mapDataToLocations(data)

        return Pair(drones, locations)
    }

    private fun mapDataToDrones(data: List<String>): List<Drone> {
        val drones = data[0].split(",")
        val modelDrones = mutableListOf<Drone>()

        drones.forEachIndexed { index, item ->
            if ((index % 2) == 0) {
                modelDrones.add(DroneDTOMapper.mapStringToDrone(index, item, drones))
            }
        }
        return modelDrones
    }

    private fun mapDataToLocations(data: List<String>): List<Location> {
        val locations = data.slice(1 until (data.size - 1))

        return locations.map {
            val item = it.split(",")
            LocationDTOMapper.mapStringToLocation(item)
        }
    }
}
