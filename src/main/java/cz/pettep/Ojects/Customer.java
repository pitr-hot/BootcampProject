package cz.pettep.Ojects;

import java.util.Date;

public class Customer {
    public String CU_OLD_ID;
    public String CU_TYPE;
    public String CU_ORIGIN_DATE;
    public String CU_REG_DATE;
    public String CU_PHONE_NUMBER;
    public String CU_NAME;

    public Customer(String CU_OLD_ID, String CU_NAME, String CU_TYPE, String CU_ORIGIN_DATE, String CU_REG_DATE, String CU_PHONE_NUMBER) {
        this.CU_OLD_ID = CU_OLD_ID;
        this.CU_TYPE = CU_TYPE;
        this.CU_ORIGIN_DATE = CU_ORIGIN_DATE;
        this.CU_REG_DATE = CU_REG_DATE;
        this.CU_PHONE_NUMBER = CU_PHONE_NUMBER;
        this.CU_NAME = CU_NAME;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "CU_OLD_ID=" + CU_OLD_ID +
                ", CU_TYPE=" + CU_TYPE +
                ", CU_ORIGIN_DATE=" + CU_ORIGIN_DATE +
                ", CU_REG_DATE=" + CU_REG_DATE +
                ", CU_PHONE_NUMBER=" + CU_PHONE_NUMBER +
                ", CU_NAME='" + CU_NAME + '\'' +
                '}';
    }
}
