package com.felixsu.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 10/16/17.
 *
 * @author felixsoewito
 */
@RestController
public class ExceptionController {

    @RequestMapping("/unauthenticated")
    public String unauthenticated() {
        return "redirect:/?error=true";
    }
}
