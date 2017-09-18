public class DogeBuilding
{
    public String name;
    public int cost;
    public int upgrades;
    public int amount;
    public int rate;
    public int total;
    public int[] upgradeChain;
    public DogeBuilding(String name)
    {
        this.name = name;
        upgrades = 0;
        amount = 0;
        if (name.equals("Clicker"))
        {
            cost = 1;
            rate = 1;
            total = 0;
            upgradeChain = new int[] {10, 500, 1000, 5000};
        }
        if (name.equals("Doge Machine"))
        {
            cost = 100;
            rate = 2;
            total = 0;
            upgradeChain = new int[] {300, 1000, 3500, 10000};
        }
        if (name.equals("Doge Farm"))
        {
            cost = 400;
            rate = 5;
            total = 0;
            upgradeChain = new int[] {1111, 2222, 33333, 444444};
        }
        if (name.equals("Doge Factory"))
        {
            cost = 3000;
            rate = 10;
            total = 0;
            upgradeChain = new int[] {10000, 50000, 100000, 5000000};
        }
        if (name.equals("Super Shibe"))
        {
            cost = 10000;
            rate = 150;
            total = 0;
            upgradeChain = new int[] {25000, 250000, 2500000, 25000000};
        }
        if (name.equals("Time Doge"))
        {
            cost = 123456;
            rate = 342;
            total = 0;
            upgradeChain = new int[] {654321, 7654321, 87654321, 987654321};
        }
        if (name.equals("Doge God"))
        {
            cost = 6666666;
            rate = 6666;
            total = 0;
            upgradeChain = new int[] {16666666, 166666666, 1666666666, 166666666};
        }
    }

    public int buyOne(int money)
    {
        if (money < cost)
        {
            System.out.println("Don't ever give me that cheap shit ever again.");
            return 0;
        }
        amount++;
        total += rate;
        cost *= 12;
        cost /= 10;
        System.out.println ("You bought one" + name + ".");
        return cost;
    }

    public int buyUpgrade(int money)
    {
        if (money < cost)
        {
            System.out.println("Stop. Go back home. Get some more doges.");
            return 0;
        }
        if (upgrades == 4)
        {
            System.out.println("This building is already maxed out!");
            return 0;
        }
        upgrades++;
        rate *= 2;
        total *= 2;
        System.out.println("You upgraded your " + name + "s.");
        return upgradeChain[upgrades];
    }

    public void buildingStats()
    {
        System.out.println("You have " + amount + " " + name+ ".");
        System.out.println("Next one costs: " + cost +" doges.");
        System.out.println("You have " + upgrades + "upgrades.");
        if (upgrades == 4)
            System.out.println("Your " + name + "s are maxed out!");
        else
            System.out.println("Next upgrade costs: " + upgradeChain[upgrades]+ " doges.");
        System.out.println("Each " + name + " produces " + rate + " doges per second.");
        System.out.println("Your " + name + "s are producing a total of " + total + " doges per second.");        
    }

    public int sell()
    {
        if (amount < 1)
        {
            System.out.println("BOY don't play with me you dont have any to sell!");
            return 0;
        }
        amount--;
        total -= rate;
        return cost/2;
    }
}
