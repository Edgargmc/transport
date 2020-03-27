package newKata

import domain.ContainerLocation
import domain.Gps
import domain.TruckDestination
import org.assertj.core.api.Assertions
import org.junit.Test

class GpsServiceTest  {

    @Test
    fun `resolver truck destination for WharehouseA`() {
        val gps = Gps();
        val truckDestiny = gps.route(ContainerLocation.WHAREHOUSEA)

        Assertions.assertThat(truckDestiny).isEqualTo(TruckDestination.PORT)
    }

    @Test
    fun `resolver truck destination for WharehouseB`() {
        val gps = Gps();
        val truckDestiny = gps.route(ContainerLocation.WHAREHOUSEB)

        Assertions.assertThat(truckDestiny).isEqualTo(TruckDestination.WHAREHOUSEB)
    }
}
