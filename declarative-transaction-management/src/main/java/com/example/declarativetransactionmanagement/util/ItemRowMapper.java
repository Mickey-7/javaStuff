package com.example.declarativetransactionmanagement.util;

import com.example.declarativetransactionmanagement.model.Item;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRowMapper implements RowMapper<Item> {
    @Override
    public Item mapRow(ResultSet resultSet, int i) throws SQLException {
        Item item = new Item();
        item.setItemId(resultSet.getLong("item_id"));
        item.setItemName(resultSet.getString("item_name"));
        item.setItemDesc(resultSet.getString("item_desc"));
        item.setItemPrice(resultSet.getDouble("item_price"));
        return item;
    }
}
