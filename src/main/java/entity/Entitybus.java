package entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * Created by Olga Pavlova on 9/16/2016.
 */
@Entity
@Table(name = "entitybus")
public class Entitybus {
    private int eid;

    private String enumber;

    @Id
    @Column(name = "EID", nullable = false)
    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    @Basic
    @Column(name = "ENUMBER", nullable = true, length = 255)
    public String getEnumber() {
        return enumber;
    }


    public void setEnumber(String enumber) {
        this.enumber = enumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entitybus entitybus = (Entitybus) o;

        if (eid != entitybus.eid) return false;
        if (enumber != null ? !enumber.equals(entitybus.enumber) : entitybus.enumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eid;
        result = 31 * result + (enumber != null ? enumber.hashCode() : 0);
        return result;
    }
}
