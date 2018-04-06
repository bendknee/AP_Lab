package applicant;

import static org.junit.Assert.assertEquals;

import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;

public class ApplicantTest {

    private Applicant applicant;
    private Predicate<Applicant> qualifiedEvaluator;
    private Predicate<Applicant> creditEvaluator;
    private Predicate<Applicant> employmentEvaluator;
    private Predicate<Applicant> criminalEvaluator;

    @Before
    public void setUp() {
        Applicant.main(new String[]{});
        applicant = new Applicant();
        qualifiedEvaluator = Applicant::isCredible;
        creditEvaluator = anApplicant -> anApplicant.getCreditScore() > 600;
        employmentEvaluator = anApplicant -> anApplicant.getEmploymentYears() > 0;
        criminalEvaluator = anApplicant -> !anApplicant.hasCriminalRecord();
    }

    @Test
    public void testSingleEvaluation() {
        assertEquals("Result of evaluating applicant: accepted", Applicant.evaluate(
                applicant, qualifiedEvaluator));
    }

    @Test
    public void testDoubleEvaluation() {
        assertEquals("Result of evaluating applicant: accepted", Applicant.evaluate(
                applicant, qualifiedEvaluator.and(employmentEvaluator)));
    }

    @Test
    public void testTripleEvaluation() {
        assertEquals("Result of evaluating applicant: accepted", Applicant.evaluate(
                applicant, qualifiedEvaluator.and(employmentEvaluator.and(creditEvaluator))));
    }

    @Test
    public void testQuadrupleEvaluation() {
        assertEquals("Result of evaluating applicant: rejected", Applicant.evaluate(
                applicant, qualifiedEvaluator.and(employmentEvaluator.and(creditEvaluator.and(
                        criminalEvaluator)))));
    }
}
