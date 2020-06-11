package net.medeiser.samples.oauth.secure.resourceserver.api.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController {

    @GetMapping("/{name}")
    fun getUserPin(@PathVariable name: String): String = "Hello $name"

}
