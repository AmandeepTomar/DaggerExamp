package com.aman.daggerexamp.di.module;



import com.aman.daggerexamp.di.scopes.UserScopes;
import com.aman.daggerexamp.network.interfaces.GitHubApiInterface;

import dagger.Module;
import dagger.Provides;
import retrofit.Retrofit;

@Module
public class GitHubModule {

    @Provides
    @UserScopes
    public GitHubApiInterface providesGitHubInterface(Retrofit retrofit) {
        return retrofit.create(GitHubApiInterface.class);
    }
}
