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

/**
 *
 * @author Charles Joseph Staal
 */
public class TestPalindrome {

    /**
     * @param args the command line arguments
     */
    private final static String toBeTested = "race car";
    private final static int errorsAllowed = 0;
    private final static int iterations = 1000;

    public static void main(String[] args) {
        testv1(toBeTested, errorsAllowed);
        testv2(toBeTested, errorsAllowed);
        testv3(toBeTested.toLowerCase().toCharArray(), errorsAllowed);

    }

    private static void testv1(String theString, int errorRate) {
        for (int counter = 0; counter < iterations; counter++) {
            isItAPalindromev1(theString, errorRate);
        }
    }

    private static void testv2(String theString, int errorRate) {
        for (int counter = 0; counter < iterations; counter++) {
            isItAPalindromev2(theString, errorRate);
        }
    }

    private static void testv3(char[] theString, int errorRate) {
        for (int counter = 0; counter < iterations; counter++) {
            isItAPalindromev3(theString, errorRate);
        }
    }

    /**
     * .0121ms runtime.
     *
     * @param theString
     * @param errorRate
     * @return
     */
    public static boolean isItAPalindromev1(String theString, int errorRate) {
        theString = theString.replaceAll(" ", "").toLowerCase();
        String theReversedString = new StringBuilder(theString).reverse().toString();
        for (int index = 0; index < theString.length(); index++) {
            if (!Character.toString(theString.charAt(index)).equalsIgnoreCase(Character.toString(theReversedString.charAt(index)))) {
                if (--errorRate < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * .00288ms runtime.
     *
     * @param firstString
     * @param errorRate
     * @return
     */
    public static boolean isItAPalindromev2(String firstString, int errorRate) {
        char[] firstCharArray = firstString.replaceAll(" ", "").toLowerCase().toCharArray();
        for (int index0 = 0, index1 = firstCharArray.length - 1; index0 <= firstCharArray.length / 2; index0++, index1--) {
            if (firstCharArray[index0] != firstCharArray[index1]) {
                if (--errorRate < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * .00234ms runtime.
     *
     * @param array
     * @param errorRate
     * @return
     */
    public static boolean isItAPalindromev3(char[] array, int errorRate) {
        array = array.toString().replaceAll(" ", "").toCharArray();
        for (int index0 = 0, index1 = array.length - 1; index0 <= array.length / 2; index0++, index1--) {
            if (array[index0] != array[index1]) {
                if (--errorRate < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
