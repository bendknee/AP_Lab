package sorting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SortAndSearchTest {

    private static int[] sequenceInput = {2, 452, 1294, 952, 3934, 20, 595, 8373, 4003, 352, 75, 111, 5771};

    @Test
    public void testGivenAlgorithm() {
        int[] processArr = sequenceInput.clone();
        assertEquals(Finder.slowSearch(processArr,8373),8373);

        processArr = Sorter.slowSort(processArr);
        contentChecker(processArr);
    }

    @Test
    public void testNewAlgorithm() {
        int[] processArr = sequenceInput.clone();
        assertEquals(Finder.slowSearchImproved(processArr,8373),8373);

        processArr = Sorter.quickSort(processArr);
        contentChecker(processArr);

        assertTrue(Finder.quickSearch(processArr,8373) >= 0);
    }

    private void contentChecker(int[] arr) {
        boolean flag = true;
        for (int a = 1; a < arr.length; a++) {
            if (arr[a] < arr[a-1]) {
                flag = false;
                break;
            }
        }
        assertTrue(flag);
    }
}
