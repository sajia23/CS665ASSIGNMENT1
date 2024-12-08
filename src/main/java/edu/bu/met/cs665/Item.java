/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/19/2024
 * File Name: Item.java
 * Description: This class represents an order item containing beverage and condiment details.
 */
package edu.bu.met.cs665;

public class Item {

    String beverageType;
    Integer beverageNum;
    String condimentType;
    Integer condimentNum;

    /**
     * Gets the type of beverage
     * @return the beverage type as a String
     */
    public String getBeverageType() {
        return beverageType;
    }

    /**
     * Sets the type of beverage
     * @param beverageType the beverage type to set
     */
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
