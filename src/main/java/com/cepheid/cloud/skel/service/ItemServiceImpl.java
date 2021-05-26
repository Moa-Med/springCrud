package com.cepheid.cloud.skel.service;

import com.cepheid.cloud.skel.exception.ResourceNotFoundException;
import com.cepheid.cloud.skel.model.Item;
import com.cepheid.cloud.skel.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }


    @Override
    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Long itemId) {

        Optional<Item> itemDb = itemRepository.findById(itemId);

        if(itemDb.isPresent()) {
            return itemDb.get();
        }else {
            throw new ResourceNotFoundException("Record not found with id : " + itemId);
        }
    }

    @Override
    public Item updateItem(Item item) {

        Optional<Item> itemDb =   itemRepository.findById(item.getId());

        if(itemDb.isPresent()) {
            Item itemUpdate = itemDb.get();
            itemUpdate.setId(item.getId());
            itemUpdate.setName(item.getName());
            itemUpdate.setState(item.getState());
            itemRepository.save(itemUpdate);
            return itemUpdate;
        }else {
            throw new ResourceNotFoundException("Record not found with id : " + item.getId());
        }

    }


    @Override
    public void deleteItem(Long itemId) {

        Optional<Item> itemDb = itemRepository.findById(itemId);

        if (itemDb.isPresent()) {
            itemRepository.delete(itemDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + itemId);

        }

    }
}
