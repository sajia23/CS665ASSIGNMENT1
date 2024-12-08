package edu.bu.met.cs665;

public class SugarDecorator extends CondimentDecorator {
    private int units;
    
    public SugarDecorator(Beverage beverage, int units) {
        super(beverage);
        this.units = Math.min(units, 3); // 确保不超过3份
    }
    
    @Override
    public String getName() {
        return beverage.getName() + " + " + units + " Sugar";
    }
    
    @Override
    public double cost() {
        return beverage.cost() + (units * 0.2); // 假设每单位糖0.2元
    }
    
    @Override
    public void cookBeverageInstructions() {
        beverage.cookBeverageInstructions();
        for(int i = 0; i < units; i++) {
            System.out.println("Adding sugar unit " + (i+1));
        }
    }
}
