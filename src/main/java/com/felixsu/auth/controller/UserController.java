package com.felixsu.auth.controller;

import com.felixsu.auth.model.User;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.*;

/**
 * Created on 10/16/17.
 *
 * @author felixsoewito
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private List<User> users = new ArrayList<>();

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Optional<User> getEmployee(@RequestParam String email) {
        return users.stream().filter(x -> x.getEmail().equals(email)).findAny();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/details"
    )
    public Principal secureHelloWorld(Principal principal) {
        return principal;
    }
}
