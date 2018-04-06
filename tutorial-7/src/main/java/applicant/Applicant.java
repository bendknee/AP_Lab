package applicant;

import java.util.function.Predicate;

/**
 * 4th exercise.
 */
public class Applicant {

    public boolean isCredible() {
        return true;
    }

    public int getCreditScore() {
        return 700;
    }

    public int getEmploymentYears() {
        return 10;
    }

    public boolean hasCriminalRecord() {
        return true;
    }

    public static String evaluate(Applicant applicant, Predicate<Applicant> evaluator) {
        return "Result of evaluating applicant: ".concat(
                evaluator.test(applicant) ? "accepted" : "rejected");
    }

    public static void main(String[] args) {
        Applicant applicant = new Applicant();
        Predicate<Applicant> qualifiedEvaluator = Applicant::isCredible;
        Predicate<Applicant> creditEvaluator = anApplicant -> anApplicant.getCreditScore() > 600;
        Predicate<Applicant> employmentEvaluator = anApplicant ->
                anApplicant.getEmploymentYears() > 0;
        Predicate<Applicant> criminalEvaluator = anApplicant -> !anApplicant.hasCriminalRecord();

        System.out.println(evaluate(applicant, qualifiedEvaluator.and(creditEvaluator)));
        System.out.println(evaluate(applicant, qualifiedEvaluator.and(
                employmentEvaluator.and(creditEvaluator))));
        System.out.println(evaluate(applicant, qualifiedEvaluator.and(
                employmentEvaluator.and(criminalEvaluator))));
        System.out.println(evaluate(applicant, qualifiedEvaluator.and(
                employmentEvaluator.and(creditEvaluator.and(criminalEvaluator)))));

        /*System.out.println(evaluate(applicant, new CreditEvaluator(new QualifiedEvaluator())));
        System.out.println(evaluate(applicant,
                new CreditEvaluator(new EmploymentEvaluator(new QualifiedEvaluator()))));
        System.out.println(evaluate(applicant,
                new CriminalRecordsEvaluator(
                        new EmploymentEvaluator(new QualifiedEvaluator()))));
        System.out.println(evaluate(applicant,
                new CriminalRecordsEvaluator(
                        new CreditEvaluator(
                                new EmploymentEvaluator(new QualifiedEvaluator())))));*/
    }
}
