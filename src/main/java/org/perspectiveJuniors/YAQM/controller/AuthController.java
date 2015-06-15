package org.perspectiveJuniors.YAQM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by eljetto on 6/11/15.
 */
@Controller
public class AuthController {
    @RequestMapping(value = "/login")
    public String loginPage() {
        return "loginPage";
    }
}
