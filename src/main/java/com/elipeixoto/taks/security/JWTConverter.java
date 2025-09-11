package com.elipeixoto.taks.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.*;
import java.util.stream.Collectors;

public class JWTConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        Set<String> roles = new HashSet<>();

        // Pega roles do realm_access
        Map<String, Object> realmAccess = jwt.getClaim("realm_access");
        if (realmAccess != null && realmAccess.containsKey("roles")) {
            roles.addAll((Collection<String>) realmAccess.get("roles"));
        }

        // Pega roles do resource_access
        Map<String, Object> resourceAccess = jwt.getClaim("resource_access");
        if (resourceAccess != null) {
            resourceAccess.forEach((client, access) -> {
                Map<String, Object> clientAccess = (Map<String, Object>) access;
                if (clientAccess.containsKey("roles")) {
                    roles.addAll((Collection<String>) clientAccess.get("roles"));
                }
            });
        }

        // Converte para authorities do Spring
        Collection<GrantedAuthority> authorities = roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.toUpperCase()))
                .collect(Collectors.toSet());

        return new JwtAuthenticationToken(jwt, authorities);
    }

}
