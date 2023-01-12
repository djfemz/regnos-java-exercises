package exercises.chapterSeven.tortoise_hare;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RaceTrackTest {

    private RaceTrack raceTrack;

    @BeforeEach
    public void setUp(){
        raceTrack=new RaceTrack();
    }



    @Test
    public void testThatRaceTrackExists(){
        assertNotNull(raceTrack);
    }

    @Test
    public void testThatRaceTrackLaneHas_70_Squares(){
        String[][] lanes = raceTrack.getLanes();
        String[] laneOne=lanes[0];
        String[] laneTwo=lanes[1];
        assertEquals(70, laneOne.length);
        assertEquals(70, laneTwo.length);

    }

    @Test
    public void testThatRaceTrackLaneSquareIsBlankByDefault(){
        String[][] lanes = raceTrack.getLanes();
        for (int counter=0;counter< lanes.length;counter++) {
            for (int counterTwo=1;counterTwo<lanes[counter].length;counterTwo++) {
                assertEquals(raceTrack.getBlankSpace(), lanes[counter][counterTwo]);
            }
        }
    }

    @Test
    public void testTortoiseFast_PlodMove(){
        raceTrack.move(5);
        String[] tortoiseLane = raceTrack.getLanes()[0];
        assertEquals(raceTrack.getTORTOISE_SYMBOL(), tortoiseLane[3]);
    }

    @Test
    public void testTortoiseSlipMove(){
        raceTrack.move(3);
        raceTrack.move(7);
        String[] tortoiseLane = raceTrack.getLanes()[0];
        assertEquals("T", tortoiseLane[0]);
    }

}