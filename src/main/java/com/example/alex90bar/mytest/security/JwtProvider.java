package com.example.alex90bar.mytest.security;

import static io.jsonwebtoken.Jwts.parser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Jwts;
import java.security.Key;
import java.time.Instant;
import java.util.Date;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

/**
 * JwtProvider
 *
 * @author alex90bar
 */

@Service
public class JwtProvider {

  private final String jwtSecret = "secret1256/sEcrEt1256//sEcrEt1256//sEcrEt1256/";
  private final Key jwtAccessSecret = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));


  public String generateToken(Authentication authentication){
    User principal = (User) authentication.getPrincipal();
    return Jwts.builder()
        .setSubject(principal.getUsername())
        .setIssuedAt(Date.from(Instant.now()))
        .signWith(jwtAccessSecret, SignatureAlgorithm.HS256)
        .setExpiration(Date.from(Instant.now().plusMillis(1209600000)))  //примерно 2 недели
        .compact();
  }

  public boolean validateToken(String jwt){
    parser().setSigningKey(jwtSecret).parseClaimsJws(jwt);
    return true;
  }


  public String getUserNameFromJwt(String token){
    Claims claims = parser()
        .setSigningKey(jwtSecret)
        .parseClaimsJws(token)
        .getBody();
    return claims.getSubject();
  }


}


