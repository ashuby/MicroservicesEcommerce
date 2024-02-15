package org.example.Controller;

import org.bson.types.ObjectId;
import org.example.Service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class TokenController {
    @Autowired
    TokenService tokenService;
    @PostMapping("/gettoken/{id}")
    public String getToken(@PathVariable("id") String id) {
        return tokenService.createTokenFunction(new ObjectId(id));
    }
}
