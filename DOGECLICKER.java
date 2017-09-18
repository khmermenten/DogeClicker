import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.*;
import java.io.*;
public class DOGECLICKER extends JPanel
implements ActionListener
{
    //STATS
    private int deepz;
    private int currentDoges;
    private int dogesAllTime;
    private double timeElapsed;
    private DogeBuilding[] buildings;
    private JButton doge;

    DOGECLICKER()
    {
        deepz = 1;
        currentDoges = 0;
        dogesAllTime = 0;
        timeElapsed = 0.0;
        buildings = new DogeBuilding[]{new DogeBuilding("Clicker"), new DogeBuilding("Doge Machine"), 
            new DogeBuilding("Doge Farm"), new DogeBuilding("Doge Factory"), 
            new DogeBuilding("Super Shibe"), new DogeBuilding("Time Doge"), 
            new DogeBuilding("Doge God")};
        ImageIcon image = new ImageIcon("doge.gif");
        doge = new JButton(image);
        doge.setVerticalTextPosition(AbstractButton.CENTER);
        doge.setHorizontalTextPosition(AbstractButton.CENTER);
        doge.setMnemonic(KeyEvent.VK_D);
        doge.setActionCommand("click");
        doge.addActionListener(this);
        doge.setToolTipText("AWOOOOO");
        add(doge);
    }

    public void directions()
    {
        System.out.println("Welcome to Doge Clicker!\nThis is a sandbox type game in which you try to obtain as many doges as possible!"); 
        System.out.println("Use your doges to buy things that make more doges for you!\nThe more you experiment, the more you will progress.");
        System.out.println("Start by opening the openDogeClicker method, and proceed to cover the universe in doge!\nType 'exit' to stop the method. Good luck!");
    }

    public void openDogeClicker() 
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
            {
                public void run() {
                    createAndShowGUI(); 
                }
            }
        );
        deepz = 0;
        for (DogeBuilding building: buildings)
            deepz += building.total;
        System.out.println("Start clicking to start flying to the MOON!!\nTo exit the program, exit out of the doge window.");
    }

    private static void createAndShowGUI() 
    {
        //Create and set up the window.
        JFrame frame = new JFrame("DOGECLICKER");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Create and set up the content pane.
        DOGECLICKER newContentPane = new DOGECLICKER();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if ("click".equals(e.getActionCommand()))
        {
            currentDoges += deepz;
            dogesAllTime += deepz;
            System.out.println("Doges: " + currentDoges);
        }
    }

    public void viewBuildingCount()
    {
        for (DogeBuilding building: buildings)
            System.out.println(building.name + "s: " + building.amount);
    }

    private void viewUpgradePrices()
    {
        for (DogeBuilding building: buildings)
        {
            if (building.upgrades == 4)
                System.out.println(building.name + ": maxed");
            else
                System.out.println("Next upgrade for " + building.name + ": " + building.upgradeChain[building.upgrades]);
        }
    }

    public void enterCheatCode(String cheatz)
    {
        if (cheatz.equals("dogeCoin"))
        {
            currentDoges *= 2;
            System.out.println("Dogecoin is a real currency. Current doges doubled!");
        }
        else if (cheatz.equals("/r/Supershibe"))
        {
            if (buildings[5].amount < 2)
            {
                buildings[5].amount += 1;
                buildings[5].total += buildings[5].rate;
            }
            buildings[5].amount *= 2;
            buildings[5].total *= 2;
            System.out.println("Your supershibes have doubled in number!");
        }
        else if (cheatz.equals("TO THE MOON!"))
        {
            for (DogeBuilding building: buildings)
            {
                building.amount *= 2;
                building.total *= 2;
            }
            System.out.println("All buildings doubled!");
        }

        else if(cheatz.equals("Jin Young Chang"))
        {
            System.err.println("WARNING COMP SCI TEACHER! THIS PROGRAM WILL SELF-DESTRUCT IN 5 SECONDS");
            for (int i = 5; i >= 1; i--)
            {
                try {
                    Thread.sleep(100);
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                if (i == 1)
                    System.out.println(i + " second");
                else
                    System.out.println(i + " seconds");
            }
            System.exit(-1);
        }
        else
            System.out.println("Much scrubby, few cheat wow");
    }

    public void viewStats()
    {
        int numBuildings = 0;
        int dogeUpgrades = 0;
        for(DogeBuilding building: buildings)
        {
            numBuildings += building.amount; 
            dogeUpgrades += building.upgrades;
        }
        System.out.println("Doges per second: " + deepz + "\n" +  "Current amount of doges: " + currentDoges + "\n" + 
            "Number of buildings: " + numBuildings + "\n" + "Doges produced all time: " + dogesAllTime + "\n" + "Upgrades purchased: " + 
            dogeUpgrades); 
    }

    public void visitStore()
    {
        System.out.println("Spend many doge here wow");
        System.out.println("Type 'E' to exit the store.");
        Scanner keyIn = new Scanner (System.in);
        System.out.println("\nA. Buy/Sell Stuff\nB. Check Upgrade Prices");
        System.out.print("Many choice wow very decision: "); 
        System.out.println("Current doges: " + currentDoges);
        String input = keyIn.nextLine().toUpperCase();
        char ch = input.charAt(0);
        while (ch != 'E')
        {
            if (ch == 'A')
                buySellStuff();
            else if (ch == 'B')
                viewUpgradePrices();
            else
                System.out.println("Invalid input! Try again...");
            ch = keyIn.nextLine().toUpperCase().charAt(0);
        }
        return; 
    }

    private void buySellStuff()
    {
        System.out.println("Which building? (use proper spacing!) Press E to exit."); 
        System.out.println("\n1. Clicker \n2. Doge Machine \n3. Doge Farm \n4. Doge Factory \n" + 
            "5. Super Shibe \n6. Time Doge \n7. Doge God");
        Scanner keyIn = new Scanner(System.in); 
        String input = keyIn.nextLine();
        while (!input.equalsIgnoreCase("E"))
        {
            for (DogeBuilding building: buildings)
            {
                if (input.equalsIgnoreCase(building.name))
                {
                    System.out.println("Type B for Buy, U for Upgrade, S for Sell, or E for Exit. Price: " + building.cost);
                    char temp = keyIn.nextLine().toUpperCase().charAt(0);
                    while(temp != 'E')
                    {
                        if (temp == 'B')
                            currentDoges -= building.buyOne(currentDoges);
                        else if (temp == 'U')
                            currentDoges -= building.buyUpgrade(currentDoges);
                        else if (temp == 'S')
                            currentDoges += building.sell();
                        else
                            System.out.println("Invalid input! Try again..."); 
                        temp = keyIn.nextLine().toUpperCase().charAt(0);
                    }
                    System.out.println("Thank you come again!");
                    return;
                }
            }
            System.out.println("Invalid input! Try again...");
            input = keyIn.nextLine();
        }
        System.out.println("Thank you come again!!");
        return;
    }

    public void checkNews()
    {
        if (dogesAllTime >= 1000000000)
            System.out.println("The universe is now covered in doge, down to the atomic level. Congratulations!");
        else if (dogesAllTime >= 500000000)
            System.out.println("Doge has become lord of the universe, and you are their master.");
        else if (dogesAllTime >= 100000000)
            System.out.println("The presence of doge has attracted all kinds of aliens to earth.");
        else if (dogesAllTime >= 10000000)
            System.out.println("A new kind of currency has been created based on doge.");
        else if (dogesAllTime >= 1000000)
            System.out.println("Your doges have achieved sentience.");
        else if (dogesAllTime >= 100000)
            System.out.println("Doge is so popular, people are naming their doges Doge.");    
        else if (dogesAllTime >= 10000)
            System.out.println("Your doges have started to take over your town.");
        else if (dogesAllTime >= 1000)
            System.out.println("The doge meme is a huge hit in your school.");
        else if (dogesAllTime >= 100)
            System.out.println("Only your friends get the joke."); 
        else if (dogesAllTime >= 10)
            System.out.println("Your doge idea has not caught on at all.");
        else
            System.out.println("You feel like creating a new meme...");
    }
}