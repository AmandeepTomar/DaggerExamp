package com.aman.daggerexamp.di.component;

import android.content.SharedPreferences;

import com.aman.daggerexamp.MainActivity;
import com.aman.daggerexamp.di.module.AppModule;
import com.aman.daggerexamp.di.module.NetModules;
import com.aman.daggerexamp.di.scopes.UserScopes;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Component;
import retrofit.Retrofit;

/**
 * Created by amandeep on 10/1/18.
 */
@Singleton
@Component(modules = {AppModule.class, NetModules.class})
public interface NetComponent {

  // void inject(MainActivity activity);
   SharedPreferences sharedPreferences();
   OkHttpClient okHttpClient();

   Retrofit retrofit();


}
