package com.learn.spring.boot.services;

import java.util.List;
import com.learn.spring.boot.pojos.*;
import org.springframework.stereotype.Service;

@Service
public class VideoService
{
private List<Video> videos = List.of(new Video("Vid 1"), new Video("Some Vid 2"), new Video("Some video which has a lenghty, long name 3"));
public List<Video> getVideos()
{
return this.videos;
}
}
