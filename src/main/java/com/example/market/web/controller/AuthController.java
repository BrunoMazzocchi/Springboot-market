package com.example.market.web.controller;

import com.example.market.domain.dto.*;
import com.example.market.domain.service.*;
import com.example.market.web.secuirty.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MarketUserDetailsService marketUserDetailsService;

    @Autowired
    private JWTUtil jwtUtil;
    @PostMapping("/authenticate")
    //autentifica
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getPassword(), request.getUsername()));

            //Envia los datos al JWT generator
            UserDetails userDetails = marketUserDetailsService.loadUserByUsername(request.getUsername());
            String jwt = jwtUtil.generateToken(userDetails);

            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
