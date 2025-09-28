package subscriber;

import models.Match;
import producers.Producer;

import java.util.ArrayList;
import java.util.List;

public class CommentarySubscriber implements Subscriber{

   private List<String> commentaries;
   private List<Producer> producers;

   public CommentarySubscriber(List<Producer> producers) {
       this.commentaries = new ArrayList<String>();
       this.producers = producers;
       for(Producer p:producers) {
           p.subscribe(this);
       }
   }


    @Override
    public void update(Producer producer) {
        this.commentaries.add(producer.getMatchData().getCommentary().get(producer.getMatchData().getCommentary().size()-1));
    }
}
