package com.example.poke_groovy.dex

import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping("/pokemon")
class PokeDex {
    static final String PREFIX_URL = "https://pokeapi.co/api/v2"

    @RequestMapping("/dex/{id}")
    String getPokemonById(@PathVariable("id") String id) {
        RestTemplate template = new RestTemplate()
        template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        template.getMessageConverters().add(new StringHttpMessageConverter());
        HttpHeaders headers = new HttpHeaders()
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON))
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36")

        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers)

        String url = PREFIX_URL + "/pokemon/" + id
        return template.exchange(url, HttpMethod.GET, entity, String.class)
    }

    @RequestMapping("/ability/{id}")
    String getAbilityById(@PathVariable("id") String id) {
        RestTemplate template = new RestTemplate()
        template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        template.getMessageConverters().add(new StringHttpMessageConverter());
        HttpHeaders headers = new HttpHeaders()
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON))
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36")

        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers)

        String url = PREFIX_URL + "/ability/" + id
        return template.exchange(url, HttpMethod.GET, entity, String.class)
    }
}