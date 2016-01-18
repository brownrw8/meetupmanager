/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meetupmanager;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Rob
 */
@Named(value = "usersController")
@Dependent
public class UsersController extends BaseController {

    private DataModel users;
    private UsersHelper helper;
    private Users current;
    

    public UsersController() {
        helper = new UsersHelper();
        startId = 1;
        endId = 10;
    }
    
    public UsersController(int startId, int endId) {
        helper = new UsersHelper();
        this.startId = startId;
        this.endId = endId;
    }

    public Users getSelected() {
        if (current == null) {
            current = new Users();
            selectedItemIndex = -1;
        }
        return current;
    }


    public DataModel getUsers() {
        if (users == null) {
            users = new ListDataModel(helper.getUsers(startId, endId));
        }
        return users;
    }

    void recreateModel() {
        users = null;
    }

    public String prepareView(){
        current = (Users) getUsers().getRowData();
        return "browse";
    }

    
    
}
