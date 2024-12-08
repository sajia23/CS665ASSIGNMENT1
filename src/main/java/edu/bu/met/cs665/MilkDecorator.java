package edu.bu.met.cs665;

public class MilkDecorator extends CondimentDecorator {
    private int units;
    
    public MilkDecorator(Beverage beverage, int units) {
        super(beverage);
        this.units = Math.min(units, 3); // 确保不超过3份
    }
    
    @Override
    public String getName() {
        return beverage.getName() + " + " + units + " Milk";
    }
    
    @Override
    public double cost() {
        return beverage.cost() + (units * 0.5); // 假设每单位牛奶0.5元
    }
    
    @Override
    public void cookBeverageInstructions() {
        beverage.cookBeverageInstructions();
        for(int i = 0; i < units; i++) {
            System.out.println("Adding milk unit " + (i+1));
        }
    }
}
