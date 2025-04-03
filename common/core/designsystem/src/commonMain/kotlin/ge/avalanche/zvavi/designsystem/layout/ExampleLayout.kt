package ge.avalanche.zvavi.designsystem.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.designsystem.product.ExampleLayout
import ge.avalanche.zvavi.designsystem.product.ProductType

/**
 * Example of how to use ProvideLayoutConfig with a ProductType
 * to create a responsive layout with a column and a button in the center.
 */
@Composable
fun ExampleLayout(
    productType: ProductType = ProductType.App,
    content: @Composable () -> Unit
) {
    // Wrap the content with ProvideLayoutConfig to get responsive layout values
    ProvideLayoutConfig(productType = productType) {
        // Use Box to center the content
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            // Use Column to arrange items vertically
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Example Content")


                Button(
                    onClick = { /* Handle click */ }
                ) {
                    Text("Click Me")
                }

                content()
            }
        }
    }
}

/**
 * Example of how to use the layout in a screen.
 */
@Composable
fun ExampleScreen() {
    // Use the ExampleLayout with ProductType.App
    ExampleLayout(productType = ProductType.App) {
        // Additional content can be passed here
        Text("Additional Content")
    }
}

/**
 * Example of how to use the layout with a different product type.
 */
@Composable
fun ExampleMiniAppScreen() {
    // Use the ExampleLayout with ProductType.MiniApp
    ExampleLayout(productType = ProductType.MiniApp) {
        // Additional content can be passed here
        Text("Mini App Content")
    }
}

/**
 * Example of how to use the layout with responsive spacing.
 */
@Composable
fun ExampleResponsiveScreen() {
    // Get the current layout configuration
    val layoutConfig = LocalLayoutConfig.current

    // Use the ExampleLayout with ProductType.App
    ExampleLayout(productType = ProductType.App) {
        // Use the layout configuration for responsive spacing
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = layoutConfig.marginHorizontal),
            verticalArrangement = Arrangement.spacedBy(layoutConfig.gutter)
        ) {
            Text("Responsive Content")
            Button(onClick = { /* Handle click */ }) {
                Text("Responsive Button")
            }
        }
    }
} 