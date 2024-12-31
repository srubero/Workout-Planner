public class WorkoutPlannerTester {

    public static void main(String[] args) {
        int[] skillLevels = {1, 2, 3}; // Beginner, Intermediate, Advanced
        int[] splitChoices = {1, 2, 3, 4}; // Pull-Push-Legs, Upper-Lower, Torso-Arms-Legs, Full Body
        int[] exerciseTypes = {1, 2, 3}; // Calisthenics, Machines, Free Weights

        for (int skillLevel : skillLevels) {
            for (int splitChoice : splitChoices) {
                for (int exerciseType : exerciseTypes) {
                    System.out.println("\n--------------------------------------------------");
                    System.out.println("Skill Level: " + skillLevel);
                    System.out.println("Split Choice: " + splitChoice);
                    System.out.println("Exercise Type: " + exerciseType);
                    System.out.println("--------------------------------------------------");

                    testWorkoutPlan(skillLevel, splitChoice, exerciseType);
                }
            }
        }
    }

    private static void testWorkoutPlan(int skillLevel, int splitChoice, int exerciseType) {
        int sets = 0, repsMin = 0, repsMax = 0;

        switch (skillLevel) {
            case 1:
                sets = 3;
                repsMin = 8;
                repsMax = 12;
                break;
            case 2:
                sets = 4;
                repsMin = 10;
                repsMax = 15;
                break;
            case 3:
                sets = 4;
                repsMin = 8;
                repsMax = 15;
                break;
        }

        System.out.println("\nWorkout Plan:");

        switch (splitChoice) {
            case 1: // Pull, Push, Legs
                System.out.println("Pull:");
                WorkoutPlanner.generateWorkout(exerciseType, new int[]{1, 2}, skillLevel == 1 ? new int[]{2, 1} : skillLevel == 2 ? new int[]{3, 1} : new int[]{4, 2}, sets, repsMin, repsMax);

                System.out.println("\nPush:");
                WorkoutPlanner.generateWorkout(exerciseType, new int[]{3, 4, 5}, skillLevel == 1 ? new int[]{1, 1, 1} : skillLevel == 2 ? new int[]{2, 1, 1} : new int[]{2, 2, 2}, sets, repsMin, repsMax);

                System.out.println("\nLegs:");
                WorkoutPlanner.generateWorkout(exerciseType, new int[]{6, 7, 8, 9}, skillLevel == 1 ? new int[]{1, 1, 1, 0} : skillLevel == 2 ? new int[]{2, 1, 1, 0} : new int[]{2, 1, 2, 0}, sets, repsMin, repsMax);
                break;

            case 2: // Upper, Lower
                System.out.println("Upper:");
                WorkoutPlanner.generateWorkout(exerciseType, new int[]{1, 2, 3, 4, 5}, skillLevel == 1 ? new int[]{1, 0, 1, 0, 1} : skillLevel == 2 ? new int[]{1, 1, 1, 0, 1} : new int[]{1, 1, 1, 1, 1}, sets, repsMin, repsMax);

                System.out.println("\nLower:");
                WorkoutPlanner.generateWorkout(exerciseType, new int[]{6, 7, 8, 9}, skillLevel == 1 ? new int[]{1, 1, 1, 0} : skillLevel == 2 ? new int[]{2, 1, 1, 1} : new int[]{2, 2, 1, 1}, sets, repsMin, repsMax);
                break;

            case 3: // Torso, Arms, Legs
                System.out.println("Torso:");
                WorkoutPlanner.generateWorkout(exerciseType, new int[]{1, 3}, skillLevel == 1 ? new int[]{1, 2} : skillLevel == 2 ? new int[]{2, 2} : new int[]{3, 3}, sets, repsMin, repsMax);

                System.out.println("\nArms:");
                WorkoutPlanner.generateWorkout(exerciseType, new int[]{2, 4, 5}, skillLevel == 1 ? new int[]{1, 1, 1} : skillLevel == 2 ? new int[]{1, 2, 1} : new int[]{2, 2, 2}, sets, repsMin, repsMax);

                System.out.println("\nLegs:");
                WorkoutPlanner.generateWorkout(exerciseType, new int[]{6, 7, 8, 9}, skillLevel == 1 ? new int[]{1, 1, 1, 0} : skillLevel == 2 ? new int[]{2, 1, 1, 1} : new int[]{2, 2, 1, 1}, sets, repsMin, repsMax);
                break;

            case 4: // Full Body
                System.out.println("Full Body:");
                WorkoutPlanner.generateWorkout(exerciseType, new int[]{1, 3, 6, 7}, skillLevel == 1 ? new int[]{1, 1, 1, 0} : skillLevel == 2 ? new int[]{1, 2, 1, 1} : new int[]{2, 2, 2, 2}, sets, repsMin, repsMax);
                break;

            default:
                System.out.println("Invalid split choice.");
        }
    }
}
