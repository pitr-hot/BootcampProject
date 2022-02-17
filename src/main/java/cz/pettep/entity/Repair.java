package cz.pettep.entity;

import java.time.LocalDate;s

public class Repair {
    public int RE_OLD_ID;
    public int RE_VEH_OLD_ID;
    public int RE_DET_ID;
    public int RE_SHOP_ID;
    public LocalDate RE_BILL_DATE;

    public Repair(int RE_OLD_ID, int RE_VEH_OLD_ID, int RE_DET_ID, int RE_SHOP_ID, LocalDate RE_BILL_DATE) {
        this.RE_OLD_ID = RE_OLD_ID;
        this.RE_VEH_OLD_ID = RE_VEH_OLD_ID;
        this.RE_DET_ID = RE_DET_ID;
        this.RE_SHOP_ID = RE_SHOP_ID;
        this.RE_BILL_DATE = RE_BILL_DATE;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "RE_OLD_ID=" + RE_OLD_ID +
                ", RE_VEH_OLD_ID=" + RE_VEH_OLD_ID +
                ", RE_DET_ID=" + RE_DET_ID +
                ", RE_SHOP_ID=" + RE_SHOP_ID +
                ", RE_BILL_DATE=" + RE_BILL_DATE +
                '}';
    }
}
