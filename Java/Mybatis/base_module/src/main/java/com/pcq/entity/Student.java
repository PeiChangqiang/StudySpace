package com.pcq.entity;

public class Student {
    private String sId;
    private String sName;
    private Integer sAge;
    private String sSes;

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Integer getsAge() {
        return sAge;
    }

    public void setsAge(Integer sAge) {
        this.sAge = sAge;
    }

    public String getsSes() {
        return sSes;
    }

    public void setsSes(String sSes) {
        this.sSes = sSes;
    }
}
