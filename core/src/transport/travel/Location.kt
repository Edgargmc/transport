package transport.travel

enum class Location {
    WarehouseA {
        override fun nextPosition(destiny: Location): Location = Port
    },
    WarehouseB {
        override fun nextPosition(destiny: Location) = Factory
    },
    Factory {
        override fun nextPosition(destiny: Location): Location {
            if (destiny == WarehouseA) return Port
            return WarehouseB
        }
    },
    Port {
        override fun nextPosition(destiny: Location) = WarehouseA
    },
    OnTheRoad{
        override fun nextPosition(destiny: Location): Location {
            TODO("Not yet implemented")
        }
    };

    abstract fun nextPosition(destiny: Location): Location
}