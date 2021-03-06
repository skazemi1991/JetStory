package com.jetlightstudio.jetstory.Models;


import com.jetlightstudio.jetstory.R;

import java.io.Serializable;

/**
 * Created by oussama on 08/03/2018.
 */

public class Story implements Serializable {
    private String title, author, date;
    private String content;
    private int id;

    public enum Category {
        action, comedy, romance, moral, kids
    }

    private Category category;
    private int time;

    public Story(String title, String author, String date, String content, int id, int time, String category) {
        this.title = title;
        this.author = author;
        this.date = date;
        this.content = content;
        this.id = id;
        this.category = categoryFromString(category);
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public Category getCategory() {
        return category;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public int getTime() {
        return time;
    }

    Category categoryFromString(String category) {
        category = category.toLowerCase();
        if (category.matches("action"))
            return Story.Category.action;
        else if (category.matches("comedy"))
            return Story.Category.comedy;
        else if (category.matches("romance"))
            return Story.Category.romance;
        else if (category.matches("moral"))
            return Story.Category.moral;
        else if (category.matches("kids"))
            return Story.Category.kids;
        else return Category.action;
    }

}
