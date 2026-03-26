package fr.mastersid.examflora.webservice

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://data.education.gouv.fr/api/explore/v2.1/catalog/datasets/fr-en-evaluations_nationales_cp_academie/"

@Module
@InstallIn(SingletonComponent::class)
object ResultWebserviceModule {
    @Provides
    fun provideMoshi() : Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .add(ResultMoshiAdapter())
            .build()
    }

    @Provides
    fun provideRetrofit(moshi : Moshi) : Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(fr.mastersid.examflora.webservice.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    fun provideResultsWebService(retrofit: Retrofit) : ResultWebservice {
        return retrofit.create(ResultWebservice::class.java)
    }
}