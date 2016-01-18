/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meetupmanager;

import javax.faces.model.DataModel;



/**
 *
 * @author Rob
 */
abstract class BaseController {
    protected int startId;
    protected int endId;
    protected int recordCount = 1000;
    protected int pageSize = 10;
    protected int selectedItemIndex;
    
    abstract void recreateModel(); 
    
     public boolean isHasNextPage() {
        if (endId + pageSize <= recordCount) {
            return true;
        }
        return false;
    }

    public boolean isHasPreviousPage() {
        if (startId-pageSize > 0) {
            return true;
        }
        return false;
    }

    public String next() {
        startId = endId+1;
        endId = endId + pageSize;
        recreateModel();
        return "index";
    }

    public String previous() {
        startId = startId - pageSize;
        endId = endId - pageSize;
        recreateModel();
        return "index";
    }

    public int getPageSize() {
        return pageSize;
    }
    
    public String prepareList(){
        recreateModel();
        return "index";
    }
}
