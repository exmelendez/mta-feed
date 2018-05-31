package com.example.android.mta;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="line")
public class LineStatus {

    @Element(name="name")
    private String line;

    @Element(name="status")
    private String status;

    @Element(name="Date")
    private String date;

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return line + " " + status + " " + date;
    }
}
