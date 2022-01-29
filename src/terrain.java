public class terrain {
    public double foodCost, waterCost, staminaCost;
    public double foodCost() {return foodCost;}
    public double waterCost(){return waterCost;}
    public double staminaCost(){return staminaCost;}
    terrain(double foodCost, double waterCost, double staminaCost){
        this.foodCost = foodCost;
        this.waterCost = waterCost;
        this.staminaCost = staminaCost;
    }
}

class grass extends terrain {
    grass() {super(1, 1, 1);}
}
class sand extends terrain {
    sand(){
        super(1,2,1.5);
    }
}
class forest extends terrain {
    forest(){super(-5,1,2);}
}
class river extends terrain {
    river(){
        super(1,-5,1);
    }
}
class log extends terrain {
    log(){
        super(1,1,-20);
    }
}




