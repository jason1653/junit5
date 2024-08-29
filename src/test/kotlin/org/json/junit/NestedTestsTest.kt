package org.json.junit

import org.json.junit.example2.Customer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.assertAll
import java.text.SimpleDateFormat
import kotlin.test.Test

class NestedTestsTest {
    val FIRST_NAME = "Jonh"
    val LAST_NAME = "Smith";

    @Nested
    inner class BuilderTest {
        private val MIDDLE_NAME = "Michael";

        @Test
        fun customerBuilder() {
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd");
            val customerDate = (simpleDateFormat).parse("2024-08-29");

            val customer = Customer(
                firstName = FIRST_NAME,
                middleName = MIDDLE_NAME,
                lastName = LAST_NAME,
                dateOfBirth = simpleDateFormat.format(customerDate)
            )


            assertAll(
                { assertEquals(FIRST_NAME, customer.firstName) },
                { assertEquals(MIDDLE_NAME, customer.middleName) },
                { assertEquals(LAST_NAME, customer.lastName) },
                { assertEquals("2024-08-29", customer.dateOfBirth) }
            )

        }
    }


}