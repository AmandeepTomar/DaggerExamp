package com.aman.daggerexamp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.aman.daggerexamp.models.Repository;
import com.aman.daggerexamp.network.interfaces.GitHubApiInterface;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {
    @Inject
    Retrofit retrofit;
    @Inject
    GitHubApiInterface mGitHubApiInterface;
    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MyApplication)getApplication()).getmGitHubComponent().inject(this);
        sharedPreferences=((MyApplication)getApplication()).getNetComponent().sharedPreferences();

        if (sharedPreferences!=null){
          String userName=  sharedPreferences.getString("name",null);
          if (userName!=null){
              Log.e("sharedpref",userName);
          }

        }


        mGitHubApiInterface.getRepository("amandeeptomar").enqueue(new Callback<ArrayList<Repository>>() {
            @Override
            public void onResponse(Response<ArrayList<Repository>> response, Retrofit retrofit) {
                Log.e("test response",response.body().get(0).getName()+" received");
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("name",response.body().get(0).getName());
                editor.apply();
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("Onfdailure",t.getMessage()+" ");

            }
        });
    }
}
