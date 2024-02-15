package org.example.Controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("token-service/token")
public interface TokenRestConsumer {

    @PostMapping("/gettoken/{id}")
    public String getToken(@PathVariable("id") String id);
}
