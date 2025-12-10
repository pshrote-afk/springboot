package com.learn.spring.boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.learn.spring.boot.services.*;

@Controller
public class HomeController {

    private final VideoService videoService;

    public HomeController(VideoService videoService)        // constructor injection
    {
        this.videoService = videoService;
    }

    @GetMapping("/")
    public String home(Model model)
    {
        model.addAttribute("videos", videoService.getVideos());
        return "home";
    }
}
