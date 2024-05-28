import java.util.Scanner;

public class Schedule {
    public static String[] generateSchedule(String[] subjectList, int numClasses) {
        String[] schedule = new String[numClasses];
        for (int i = 0; i < numClasses; i++) {
            if (i % 2 == 0) {
                int randomIndex = (int) (Math.random() * 4);
                schedule[i] = subjectList[randomIndex];
            } else {
                int randomIndex = 4 + (int) (Math.random() * 3);
                schedule[i] = subjectList[randomIndex];
            }
        }
        return schedule;
    }

    public static int[] computeDifficulties(String[] schedule, String[] subjectList) {
        int[] difficulties = new int[schedule.length];

        for (int i = 0; i < schedule.length; i++) {
            String subject = schedule[i];
            int subjectIndex = -1;
            for (int j = 0; j < subjectList.length; j++) {
                if (subject == subjectList[j]) {
                    subjectIndex = j;
                    break;
                }
            }
            difficulties[i] = subjectIndex + i;
        }
        return difficulties;
    }

    public static void compareDifficulties(String[] schedule1, String[] schedule2, String[] subjectList) {
        int totalDifficulty1 = 0;
        for (int difficulty : computeDifficulties(schedule1, subjectList)) {
            totalDifficulty1 += difficulty;
        }

        int totalDifficulty2 = 0;
        for (int difficulty : computeDifficulties(schedule2, subjectList)) {
            totalDifficulty2 += difficulty;
        }

        if (totalDifficulty1 > totalDifficulty2) {
            System.out.println("The first schedule is harder than the second schedule.");
        } else if (totalDifficulty2 > totalDifficulty1) {
            System.out.println("The second schedule is harder than the first schedule.");
        } else if (totalDifficulty2 == totalDifficulty1) {
            System.out.println("The two schedules are equally difficult.");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of classes: ");
        int numClasses = scan.nextInt();
        scan.nextLine(); // Consume the newline character

        System.out.print("Enter this schedule's owner's name: ");
        String owner = scan.nextLine();

        String[] subjectList = {"English", "History", "Math", "CS", "Science", "Engineering", "Lab"};

        String[] schedule1 = generateSchedule(subjectList, numClasses);
        String[] schedule2 = generateSchedule(subjectList, numClasses);

        System.out.println("Schedules created successfully. Here are the details:");
        System.out.println("Owner: " + owner);
        System.out.println("Number of Classes: " + numClasses);

        System.out.println("Schedule 1:");
        int[] difficulty1 = computeDifficulties(schedule1, subjectList);
        for (int i = 0; i < schedule1.length; i++) {
            System.out.println(schedule1[i] + " " + difficulty1[i]);
        }

        System.out.println("Schedule 2:");
        int[] difficulty2 = computeDifficulties(schedule2, subjectList);
        for (int i = 0; i < schedule2.length; i++) {
            System.out.println(schedule2[i] + " " + difficulty2[i]);
        }

        compareDifficulties(schedule1, schedule2, subjectList);
    }
}