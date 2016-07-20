package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.AndroidTestCase;
import android.util.Log;
import android.util.Pair;

import java.util.Random;

/**
 * Created by Mezah on 7/18/2016.
 */

public class EndPointAsyncTaskTest extends AndroidTestCase {

    private Context mContext;
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mContext=getContext();
    }

    public void testJokes(){

        Random random=new Random();
        int index=random.nextInt(15);
        try {
            EndpointsAsyncTask async=new EndpointsAsyncTask(null);

            String result = async.execute(new Pair<Context, String>(mContext, index + "")).get();

            assertFalse("Error: The Result from Backend is empty",result.isEmpty());
            assertFalse("Error: The Connection to the appengine Failed",TestUtil.testIfConnectionFail(result));
            Log.d("Joke",result);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public void testJokeNumber(){

        // must no exceed 15 (number of jokes array)
        int index=10;


        try {
            EndpointsAsyncTask async=new EndpointsAsyncTask(null);

            String result = async.execute(new Pair<Context, String>(mContext, index + "")).get();

            assertTrue("Error: Wrong Joke returned",TestUtil.checkJokeNumber(result,index));

            Log.d("Joke",result);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
