package com.example.market.web.secuirty;

import io.jsonwebtoken.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class JWTUtil {
    private static final String KEY = "testing";

    public String generateToken(UserDetails userDetails){
        //Genera un JWT y lo retorna
        return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10 ))
                .signWith(SignatureAlgorithm.HS256, KEY).compact();
    }
}
