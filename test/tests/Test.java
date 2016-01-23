/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.util.List;
import meetupmanager.*;


/**
 *
 * @author Rob
 */
public class Test {
    
    public static void main(String[] args){
         BaseHelper helper;
         helper = new EventsHelper();
         List<Events> objects = helper.fetchAll();
         for(Events e : objects){
             System.out.println(e.getName());
         }
    }
}
