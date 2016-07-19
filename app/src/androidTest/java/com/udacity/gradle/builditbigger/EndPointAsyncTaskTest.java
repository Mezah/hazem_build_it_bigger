package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.AndroidTestCase;
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
            assertTrue("Error: THe Result from Backend is empty",result.isEmpty());
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
