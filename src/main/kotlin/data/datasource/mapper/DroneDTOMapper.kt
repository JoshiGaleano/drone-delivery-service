package data.datasource.mapper

import domain.Drone

object DroneDTOMapper {

    fun mapStringToDrone(index: Int, item: String, data: List<String>): Drone {
        return Drone(
            name = item.trim(),
            maxWeight = data[index + 1].trim().removePrefix("[").removeSuffix("]").toInt()
        )
    }
}
