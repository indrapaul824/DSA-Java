package Leetcode;
import java.util.*;

public class UndergroundSystem {
    static class Pair<T extends Comparable<?>, P extends Comparable<?>> {
        T first;
        P second;

        public Pair(T first, P second) {
            this.first = first;
            this.second = second;
        }
        public T getKey() {
            return first;
        }
        public P getValue() {
            return second;
        }
    }
    Map<Integer, Pair<String, Integer>> checkInMap;
    Map<String, Pair<Double, Integer>> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkIn = checkInMap.get(id);
        checkInMap.remove(id);

        String routeName = checkIn.getKey() + "->" + stationName;
        int totalTime = t - checkIn.getValue();

        Pair<Double, Integer> route = routeMap.getOrDefault(routeName, new Pair<>(0.0, 0));

        routeMap.put(routeName, new Pair<>(route.getKey() + totalTime, route.getValue() + 1));
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeName = startStation + "->" + endStation;
        Pair<Double, Integer> trip = routeMap.get(routeName);
        return trip.getKey() / trip.getValue();
    }
}
