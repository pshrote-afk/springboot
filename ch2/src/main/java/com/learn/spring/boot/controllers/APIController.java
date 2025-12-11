package com.learn.spring.boot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.learn.spring.boot.pojos.*;
import com.learn.spring.boot.services.*;
import java.util.*;

@RestController                     // RestControllers return only JSON
public class APIController
{
    private VideoService videoService;  // because this is a controller and I want to use this service. 
                                       // VideoService class has been marked as @Service. Hence it has business logic. And a single copy of it will be created
    public APIController(VideoService videoService)
    {
        this.videoService = videoService;
    }

    @GetMapping("/api/videos")
    public List<Video> getAll()
    {
        return videoService.getVideos();
    }

    @PostMapping("/api/videos")
    public Video newVideo(@RequestBody Video video)
    {
        videoService.addVideo(video);
        return video;   
    }

}

