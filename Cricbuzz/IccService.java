public class IccService {
    private int runs;
    private int wickets;
    private int overs;

    public IccService(int runs, int wickets, int overs) {
        this.runs = runs;
        this.wickets = wickets;
        this.overs = overs;
    }

    public int getOvers() {
        return overs;
    }

    public int getRuns() {
        return runs;
    }

    public int getWickets() {
        return wickets;
    }

    public void updateScores(int wickets, int overs,int runs) {
//        will be making an api call to get the data from icc
        this.wickets = wickets;
        this.overs = overs;
        this.runs = runs;
    }
}
