public class GradeCalculator {

    public double calculateAverage(int mark1, int mark2, int mark3) {

        return (mark1 + mark2 + mark3) / 3.0;
    }

    public String getGrade(double average) {

        if (average >= 70) {
            return "First Class";

        } else if (average >= 60) {
            return "Upper Second (2:1)";

        } else if (average >= 50) {
            return "Lower Second (2:2)";

        } else if (average >= 40) {
            return "Third Class";

        } else {
            return "Fail";
        }
    }
}
