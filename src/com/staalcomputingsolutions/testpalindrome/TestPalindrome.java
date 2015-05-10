/* 
 * Copyright (C) 2015 Charles Joseph Staal
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.staalcomputingsolutions.testpalindrome;

import java.util.Scanner;

/**
 *
 * @author Charles Joseph Staal
 */
public class TestPalindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter string to be tested:");
        String theString = sc.nextLine();
        System.out.println("Please enter error rate:");
        int errorRate = sc.nextInt();
        System.out.println(isItAPalidrone(theString, errorRate));

    }

    public static boolean isItAPalidrone(String theString, int errorRate) {
        theString = theString.replaceAll(" ", "");
        String theReversedString = new StringBuilder(theString).reverse().toString();
        int error = 0;
        for (int index = 0; index < theString.length(); index++) {
            if (!Character.toString(theString.charAt(index)).equalsIgnoreCase(Character.toString(theReversedString.charAt(index)))) {
                error++;
                if (error > errorRate) {
                    return false;
                }
            }
        }
        return true;
    }
}