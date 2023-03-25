package se.atg.service.harrykart.kotlin.rest

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kotlin/api")
class HarryKartController {

    @PostMapping(path = ["/play"], consumes = [MediaType.APPLICATION_XML_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun playHarryKart(): String {
        return """{ "message": "Don't know how to play yet" }"""
    }
}
