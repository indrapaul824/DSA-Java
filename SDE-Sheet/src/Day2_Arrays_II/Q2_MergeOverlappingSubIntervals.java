package Day2_Arrays_II;
import java.util.*;

public class Q2_MergeOverlappingSubIntervals {

    // Brute Force Approach
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int n = intervals.length;

        LinkedList<int[]> merged = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0], end = intervals[i][1];

            if (!merged.isEmpty() && end <= merged.getLast()[1])
                continue;

            for (int j = i+1; j < n; j++) {
                if (intervals[j][0] <= end)
                    end = Math.max(end, intervals[j][1]);
                else
                    break;
            }

            merged.add(new int[]{start, end});
        }

        return merged.toArray(new int[merged.size()][]);
    }

    // Optimal Approach
    public int[][] merge_optimal(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int n = intervals.length;

        LinkedList<int[]> merged = new LinkedList<>();

        merged.add(intervals[0]);

        for (int i = 1; i < n; i++) {
            int end = merged.getLast()[1];
            if (intervals[i][0] <= end)
                merged.getLast()[1] = Math.max(end, intervals[i][1]);
            else
                merged.add(intervals[i]);
        }

        return merged.toArray(new int[merged.size()][]);
    }

    static class Interval {
        int start, end;
        public Interval() {
            start = 0;
            end = 0;
        }
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(a -> a.start));

        LinkedList<Interval> merged = new LinkedList<>();

        merged.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            Interval lastInterval = merged.getLast();

            if (lastInterval.end >= intervals.get(i).start) {
                lastInterval.end = Math.max(lastInterval.end, intervals.get(i).end);
            } else {
                merged.add(intervals.get(i));
            }
        }

        return new ArrayList<>(merged);
    }
}
