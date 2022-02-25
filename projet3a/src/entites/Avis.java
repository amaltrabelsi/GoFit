/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author HP 840 G3
 */
public class Avis {

   
    private int Avis_Id;
    private int Likes;
    private int Dislike;

    public Avis() {
    }
   
     public Avis(int Avis_Id, int Likes, int Dislike) {
        this.Avis_Id = Avis_Id;
        this.Likes = Likes;
        this.Dislike = Dislike;
    }

    public Avis(int Likes, int Dislike) {
        this.Likes = Likes;
        this.Dislike = Dislike;
    }

    public int getAvis_Id() {
        return Avis_Id;
    }

    public void setAvis_Id(int Avis_Id) {
        this.Avis_Id = Avis_Id;
    }

    public int getLikes() {
        return Likes;
    }

    public void setLikes(int Likes) {
        this.Likes = Likes;
    }

    public int getDislike() {
        return Dislike;
    }

    public void setDislike(int Dislike) {
        this.Dislike = Dislike;
    }

    @Override
    public String toString() {
        return "Avis{" + "Avis_Id=" + Avis_Id + ", Likes=" + Likes + ", Dislike=" + Dislike + '}';
    }
     
    
}
