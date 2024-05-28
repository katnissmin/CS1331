public class ShipDriver {
    public static void main(String[] args) {
        Ship ship1 = new Ship("bitch");
        Ship ship2 = new Ship();

        Sugar sugar1 = new Sugar(7, 50);
        Sugar sugar2 = new Sugar(5, 140);
        Sugar sugar3 = new Sugar(10,-30);
        Sugar sugar4 = new Sugar(30, 20);
        Sugar sugar5 = new Sugar(70, 34);

        Coin coin1 = new Coin(20, true, 1790, "Copper");
        Coin coin2 = new Coin(false, 1500);
        Coin coin3 = new Coin(true, -30);
        Coin coin4 = new Coin(10, false, -20, "Silver");
        Coin coin5 = new Coin(true, 80);

        ship1.addCargo(sugar1);
        ship1.addCargo(sugar2);
        ship1.addCargo(sugar3);
        ship1.addCargo(sugar4);
        ship1.addCargo(sugar5);
        ship1.addCargo(coin1);
        ship1.addCargo(coin2);
        ship1.addCargo(coin3);
        ship1.addCargo(coin4);
        ship1.addCargo(coin5);
        // ^^ adding 10 loot items to ship1
        
        ship1.addCargo(coin4);
        ship1.addCargo(coin5);
        ship1.removeCargo();
        ship1.removeCargo(sugar4);
        ship1.removeCargo(coin5);

        //ship2.addCargo(sugar1);
       // ship2.addCargo(sugar2);
        //ship2.addCargo(sugar3);
        //ship2.addCargo(sugar4);
        //ship2.addCargo(sugar5);
        //ship2.addCargo(coin1);
       // ship2.addCargo(coin2);
       // ship2.addCargo(coin3);
       // ship2.addCargo(coin4);
       // ship2.addCargo(coin5);

        //ship2.removeCargo(coin5);
        //ship2.removeCargo(sugar1);
        //ship2.removeCargo(sugar4);
        //ship2.removeCargo();
        //ship2.addCargo(sugar4);


        //System.out.println(coin1.toString());
        //System.out.println(sugar3.toString());


        //System.out.println(ship2.toString());
        System.out.println(ship1.toString());


    }
}