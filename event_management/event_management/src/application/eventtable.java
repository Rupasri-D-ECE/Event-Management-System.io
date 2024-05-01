package application;

import javafx.beans.property.*;


public class eventtable {
   // private final IntegerProperty taskIdProperty = new SimpleIntegerProperty();
    private final StringProperty eventnameProperty = new SimpleStringProperty();
   private final StringProperty dateProperty = new SimpleStringProperty();
    private final StringProperty descriptionProperty = new SimpleStringProperty();
    private final StringProperty timeProperty = new SimpleStringProperty();
    
    public eventtable() {
    }

    public eventtable(String eventname, String description, String date,String time) {
        this.eventnameProperty.set(eventname);
        this.descriptionProperty.set(description);
        this.dateProperty.set(date);
        this.timeProperty.set(time);
        
    }

 

    public String geteventname() {
        return eventnameProperty.get();
    }

    public void eventname(String eventname) {
        this.eventnameProperty.set(eventname);
    }

    public StringProperty eventnameProperty() {
        return eventnameProperty;
    }
    public String getDescription() {
        return descriptionProperty.get();
    }

    public void setDescription(String description) {
        this.descriptionProperty.set(description);
    }

    public StringProperty descriptionProperty() {
        return descriptionProperty;
    }
    

    public String getdate() {
        return dateProperty.get();
    }

    public void setdate(String date) {
        this.dateProperty.set(date);
    }

    public StringProperty dateProperty() {
        return dateProperty;
    }
    
    public void settime(String time) {
        this.timeProperty.set(time);
    }
    
    public StringProperty timeProperty() {
        return timeProperty;
    }

    

    @Override
    public String toString() {
        return "eventtable{" +
                ", eventname='" + eventnameProperty.get() + '\'' +
                ", description='" + descriptionProperty.get() + '\'' +
                ", date='" + dateProperty.get() + '\'' +
                ", time='"+timeProperty.get()+'\''+
                '}';
    }
}