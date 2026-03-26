package fr.mastersid.stackoverflow.Repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

// pour injecter le DummyImpl quand le repository est demandé,
// on l'intsalle dans un conteneur lié au cycle de vie des ViewModels: ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class SlackOverflowRepositoryModule {
    @Binds
    abstract fun bindSlackOverflowRepository(
        slackOverflowRepositoryImpl: SlackOverflowRepositoryImpl
    ): SlackOverflowRepository
}