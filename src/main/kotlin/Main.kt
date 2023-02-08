import data.datasource.DroneDeliveryDataSourceImpl
import data.repository.DroneDeliveryRepositoryImpl
import data.usecase.DroneDeliveryUseCase
import domain.Drone
import domain.Location

private const val FILE_PATH = "src/main/resources/txt/Input.txt"

private lateinit var currentTrip: MutableList<Location>

private var currentWeight = 0
private var lastDrone: Drone? = null

fun main() {
    val result = DroneDeliveryUseCase(
        DroneDeliveryRepositoryImpl(
            DroneDeliveryDataSourceImpl()
        )
    ).getData(FILE_PATH)

    startDeliveries(result)
}

private fun startDeliveries(result: Pair<List<Drone>, List<Location>>) {
    val drones = result.first
    val locations = result.second

    val droneTrips = mutableMapOf<Drone, MutableList<List<Location>>>()
    for (drone in drones) {
        droneTrips[drone] = mutableListOf()
    }
    currentTrip = mutableListOf()
    currentWeight = 0

    assignDeliveries(locations, drones, droneTrips)
}

private fun assignDeliveries(
    locations: List<Location>,
    drones: List<Drone>,
    droneTrips: Map<Drone, MutableList<List<Location>>>
) {
    for (location in locations) {
        var assigned = false
        for (drone in drones) {
            if (currentWeight + location.weight <= drone.maxWeight) {
                currentWeight += location.weight
                currentTrip.add(location)
                assigned = true
                lastDrone = drone
                break
            }
        }
        if (!assigned) {
            droneTrips[lastDrone]!!.add(currentTrip)
            currentTrip = mutableListOf(location)
            currentWeight = location.weight
        }
    }

    if (currentTrip.isNotEmpty()) {
        droneTrips[lastDrone!!]!!.add(currentTrip)
    }
    printResults(droneTrips)
}

private fun printResults(droneTrips: Map<Drone, List<List<Location>>>) {
    for (drone in droneTrips) {
        println(drone.key.name)
        var tripNumber = 1
        for (trip in drone.value) {
            println("Trip #$tripNumber")
            for (location in trip) {
                print("[${location.name}], ")
            }
            println("")
            tripNumber++
        }
        println("")
    }
}
