package com.tangdesam.roomschedule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/booking")
public class BookingController {
    @GetMapping("/list")
    public String list() {
        return("booking/list");
    }
}
