package com.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@AttributeOverrides(
        {
                @AttributeOverride(name="vinNumber", column = @Column( name= "vin_number"))
        }
)
public class VehicleId implements Serializable {

    private String vinNumber;
    private long milage;

    public VehicleId() {
    }

    public VehicleId(String vinNumber, long milage) {
        this.vinNumber = vinNumber;
        this.milage = milage;
    }


    public String getVinNumber() {
        return vinNumber;
    }

    public VehicleId setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
        return this;
    }

    public long getMilage() {
        return milage;
    }

    public VehicleId setMilage(long milage) {
        this.milage = milage;
        return this;
    }
}
