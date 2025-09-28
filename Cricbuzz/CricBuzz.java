public class CricBuzz {
    private int runs;
    private int wickets;
    private int overs;

    private IccService iccService; //this violates dip

    public CricBuzz() {
        this.iccService = new IccService(0,0,0);
    }

    public void updateScore(int run,int wickets,int overs) {
        while (true) {
            iccService.updateScores(run,wickets,overs);

            if(this.overs != iccService.getOvers()) {
                this.overs = iccService.getOvers();
                this.wickets = iccService.getWickets();
                this.runs = iccService.getRuns();
                System.out.println(this.runs + " " + this.wickets + " " + this.overs);
            }
        }
    }
}
