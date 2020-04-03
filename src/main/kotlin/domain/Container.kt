package domain

class Container(val destination: Wharehouses) {
    var currentLocation = Destination.NONE
        private set

    fun delivered(destination: Destination) {
        this.currentLocation = destination
    }

    fun isDelivered(): Boolean {
        if (destination == Wharehouses.B && this.currentLocation == Destination.WHAREHOUSEB) {
            return true
        }
        if (destination == Wharehouses.A && this.currentLocation == Destination.WHAREHOUSEA) {
            return true
        }
            return false
    }
}
