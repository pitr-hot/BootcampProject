package cz.pettep.Ojects;

import java.util.Date;

public class Vehicle {
    public int VEH_OLD_ID;
    public int VEH_CU_ID;
    public String VEH_VIN;
    public Date VEH_REG_DATE;
    public String VEH_REG_COUNTRY;
    public String VEH_MANUFACTURER;
    public String VEH_TYPE;
    public String VEH_BODY;
    public String VEH_ENGINE;
    public String VEH_RESTRAINT;
    public String VEH_MODEL;
    public int VEH_YEAR;
    public String VEH_PLANT;
    public String VEH_SERIAL_NUMBER;

    public Vehicle(int VEH_OLD_ID, int VEH_CU_ID, String VEH_VIN, Date VEH_REG_DATE, String VEH_REG_COUNTRY, String VEH_MANUFACTURER, String VEH_TYPE, String VEH_BODY, String VEH_ENGINE, String VEH_RESTRAINT, String VEH_MODEL, int VEH_YEAR, String VEH_PLANT, String VEH_SERIAL_NUMBER) {
        this.VEH_OLD_ID = VEH_OLD_ID;
        this.VEH_CU_ID = VEH_CU_ID;
        this.VEH_VIN = VEH_VIN;
        this.VEH_REG_DATE = VEH_REG_DATE;
        this.VEH_REG_COUNTRY = VEH_REG_COUNTRY;
        this.VEH_MANUFACTURER = VEH_MANUFACTURER;
        this.VEH_TYPE = VEH_TYPE;
        this.VEH_BODY = VEH_BODY;
        this.VEH_ENGINE = VEH_ENGINE;
        this.VEH_RESTRAINT = VEH_RESTRAINT;
        this.VEH_MODEL = VEH_MODEL;
        this.VEH_YEAR = VEH_YEAR;
        this.VEH_PLANT = VEH_PLANT;
        this.VEH_SERIAL_NUMBER = VEH_SERIAL_NUMBER;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "VEH_OLD_ID=" + VEH_OLD_ID +
                ", VEH_CU_ID=" + VEH_CU_ID +
                ", VEH_VIN='" + VEH_VIN + '\'' +
                ", VEH_REG_DATE=" + VEH_REG_DATE +
                ", VEH_REG_COUNTRY='" + VEH_REG_COUNTRY + '\'' +
                ", VEH_MANUFACTURER='" + VEH_MANUFACTURER + '\'' +
                ", VEH_TYPE='" + VEH_TYPE + '\'' +
                ", VEH_BODY='" + VEH_BODY + '\'' +
                ", VEH_ENGINE='" + VEH_ENGINE + '\'' +
                ", VEH_RESTRAINT='" + VEH_RESTRAINT + '\'' +
                ", VEH_MODEL='" + VEH_MODEL + '\'' +
                ", VEH_YEAR=" + VEH_YEAR +
                ", VEH_PLANT='" + VEH_PLANT + '\'' +
                ", VEH_SERIAL_NUMBER='" + VEH_SERIAL_NUMBER + '\'' +
                '}';
    }
}
