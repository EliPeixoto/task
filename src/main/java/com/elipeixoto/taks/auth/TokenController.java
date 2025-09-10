package com.elipeixoto.taks.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/token")
@RestController
public class TokenController {


    @PostMapping()
    public ResponseEntity<String> token(@RequestBody Usuario user){

        HttpHeaders headers = new HttpHeaders();
        RestTemplate rest = new RestTemplate();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id", user.clientId);
        formData.add("username", user.username);
        formData.add("password", user.password);
        formData.add("grant_type", user.grantType);

        HttpEntity<MultiValueMap<String, String>> entity
                = new HttpEntity<MultiValueMap<String, String>>(formData, headers);

       var result =  rest.postForEntity("http://localhost:8080/realms/meuprojeto/protocol/openid-connect/token", entity, String.class);

       return result;
    }

    public record Usuario(String password, @JsonProperty("client_id") String clientId, @JsonProperty("grant_type") String grantType, String username){}
}
