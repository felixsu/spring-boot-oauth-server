package com.felixsu.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 10/16/17.
 *
 * @author felixsoewito
 */
@RestController
public class UserController {

    @RequestMapping({ "/user", "/bearer/me" })
    public Map<String, Object> user(Principal principal) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", principal.getName());
        map.put("principal", principal);
        return map;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/bearer/hello"
    )
    public Principal secureHelloWorld(Principal principal) {
        return principal;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/bearer/muser"
    )
    public Principal secureUser(Principal principal) {
        return principal;
    }
}
