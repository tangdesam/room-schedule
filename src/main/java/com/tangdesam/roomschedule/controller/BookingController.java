package com.tangdesam.roomschedule.controller;

import com.tangdesam.roomschedule.dao.BookingDao;
import com.tangdesam.roomschedule.dao.RoomDao;
import com.tangdesam.roomschedule.entity.Booking;
import com.tangdesam.roomschedule.entity.Room;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingDao bookingDao;
    @Autowired
    private RoomDao roomDao;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("bookingList", bookingDao.findAll());
        return("booking/list");
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("booking", new Booking());
        model.addAttribute("roomList", roomDao.findAll());
        return("booking/create");
    }

    @PostMapping("/save")
    public String save(RedirectAttributes redirectAttributes, @Valid Booking booking, BindingResult result) {

        if (result.hasErrors()) {
            return "room/create";
        }

        bookingDao.save(booking);

        redirectAttributes.addFlashAttribute("message", "Booking created");
        redirectAttributes.addFlashAttribute("messageCss", "alert alert-success");

        return("redirect:/booking/list");
    }

}
