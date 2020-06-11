package net.medeiser.samples.oauth.secure.oauth2webclientsample.api.controllers

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono

@RestController
@RequestMapping(value = ["facade"])
class FacadeController(private val webclient: WebClient) {

    @GetMapping(path=["/{name}"], produces = [MediaType.ALL_VALUE])
    fun getRemoteGreeting(@PathVariable name: String): Mono<String> = webclient
            .get()
            .uri { uriBuilder ->
                uriBuilder.path("localhost:8081/{name}")
                        .build(name)
            }
            .retrieve()
            .bodyToMono()
}
