package org.example;

import entity.Client;
import grud.ClientDaoRealization;
import storage.DatabaseInitService;

public class Main {
    public static void main(String[] args){


       // new DatabaseInitService().initDb();
       System.out.println( new ClientDaoRealization().findById(2));
      // new ClientDaoRealization().save(new Client());
    }



}