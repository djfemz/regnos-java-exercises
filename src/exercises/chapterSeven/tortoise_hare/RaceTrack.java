package exercises.chapterSeven.tortoise_hare;

import java.util.Arrays;

public class RaceTrack {
    private final String[][] lanes;
    private final String TORTOISE_SYMBOL="T";
    private int tortoisePosition;
    private int harePosition;
    private final String HARE_SYMBOL="H";

    private final String blankSpace = " ";
    private final int TORTOISE_LANE=0;

    private final int HARE_LANE=1;


    public RaceTrack() {
        int numberOfLanes=2;
        int numberOfSquaresPerLane = 70;
        this.lanes = new String[numberOfLanes][numberOfSquaresPerLane];
        for (String[] lane :lanes) {
            Arrays.fill(lane, blankSpace);
        }
        lanes[0][tortoisePosition]=TORTOISE_SYMBOL;
        lanes[1][harePosition]=HARE_SYMBOL;
    }

    public String[][] getLanes() {
        return lanes;
    }

    public String getTORTOISE_SYMBOL() {
        return TORTOISE_SYMBOL;
    }

    public String getHARE_SYMBOL() {
        return HARE_SYMBOL;
    }

    public void move(int number) {
        moveTortoise(number);
    }

    private void moveTortoise(int number) {
        String[] lane = lanes[TORTOISE_LANE];
        if (number >=1&& number <=5) makeFastPlodMove(lane);
        if (number >=6&& number <=7) makeSlipMove(lane);
    }

    private void makeFastPlodMove(String[] lane) {
        lane[tortoisePosition]=blankSpace;
        lane[tortoisePosition+RaceMove.FAST_PLOD] = TORTOISE_SYMBOL;
        tortoisePosition +=RaceMove.FAST_PLOD;
    }

    private void makeSlipMove(String[] lane) {
        if (tortoisePosition<6) {
            lane[0]=getTORTOISE_SYMBOL();
            tortoisePosition=0;
        }else {
            lane[tortoisePosition + RaceMove.SLIP] = TORTOISE_SYMBOL;
            tortoisePosition += RaceMove.SLIP;
        }
    }


    public void setTortoisePosition(int tortoisePosition) {
        this.tortoisePosition = tortoisePosition;
    }

    public void setHarePosition(int harePosition) {
        this.harePosition = harePosition;
    }

    public String getBlankSpace() {
        return blankSpace;
    }

    public int getTortoisePosition() {
        return tortoisePosition;
    }
}
