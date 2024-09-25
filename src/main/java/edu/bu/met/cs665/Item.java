package edu.bu.met.cs665;

/**
 * This is the Item class which is collected in Order class.
 */
public class Item {

    String beverageType;
    Integer beverageNum;
    String condimentType;
    Integer condimentNum;

    public String getBeverageType() {
        return beverageType;
    }

    public void setBeverageType(String beverageType) {
        this.beverageType = beverageType;
    }

    public Integer getBeverageNum() {
        return beverageNum;
    }

    public void setBeverageNum(Integer beverageNum) {
        this.beverageNum = beverageNum;
    }

    public String getCondimentType() {
        return condimentType;
    }

    public void setCondimentType(String condimentType) {
        this.condimentType = condimentType;
    }

    public Integer getCondimentNum() {
        return condimentNum;
    }

    public void setCondimentNum(Integer condimentNum) {
        this.condimentNum = condimentNum;
    }
}
