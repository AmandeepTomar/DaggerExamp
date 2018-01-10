package com.aman.daggerexamp.di.component;



import android.content.SharedPreferences;

import com.aman.daggerexamp.MainActivity;
import com.aman.daggerexamp.di.module.GitHubModule;
import com.aman.daggerexamp.di.scopes.UserScopes;

import dagger.Component;

@UserScopes
@Component(dependencies = NetComponent.class, modules = GitHubModule.class)
public interface GitHubComponent {
    //void inject(MainActivity activity);

    void inject(MainActivity activity);


}
