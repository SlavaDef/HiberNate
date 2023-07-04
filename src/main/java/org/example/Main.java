package org.example;

import grud.ClientDaoRealization;
import storage.DatabaseInitService;

public class Main {
    public static void main(String[] args){


       // new DatabaseInitService().initDb();
       System.out.println( new ClientDaoRealization().findById(2));
    }



}