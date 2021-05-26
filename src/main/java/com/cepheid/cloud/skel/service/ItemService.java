package com.cepheid.cloud.skel.service;

import com.cepheid.cloud.skel.model.Item;

import java.util.List;

/**
 * This interface allows the ItemServiceImpl to just get the right method for the application
 */
public interface ItemService {

     List<Item> getAllItem();
     Item getItemById(Long itemId);
     Item updateItem(Item item);
     Item createItem (Item item);
     void deleteItem(Long itemId);

}
