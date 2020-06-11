package net.medeiser.samples.oauth.secure.oauth2webclientsample.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction
import org.springframework.security.oauth2.client.web.server.UnAuthenticatedServerOAuth2AuthorizedClientRepository
import org.springframework.web.reactive.function.client.WebClient


@Configuration
class WebClientConfig {

    @Bean
    fun webClient(clientRegistrations: ReactiveClientRegistrationRepository): WebClient {
        val oauth = ServerOAuth2AuthorizedClientExchangeFilterFunction(clientRegistrations, UnAuthenticatedServerOAuth2AuthorizedClientRepository())
        oauth.setDefaultClientRegistrationId("custom")
        return WebClient.builder()
                .filter(oauth)
                .build()
    }

}
