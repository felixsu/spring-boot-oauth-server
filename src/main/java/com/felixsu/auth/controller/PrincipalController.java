package com.felixsu.auth.controller;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * Created on 10/16/17.
 *
 * @author felixsoewito
 */
@RestController
@RequestMapping("/principal")
public class PrincipalController {

    @RequestMapping(
            method = RequestMethod.GET
    )
    public Principal getPrincipalDetails(Principal principal) {
        return principal;
    }
}
