package com.cepheid.cloud.skel.model;

import javax.persistence.*;
import java.util.List;

enum State { UNDEFINED , VALID , INVALID }

@Entity
public class Item extends AbstractEntity {

    @Column(name = "name")
    private String name ;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private State state ;

    @OneToMany(mappedBy = "item")
    private List<Description> descriptions ;

    public Item(String name, State state) {
        this.name = name;
        this.state = state;
    }

    public Item() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
