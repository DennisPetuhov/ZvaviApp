package ge.avalanche.zvavi.bulletin.data.di

import ge.avalanche.zvavi.bulletin.api.models.BulletinRepository
import ge.avalanche.zvavi.bulletin.data.datasource.BulletinLocalDataSource
import ge.avalanche.zvavi.bulletin.data.datasource.BulletinLocalDataSourceImpl
import ge.avalanche.zvavi.bulletin.data.datasource.BulletinRemoteDataSource
import ge.avalanche.zvavi.bulletin.data.datasource.BulletinRemoteDataSourceImpl
import ge.avalanche.zvavi.bulletin.data.repository.BulletinRepositoryImpl
import ge.avalanche.zvavi.bulletin.data.domain.usecase.FetchBulletinUseCase
import ge.avalanche.zvavi.bulletin.data.domain.usecase.ObserveBulletinUseCase
import ge.avalanche.zvavi.foundation.dispatchers.DispatchersProvider
import ge.avalanche.zvavi.network.client.ApiClient
import ge.avalanche.zvavi.database.dao.BulletinDao
import org.koin.dsl.module

val bulletinDataModule = module {

    single<BulletinRemoteDataSource> {
        BulletinRemoteDataSourceImpl(
            apiClient = get<ApiClient>()
        )
    }
    single<BulletinLocalDataSource> {
        BulletinLocalDataSourceImpl(bulletinDao = get<BulletinDao>()
        )
    }
    single<BulletinRepository> {
        BulletinRepositoryImpl(
            remoteDataSource = get(),
            localDataSource = get(),
            dispatchers = get<DispatchersProvider>(),
            dao = get<BulletinDao>()
        )
    }
    single<FetchBulletinUseCase> {
        FetchBulletinUseCase(
            repository = get(),
            dispatchers = get<DispatchersProvider>()
        )
    }
    single<ObserveBulletinUseCase> {
        ObserveBulletinUseCase(
            repository = get(),
            dispatchers = get<DispatchersProvider>()
        )
    }
}