package ge.avalanche.zvavi.bulletin.data.di

import ge.avalanche.zvavi.bulletin.api.BulletinRepository
import ge.avalanche.zvavi.bulletin.data.datasource.BulletinRemoteDataSource
import ge.avalanche.zvavi.bulletin.data.datasource.BulletinRemoteDataSourceImpl
import ge.avalanche.zvavi.bulletin.data.repository.BulletinRepositoryImpl
import ge.avalanche.zvavi.bulletin.data.usecase.GetBulletinUseCase
import ge.avalanche.zvavi.foundation.dispatchers.DispatchersProvider
import ge.avalanche.zvavi.network.config.NetworkConfig
import io.ktor.client.HttpClient
import org.koin.dsl.module

val bulletinDataModule = module {

    single<BulletinRemoteDataSource> {
        BulletinRemoteDataSourceImpl(
            httpClient = get<HttpClient>(),
            baseUrl = get<NetworkConfig>().baseUrl
        )
    }

    single<BulletinRepository> {
        BulletinRepositoryImpl(
            remoteDataSource = get(),
            dispatchers = get<DispatchersProvider>()
        )
    }

    single<GetBulletinUseCase> {
        GetBulletinUseCase(
            repository = get()
        )
    }
}