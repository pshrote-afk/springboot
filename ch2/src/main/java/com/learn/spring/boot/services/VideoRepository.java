package com.learn.spring.boot.services;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import com.learn.spring.boot.pojos.VideoEntity;

public interface VideoRepository //for writing a query, w/o writing a query
    extends JpaRepository<VideoEntity, Long> 
{
    List<VideoEntity> findByName(String name);
}
