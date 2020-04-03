package newKata

import domain.Wharehouses
import domain.TruckDestinationService
import domain.Destination
import org.assertj.core.api.Assertions
import org.junit.Test

class DestinationServiceTest  {
    @Test
    fun `resolve truck destination for WharehouseA`() {
        val truckDestinationService = TruckDestinationService()
        val truckDestiny = truckDestinationService.route(Wharehouses.A)

        Assertions.assertThat(truckDestiny).isEqualTo(Destination.PORT)
    }

    @Test
    fun `resolve truck destination for WharehouseB`() {
        val truckDestinationService = TruckDestinationService()
        val truckDestiny = truckDestinationService.route(Wharehouses.B)

        Assertions.assertThat(truckDestiny).isEqualTo(Destination.WHAREHOUSEB)
    }

    @Test
    fun `return 5 hours for wharehouse b`() {
        val truckDestinationService = TruckDestinationService()
        val hours = truckDestinationService.timeToDestinationFromFactory(Destination.WHAREHOUSEB)

        Assertions.assertThat(hours).isEqualTo(5)
    }

    @Test
    fun `return 1 hours for port`() {
        val truckDestinationService = TruckDestinationService()
        val hours = truckDestinationService.timeToDestinationFromFactory(Destination.PORT)

        Assertions.assertThat(hours).isEqualTo(1)
    }

    @Test
    fun `return 5 hours for factory from wharehouse b`() {
        val truckDestinationService = TruckDestinationService()
        val hours = truckDestinationService.timeToFactoryFromDestination(Destination.WHAREHOUSEB)

        Assertions.assertThat(hours).isEqualTo(5)
    }

    @Test
    fun `return 1 hour for factory from port`() {
        val truckDestinationService = TruckDestinationService()
        val hours = truckDestinationService.timeToFactoryFromDestination(Destination.PORT)

        Assertions.assertThat(hours).isEqualTo(1)
    }
}
