package com.perscholas.applying_oop_to_jdbc.daos;

import java.util.ArrayList;
import java.util.List;

import com.perscholas.applying_oop_to_jdbc.models.Item;

public class ItemDAO extends DAO implements ItemDAOI {

    @Override
    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        try {
            connect();
            ps = conn.prepareStatement(SQL.GET_ALL_ITEMS.getQuery());
            rs = ps.executeQuery();
            while (rs.next()) {
                items.add(new Item(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dispose();
        }
        return items;
    }

    @Override
    public void addItem(Item i) {
        try {
            connect();
            ps = conn.prepareStatement(SQL.ADD_ITEM.getQuery());
            ps.setInt(1, i.getId());
            ps.setString(2, i.getName());
            ps.setDouble(3, i.getPrice());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dispose();
        }
    }

    @Override
    public void removeItemById(int id) {
        try {
            connect();
            ps = conn.prepareStatement(SQL.REMOVE_ITEM_BY_ID.getQuery());
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dispose();
        }
    }
    
}
