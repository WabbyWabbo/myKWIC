package com.kwic.modularization2;

import java.util.Comparator;

public class AlphabetizerCompartor implements Comparator<String>{


        @Override
        public int compare(String o1, String o2) {
            if (o1 == null && o2 == null) {
                throw new NullPointerException();
            }
            int compareValue = 0;
            char o1c = o1.charAt(0);
            char o2c = o2.charAt(0);
            compareValue = o1c - o2c;
            return compareValue;

        }


}
