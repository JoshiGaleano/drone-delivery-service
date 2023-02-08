package data.datasource

import java.io.File
import java.io.InputStream

class DroneDeliveryDataSourceImpl: DroneDeliveryDataSource {

    override fun getData(path: String): List<String> {
        val inputStream: InputStream = File(path).inputStream()
        val inputString = inputStream.bufferedReader().use { it.readText() }

        return inputString.split('\n')
    }
}
