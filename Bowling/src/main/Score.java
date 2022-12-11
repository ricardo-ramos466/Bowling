package main;

import java.util.*;

public class Score {
    private List<Integer> listOfPlays;
    private int totalScore;
    private Map<Integer,List<Integer>> frames;


    // Setting the value of each frame saved as a HashMap
    public void setAllFrames(List<Integer> plays){
        // Keeps track of the frame to be saved
        int frame = 1;
        //HashMap to be used to save the individual frames
        Map<Integer,List<Integer>> frames = new HashMap<>();
        //Looping the list of values and splitting them between the frames
        for( int i = 0; i< plays.size(); i++){
            //Checks to see if the value is a strike, and we are not on the last frame
            if(plays.get(i)==10 && frame !=10) {
                //Value then gets added to the HashMap with the current frame
                frames.put(frame, Collections.singletonList(plays.get(i)));
                //Frame Count is increased by 1
                frame++;
                //Verifying that we are not on the last frame
            }else if( frame != 10){
                //List to house the scores we will be saving
                List<Integer> scores = new ArrayList<>();
                // since we know that the score is not a strike because it was verified in the last (if) we then save the pair to the list
                scores.add(plays.get(i));
                scores.add(plays.get(i+1));
                //We now save the list pair with the corresponding frame
                frames.put(frame,scores);
                //because we have used two values from the original plays list we must increase our count (i)
                // by one before the next loop through as well as increase our frame count
                i++;
                frame++;
                //Finally we check to see if we are on the las frame (frame 10)
            } else if(frame == 10){
                //List to house the scores we will be saving
                List<Integer> scores = new ArrayList<>();
                //We know that at minimum there will be two scores in the last frame, so we add them to the count
                scores.add(plays.get(i));
                scores.add(plays.get(i+1));
                frames.put(frame,scores);
                //Now we check to see if there is a third value for the final frame
                if (plays.size()-i == 3){
                    //If there is we add it to the list
                    scores.add(plays.get(i+2));
                    frames.put(frame,scores);
                }
                //increase our count by two to exit the loop
                i+=2;
            }
        }
        //Save the HashMap to the Class Variable
        setFrames(frames);

    }

    //Calculates the Final score of the game by taking in a list of each roll
    public int calculateScore(List<Integer> listOfPlays){
        //First we must organize the list and set up the frames
        setAllFrames(listOfPlays);
        //Frames get save in a new HashMap
        Map<Integer,List<Integer>> frames = getFrames();
        //We use this variable to keep track of the current frame's score
        int currentFrameScore = 0;
        //This will be used to house the total score
        int totalScore = 0;
        //A for loop to iterate though the HashMap with (i) to keep track of the frame
        for(int i = 1; i<11; i++){
            //We now check that the frame is not frame 10
            if(i !=10){
                //We check to make sure that the frame has two values saved in its list and that it is not a spare
                if(frames.get(i).size() == 2 && frames.get(i).get(0) + frames.get(i).get(1) != 10){
                    //The total for the frame is just the two values added together
                    currentFrameScore = frames.get(i).get(0) + frames.get(i).get(1);
                    //We add the value to the total score
                    totalScore += currentFrameScore;
                    //For redundancy we reset the value of currentFrameScore
                    currentFrameScore = 0;
                    //Now we check for a spare
                } else if(frames.get(i).size() == 2 && frames.get(i).get(0) + frames.get(i).get(1) == 10){
                    //The value of the current frame is the two values plus the next frame's first roll
                    currentFrameScore = frames.get(i).get(0) + frames.get(i).get(1) + frames.get(i+1).get(0);
                    //Add the current frame to the total
                    totalScore += currentFrameScore;
                    //Reset for redundancy
                    currentFrameScore = 0;
                    //Now we check if there is a strike
                } else if(frames.get(i).size() == 1 && frames.get(i).get(0) == 10){
                    //we save the value of the strike
                    currentFrameScore = frames.get(i).get(0);
                    //We check to see if the Next frame is also a strike and there are only one value for that frame
                    if (frames.get(i+1).get(0) == 10 && frames.get(i+1).size() == 1){
                        //If so add the value of the next frame and the value of the subsequent frames first roll
                        currentFrameScore += frames.get(i+1).get(0) + frames.get(i+2).get(0);
                    } else{
                        //if the next frame is not a strike add the values of that frames first and second roll
                        currentFrameScore += frames.get(i+1).get(0) + frames.get(i+1).get(1);
                    }
                    //Add to total
                    totalScore += currentFrameScore;
                    //Reset for redundancy
                    currentFrameScore = 0;
                }
            } else{
                //For the last frame we check for amount of rolls in that frame if only two just add
                if(frames.get(i).size() == 2){
                    totalScore += frames.get(i).get(0) + frames.get(i).get(1);
                }else {
                    //if more than two add all three rolls
                    totalScore += frames.get(i).get(0) + frames.get(i).get(1) + frames.get(i).get(2);
                }
            }
        }
        //return the total and save to class
        setTotalScore(totalScore);
        return totalScore;
    }


    //Getters and setters
    public List<Integer> getListOfPlays() {
        return listOfPlays;
    }

    public void setListOfPlays(List<Integer> listOfPlays) {
        this.listOfPlays = listOfPlays;
    }


    public Map<Integer, List<Integer>> getFrames() {
        return frames;
    }

    public void setFrames(Map<Integer, List<Integer>> frames) {
        this.frames = frames;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
}