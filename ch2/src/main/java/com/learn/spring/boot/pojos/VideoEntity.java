package com.learn.spring.boot.pojos;
import jakarta.persistence.*;
@Entity
public class VideoEntity
{
    private @Id @GeneratedValue Long id;
    private String name;
    private String description;

    protected VideoEntity()     // a default constructor - just to satisfy JPA's specs. 'protected' access because we dont want accidental object creations by user
    {
        this(null,null);
    }

    public VideoEntity(String name, String description)
    {
        this.id = null;
        this.name = name;
        this.description = description;
    }

    public Long getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getDescription()
    {
        return description;
    }

}
