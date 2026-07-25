import java.util.HashMap;

class UndergroundSystem {

    class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    class Trip {
        int totalTime;
        int count;

        Trip(int totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }

    private HashMap<Integer, CheckIn> checkIns;
    private HashMap<String, Trip> trips;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        trips = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = checkIns.get(id);

        String key = checkIn.station + "->" + stationName;
        int travelTime = t - checkIn.time;

        Trip trip = trips.getOrDefault(key, new Trip(0, 0));
        trip.totalTime += travelTime;
        trip.count++;

        trips.put(key, trip);

        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "->" + endStation;
        Trip trip = trips.get(key);

        return (double) trip.totalTime / trip.count;
    }
}