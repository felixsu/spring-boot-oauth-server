package com.felixsu.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created on 10/16/17.
 *
 * @author felixsoewito
 */
@RestController
public class UserController {

    @RequestMapping("/user")
    public Principal user(Principal principal) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", principal.getName());
        return principal;
    }
}
