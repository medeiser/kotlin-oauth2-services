package net.medeiser.samples.oauth.secure.resourceserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Oauth2ResourceServerSampleApplication

fun main(args: Array<String>) {
	runApplication<Oauth2ResourceServerSampleApplication>(*args)
}
