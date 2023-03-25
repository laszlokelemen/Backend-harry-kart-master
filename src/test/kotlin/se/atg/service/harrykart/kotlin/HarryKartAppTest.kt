package se.atg.service.harrykart.kotlin

import io.restassured.RestAssured
import io.restassured.RestAssured.`when`
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import io.restassured.http.Header
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import java.net.URI

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("kotlin-test")
class HarryKartAppTest {

    private val harryKartApp = URI.create("http://localhost:8282/kotlin/api/play")

    @BeforeAll
    fun enableLoggingOfRequestAndResponseIfValidationFails() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails()
    }

    @Test
    fun `Trying to GET instead of POST should return 405 Method not allowed`() {
        `when`()
            .get(harryKartApp)
        .then()
            .assertThat()
            .statusCode(405)
    }

    @Test
    fun `The application doesn't know how to play yet`() {
        given()
            .header(Header("Content-Type", ContentType.XML.toString()))
        .`when`()
            .post(harryKartApp)
        .then()
            .assertThat()
            .statusCode(200)
            .and()
            .header("Content-Type", ContentType.JSON.toString())
            .and()
            .body("message", equalTo("Don't know how to play yet"))
    }
}
