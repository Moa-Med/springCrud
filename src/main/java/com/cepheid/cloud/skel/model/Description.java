package com.cepheid.cloud.skel.model;

import javax.persistence.*;

@Entity
public class Description {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String descriptionDetail ;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item ;

    public Description( String descriptionDetail , Item item) {
        this.descriptionDetail = descriptionDetail;
        this.item = item;
    }

    public Description() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescriptionDetail() {
        return descriptionDetail;
    }

    public void setDescriptionDetail(String descriptionDetail) {
        this.descriptionDetail = descriptionDetail;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
