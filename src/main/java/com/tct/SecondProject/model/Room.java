package com.tct.SecondProject.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Room {

    @Id
    private Integer id ;

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }


}
