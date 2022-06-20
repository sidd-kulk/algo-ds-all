package basics.geekforgeeks.greedy;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class GreedyProblems {
    static int minimumNumberOfCoins(int[] coins, int amount) {
        if (coins == null) return 0;

        int minimumNumberOfCoins = 0;
        int remainingAmount = amount;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= remainingAmount) {
                int numberOfCoinsOfCurrentValue = remainingAmount / coins[i];
                minimumNumberOfCoins += numberOfCoinsOfCurrentValue;
                remainingAmount = remainingAmount - numberOfCoinsOfCurrentValue * coins[i];
            }
            if (remainingAmount == 0) break;
        }
        if (remainingAmount != 0) throw new RuntimeException("Could not satisfy the condition");

        return minimumNumberOfCoins;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{10, 6, 2};
//        Arrays.stream(nums).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
//        System.out.println(minimumNumberOfCoins(nums, 189));

        Activity[] activities = new Activity[] {new Activity(12,25), new Activity(10,20), new Activity(20,30)};
        System.out.println(activitySelection(activities));
    }

    static int activitySelection(Activity[] activities) {
        if (activities == null) return 0;
        Arrays.sort(activities);

        int maxActivities = 1;
        int previousActivityEndIndex = 0;
        for (int i = 1; i < activities.length; i++) {
            int currentActivityStart = activities[i].getStartTime();
            int previousActivityEnd = activities[previousActivityEndIndex].getEndTime();
            if (currentActivityStart >= previousActivityEnd) {
                maxActivities++;
            }
        }

        return maxActivities;
    }

}


class Activity implements Comparable<Activity> {
    private int startTime;
    private int endTime;

    Activity(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return startTime == activity.startTime && endTime == activity.endTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, endTime);
    }

    @Override
    public int compareTo(@NotNull Activity activity) {
        return Integer.compare(this.getEndTime(), activity.getEndTime());
    }
}