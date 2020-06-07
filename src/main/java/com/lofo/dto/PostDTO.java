package com.lofo.dto;

import java.io.Serializable;
import java.util.Objects;

public class PostDTO  implements Serializable {
     private int id;
     private int userId;
     private String type;
     private String category;
     private String date;

    public PostDTO(int id, int userId, String type, String category, String date) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.category = category;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostDTO)) return false;
        PostDTO postDTO = (PostDTO) o;
        return getId() == postDTO.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
