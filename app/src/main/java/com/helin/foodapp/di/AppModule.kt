package com.helin.foodapp.di

import com.helin.foodapp.model.dataSource.FoodDataSource
import com.helin.foodapp.model.dataSource.SepetFoodDataSource
import com.helin.foodapp.model.repository.FoodRepo
import com.helin.foodapp.model.repository.SepetFoodRepo
import com.helin.foodapp.retrofit.ApiUtils
import com.helin.foodapp.retrofit.FoodDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesFoodDataSource(fDao : FoodDao) : FoodDataSource {
        return FoodDataSource(fDao)
    }

    @Provides
    @Singleton
    fun providesFoodRepo(fDS : FoodDataSource) : FoodRepo {
        return FoodRepo(fDS)
    }

    @Provides
    @Singleton
    fun providesSepetFoodRepo(sfdt : SepetFoodDataSource) : SepetFoodRepo {
        return SepetFoodRepo(sfdt)
    }

    @Provides
    @Singleton
    fun providesSepetFoodDataSource(fdao : FoodDao) : SepetFoodDataSource {
        return SepetFoodDataSource(fdao)
    }

    @Provides
    @Singleton
    fun providesFoodDao() : FoodDao {
        return ApiUtils.getFoodDao()
    }
}