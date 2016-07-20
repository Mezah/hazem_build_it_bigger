package com.udacity.gradle.builditbigger;

/**
 * Created by Mezah on 7/19/2016.
 */
public class TestUtil {

    public static boolean checkJokeNumber(String joke,int index){

        String[] sa=joke.split(" ");

        int jokeNumber=Integer.valueOf(sa[sa.length-1]);

        return index==(jokeNumber-1);
    }

    public static boolean testIfConnectionFail(String result){

        String[] ar=result.split(" ");

        return ar[0].equals("failed");
    }
}
