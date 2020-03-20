package newKata

import domain.Locations.*
import domain.Truck
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import useCase.SendCargosToWarehouses

class SendCargosToWarehousesShould {

    @Test
    fun `returns 5 hours when shipping to WAREHOUSE_B warehouse 5 hours`() {
        val warehouse = listOf(WAREHOUSE_B)
        val trucks = listOf(Truck())

        val timeDelivered = SendCargosToWarehouses(trucks).execute(warehouse)

        assertThat(timeDelivered).isEqualTo(5)
    }

    @Test
    fun `return 25 hours when one truck go to WAREHOUSE_B `() {
        val warehouse = listOf(WAREHOUSE_B, WAREHOUSE_B, WAREHOUSE_B)
        val trucks = listOf(Truck())

        val timeDelivered = SendCargosToWarehouses(trucks).execute(warehouse)

        assertThat(timeDelivered).isEqualTo(25)
    }

    @Test
    fun `return 15 hours when two truck go to WAREHOUSE_B`() {
        val warehouse = listOf(WAREHOUSE_B, WAREHOUSE_B, WAREHOUSE_B)
        val trucks = listOf(Truck(), Truck())

        val timeDelivered = SendCargosToWarehouses(trucks).execute(warehouse)

        assertThat(timeDelivered).isEqualTo(15)
    }
}
