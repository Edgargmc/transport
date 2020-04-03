package domain

class TruckDestinationService {
    fun route(location: Wharehouses): Destination {
        if (location == Wharehouses.A) {
            return Destination.PORT;
        } else {
            return Destination.WHAREHOUSEB;
        }
    }

    fun timeToDestinationFromFactory(destination: Destination): Int {
        if (destination == Destination.PORT) return 1
        return 5
    }

    fun timeToFactoryFromDestination(destination: Destination): Int {
        if (destination == Destination.PORT) return 1
        return 5
    }
}
