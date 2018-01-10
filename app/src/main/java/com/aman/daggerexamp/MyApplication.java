package com.aman.daggerexamp;

import android.app.Application;


import com.aman.daggerexamp.di.component.DaggerGitHubComponent;
import com.aman.daggerexamp.di.component.DaggerNetComponent;
import com.aman.daggerexamp.di.component.GitHubComponent;
import com.aman.daggerexamp.di.component.NetComponent;
import com.aman.daggerexamp.di.module.AppModule;
import com.aman.daggerexamp.di.module.GitHubModule;
import com.aman.daggerexamp.di.module.NetModules;

/**
 * Created by amandeep on 10/1/18.
 */

public class MyApplication extends Application {
    private NetComponent netComponent;
    private GitHubComponent mGitHubComponent;



    @Override
    public void onCreate() {
        super.onCreate();

        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModules(new NetModules("https://api.github.com"))
                .build();

        mGitHubComponent = DaggerGitHubComponent.builder()
                .netComponent(netComponent)
                .gitHubModule(new GitHubModule())
                .build();

    }

    public NetComponent getNetComponent(){
        return netComponent;
    }

    public GitHubComponent getmGitHubComponent(){
        return mGitHubComponent;
    }
}
