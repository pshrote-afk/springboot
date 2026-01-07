package com.learn.spring.boot.services;

import java.util.*;
import org.springframework.stereotype.Service;

import com.learn.spring.boot.pojos.VideoEntity;
import com.learn.spring.boot.services.VideoRepository;

@Service
public class VideoService {
    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository)
    {
        this.videoRepository = videoRepository;
    }

    public List<VideoEntity> findAll()
    {
        return videoRepository.findAll();
    }

    public VideoEntity save(VideoEntity videoEntity)
    {
        return videoRepository.save(videoEntity);
    }

}
