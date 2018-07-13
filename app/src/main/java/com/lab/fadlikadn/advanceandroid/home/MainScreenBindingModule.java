package com.lab.fadlikadn.advanceandroid.home;

import com.bluelinelabs.conductor.Controller;
import com.lab.fadlikadn.advanceandroid.di.ControllerKey;
import com.lab.fadlikadn.advanceandroid.trending.TrendingReposComponent;
import com.lab.fadlikadn.advanceandroid.trending.TrendingReposController;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
        TrendingReposComponent.class,
})
public abstract class MainScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindTrendingReposInjector(TrendingReposComponent.Builder builder);

}
