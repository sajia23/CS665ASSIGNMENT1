package edu.bu.met.cs665;
public abstract class CondimentDecorator implements Beverage {
    protected Beverage beverage;
    
    public CondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }
    
    @Override
    public String getName() {
        return beverage.getName();
    }
    
    @Override
    public void cookBeverageInstructions() {
        beverage.cookBeverageInstructions();
    }
} 