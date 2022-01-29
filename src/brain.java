public class brain {
    public int posRow;
    public int posCol;
    public String[][] terrain;

    public brain (int posRow, int posCol, String[][] terrain){
        this.posRow = posRow;
        this.posCol = posCol;
        this.terrain = terrain;
    }


    public int getRow(){return posRow;}
    public int getCol(){return posCol;}

}
class simpleBrain extends brain {
    simpleBrain(int posRow, int posCol, String[][] terrain) {
        super(posRow, posCol, terrain);
    }

    public int move(int posCol) {
        return ++posCol;
    }
}
class complexBrain extends brain {
    public complexBrain(int posRow, int posCol, String[][] terrain) {
        super(posRow, posCol, terrain);
    }

    public String move(player player, terrain[][] objectTerrain, String[][] terrain, double food, double water, double stamina) {
        String up = terrain[posRow - 1][posCol];
        String right = terrain[posRow][posCol + 1];
        String down = terrain[posRow + 1][posCol];
        double total = 0;



        if (food < water && food < stamina) {
            if (up.equals("f")) {
                return "up1";
            } else if (down.equals("f")) {
                return "down1";
            } else if(right.equals("f")){
                return "right1";
            }
        } else if (water < food && water < stamina) {
            if (up.equals("r")) {
                return "up1";
            } else if (down.equals("r")) {
                return "down1";
            } else if(right.equals("f")){
                return "right1";
            }
        } else if (stamina < food && stamina < water){
            if (up.equals("l")) {
                return "up1";
            } else if (down.equals("l")) {
                return "down1";
            } else if(right.equals("f")){
                return "right1";
            }
        }
        double sumFoodUp = player.getFoodSupply() - objectTerrain[posRow - 1][posCol].foodCost();
        double sumWaterUp = player.getWaterSupply() - objectTerrain[posRow - 1][posCol].waterCost();
        double sumStaminaUp = player.getStaminaSupply() - objectTerrain[posRow - 1][posCol].staminaCost();

        if(sumFoodUp < 20){
            sumFoodUp = 20;
        }
        if(sumWaterUp < 20){
            sumWaterUp = 20;
        }
        if(sumStaminaUp < 20){
            sumStaminaUp = 20;
        }

        double sumFoodDown = player.getFoodSupply() - objectTerrain[posRow + 1][posCol].foodCost();
        double sumWaterDown = player.getWaterSupply() - objectTerrain[posRow + 1][posCol].waterCost();
        double sumStaminaDown = player.getStaminaSupply() - objectTerrain[posRow + 1][posCol].staminaCost();

        if(sumFoodDown < 20){
            sumFoodDown = 20;
        }
        if(sumWaterDown < 20){
            sumWaterDown = 20;
        }
        if(sumStaminaDown < 20){
            sumStaminaDown = 20;
        }

        double sumFoodRight = player.getFoodSupply() - objectTerrain[posRow][posCol + 1].foodCost();
        double sumWaterRight = player.getWaterSupply() - objectTerrain[posRow][posCol + 1].waterCost();
        double sumStaminaRight = player.getStaminaSupply() - objectTerrain[posRow][posCol + 1].staminaCost();

        if(sumFoodRight < 20){
            sumFoodRight = 20;
        }
        if(sumWaterRight < 20){
            sumWaterRight = 20;
        }
        if(sumStaminaRight < 20){
            sumStaminaRight = 20;
        }

        double totalSumUp = sumFoodUp + sumWaterUp + sumStaminaUp;
        double totalSumDown = sumFoodDown + sumWaterDown + sumStaminaDown;
        double totalSumRight = sumFoodRight+ sumWaterRight + sumStaminaRight;

        if(totalSumUp > totalSumDown && totalSumUp > totalSumRight){
            return "up1";
        }else if(totalSumDown > totalSumUp && totalSumDown > totalSumRight){
            return "down1";
        }else{
            return "right1";
        }
    }
}
class moreComplexBrain extends brain{
    public moreComplexBrain(int posRow, int posCol, String[][] terrain) {super(posRow, posCol, terrain);}
    public String move(player player, terrain[][] objectTerrain, String[][] terrain, double food, double water, double stamina) {
        String up = terrain[posRow - 1][posCol];
        String upRight = terrain[posRow - 1][posCol + 1];
        String right = terrain[posRow][posCol + 1];
        String down = terrain[posRow + 1][posCol];
        String downRight = terrain[posRow + 1][posCol + 1];
        double total = 0;
        if(up.equals("g") && right.equals("g") && down.equals("g") && upRight.equals("g") && downRight.equals("g")){
            return "right1";
        }
        if (food < water && food < stamina) {
            if (up.equals("f")) {
                return "up1";
            } else if (down.equals("f")) {
                return "down1";
            } else if(right.equals("f")){
                return "right1";
            }else if(upRight.equals("f")){
                return "upRight";
            }else if(downRight.equals("f")){
                return "downRight";
            }
        } else if (water < food && water < stamina) {
            if (up.equals("r")) {
                return "up1";
            } else if (down.equals("r")) {
                return "down1";
            } else if(right.equals("r")){
                return "right1";
            }else if(upRight.equals("r")){
                return "upRight";
            }else if(downRight.equals("r")){
                return "downRight";
            }
        } else if (stamina < food && stamina < water){
            if (up.equals("l")) {
                return "up1";
            } else if (down.equals("l")) {
                return "down1";
            } else if(right.equals("l")){
                return "right1";
            }else if(upRight.equals("l")){
                return "upRight";
            }else if(downRight.equals("l")){
                return "downRight";
            }
        }


        double sumFoodUp = player.getFoodSupply() - objectTerrain[posRow - 1][posCol].foodCost();
        double sumWaterUp = player.getWaterSupply() - objectTerrain[posRow - 1][posCol].waterCost();
        double sumStaminaUp = player.getStaminaSupply() - objectTerrain[posRow - 1][posCol].staminaCost();

        if(sumFoodUp < 20){
            sumFoodUp = 20;
        }
        if(sumWaterUp < 20){
            sumWaterUp = 20;
        }
        if(sumStaminaUp < 20){
            sumStaminaUp = 20;
        }

        double sumFoodDown = player.getFoodSupply() - objectTerrain[posRow + 1][posCol].foodCost();
        double sumWaterDown = player.getWaterSupply() - objectTerrain[posRow + 1][posCol].waterCost();
        double sumStaminaDown = player.getStaminaSupply() - objectTerrain[posRow + 1][posCol].staminaCost();

        if(sumFoodDown < 20){
            sumFoodDown = 20;
        }
        if(sumWaterDown < 20){
            sumWaterDown = 20;
        }
        if(sumStaminaDown < 20){
            sumStaminaDown = 20;
        }

        double sumFoodRight = player.getFoodSupply() - objectTerrain[posRow][posCol + 1].foodCost();
        double sumWaterRight = player.getWaterSupply() - objectTerrain[posRow][posCol + 1].waterCost();
        double sumStaminaRight = player.getStaminaSupply() - objectTerrain[posRow][posCol + 1].staminaCost();

        if(sumFoodRight < 20){
            sumFoodRight = 20;
        }
        if(sumWaterRight < 20){
            sumWaterRight = 20;
        }
        if(sumStaminaRight < 20){
            sumStaminaRight = 20;
        }

        double sumFoodUpRight = player.getFoodSupply() - objectTerrain[posRow - 1][posCol + 1].foodCost();
        double sumWaterUpRight = player.getWaterSupply() - objectTerrain[posRow - 1][posCol + 1].waterCost();
        double sumStaminaUpRight = player.getStaminaSupply() - objectTerrain[posRow - 1][posCol + 1].staminaCost();

        if(sumFoodUpRight < 20){
            sumFoodUpRight = 20;
        }
        if(sumWaterUpRight < 20){
            sumWaterUpRight = 20;
        }
        if(sumStaminaUpRight < 20){
            sumStaminaUpRight = 20;
        }
        double sumFoodDownRight = player.getFoodSupply() - objectTerrain[posRow + 1][posCol + 1].foodCost();
        double sumWaterDownRight = player.getWaterSupply() - objectTerrain[posRow + 1][posCol + 1].waterCost();
        double sumStaminaDownRight = player.getStaminaSupply() - objectTerrain[posRow + 1][posCol + 1].staminaCost();

        if(sumFoodDownRight < 20){
            sumFoodDownRight = 20;
        }
        if(sumWaterDownRight < 20){
            sumWaterDownRight = 20;
        }
        if(sumStaminaDownRight < 20){
            sumStaminaDownRight = 20;
        }

        double totalSumUp = sumFoodUp + sumWaterUp + sumStaminaUp;
        double totalSumDown = sumFoodDown + sumWaterDown + sumStaminaDown;
        double totalSumRight = sumFoodRight+ sumWaterRight + sumStaminaRight;
        double totalSumUpRight = sumFoodUpRight + sumWaterUpRight + sumStaminaUpRight;
        double totalSumDownRight = sumFoodDownRight + sumWaterDownRight + sumStaminaDownRight;

        if(totalSumUp > totalSumDown && totalSumUp > totalSumRight && totalSumUp > totalSumUpRight && totalSumUp > totalSumDownRight){
            return "up1";
        }else if(totalSumDown > totalSumUp && totalSumDown > totalSumRight && totalSumDown > totalSumUpRight && totalSumDown > totalSumDownRight){
            return "down1";
        }else if(totalSumRight > totalSumUp && totalSumRight > totalSumDown && totalSumRight > totalSumUpRight && totalSumRight > totalSumDownRight){
            return "right1";
        }else if(totalSumUpRight > totalSumUp && totalSumUpRight > totalSumDown && totalSumUpRight > totalSumRight && totalSumUpRight > totalSumDownRight){
            return "upRight";
        }else if(totalSumDownRight > totalSumUp && totalSumDownRight > totalSumUpRight && totalSumDownRight > totalSumRight && totalSumDownRight > totalSumDown){
            return "downRight";
        }else{
            return "right1";
        }
    }
}






