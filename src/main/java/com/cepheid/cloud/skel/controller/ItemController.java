package com.cepheid.cloud.skel.controller;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.cepheid.cloud.skel.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cepheid.cloud.skel.model.Item;

import io.swagger.annotations.Api;

// curl http:/localhost:9443/app/api/1.0/items

@Component
@Path("/api/1.0/items")
@Api()
public class ItemController {

  private final ItemServiceImpl mItemServiceImpl;

  @Autowired
  public ItemController(ItemServiceImpl itemServiceImpl) {
    mItemServiceImpl = itemServiceImpl;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("")
  @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
  public ResponseEntity<List<Item>> getAllItems() {

      return ResponseEntity.ok().body(mItemServiceImpl.getAllItem());
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Path("")
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
  public ResponseEntity<Item> createItem(Item item) {

      return ResponseEntity.ok().body(mItemServiceImpl.createItem(item));
  }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public ResponseEntity<Item> getItemById(@PathParam("id") Long id) {

        return ResponseEntity.ok().body(mItemServiceImpl.getItemById(id));
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public ResponseEntity<Item> updateItemById(@PathParam("id") Long id ,Item item) {
         item.setId(id);
        return ResponseEntity.ok().body(mItemServiceImpl.updateItem(item));
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public HttpStatus deleteItemById(@PathParam("id") Long id ) {
        mItemServiceImpl.deleteItem(id);
        return HttpStatus.OK;
    }
}
