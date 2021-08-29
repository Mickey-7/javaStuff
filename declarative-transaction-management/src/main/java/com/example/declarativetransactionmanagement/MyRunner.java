package com.example.declarativetransactionmanagement;

import com.example.declarativetransactionmanagement.model.Item;
import com.example.declarativetransactionmanagement.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    private ItemService itemService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("----Available Items----");
        List<Item> items = itemService.getItems();
        items.forEach(System.out::println);
        System.out.println();

        try{
            Item delItem = new Item();
            delItem.setItemId(6L);
            itemService.deleteItem(delItem);
            System.out.println("Item successfully deleted.");
        }catch (Exception e){
            System.out.println("Item was not deleted.");
            System.out.println("Transaction rolled back due to Exception");
        }
        System.out.println();

        System.out.println("----Available Items After Delete----");
        List<Item> itemsAfterDelete = itemService.getItems();
        itemsAfterDelete.forEach(System.out::println);
        System.out.println();
    }
}
