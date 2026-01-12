package com.learn.spring.boot.controllers;

import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.learn.spring.boot.services.VideoService;
import com.learn.spring.boot.pojos.VideoDTO;
import com.learn.spring.boot.pojos.VideoEntity;
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
        model.addAttribute("videos", videoService.findAll());
        return "home";
    }

    @PostMapping("/new-video")
    public String newVideo(@ModelAttribute VideoEntity videoEntity, Model model)
    {
	    videoService.save(videoEntity);
	    return "redirect:/";
    }
/*
	@GetMapping("/react")
	public String reactMethod()
	{
		return "react";
	}
*/
    @GetMapping("/multi-field-search")
    public String multiFieldSearch(@ModelAttribute VideoDTO videoDTO, Model model)
    {                               // @ModelAttribute binds form fields to DTO
        List<VideoEntity> searchResultVideos = videoService.findByNameContainingAndDescriptionContaining(videoDTO.name(), videoDTO.description());
        model.addAttribute("searchResultVideos", searchResultVideos);
        return "home";
    }
}
