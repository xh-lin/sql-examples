package com.perscholas.applying_oop_to_jdbc.daos;

import java.util.List;

import com.perscholas.applying_oop_to_jdbc.models.Item;

public interface ItemDAOI {
    
    enum SQL {
        GET_ALL_ITEMS("SELECT * FROM item"),
        ADD_ITEM("INSERT item VALUES(?, ?, ?)"),
        REMOVE_ITEM_BY_ID("DELETE FROM item WHERE id = ?");
        private final String query;
        private SQL(String s) { this.query = s; }
        public String getQuery() { return query; }
    }

    public List<Item> getAllItems();

    public void addItem(Item i);

    public void removeItemById(int id);

}
