package transport.travel

enum class Location {
    A {
        override fun nextPosition(destiny: Location): Location = Port
    },
    B {
        override fun nextPosition(destiny: Location) = Factory
    },
    Factory {
        override fun nextPosition(destiny: Location): Location {
            if (destiny == A) return Port
            return B
        }
    },
    Port {
        override fun nextPosition(destiny: Location) = A
    };

    abstract fun nextPosition(destiny: Location): Location
}