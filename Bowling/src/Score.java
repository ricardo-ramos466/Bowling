import java.util.*;

public class Score {
    private List<Integer> listOfPlays;
    private Map<Integer,List<Integer>> frames;



    public void setAllFrames(List<Integer> plays){
        int frame = 1;
        Map<Integer,List<Integer>> frames = new HashMap<>();
        for( int i = 0; i< plays.size(); i++){
            if(plays.get(i)==10 && frame !=10) {
                frames.put(frame, Collections.singletonList(plays.get(i)));
                frame++;
            }else if( frame != 10){
                List<Integer> scores = new ArrayList<>();
                scores.add(plays.get(i));
                scores.add(plays.get(i+1));
                frames.put(frame,scores);
                i++;
                frame++;
            } else if(frame == 10){
                List<Integer> scores = new ArrayList<>();
                scores.add(i);
                scores.add(i+1);
                if (plays.size()-i == 3){
                    scores.add(i+2);
                }
                i+=2;
            }
        }
        setFrames(frames);

    }

    public int calculateScore(List<Integer> listOfPlays){
        setAllFrames(listOfPlays);
        Map<Integer,List<Integer>> frames = getFrames();
        int currentFrameScore = 0;
        int totalScore = 0;
        for(int i = 1; i<=10; i++){
            if(i !=10){
                if(frames.get(i).size() == 2 && frames.get(i).get(0) + frames.get(i).get(1) != 10){
                    totalScore += frames.get(i).get(0) + frames.get(i).get(1);
                } else if(frames.get(i).size() == 2 && frames.get(i).get(0) + frames.get(i).get(1) == 10){
                    currentFrameScore = frames.get(i).get(0) + frames.get(i).get(1) + frames.get(i+1).get(0);
                    totalScore += currentFrameScore;
                } else if(frames.get(i).size() == 1){
                    
                }
            }

        }

        return 0;
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
}