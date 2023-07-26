package ru.findfood.PersonalArea.dtos;

import java.util.List;

public class ListResponse<T> {

    List<T> list;

    public ListResponse() {
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }


}
