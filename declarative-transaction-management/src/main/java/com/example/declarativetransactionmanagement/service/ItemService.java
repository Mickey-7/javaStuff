package com.example.declarativetransactionmanagement.service;

import com.example.declarativetransactionmanagement.model.Item;
import com.example.declarativetransactionmanagement.repository.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ItemService {
    @Autowired
    private ItemDao itemDao;

    @Transactional(readOnly = true)
    public List<Item> getItems(){
        return itemDao.getItems();
    }

    public void addItem(Item item){
        itemDao.addItem(item);
    }

    public void updateItem(Item item){
        itemDao.update(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteItem(Item item) throws Exception {
        itemDao.deleteItem(item);
    }
}
