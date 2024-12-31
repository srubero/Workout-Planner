import java.util.*;

public class WorkoutPlanner {

    static class Exercise {
        String name;
        String code;

        Exercise(String name, String code) {
            this.name = name;
            this.code = code;
        }
    }

    static class UserProfile {
        String name;
        int skillLevel;
        int exerciseType;
        int splitChoice;

        UserProfile(String name, int skillLevel, int exerciseType, int splitChoice) {
            this.name = name;
            this.skillLevel = skillLevel;
            this.exerciseType = exerciseType;
            this.splitChoice = splitChoice;
        }
    }

    static List<Exercise> exercises = new ArrayList<>();

    static {
        //This part with the codes is important.
        // The first number determines the type of exercise. So this would be calisthenics, free weights, or machines.
        //The second digit is the muscle. So this would be: back, biceps, chest, triceps, shoulders, quads, hamstrings, glutes, and calves
        //The final aspects that organizes these workouts is the order they are in. The hardest exercise is the first one in the group.
        //So for example, pullups are harder than inverted rows which is why they are first in the addition.

        exercises.add(new Exercise("Pullups", "11"));
        exercises.add(new Exercise("Inverted Rows", "11"));
        exercises.add(new Exercise("Chinups", "12"));
        exercises.add(new Exercise("Pelican Curls", "12"));
        exercises.add(new Exercise("Ring Curls", "12"));
        exercises.add(new Exercise("Dips", "13"));
        exercises.add(new Exercise("Pushups", "13"));
        exercises.add(new Exercise("Ring Flys", "13"));
        exercises.add(new Exercise("Bodyweight Skullcrushers", "14"));
        exercises.add(new Exercise("Diamond Pushups", "14"));
        exercises.add(new Exercise("Bodyweight Extensions", "14"));
        exercises.add(new Exercise("Pike Pushups", "15"));
        exercises.add(new Exercise("Face Pulls", "11"));
        exercises.add(new Exercise("Pistol Squat", "16"));
        exercises.add(new Exercise("Sissy Squat", "16"));
        exercises.add(new Exercise("Nordics", "17"));
        exercises.add(new Exercise("Split Squat", "18"));
        exercises.add(new Exercise("Glute Bridges", "18"));
        // machines
        exercises.add(new Exercise("T-Bar Rows", "21"));
        exercises.add(new Exercise("Lat Pulldowns", "21"));
        exercises.add(new Exercise("Cable Rows", "21"));
        exercises.add(new Exercise("Lat Prayers", "21"));
        exercises.add(new Exercise("Face Away Cable Curls", "22"));
        exercises.add(new Exercise("Preacher Curl Machine", "22"));
        exercises.add(new Exercise("Standing Cable Curls", "22"));
        exercises.add(new Exercise("Pec Deck Flys", "23"));
        exercises.add(new Exercise("Vertical Chest Press", "23"));
        exercises.add(new Exercise("Cable Tricep Pushdowns", "24"));
        exercises.add(new Exercise("Cable Overhead Extensions", "24"));
        exercises.add(new Exercise("Cable Lateral Raises", "25"));
        exercises.add(new Exercise("Machine Overhead Press", "25"));
        exercises.add(new Exercise("Cable Face Pulls", "21"));//a pulling shoulder exercise
        exercises.add(new Exercise("Leg Press", "26"));
        exercises.add(new Exercise("Hack Squat", "26"));
        exercises.add(new Exercise("Leg Extensions", "26"));
        exercises.add(new Exercise("Leg Curls", "27"));
        exercises.add(new Exercise("Hip Thrust Machine", "28"));
        exercises.add(new Exercise("Machine Calf Raises", "29"));
        // free weights
        exercises.add(new Exercise("Bent Over Barbell Rows", "31"));
        exercises.add(new Exercise("Bench Assisted Single Arm Rows", "31"));
        exercises.add(new Exercise("Dumbbell Pullovers", "31"));
        exercises.add(new Exercise("Shrugs", "31"));
        exercises.add(new Exercise("Incline Dumbbell Curls", "32"));
        exercises.add(new Exercise("Preacher Bar Curls", "32"));
        exercises.add(new Exercise("Standing Barbell Curls", "32"));
        exercises.add(new Exercise("Hammer Curls", "32"));
        exercises.add(new Exercise("Reverse Grip Curls", "32"));
        exercises.add(new Exercise("Incline Dumbbell Press", "33"));
        exercises.add(new Exercise("Dumbbell Flys", "33"));
        exercises.add(new Exercise("Flat Bench Press", "33"));
        exercises.add(new Exercise("Close Grip Bench Press", "33"));
        exercises.add(new Exercise("Skullcrushers", "34"));
        exercises.add(new Exercise("Overhead Tricep Extensions", "34"));
        exercises.add(new Exercise("Lateral Raises", "35"));
        exercises.add(new Exercise("Overhead Press", "35"));
        exercises.add(new Exercise("Reverse Dumbbell Fly", "31"));
        exercises.add(new Exercise("Front Raise", "35"));
        exercises.add(new Exercise("Front Squat", "36"));
        exercises.add(new Exercise("Back Squat", "36"));
        exercises.add(new Exercise("Goblet Squat", "36"));
        exercises.add(new Exercise("Romanian Deadlifts", "37"));
        exercises.add(new Exercise("Deadlift", "37"));
        exercises.add(new Exercise("Bulgarian Split Squat", "38"));
        exercises.add(new Exercise("Walking Lunges", "38"));
        exercises.add(new Exercise("Calf Raises", "39"));
    }


    private static List<Exercise> filterExercises(int type, int muscleGroup) {
        List<Exercise> filtered = new ArrayList<>();
        for (Exercise ex : exercises) {
            if (ex.code.charAt(0) - '0' == type && ex.code.charAt(1) - '0' == muscleGroup) {
                filtered.add(ex);
            }
        }
        return filtered;
    }

    static void generateWorkout(int exerciseType, int[] muscleGroups, int[] exercisesPerGroup, int sets, int repsMin, int repsMax) {
        for (int i = 0; i < muscleGroups.length; i++) {
            List<Exercise> filtered = filterExercises(exerciseType, muscleGroups[i]);
            int count = Math.min(exercisesPerGroup[i], filtered.size());
            for (int j = 0; j < count; j++) {
                Exercise exercise = filtered.get(j);
                System.out.println(exercise.name + " - " + sets + " sets of " + repsMin + "-" + repsMax + " reps");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Enter your skill level: 1 - Beginner, 2 - Intermediate, 3 - Advanced");
                int skillLevel = scanner.nextInt();

                int sets = 0, repsMin = 0, repsMax = 0, exercisesPerDay = 0, daysPerWeek = 0;
                switch (skillLevel) {
                    case 1:
                        sets = 3;
                        repsMin = 8;
                        repsMax = 12;
//                        exercisesPerDay = 3;
                        daysPerWeek = 3;
                        break;
                    case 2:
                        sets = 4;
                        repsMin = 10;
                        repsMax = 15;
//                        exercisesPerDay = 4;
                        daysPerWeek = 4;
                        break;
                    case 3:
                        sets = 4;
                        repsMin = 8;
                        repsMax = 15;
//                        exercisesPerDay = 6;
                        daysPerWeek = 5;
                        break;
                    default:
                        System.out.println("Invalid skill level");
                        return;
                }

                System.out.println("\nChoose your split:");
                System.out.println("1 - Pull, Push, Legs\n2 - Upper, Lower\n3 - Torso, Arms, Legs\n4 - Full Body");
                int splitChoice = scanner.nextInt();

                System.out.println("\nChoose your exercise type:");
                System.out.println("1 - Calisthenics\n2 - Machines\n3 - Free Weights");
                int exerciseType = scanner.nextInt();

                System.out.println("\nWorkout Plan:");

                switch (splitChoice) {
                    case 1: // Pull, Push, Legs
                        System.out.println("Pull:");
                        generateWorkout(exerciseType, new int[]{1, 2}, skillLevel == 1 ? new int[]{2, 1} : skillLevel == 2 ? new int[]{3, 1} : new int[]{4, 2}, sets, repsMin, repsMax);

                        System.out.println("\nPush:");
                        generateWorkout(exerciseType, new int[]{3, 4, 5}, skillLevel == 1 ? new int[]{1, 1, 1} : skillLevel == 2 ? new int[]{2, 1, 1} : new int[]{2, 2, 2}, sets, repsMin, repsMax);

                        System.out.println("\nLegs:");
                        generateWorkout(exerciseType, new int[]{6, 7, 8, 9}, skillLevel == 1 ? new int[]{1, 1, 1, 0} : skillLevel == 2 ? new int[]{2, 1, 1, 0} : new int[]{2, 1, 2, 0}, sets, repsMin, repsMax);
                        break;

                    case 2: // Upper, Lower
                        System.out.println("Upper:");
                        generateWorkout(exerciseType, new int[]{1, 2, 3, 4, 5}, skillLevel == 1 ? new int[]{1, 0, 1, 0, 1} : skillLevel == 2 ? new int[]{1, 1, 1, 0, 1} : new int[]{1, 1, 1, 1, 1}, sets, repsMin, repsMax);

                        System.out.println("\nLower:");
                        generateWorkout(exerciseType, new int[]{6, 7, 8, 9}, skillLevel == 1 ? new int[]{1, 1, 1, 0} : skillLevel == 2 ? new int[]{2, 1, 1, 1} : new int[]{2, 2, 1, 1}, sets, repsMin, repsMax);
                        break;

                    case 3: // Torso, Arms, Legs
                        System.out.println("Torso:");
                        generateWorkout(exerciseType, new int[]{1, 3}, skillLevel == 1 ? new int[]{1, 2} : skillLevel == 2 ? new int[]{2, 2} : new int[]{3, 3}, sets, repsMin, repsMax);

                        System.out.println("\nArms:");
                        generateWorkout(exerciseType, new int[]{2, 4, 5}, skillLevel == 1 ? new int[]{1, 1, 1} : skillLevel == 2 ? new int[]{1, 2, 1} : new int[]{2, 2, 2}, sets, repsMin, repsMax);

                        System.out.println("\nLegs:");
                        generateWorkout(exerciseType, new int[]{6, 7, 8, 9}, skillLevel == 1 ? new int[]{1, 1, 1, 0} : skillLevel == 2 ? new int[]{2, 1, 1, 1} : new int[]{2, 2, 1, 1}, sets, repsMin, repsMax);
                        break;

                    case 4: // Full Body
                        System.out.println("Full Body:");
                        generateWorkout(exerciseType, new int[]{1, 3, 5, 6, 7}, skillLevel == 1 ? new int[]{1, 1, 0, 1, 0} : skillLevel == 2 ? new int[]{1, 1, 0, 1, 1} : new int[]{1, 1, 1, 1, 1}, sets, repsMin, repsMax);
                        break;

                    default:
                        System.out.println("Invalid split choice. Please try again.");
                        continue;
                }
                System.out.println("\nWorkout days per week: " + daysPerWeek);
                System.out.println();

                System.out.println("\nDo you want to create another workout routine? (yes/no)");
                String continueChoice = scanner.next();
                if (continueChoice.equalsIgnoreCase("no")) {
                    System.out.println("Goodbye!");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers only.");
                scanner.next(); // Clear the invalid input
            }
        }
        scanner.close();
    }
}
