package com.tangdesam.roomschedule.controller;

import com.tangdesam.roomschedule.dao.RoomDao;
import com.tangdesam.roomschedule.entity.Room;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomDao roomDao;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("roomList", roomDao.findAll());
        return("room/list");
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("room", new Room());
        return("room/create");
    }

    @PostMapping("/save")
    public String save(RedirectAttributes redirectAttributes, @Valid Room room, BindingResult result) {

        if (result.hasErrors()) {
            return "room/create";
        }

        roomDao.save(room);

        redirectAttributes.addFlashAttribute("message", "Room created");
        redirectAttributes.addFlashAttribute("messageCss", "alert alert-success");

        return("redirect:/room/list");
    }

    @GetMapping("/edit/{roomId}")
    public String edit(@PathVariable("roomId") String roomId, Model model, RedirectAttributes redirectAttributes) {
        Room room = roomDao.findById(roomId).orElse(null);

        if (room == null) {
            redirectAttributes.addFlashAttribute("message", "Room not found");
            redirectAttributes.addFlashAttribute("messageCss", "alert alert-danger");

            return("redirect:/room/list");
        }

        model.addAttribute("room", room);
        return("room/edit");
    }

    @PostMapping("/update")
    public String update(RedirectAttributes redirectAttributes, @Valid Room room, BindingResult result) {

        if (result.hasErrors()) {
            return "room/edit";
        }

        roomDao.save(room);

        redirectAttributes.addFlashAttribute("message", "Room updated");
        redirectAttributes.addFlashAttribute("messageCss", "alert alert-success");

        return("redirect:/room/list");
    }

    @PostMapping("/delete")
    public String delete(RedirectAttributes redirectAttributes, HttpServletRequest request) {
        String roomId = "";
        if (request.getParameter("roomId") != null) roomId = request.getParameter("roomId");

        Room room = roomDao.findById(roomId).orElse(null);

        if (room != null) {
            roomDao.delete(room);
            redirectAttributes.addFlashAttribute("message", "Room deleted");
            redirectAttributes.addFlashAttribute("messageCss", "alert alert-success");
        }
        else {
            redirectAttributes.addFlashAttribute("message", "Room not found");
            redirectAttributes.addFlashAttribute("messageCss", "alert alert-danger");
        }

        return("redirect:/room/list");
    }

}
