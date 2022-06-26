package basics.geekforgeeks.greedy;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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

    static int activitySelection(Activity[] activities) {
        if (activities == null) return 0;

        Activity[] clonedActivities = activities.clone();
        Arrays.sort(clonedActivities);

        int maxActivities = 1;
        int previousActivityEndIndex = 0;
        for (int i = 1; i < clonedActivities.length; i++) {
            int currentActivityStart = clonedActivities[i].getStartTime();
            int previousActivityEnd = clonedActivities[previousActivityEndIndex].getEndTime();
            if (currentActivityStart >= previousActivityEnd) {
                System.out.println(clonedActivities[i]);
                maxActivities++;
                previousActivityEndIndex = i;
            }
        }

        return maxActivities;
    }

    static int jobSequencing(Job[] jobs) {
        if (jobs == null) return 0;
        Job[] clonedJobs = jobs.clone();
        int max = Arrays.stream(clonedJobs).map(Job::getDeadline).max(Integer::compare).get();
        int[] profits = new int[max];

        Arrays.sort(clonedJobs, Collections.reverseOrder());
        for (Job job : clonedJobs) {
            int deadline = job.getDeadline();
            int i = deadline - 1;
            while (i > 0 && profits[i] != 0) {
                i--;
            }
            if (profits[i] == 0) {
                profits[i] = job.getProfit();
            }
        }

        return Arrays.stream(profits).sum();
    }


    static int jobSequencingCustomComparator(Job[] jobs) {
        if (jobs == null) return 0;

        Job[] clonedJobs = jobs.clone();
        Arrays.sort(clonedJobs, JobCustomComparator.getComparator());
        int previousTaskComletedAt = 0;
        int maxProfits = 0;
        for (Job job : clonedJobs) {
            if (job.getDeadline() > previousTaskComletedAt) {
                previousTaskComletedAt++;
                maxProfits += job.getProfit();
            }
        }
        return maxProfits;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{10, 6, 2};
//        Arrays.stream(nums).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
//        System.out.println(minimumNumberOfCoins(nums, 189));

//        [[2,15],[36,45],[9,29],[16,23],[4,9]]

        Activity[] activities = new Activity[]{new Activity(2, 15), new Activity(36, 45), new Activity(9, 29), new Activity(16, 23), new Activity(4, 9)};
        System.out.println(activitySelection(activities));

//        Job[] jobs = new Job[]{new Job(2, 50), new Job(2, 60), new Job(3, 20), new Job(3, 30)};
//        Job[] jobs = new Job[]{new Job(4, 50), new Job(1, 5), new Job(1, 20), new Job(5, 10), new Job(5, 80)};
//        System.out.println(jobSequencing(jobs));
//        System.out.println(jobSequencingCustomComparator(jobs));
    }
}

class JobCustomComparator {
    public static Comparator<Job> getComparator() {
        Comparator<Job> deadLineComparator = Comparator.comparing(Job::getDeadline);
        Comparator<Job> profitComparator = Comparator.comparing(Job::getProfit, Collections.reverseOrder());

        return deadLineComparator.thenComparing(profitComparator);
    }
}

class Job implements Comparable<Job> {
    private int deadline;
    private int profit;

    Job(int deadline, int profit) {
        this.deadline = deadline;
        this.profit = profit;
    }

    public int getDeadline() {
        return deadline;
    }

    public int getProfit() {
        return profit;
    }

    @Override
    public int compareTo(@NotNull Job otherJob) {
        return (this.getProfit() - otherJob.getProfit());
    }

    @Override
    public String toString() {
        return "Job{" +
                "deadline=" + deadline +
                ", profit=" + profit +
                '}';
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