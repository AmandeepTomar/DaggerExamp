package com.aman.daggerexamp.di.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by amandeep on 10/1/18.
 */
@Module
public class AppModule {
    Application mApplication;

    public AppModule(Application application) {
       mApplication = application;
    }

    @Provides
    @Singleton
    Application provideApplication(){return mApplication;}
}
