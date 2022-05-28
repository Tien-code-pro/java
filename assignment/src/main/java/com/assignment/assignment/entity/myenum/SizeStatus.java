package com.assignment.assignment.entity.myenum;

public enum SizeStatus {
    ACTIVE(1),DEACTIVE(0),DELETE(-1),UNDEFINE(-2);

    private int value;
    SizeStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public static SizeStatus of(int value){
        for (SizeStatus status :
                SizeStatus.values()){
            if (status.getValue() == value){
                return status;
            }
        }
        return UNDEFINE;
    }
}
