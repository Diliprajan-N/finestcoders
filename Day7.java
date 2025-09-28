public class Day7{
    public static void main(String[] args) {
        int mulePrice = 50, sheepPrice = 40, goatPrice = 25, pigPrice = 10;

        for (int mules = 0; mules <= 2; mules++) {
            for (int sheep = 0; sheep <= 2; sheep++) {
                for (int pigs = 0; pigs <= 50; pigs++) { 

                   
                    int goats = (4 * mules) + (2 * sheep) - (4 * pigs);

                    if (goats >= 0 && goats <= 50) {
                        int totalAnimals = mules + sheep + goats + pigs;
                        if (totalAnimals > 0) { 
                           System.out.println("Mules: " + mules + ", Sheep: " + sheep + ", Goats: " + goats + ", Pigs: " + pigs + " => Avg: 30");
                           break;
                        }
                    }
                }
            }
        }
    }
}