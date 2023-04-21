package vn.thailam.wheresmyremote.ui.utils

object AppDestinations {
    const val HOME = "home"
    const val ADD_PLACE = "place/add"
    const val ADD_ITEM = "item/add?${DestinationArg.PLACE_ID}={${DestinationArg.PLACE_ID}}"
    const val PLACE_DETAIL = "place/detail/{${DestinationArg.PLACE_ID}}"

    fun replaceArg(destination: String, data: Pair<String, Any?>): String {
        return destination.replace("{${data.first}}", data.second.toString())
    }

    fun replaceArgs(destination: String, vararg data: Pair<String, Any?>): String {
        var tempDestination = destination
        data.forEach {
            tempDestination = replaceArg(tempDestination, it)
        }
        return tempDestination
    }
}

object DestinationArg {
    const val PLACE_ID = "placeId"
}
