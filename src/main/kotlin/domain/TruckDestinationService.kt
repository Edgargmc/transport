package domain

class TruckDestinationService {
    fun route(location: Wharehouses): TruckDestination {
        if (location == Wharehouses.A) {
            return TruckDestination.PORT;
        } else {
            return TruckDestination.WHAREHOUSEB;
        }
    }

    fun timeToDestinationFromFactory(destination: TruckDestination): Int {
        if (destination == TruckDestination.PORT) return 1
        return 5
    }

    fun timeToFactoryFromDestination(destination: TruckDestination): Int {
        if (destination == TruckDestination.PORT) return 1
        return 5
    }
}
