package cz.pettep.entity;

import java.time.LocalDate;

public class Customer {
    public int CU_OLD_ID;
    public String CU_NAME;
    public char CU_TYPE;
    public LocalDate CU_ORIGIN_DATE;
    public LocalDate CU_REG_DATE;
    public Integer CU_PHONE_NUMBER;

    public Customer(int CU_OLD_ID, String CU_NAME, char CU_TYPE, LocalDate CU_ORIGIN_DATE, LocalDate CU_REG_DATE, Integer CU_PHONE_NUMBER) {
        this.CU_OLD_ID = CU_OLD_ID;
        this.CU_NAME = CU_NAME;
        this.CU_TYPE = CU_TYPE;
        this.CU_ORIGIN_DATE = CU_ORIGIN_DATE;
        this.CU_REG_DATE = CU_REG_DATE;
        this.CU_PHONE_NUMBER = CU_PHONE_NUMBER;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "CU_OLD_ID=" + CU_OLD_ID +
                ", CU_NAME=" + CU_NAME +
                ", CU_TYPE=" + CU_TYPE +
                ", CU_ORIGIN_DATE=" + CU_ORIGIN_DATE +
                ", CU_REG_DATE=" + CU_REG_DATE +
                ", CU_PHONE_NUMBER=" + CU_PHONE_NUMBER + '}';
    }
}
