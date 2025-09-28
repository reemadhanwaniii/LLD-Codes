package subscriber;

import models.Match;
import producers.Producer;

import java.util.ArrayList;
import java.util.List;

public class CommentarySubscriber implements Subscriber{

   private List<String> commentaries;

   public CommentarySubscriber() {
       this.commentaries = new ArrayList<String>();
   }


    @Override
    public void update(Producer producer) {
        this.commentaries.add(producer.getMatchData().getCommentary().get(producer.getMatchData().getCommentary().size()-1));
    }
}
