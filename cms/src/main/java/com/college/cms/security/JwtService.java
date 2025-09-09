// package com.college.cms.security;

// import io.jsonwebtoken.ExpiredJwtException;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.MalformedJwtException;
// import io.jsonwebtoken.UnsupportedJwtException;
// import io.jsonwebtoken.io.Decoders;
// import io.jsonwebtoken.security.Keys;
// //import io.jsonwebtoken.security.SecurityException;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.stereotype.Service;

// import javax.crypto.SecretKey;
// import java.util.Date;

// @Service
// public class JwtService {
//     private static final Logger logger = LoggerFactory.getLogger(JwtService.class);

//     @Value("${jwt.secret.key}")
//     private String jwtSecret;

//     @Value("${jwt.expirationMs}")
//     private int jwtExpirationMs; // 86400000 = 24 hours

//     public String generateJwtToken(Authentication authentication) {
//         UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();

//         return Jwts.builder()
//                 .subject((userPrincipal.getUsername()))
//                 .issuedAt(new Date())
//                 .expiration(new Date((new Date()).getTime() + jwtExpirationMs))
//                 .signWith(getSigningKey(), Jwts.SIG.HS512)
//                 .compact();
//     }

//     public String getUserNameFromJwtToken(String token) {
//         return Jwts.parser()
//                 .verifyWith(getSigningKey())
//                 .build()
//                 .parseSignedClaims(token)
//                 .getPayload()
//                 .getSubject();
//     }

//     public boolean validateJwtToken(String authToken) {
//         try {
//             Jwts.parser()
//                 .verifyWith(getSigningKey())
//                 .build()
//                 .parseSignedClaims(authToken);
//             return true;
//         } catch (MalformedJwtException e) {
//             logger.error("Invalid JWT token: {}", e.getMessage());
//         } catch (ExpiredJwtException e) {
//             logger.error("JWT token is expired: {}", e.getMessage());
//         } catch (UnsupportedJwtException e) {
//             logger.error("JWT token is unsupported: {}", e.getMessage());
//         } catch (IllegalArgumentException e) {
//             logger.error("JWT claims string is empty: {}", e.getMessage());
//         } catch (Exception e) {
//             logger.error("JWT validation error: {}", e.getMessage());
//         }
//         return false;
//     }

//     private SecretKey getSigningKey() {
//         byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
//         return Keys.hmacShaKeyFor(keyBytes);
//     }
// }