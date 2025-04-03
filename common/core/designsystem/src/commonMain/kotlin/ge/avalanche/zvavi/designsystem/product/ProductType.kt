package ge.avalanche.zvavi.designsystem.product

sealed class ProductType {
    object App : ProductType()
    object Extensions : ProductType()
    object MiniApp : ProductType()
    object Website : ProductType()
} 