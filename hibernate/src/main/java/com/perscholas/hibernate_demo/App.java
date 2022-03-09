package com.perscholas.hibernate_demo;

import com.perscholas.hibernate_demo.controller.FindUserHql;

public class App
{

    public static void main( String[] args )
    {
        FindUserHql u = new FindUserHql();
        u.findUser();
        u.findUserSelect();
    }

}
