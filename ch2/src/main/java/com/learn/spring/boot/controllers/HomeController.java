package com.learn.spring.boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.learn.spring.boot.services.*;
import com.learn.spring.boot.pojos.*;
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

    @PostMapping("/new-video")
    public String newVideo(@RequestParam String name)
    {
	videoService.addVideo(new Video(name));
	return "redirect:/";
    }
	
	@GetMapping("/react")
	public String reactMethod()
	{
		return "react";
	}
}
