public class player {
    public double foodSupply = 20, waterSupply = 20, staminaSupply = 20;
    public double foodFactor = 1, waterFactor = 1, staminaFactor = 1;

    player(double foodFactor, double waterFactor, double staminaFactor){
        this.foodFactor = foodFactor;
        this.waterFactor = waterFactor;
        this.staminaFactor = staminaFactor;

    }

    //getters and setters
    public double getFoodSupply(){return foodSupply;}
    public void setFoodSupply(double newFoodSupply){foodSupply = newFoodSupply;}
    public double getWaterSupply(){return waterSupply;}
    public void setWaterSupply(double newWaterSupply){waterSupply = newWaterSupply;}
    public double getStaminaSupply(){return staminaSupply;}
    public void setStaminaSupply(double newStaminaSupply){staminaSupply = newStaminaSupply;}

    //factors
    public double foodFactor(){return foodFactor;}
    public double waterFactor(){return waterFactor;}
    public double staminaFactor(){return staminaFactor;}

    public boolean enter (terrain square){
        //food
        double food = square.foodCost();
        if(food > 0.0){food *= foodFactor();}
        foodSupply -= food;
        if(foodSupply > 20.0){foodSupply = 20.0;}
        if (foodSupply < 0.0){return false;}
        //water
        double water = square.waterCost();
        if(water > 0.0){water *= waterFactor();}
        waterSupply -= water;
        if(waterSupply > 20.0){waterSupply = 20.0;}
        if (waterSupply < 0.0){return false;}
        //stamina
        double stamina = square.staminaCost();
        if(stamina > 0.0){stamina *= staminaFactor();}
        staminaSupply -= stamina;
        if(staminaSupply > 20.0){staminaSupply = 20.0;}
        if (staminaSupply < 0.0){return false;}

        return true;
    }
}
class camel extends player{
    camel() { super(0.5, 0.25, 0.5);}
}
class runner extends player{
    runner(){ super(0.5, 0.5, 0.25);}
}
class brute extends player{
    brute() { super(0.25, 0.5, 0.5);}
}
