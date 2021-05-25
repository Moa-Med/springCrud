package com.cepheid.cloud.skel.service;

import com.cepheid.cloud.skel.model.Item;

import java.util.List;

public interface ItemService {

     List<Item> getAllItem();
     Item getItemById(Long itemId);
     Item updateItem(Item item);
     Item createItem (Item item);
     void deleteItem(Item Long);
}
