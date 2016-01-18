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
@Named(value = "eventsController")
@Dependent
public class EventsController extends BaseController {

    private DataModel events;
    private EventsHelper helper;
    private Events current;


    public EventsController() {
        helper = new EventsHelper();
        startId = 1;
        endId = 10;
    }
    
    public EventsController(int startId, int endId) {
        helper = new EventsHelper();
        this.startId = startId;
        this.endId = endId;
    }

    public Events getSelected() {
        if (current == null) {
            current = new Events();
            selectedItemIndex = -1;
        }
        return current;
    }

    public DataModel getEvents() {
        if (events == null) {
            events = new ListDataModel(helper.getEvents(startId, endId));
        }
        return events;
    }

    void recreateModel() {
        events = null;
    }

    public String prepareView(){
        current = (Events) getEvents().getRowData();
        return "browse";
    }

}
