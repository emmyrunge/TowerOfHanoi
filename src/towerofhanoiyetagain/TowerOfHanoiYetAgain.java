package towerofhanoiyetagain;

import java.util.Scanner;
public class TowerOfHanoiYetAgain
{
    private static String indent = "";  // indentation for trace
    public static int count = 0;

    public static void main(String[] args)
    {
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter less than 0 to exit");
            while(true)
            {
                System.out.print("Enter the number of Disks: ");

                int diskNumber = sc.nextInt();

                //added the >20 cause it took to long to compile
                if(diskNumber < 0 || diskNumber > 20)
                {
                    System.exit(0);
                }
                countRings(diskNumber, 'A', 'B', 'C');
                System.out.println("Total number of Disc Moves is: " + count);
                count = 0;
            }
        }
    }

    public static void countRings(int ring, char first, char mid, char last)
    {
        if (ring == 1)
        {
            ++count;
        }else
        {
            countRings(ring - 1, first, last, mid);
            ++count;
            countRings(ring - 1, mid, first, last);
        }
    }


    private static int getInt(int lBound, int uBound)
    {
        return getInt("Please enter an integer between ", lBound, uBound);
    }

    private static int getInt(String prompt, int lBound, int uBound)
    {
        int intRV = 0;
        System.out.printf(prompt);
        System.out.printf("between %d  and  %d\n",
                lBound, uBound);
        Scanner kbd = new Scanner(System.in);
        String usrInput = "";
        do
        {
            usrInput = kbd.nextLine();
            try
            {
                intRV = Integer.parseInt(usrInput);
                if (intRV < lBound || intRV > uBound)
                {
                    System.out.println(usrInput + " is not a valid number");
                }
            }
            catch (Exception ex)
            {
                System.out.println(usrInput + " is not a number");
            }
        }
        while (lBound > intRV || uBound < intRV);

        return intRV;
    }

    /**
     * getBool - get a yeah or nay response from the user
     *
     * @param prompt
     * @return
     */
    public static boolean getBool(String prompt)
    {
        boolean blnRV = false;  // defaulting to false
        Scanner kbd = new Scanner(System.in);
        System.out.println(prompt);
        String usrInput = kbd.nextLine();
        char yY = usrInput.charAt(0);
        blnRV = yY == 'y' || yY == 'Y';
        return blnRV;
    }
}
