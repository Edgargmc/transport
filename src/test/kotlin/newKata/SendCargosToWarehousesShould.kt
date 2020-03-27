package newKata

import domain.ContainerLocation
import domain.Truck
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import useCase.SendCargosToWarehouses

class SendCargosToWarehousesShould {

    @Test
    fun `returns 5 hours when shipping to WAREHOUSE_B warehouse 5 hours`() {
        val warehouse = listOf(ContainerLocation.WHAREHOUSEA)
        val trucks = listOf(Truck())

        val timeDelivered = SendCargosToWarehouses(trucks).execute(warehouse)

        assertThat(timeDelivered).isEqualTo(5)
    }
//
//    @Test
//    fun `return 25 hours when one truck go to WAREHOUSE_B `() {
//        val warehouse = listOf(WAREHOUSE_B, WAREHOUSE_B, WAREHOUSE_B)
//        val trucks = listOf(Truck())
//
//        val timeDelivered = SendCargosToWarehouses(trucks).execute(warehouse)
//
//        assertThat(timeDelivered).isEqualTo(25)
//    }
//
//    @Test
//    fun `return 15 hours when two truck go to WAREHOUSE_B`() {
//        val warehouse = listOf(WAREHOUSE_B, WAREHOUSE_B, WAREHOUSE_B)
//        val trucks = listOf(Truck(), Truck())
//
//        val timeDelivered = SendCargosToWarehouses(trucks).execute(warehouse)
//
//        assertThat(timeDelivered).isEqualTo(15)
//    }
//
//    @Test
//    fun `return 50 hours when can not delivery to WAREHOUSE_A`() {
//        val warehouse = listOf(WAREHOUSE_A)
//        val trucks = listOf(Truck())
//
//        val timeDelivered = SendCargosToWarehouses(trucks).execute(warehouse)
//
//        assertThat(timeDelivered).isEqualTo(50)
//    }
//
//    @Test
//    fun `return 5 hours when two truck go to WAREHOUSE_A`() {
//        val warehouse = listOf(WAREHOUSE_A)
//        val trucks = listOf(Truck())
//
//        val timeDelivered = SendCargosToWarehouses(trucks).execute(warehouse)
//
//        assertThat(timeDelivered).isEqualTo(1)
//    }
//
//    val ships = listOf<Ship>()
}
