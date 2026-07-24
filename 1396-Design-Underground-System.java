class UndergroundSystem {
    private Map<Integer, Object[]> checkIns; // id -> [station, time]
    private Map<String, double[]> travelStats; // "start->end" -> [totalTime, count]

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        travelStats = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new Object[]{stationName, t});
    }

    public void checkOut(int id, String stationName, int t) {
        Object[] info = checkIns.remove(id);
        String startStation = (String) info[0];
        int startTime = (int) info[1];

        String route = startStation + "->" + stationName;
        double duration = t - startTime;

        double[] stats = travelStats.getOrDefault(route, new double[2]);
        stats[0] += duration;
        stats[1] += 1;
        travelStats.put(route, stats);
    }

    public double getAverageTime(String startStation, String endStation) {
        double[] stats = travelStats.get(startStation + "->" + endStation);
        return stats[0] / stats[1];
    }
}
