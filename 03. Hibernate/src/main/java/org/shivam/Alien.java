package org.shivam;

import jakarta.persistence.*;

//@Entity(name = "alien_table") // Keep a custom entity name
@Entity
@Table(name = "alien_table") // Does not change the entity name just changing the table name
public class Alien {

    @Id
    private int aid;
    @Column(name = "alien_name") // Custom column name
    private String aname;
    @Transient // This make sures that the attached data will not be stored in db, tech in this case
    private String tech;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
}
