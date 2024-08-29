package org.json.junit.example2

import org.json.junit.example2.assertions.SUT
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertAll
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class AsertAllTest {
    @Test
    @DisplayName("기본적으로 테스트 대상 시스템은 검증하지 않는다")
    fun testSystemNotVerified() {
        val syustemUnderTest = SUT(
            systemName = "테스트 대상 시스템"
        )
        assertAll("테스트 대상 시스템을 검증하지 않았는지 확인", {
            assertEquals("테스트 대상 시스템", syustemUnderTest.systemName)
        }, {
            assertFalse { syustemUnderTest.isVerified!! }
        })

    }

    @Test
    @DisplayName("테스트 대상 시스템을 검증한다")
    fun testSystemUnderVerification() {
        val syustemUnderTest = SUT(
            systemName = "테스트 대상 시스템"
        )

        syustemUnderTest.isVerified = true

        assertAll("테스트 대상 시스템을 검증하지 않았는지 확인", {
            assertEquals("테스트 대상 시스템", syustemUnderTest.systemName)
        }, {
            assertTrue { syustemUnderTest.isVerified!! }
        })
    }

    @Test
    @DisplayName("테스트 대상 시스템을 검증한다")
    fun testSystemUnderVerification2() {
        val syustemUnderTest = SUT(
            systemName = "테스트 대상 시스템"
        )


        syustemUnderTest.isVerified = true

        assertTrue(syustemUnderTest.isVerified!!, "테스트 대상 시스템을 검증했는지 확인")
    }

    @Test
    @DisplayName("테스트 대상 시스템을 검증하지 않았다")
    fun testSystemUnderVerification3() {
        val syustemUnderTest = SUT(
            systemName = "테스트 대상 시스템"
        )

        assertFalse(syustemUnderTest.isVerified!!, "테스트 대상 시스템을 검증했는지 확인")
    }

    @Test
    @DisplayName("테스트 대상 시스템은 현재 작업이 없다")
    fun testNoJob() {
        val syustemUnderTest = SUT(
            systemName = "테스트 대상 시스템"
        )

        assertNull(syustemUnderTest.currentJob, "테스트 대상 시스템은 현재 작업이 없는지 확인")
    }
}