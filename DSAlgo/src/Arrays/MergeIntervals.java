package Arrays;

import java.util.ArrayList;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47512/assignment/problems/58?navref=cl_tt_nv */
public class MergeIntervals {
    /*
     * T.C: O(n)
     * S.C: O(1)
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> list = new ArrayList<Interval>();

        // Iterate through array
        for (int i = 0; i < intervals.size(); i++) {
            /*
             * Check if newInterval start point is greater than
             * current interval end point, then add current interval to result list
             */
            if (intervals.get(i).end < newInterval.start) {
                list.add(new Interval(intervals.get(i).start, intervals.get(i).end));
            }
            /*
             * Check if newInterval end point is less than
             * current interval start point, then add to result list
             */
            else if (intervals.get(i).start > newInterval.end) {
                // New interval is added to result list
                list.add(newInterval);
                /*
                 * If new interval is added then add remaining interval
                 * from input list
                 */
                for (int j = i; j < intervals.size(); j++) {
                    list.add(new Interval(intervals.get(j).start, intervals.get(j).end));
                }

                // return result list
                return list;
            }
            /*
             * If newInterval is overlapped with current interval start or end,
             * then compute intput newInterval new start and end
             */
            else {
                newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            }
        }

        /* If list is not returned before, then add newInterval to result list */
        list.add(new Interval(newInterval.start, newInterval.end));
        return list;
    }
}
