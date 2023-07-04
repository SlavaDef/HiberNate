package org.example;

import entity.Client;
import grud.ClientCrudService;
import grud.PlanetCrudService;

import java.util.List;

public class Main {
    public static void main(String[] args){


       // new DatabaseInitService().initDb();
       System.out.println( new PlanetCrudService().getAll());
     //  Client client = new Client();
      // client.setName("Bob Terner");
       //new ClientDaoRealization().update(2L,"Liza Ducalis");
     //  List<Client> list =  new ClientCrudService().getAll();
      // System.out.println(list);
      //  System.out.println( new ClientDaoRealization().findById(11));
      // new ClientDaoRealization().save(new Client());

      //  HibernateUtil util = new HibernateUtil().getInstance();

    }



}