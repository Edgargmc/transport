package newKata

import domain.Factory
import domain.Wharehouses
import domain.TruckDestinationService
import domain.Truck
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import useCase.SendCargoesToWarehouses

class SendCargoesToWarehousesShould {
    @Test
    fun `returns 5 hours when shipping to warehouse b hours`() {
        val warehouse = listOf(Wharehouses.B)
        val trucks = listOf(Truck(TruckDestinationService()))

        val timeDelivered = sendCargoesToWarehouses(trucks).execute(warehouse)

        assertThat(timeDelivered).isEqualTo(5)
    }

    @Test
    fun `return 25 hours when one truck go to WAREHOUSE_B `() {
        val warehouse = listOf(Wharehouses.B, Wharehouses.B, Wharehouses.B)
        val trucks = listOf(Truck(TruckDestinationService()))

        val timeDelivered = sendCargoesToWarehouses(trucks).execute(warehouse)

        assertThat(timeDelivered).isEqualTo(25)
    }

    @Test
    fun `return 15 hours when two truck go to WAREHOUSE_B`() {
        val warehouse = listOf(Wharehouses.B, Wharehouses.B, Wharehouses.B)
        val trucks = listOf(Truck(TruckDestinationService()), Truck(TruckDestinationService()))

        val timeDelivered = sendCargoesToWarehouses(trucks).execute(warehouse)

        assertThat(timeDelivered).isEqualTo(15)
    }

    private fun sendCargoesToWarehouses(trucks: List<Truck>) = SendCargoesToWarehouses(trucks, Factory(trucks))
}
