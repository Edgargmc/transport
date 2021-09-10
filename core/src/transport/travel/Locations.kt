package transport.travel

enum class Locations {
    WarehouseA {
        override fun nextPosition(destiny: Locations): Locations = Port
    },
    WarehouseB {
        override fun nextPosition(destiny: Locations) = Factory
    },
    Factory {
        override fun nextPosition(destiny: Locations): Locations {
            if (destiny == WarehouseA) return Port
            return WarehouseB
        }
    },
    Port {
        override fun nextPosition(destiny: Locations) = WarehouseA
    },
    OnTheRoad{
        override fun nextPosition(destiny: Locations): Locations {
            TODO("Not yet implemented")
        }
    };

    abstract fun nextPosition(destiny: Locations): Locations
}