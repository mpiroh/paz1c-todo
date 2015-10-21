package sk.upjs.ics.todo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Uloha {
    private Long id;
    
    private String nazov;
    
    private Date date;
    
    private SimpleDateFormat dateFormat = new SimpleDateFormat("d.M.yyyy");    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return this.nazov + " (termín " + dateFormat.format(this.date) + ")";
    }
}