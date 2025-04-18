package ge.avalanche.zvavi.bulletin.data.di

import ge.avalanche.zvavi.bulletin.api.BulletinRepository
import ge.avalanche.zvavi.bulletin.data.datasource.BulletinRemoteDataSource
import ge.avalanche.zvavi.bulletin.data.datasource.BulletinRemoteDataSourceImpl
import ge.avalanche.zvavi.bulletin.data.repository.BulletinRepositoryImpl
import ge.avalanche.zvavi.bulletin.data.usecase.GetBulletinUseCase
import org.koin.dsl.module

val bulletinDataModule = module {
    single<BulletinRemoteDataSource> {
        BulletinRemoteDataSourceImpl(
            client = get(), baseUrl = "https://gnfghuusszsxjddfousc.supabase.co/rest/v1/"
        )
    }

    single<BulletinRepository> {
        BulletinRepositoryImpl(
            remoteDataSource = get(),
            localDataSource = get(),
            dispatchers = get()
        )
    }
    single {
        GetBulletinUseCase(
            repository = get(),
            dispatchers = get()
        )
    }
}