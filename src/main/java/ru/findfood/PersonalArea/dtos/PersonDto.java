package ru.findfood.PersonalArea.dtos;

import java.util.Date;

public class PersonDto {
    private Long id;
    private String sex;
    private Date birthday;
    private Integer weight;
    private Integer height;
    private String activity_title;
    private String goal_title;

    public PersonDto() {
    }

    public PersonDto(Long id, String sex, Date birthday, Integer weight, Integer height, String activity_title, String goal_title) {
        this.id = id;
        this.sex = sex;
        this.birthday = birthday;
        this.weight = weight;
        this.height = height;
        this.activity_title = activity_title;
        this.goal_title = goal_title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getActivity_title() {
        return activity_title;
    }

    public void setActivity_title(String activity_title) {
        this.activity_title = activity_title;
    }

    public String getGoal_title() {
        return goal_title;
    }

    public void setGoal_title(String goal_title) {
        this.goal_title = goal_title;
    }
}
