package data.datasource.mapper

import domain.Location

object LocationDTOMapper {

    fun mapStringToLocation(item: List<String>): Location {
        return Location(
            name = item[0].removePrefix("[").removeSuffix("]"),
            weight = item[1].trim().removePrefix("[").removeSuffix("]").toInt()
        )
    }
}
