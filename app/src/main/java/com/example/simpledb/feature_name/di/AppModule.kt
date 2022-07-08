package com.example.simpledb.feature_name.di

import android.app.Application
import androidx.room.Room
import com.example.simpledb.NameApp
import com.example.simpledb.feature_name.data.data_source.NameDataBase
import com.example.simpledb.feature_name.data.repository.NameRepositoryImpl
import com.example.simpledb.feature_name.domain.repository.NameRepository
import com.example.simpledb.feature_name.domain.use_case.AddName
import com.example.simpledb.feature_name.domain.use_case.GetName
import com.example.simpledb.feature_name.domain.use_case.GetNames
import com.example.simpledb.feature_name.domain.use_case.NameUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNameDataBase(app:Application):NameDataBase{
        return Room.databaseBuilder(
            app,
            NameDataBase::class.java,
            NameDataBase.DATABASE_NAME

        ).build()
    }

    @Provides
    @Singleton
    fun provideNameRepository(db:NameDataBase):NameRepository{
        return NameRepositoryImpl(db.nameDao)

    }
    @Provides
    @Singleton
    fun provideNameUseCases(repository:NameRepository):NameUseCases{
        return NameUseCases(
            getNames = GetNames(repository),
            getName = GetName(repository),
            addName = AddName(repository)
            )
    }
}
