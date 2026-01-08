package dp;

import java.util.Arrays;

public class e_house_robber_I {
    static void main() {
        int[] houses = {1, 2, 3, 1};

        // Recursion
        A_Recursion a = new A_Recursion();
        System.out.println(a.robbed(houses));

        // Recursion + Memoization [Top-Down]
        B_Recursion b = new B_Recursion();
        System.out.println(b.robbed(houses));

        // Recursion + Memoization [Bottom-Up]
        C_Recursion c = new C_Recursion();
        System.out.println(c.robbed(houses));
    }
}

class A_Recursion {
    int solve(int[] houses, int i) {
        if (i >= houses.length) {
            return 0;
        }
        int steal = houses[i] + solve(houses, i + 2);
        int skip = solve(houses, i + 1);
        return Math.max(steal, skip);
    }

    int robbed(int[] houses) {
        if (houses.length == 0) {
            return 0;
        }
        if (houses.length == 1) {
            return houses[0];
        }
        if (houses.length == 2) {
            return Math.max(houses[0], houses[1]);
        }
        return solve(houses, 0);
    }

}

class B_Recursion {

    int[] t = new int[101];

    int solve(int[] houses, int i) {
        if (i >= houses.length) {
            return 0;
        }
        if (t[i] != -1) {
            return t[i];
        }

        int steal = houses[i] + solve(houses, i + 2);
        int skip = solve(houses, i + 1);
        return t[i] = Math.max(steal, skip);
    }

    int robbed(int[] houses) {
        if (houses.length == 0) {
            return 0;
        }
        if (houses.length == 1) {
            return houses[0];
        }
        if (houses.length == 2) {
            return Math.max(houses[0], houses[1]);
        }
        Arrays.fill(t, -1);
        return solve(houses, 0);
    }
}

class C_Recursion {

    int robbed(int[] houses) {
        int[] maxRobberyTillHouse = new int[houses.length + 1];

        if (houses.length == 0) {
            return 0;
        }
        if (houses.length == 1) {
            return houses[0];
        }
        if (houses.length == 2) {
            return Math.max(houses[0], houses[1]);
        }

        //maxRobberyTillHouse - 0
        maxRobberyTillHouse[0] = 0;

        //maxRobberyTillHouse - 1
        maxRobberyTillHouse[1] = houses[0];

        //maxRobberyTillHouse - 2
        maxRobberyTillHouse[2] = Math.max(houses[0], houses[1]);

        //maxRobberyTillHouse - 3
        maxRobberyTillHouse[3] = Math.max(
                // max till last house or i-1
                maxRobberyTillHouse[2],
                // max till i-2, and wealth in current house which is i-1 from house array
                maxRobberyTillHouse[3 - 2] + houses[3 - 1]);

        //maxRobberyTillHouse - 4
        maxRobberyTillHouse[4] = Math.max(
                // max till last house or i-1
                maxRobberyTillHouse[4 - 1],
                // max till i-2, and wealth in current house which is i-1 from house array
                maxRobberyTillHouse[4 - 2] + houses[4 - 1]);

        //maxRobberyTillHouse - i
        //        maxRobberyTillHouse[i] = Math.max(
        //                // max till last house or i-1
        //                maxRobberyTillHouse[i-1],
        //                // max till i-2, and wealth in current house which is i-1 from house array
        //                maxRobberyTillHouse[i-2] + houses[i-1]);

        for (int i = 2; i <= houses.length; i++) {
            maxRobberyTillHouse[i] = Math.max(
                    // max till last house or i-1
                    maxRobberyTillHouse[i - 1],
                    // max till i-2, and wealth in current house which is i-1 from house array
                    maxRobberyTillHouse[i - 2] + houses[i - 1]);
        }

        return maxRobberyTillHouse[houses.length];
    }
}