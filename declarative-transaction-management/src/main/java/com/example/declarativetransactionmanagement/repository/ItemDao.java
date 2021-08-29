package com.example.declarativetransactionmanagement.repository;

import com.example.declarativetransactionmanagement.model.Item;
import com.example.declarativetransactionmanagement.util.ItemRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Item> getItems(){
        String sql = "SELECT * FROM item";
        List<Item> items = new ArrayList<>();
        items = jdbcTemplate.query(sql,new ItemRowMapper());
        return items;
    }

    public void addItem(Item item){
        String sql = "INSERT INTO item VALUES(?,?,?,?)";
        jdbcTemplate.update(sql, new Item(item.getItemId(), item.getItemName(), item.getItemDesc(),item.getItemPrice()));
    }

    public void update(Item item){
        String sql = "UPDATE item SET item_name=?,item_desc=?,item_price=? WHERE item_id=?";
        jdbcTemplate.update(sql, new Item(item.getItemId(), item.getItemName(), item.getItemDesc(),item.getItemPrice()));
    }

    public void deleteItem(Item item) throws Exception {
        String sql = "DELETE FROM item WHERE item_id=?";
        jdbcTemplate.update(sql, item.getItemId());
        throw new Exception();
        //In the above DAO class, I have thrown new Exception() from deleteItem() method
        //even after deletion of an item to show you that the data gets rolled back on Exception.
        //Ideally you should code to interface to achieve loose coupling
        //but here for showing an example I have used class as a DAO.
    }
}
