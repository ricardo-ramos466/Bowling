package test;
import main.Score;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCases {
    private Score score = new Score();
    List<Integer> listOfStrikes = new ArrayList<>();
    List<Integer> listOfSpares = new ArrayList<>();
    List<Integer> listOfNoSpares = new ArrayList<>();

    List<Integer> listOfMix = new ArrayList<>();
    @BeforeTest
    public void prep_for_all_strikes(){

        int amountOfStrikes = 0;
        while(amountOfStrikes<12){
            listOfStrikes.add(10);
            amountOfStrikes++;
        }
    }

    @Test
    public void when_all_strikes_score_is_300(){
        //Act - calculate score
        score.calculateScore(listOfStrikes);

        // Assert - make sure total score is 300
        Assert.assertEquals(score.getTotalScore(),300);
    }

    @BeforeTest
    public void prep_for_all_spares(){
        List<Integer> allSpares = new ArrayList<>();
       allSpares.add(2);
       allSpares.add(8);
       allSpares.add(5);
       allSpares.add(5);
       allSpares.add(9);
       allSpares.add(1);
       allSpares.add(7);
       allSpares.add(3);
       allSpares.add(6);
       allSpares.add(4);
       allSpares.add(1);
       allSpares.add(9);
       allSpares.add(0);
       allSpares.add(10);
       allSpares.add(8);
       allSpares.add(2);
       allSpares.add(4);
       allSpares.add(6);
       allSpares.add(1);
       allSpares.add(9);
       allSpares.add(3);
       listOfSpares = allSpares;
    }

    @Test
    public void all_spares_score_is_144(){
        //Act - calculate score
        score.calculateScore(listOfSpares);

        //Assert - total should be 144
        Assert.assertEquals(score.getTotalScore(),144);

    }

    @BeforeTest
    public void prep_for_no_spares_or_strikes(){
        listOfNoSpares.add(7);
        listOfNoSpares.add(2);
        listOfNoSpares.add(8);
        listOfNoSpares.add(1);
        listOfNoSpares.add(9);
        listOfNoSpares.add(0);
        listOfNoSpares.add(3);
        listOfNoSpares.add(1);
        listOfNoSpares.add(6);
        listOfNoSpares.add(1);
        listOfNoSpares.add(2);
        listOfNoSpares.add(4);
        listOfNoSpares.add(2);
        listOfNoSpares.add(6);
        listOfNoSpares.add(5);
        listOfNoSpares.add(2);
        listOfNoSpares.add(7);
        listOfNoSpares.add(1);
        listOfNoSpares.add(6);
        listOfNoSpares.add(1);



    }
    @Test
    public void no_spares_no_strikes_total_74(){
        //Act - calculate Score
        score.calculateScore(listOfNoSpares);

        //Assert - score should equal 74
        Assert.assertEquals(score.getTotalScore(),74);
    }

    @BeforeTest
    public void prep_for_mix(){
        listOfMix.add(4);
        listOfMix.add(5);
        listOfMix.add(9);
        listOfMix.add(0);
        listOfMix.add(10);
        listOfMix.add(6);
        listOfMix.add(4);
        listOfMix.add(7);
        listOfMix.add(2);
        listOfMix.add(8);
        listOfMix.add(2);
        listOfMix.add(5);
        listOfMix.add(5);
        listOfMix.add(6);
        listOfMix.add(3);
        listOfMix.add(10);
        listOfMix.add(9);
        listOfMix.add(1);
        listOfMix.add(7);
    }

    @Test
    public void mix_game_test_total_141(){
        //Act - calculate score
        score.calculateScore(listOfMix);

        //Assert - total should equal 141
        Assert.assertEquals(score.getTotalScore(),141);
    }
}
