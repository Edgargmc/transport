package transport.travel

class Travel(val destination: Location, val containers: Containers) {
    var location = Location.Factory
    var hours: Hours = Hours(0)

    fun incrementHours(hours: Hours) {
        this.hours = this.hours.increment(hours)
    }

    fun nextLocation() {
        location = location.nextPosition(destination)
    }

}
