package domain

class Gps {
    fun route(location: ContainerLocation): TruckDestination {
        if(location == ContainerLocation.WHAREHOUSEA) {
            return TruckDestination.PORT;
        } else {
            return TruckDestination.WHAREHOUSEB;
        }
    }
}
