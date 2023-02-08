package data.datasource

interface DroneDeliveryDataSource {

    fun getData(path: String): List<String>
}
