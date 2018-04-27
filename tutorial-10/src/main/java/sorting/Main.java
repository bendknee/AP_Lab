package sorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    private static String pathFile = "plainTextDirectory/input/sortingProblem.txt";
    private static int numberOfItemToBeSorted = 50000;

    public static void main(String[] args) throws IOException {

        int[] sequenceInput = convertInputFileToArray();

        //Searching Input Before Sorting With Slow Search
        long totalMilisSearchBeforeSort = System.currentTimeMillis();
        int searchingResultBeforeSort = Finder.slowSearch(sequenceInput, 40738);
        totalMilisSearchBeforeSort = System.currentTimeMillis() - totalMilisSearchBeforeSort;
        System.out.println("Slow Search Complete in " + totalMilisSearchBeforeSort + " milisecond");

        //Searching Input Before Sorting With Improved Slow Search
        long totalMilisImprovedSearchBeforeSort = System.currentTimeMillis();
        int searchingImprovedResultBeforeSort = Finder.slowSearchImproved(sequenceInput, 40738);
        totalMilisImprovedSearchBeforeSort = System.currentTimeMillis() - totalMilisImprovedSearchBeforeSort;
        System.out.println("Improved Slow Search Complete in " + totalMilisImprovedSearchBeforeSort + " milisecond");

        //Sorting Input With Slow Sort
        long totalMilisSlowSorting = System.currentTimeMillis();
        int[] slowSortedInput = Sorter.slowSort(sequenceInput);
        totalMilisSlowSorting = System.currentTimeMillis() - totalMilisSlowSorting;
        System.out.println("Slow Sort Complete in " + totalMilisSlowSorting + " milisecond");

        //Searching Input After Slow Sorting With Slow Search
        long totalMilisSlowSearchAfterSlowSort = System.currentTimeMillis();
        int searchingSlowResultAfterSlowSort = Finder.slowSearch(slowSortedInput, 40738);
        totalMilisSlowSearchAfterSlowSort = System.currentTimeMillis() - totalMilisSlowSearchAfterSlowSort;
        System.out.println("Slow Search Complete in " + totalMilisSlowSearchAfterSlowSort + " milisecond");

        //Searching Input After Slow Sorting With Fast Search
        long totalMilisQuickSearchAfterSlowSort = System.currentTimeMillis();
        int searchingQuickResultAfterSlowSort = Finder.quickSearch(slowSortedInput, 40738);
        totalMilisQuickSearchAfterSlowSort = System.currentTimeMillis() - totalMilisQuickSearchAfterSlowSort;
        System.out.println("Quick Search Complete in " + totalMilisQuickSearchAfterSlowSort + " milisecond");

        //Reseting array
        System.out.println("\nResetting Array. . . ");
        sequenceInput = convertInputFileToArray();

        //Searching Input Before Sorting With Improved Slow Search
        totalMilisImprovedSearchBeforeSort = System.currentTimeMillis();
        searchingImprovedResultBeforeSort = Finder.slowSearchImproved(sequenceInput, 40738);
        totalMilisImprovedSearchBeforeSort = System.currentTimeMillis() - totalMilisImprovedSearchBeforeSort;
        System.out.println("Improved Slow Search Complete in " + totalMilisImprovedSearchBeforeSort + " milisecond");

        //Sorting Input With Quick Sort
        long totalMilisQuickSorting = System.currentTimeMillis();
        int[] quickSortedInput = Sorter.quickSort(sequenceInput);
        totalMilisQuickSorting = System.currentTimeMillis() - totalMilisQuickSorting;
        System.out.println("Quick Sort Complete in " + totalMilisQuickSorting + " milisecond");

        //Searching Input After Quick Sorting With Slow Search
        long totalMilisSlowSearchAfterQuickSort = System.currentTimeMillis();
        int searchingSlowResultAfterQuickSort = Finder.slowSearch(quickSortedInput, 40738);
        totalMilisSlowSearchAfterQuickSort = System.currentTimeMillis() - totalMilisSlowSearchAfterQuickSort;
        System.out.println("Slow Search Complete in " + totalMilisSlowSearchAfterQuickSort + " milisecond");

        //Searching Input After Quick Sorting With Fast Search
        long totalMilisQuickSearchAfterQuickSort = System.currentTimeMillis();
        int searchingQuickResultAfterQuickSort = Finder.quickSearch(quickSortedInput, 40738);
        totalMilisQuickSearchAfterQuickSort = System.currentTimeMillis() - totalMilisQuickSearchAfterQuickSort;
        System.out.println("Quick Search Complete in " + totalMilisQuickSearchAfterQuickSort + " milisecond");
    }

    /**
     * Converting a file input into an array of integer.
     * @return an array of integer that represent an integer sequence.
     * @throws IOException in the case of the file is not found because of the wrong path of file.
     */
    public static int[] convertInputFileToArray() throws IOException {
        File sortingProblemFile = new File(pathFile);
        FileReader fileReader = new FileReader(sortingProblemFile);
        int[] sequenceInput = new int[numberOfItemToBeSorted];

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String currentLine;
        int indexOfSequence = 0;
        while ((currentLine = bufferedReader.readLine()) != null) {
            sequenceInput[indexOfSequence] = Integer.parseInt(currentLine);
            indexOfSequence++;
        }
        return sequenceInput;
    }
}
