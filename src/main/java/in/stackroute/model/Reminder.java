package in.stackroute.model;

import java.time.LocalDate;

public class Reminder {

    private int id;
    private String text;
    private String date;
    private boolean remind;


    public Reminder() {
    }

    public Reminder(int id, String text,String date, boolean remind) {
        this.id = id;
        this.text = text;
        this.date = date;
        this.remind = remind;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isRemind() {
        return remind;
    }

    public void setRemind(boolean remind) {
        this.remind = remind;
    }



}