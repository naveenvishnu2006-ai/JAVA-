class UndergroundSystem {
    private Map<Integer, Pair> checkIns; // id -> (station, time)
    private Map<String, double[]> travelStats; // "start->end" -> [totalTime, count]

    class Pair {
        String station;
        int time;
        Pair(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        travelStats = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair checkInInfo = checkIns.remove(id);
        String route = checkInInfo.station + "->" + stationName;
        double duration = t - checkInInfo.time;
        
        double[] stats = travelStats.getOrDefault(route, new double[2]); // [totalTime, count]
        stats[0] += duration;
        stats[1] += 1;
        travelStats.put(route, stats);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;
        double[] stats = travelStats.get(route);
        return stats[0] / stats[1];
    }
}
