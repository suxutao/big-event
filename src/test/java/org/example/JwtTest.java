package org.example;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JwtTest {


    @Test
    public void testJwt() {
        Map<String, Object>claims=new HashMap<>();
        claims.put("id",1);
        claims.put("username","张三");
        String token = JWT.create()
                .withClaim("user", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12))
                .sign(Algorithm.HMAC256("key"));
        System.out.println(token);
    }

    @Test
    public void parseJwt(){
        String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGFpbXMiOnsiaWQiOjQsInVzZXJuYW1lIjoiYWFhYWEifSwiZXhwIjoxNzM1NDM1MzMwfQ.wa7F0vfTJvRLVQFGz87CIABMR_sr8tuZUDB60aazCw0";
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("key")).build();
        System.out.println(verifier.verify(token).getClaims());
    }
}
