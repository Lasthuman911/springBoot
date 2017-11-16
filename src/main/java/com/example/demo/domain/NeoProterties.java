package com.example.demo.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 读取配置信息
 *
 * @author wzm
 * @create 2017-11-16-13:50
 */
@Component
public class NeoProterties {
    @Value("${com.neo.title}")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Value("${com.neo.description}")

    private String description;
}
