package com.cepheid.cloud.skel.controller;

import java.util.Collection;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.cepheid.cloud.skel.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cepheid.cloud.skel.model.Item;
import com.cepheid.cloud.skel.repository.ItemRepository;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PathVariable;


// curl http:/localhost:9443/app/api/1.0/items

@Component
@Path("/api/1.0/items")
@Api()
public class ItemController {

  private final ItemRepository mItemRepository;
  private final ItemServiceImpl mItemServiceImpl;

  @Autowired
  public ItemController(ItemRepository itemRepository, ItemServiceImpl itemServiceImpl) {
    mItemRepository = itemRepository;
    mItemServiceImpl = itemServiceImpl;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/hey/{id}")
  @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
  public String getItems(@PathParam("id") int id) {
    return id+" Test bravo ";
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Path("")
  @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
  public String createItem(int id) {
    return id+" Test bravo ";
  }

  @PostMapping("/products")
  public ResponseEntity<Product> createProduct(@RequestBody Product product){
    return ResponseEntity.ok().body(this.productService.createProduct(product));
  }




}
