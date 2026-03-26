package fr.mastersid.examflora.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import fr.mastersid.examflora.repository.ResultRepository
import fr.mastersid.examflora.repository.ResultRepositoryImpl
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ResultRepositoryModule {
    @Binds
    abstract fun bindResultRepository(
        resultRepositoryImpl: ResultRepositoryImpl
    ): ResultRepository
}