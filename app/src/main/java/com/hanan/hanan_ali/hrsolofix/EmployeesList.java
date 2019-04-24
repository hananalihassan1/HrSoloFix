package com.hanan.hanan_ali.hrsolofix;

public class EmployeesList {
    String  name,Governorat,section,regest_reas,date,number;
    public EmployeesList()
    {

    }
    public EmployeesList(String name, String Governorat, String section, String regest_reas, String number, String date )
    {
        this.name=name;
        this.Governorat=Governorat;
        this.section=section;
        this.regest_reas=regest_reas;
        this.number=number;
        this.date=date;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGovernorat() {
        return Governorat;
    }

    public void setGovernorat(String governorat) {
        Governorat = governorat;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getRegest_reas() {
        return regest_reas;
    }

    public void setRegest_reas(String regest_reas) {
        this.regest_reas = regest_reas;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
