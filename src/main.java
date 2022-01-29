//Jimmy Peng
import java.util.*; 
import java.util.concurrent.TimeUnit; // added time library
public class main {
    public static void main(String[] args) throws InterruptedException {
        terrain[][] terrain = new terrain[10][50];
        Random rand = new Random();
        int intRandom;
        int posRow = 5, posCol = 0;
        Scanner input = new Scanner(System.in);
        String[][] terrainOutput = new String[10][50];
        boolean validInput = false;
        int user = 0;
        Scanner input1 = new Scanner(System.in);
        System.out.println("Rules: \n F = Forest (+5 Food, -1 Water, -2 Stamina) \n R = River (-1 Food, +5 Water, -1 Stamina) \n L = Log (-1 Food, -1 Water, +20 Stamina) \n S = Sand (-1 Food, -2 Water, -1.5 Stamina");
        while(!validInput) {
            System.out.println("What do you want to play as? \n 1 for user \n 2 for simple brain \n 3 for complex brain \n 4 for even more complex brain");
            user = input1.nextInt();
            if(user == 1 || user == 2 || user == 3 || user == 4){
                validInput = true;
            }else{
                System.out.println("Invalid input");
            }
        }

        for(int i = 0; i < 10 ; i++){
            for(int j = 0; j < 50 ; j++){
                intRandom = rand.nextInt(10);
                //60% grass
                if(intRandom >= 0 && intRandom <= 5){
                    terrain[i][j] = new grass();
                    terrainOutput[i][j] = " ";
                }
                //10% log
                if(intRandom == 6){
                    terrain[i][j] = new log();
                    terrainOutput[i][j] = "l";
                }
                //10% sand
                else if(intRandom == 7){
                    terrain[i][j] = new sand();
                    terrainOutput[i][j] = "s";
                }
                //10% forest
                else if(intRandom == 8){
                    terrain[i][j] = new forest();
                    terrainOutput[i][j] = "f";
                }
                //10% river
                else if(intRandom == 9){
                    terrain[i][j] = new river();
                    terrainOutput[i][j] = "r";
                }

            }
            System.out.println();
        }
        player test;
        intRandom = rand.nextInt(2);
        if(intRandom == 0){
            test = new camel();
            System.out.println("Camel Player Type Selected - decreased water cost");
        }else if(intRandom == 1){
            test = new runner();
            System.out.println("Runner Player Type Selected - decreased stamina cost");
        }else {
            test = new brute();
            System.out.println("Brute Player Type Selected - decreased food cost");
        }


        if(user == 1){
            System.out.println("Enter W to move up, A to move left, S to move down, and d to move right");
        }
        System.out.println("Food: " + test.getFoodSupply() + " Water: " + test.getWaterSupply() + " Stamina: " + test.getStaminaSupply());

        String[][] terrainOutput2 = terrainOutput.clone();
        terrainOutput2[5][0] = "X";
        for(int i = 0; i < 10 ; i++) {
            for (int j = 0; j < 50; j++) {
                System.out.print(terrainOutput2[i][j] + " ");
            }
            System.out.println();
        }


        while(test.enter(terrain[posRow][posCol])){
            //User
            if(user == 1) {
                String inputString = input.nextLine();
                switch (inputString) {
                    case "w":
                        posRow--;
                        break;
                    case "d":
                        posCol++;
                        break;
                    case "s":
                        posRow++;
                        break;
                    case "a":
                        posCol--;
                        break;
                    default:
                        System.out.println("Invalid Command");
                }
            }


//          Simple Brain
            if(user == 2) {
                simpleBrain simple = new simpleBrain(posRow, posCol, terrainOutput);
                TimeUnit.MILLISECONDS.sleep(2000);
                posCol = simple.move(posCol);
            }
//          Complex Brain
            if(user == 3) {
                complexBrain complex = new complexBrain(posRow, posCol, terrainOutput);
                TimeUnit.MILLISECONDS.sleep(2000);
                if (complex.move(test, terrain, terrainOutput, test.getFoodSupply(), test.getWaterSupply(), test.getStaminaSupply()).equals("up1")) {
                    posRow--;
                } else if (complex.move(test, terrain, terrainOutput, test.getFoodSupply(), test.getWaterSupply(), test.getStaminaSupply()).equals("down1")) {
                    posRow++;
                } else {
                    posCol++;
                }
            }

//          more complex brain
            if(user == 4) {
                moreComplexBrain moreComplex = new moreComplexBrain(posRow, posCol, terrainOutput);
                TimeUnit.MILLISECONDS.sleep(2000);
                if (moreComplex.move(test, terrain, terrainOutput, test.getFoodSupply(), test.getWaterSupply(), test.getStaminaSupply()).equals("up1")) {
                    posRow--;
                } else if (moreComplex.move(test, terrain, terrainOutput, test.getFoodSupply(), test.getWaterSupply(), test.getStaminaSupply()).equals("down1")) {
                    posRow++;
                } else if(moreComplex.move(test, terrain, terrainOutput, test.getFoodSupply(), test.getWaterSupply(), test.getStaminaSupply()).equals("right1")){
                    posCol++;
                }else if(moreComplex.move(test, terrain, terrainOutput, test.getFoodSupply(), test.getWaterSupply(), test.getStaminaSupply()).equals("upRight")){
                    posRow--;
                    test.enter(terrain[posRow][posCol]);
                    terrainOutput[posRow][posCol] = "X";
                    posCol++;
                }else{
                    posRow++;
                    test.enter(terrain[posRow][posCol]);
                    terrainOutput[posRow][posCol] = "X";
                    posCol++;
                }
            }
            move(test, terrain, terrainOutput, posRow, posCol);

        }

        System.out.println("You died");
        System.out.println("Score: " + posCol);

    }

    public static void move(player test, terrain[][] objectTerrain, String[][] terrainOutput, int posRow, int posCol){
        test.enter(objectTerrain[posRow][posCol]);
        System.out.println("Food: " + test.getFoodSupply() + " Water: " + test.getWaterSupply() + " Stamina: " + test.getStaminaSupply());
        terrainOutput[posRow][posCol] = "X";
        for(int i = 0; i < 10 ; i++) {
            for (int j = 0; j < 50; j++) {
                System.out.print(terrainOutput[i][j] + " ");
            }
            System.out.println();
        }
    }

}
