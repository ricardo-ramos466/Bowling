import java.util.*;

public class Score {
    private List<Integer> listOfPlays;
    private Map<Integer,List<Integer>> frames;



    public void SetAllFrames(List<Integer> plays){
        int frame = 1;
        Map<Integer,List<Integer>> frames = new HashMap<>();
        for( int i = 0; i< plays.size(); i++){
            if(plays.get(i)==10 && (i != plays.size()-3) || i != plays.size()-2) {
                frames.put(frame, Collections.singletonList(plays.get(i)));
                frame++;
            }else if( i != plays.size()-3 || i != plays.size()-2){
                List<Integer> scores = new ArrayList<>();
                scores.add(plays.get(i));
                scores.add(plays.get(i+1));
                frames.put(frame,scores);
                i++;
            }
        }

    }

    public int calculateScore(){
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
