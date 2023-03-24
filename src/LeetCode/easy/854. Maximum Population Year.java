/*
854. Maximum Population Year
Easy
Companies
You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years of the ith person.

The population of some year x is the number of people alive during that year. The ith person is counted in year x's population if x is in the inclusive range [birthi, deathi - 1]. Note that the person is not counted in the year that they die.

Return the earliest year with the maximum population.

 

Example 1:

Input: logs = [[1993,1999],[2000,2010]]
Output: 1993
Explanation: The maximum population is 1, and 1993 is the earliest year with this population.
Example 2:

Input: logs = [[1950,1961],[1960,1971],[1970,1981]]
Output: 1960
Explanation: 
The maximum population is 2, and it had happened in years 1960 and 1970.
The earlier year between them is 1960.
 

Constraints:

1 <= logs.length <= 100
1950 <= birthi < deathi <= 2050
*/

public class PopulationAnalyzer {
    public static void main(String[] args) {
        // Example 1
        int[][] logs1 = {{1950, 1961}, {1960, 1971}, {1970, 1981}};
        int earliestYear1 = maximumPopulation(logs1);
        System.out.println("Earliest year with maximum population for Example 1: " + earliestYear1);

        // Output: Earliest year with maximum population for Example 1: 1960
        
        // Example 2
        int[][] logs2 = {{1950, 1960}, {1960, 1970}, {1970, 1980}, {1980, 1990}};
        int earliestYear2 = maximumPopulation(logs2);
        System.out.println("Earliest year with maximum population for Example 2: " + earliestYear2);

        // Output: Earliest year with maximum population for Example 2: 1960
        
        // Example 3
        int[][] logs3 = {{1990, 2000}, {1995, 2005}, {2000, 2010}, {2005, 2015}};
        int earliestYear3 = maximumPopulation(logs3);
        System.out.println("Earliest year with maximum population for Example 3: " + earliestYear3);

        // Output: Earliest year with maximum population for Example 3: 1995
    }

    public static int maximumPopulation(int[][] logs) {
       int[] population = new int[101];
    int earliestYear = 1950;
    int maxPopulation = 0;
    
     // Step 2: Increment population count for each year between birth and death year
    for (int i = 0; i < logs.length; i++) {
        int birthYear = logs[i][0];
        int deathYear = logs[i][1];
        for (int j = birthYear - earliestYear; j < deathYear - earliestYear; j++) {
            population[j]++;
        }
    }

    //  Find earliest year with maximum population count
    for (int i = 0; i < population.length; i++) {
        if (population[i] > maxPopulation) {
            maxPopulation = population[i];
            earliestYear = i + 1950;
        }
    }
    
    return earliestYear;
    }
}
