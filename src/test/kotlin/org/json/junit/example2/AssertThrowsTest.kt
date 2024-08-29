package org.json.junit.example2

import org.json.junit.example2.assertions.NoJobException
import org.json.junit.example2.assertions.SUT
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test


class AssertThrowsTest {
    private val systemUnderTest = SUT(
        systemName = "테스트 대상 시스템"
    )

    @Test
    @DisplayName("예외가 발생하고 예외에 대한 참조가 유지되는지 검증한다")
    fun testCatchException() {
        val throwable: Throwable = assertThrows("오류발생", { systemUnderTest.run {1000} })

        assertEquals("실행할 작업이 없습니다!", throwable.message)
    }
}