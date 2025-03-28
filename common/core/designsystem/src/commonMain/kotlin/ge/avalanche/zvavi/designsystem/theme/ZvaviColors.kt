package ge.avalanche.zvavi.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import ge.avalanche.zvavi.designsystem.effect.LocalShadowColorProvider
import ge.avalanche.zvavi.designsystem.effect.ZvaviShadowColor
import ge.avalanche.zvavi.designsystem.opacity.ZvaviOpacity
import androidx.compose.ui.graphics.Color as ZvaviColor

object ZvaviTheme {
    val colors: ZvaviColors
        @Composable
        get() = LocalColorProvider.current
    val shadowColor: ZvaviShadowColor
        @Composable get() = LocalShadowColorProvider.current
}

val LocalColorProvider =
    staticCompositionLocalOf<ZvaviColors> { error("No default implementation") }

@Immutable
class ZvaviColors(
// Content
    val contentNeutralPrimary: ZvaviColor,
    val contentBrandPrimary: ZvaviColor,
    val contentPositivePrimary: ZvaviColor,
    val contentWarningPrimary: ZvaviColor,
    val contentNegativePrimary: ZvaviColor,
    val contentInfoPrimary: ZvaviColor,
    val contentNeutralSecondary: ZvaviColor,
    val contentBrandSecondary: ZvaviColor,
    val contentPositiveSecondary: ZvaviColor,
    val contentWarningSecondary: ZvaviColor,
    val contentNegativeSecondary: ZvaviColor,
    val contentInfoSecondary: ZvaviColor,
    val contentNeutralTertiary: ZvaviColor,
    val contentBrandTertiary: ZvaviColor,
    val contentPositiveTertiary: ZvaviColor,
    val contentWarningTertiary: ZvaviColor,
    val contentNegativeTertiary: ZvaviColor,
    val contentInfoTertiary: ZvaviColor,
    val contentNeutralPrimaryInverted: ZvaviColor,
    val contentStaticLightPrimary: ZvaviColor,
    val contentStaticLightSecondary: ZvaviColor,
    val contentStaticDarkPrimary: ZvaviColor,
    val contentStaticDarkSecondary: ZvaviColor,

// Background
    val backgroundNeutralHigh: ZvaviColor,
    val backgroundBrandHigh: ZvaviColor,
    val backgroundPositiveHigh: ZvaviColor,
    val backgroundWarningHigh: ZvaviColor,
    val backgroundNegativeHigh: ZvaviColor,
    val backgroundInfoHigh: ZvaviColor,
    val backgroundNeutralLow: ZvaviColor,
    val backgroundBrandLow: ZvaviColor,
    val backgroundPositiveLow: ZvaviColor,
    val backgroundWarningLow: ZvaviColor,
    val backgroundNegativeLow: ZvaviColor,
    val backgroundInfoLow: ZvaviColor,
    val backgroundNeutralHighInverted: ZvaviColor,
    val backgroundStaticLightHigh: ZvaviColor,
    val backgroundStaticDarkHigh: ZvaviColor,

// Overlay
    val overlayNeutral: ZvaviColor,
    val overlayBrand: ZvaviColor,
    val overlayPositive: ZvaviColor,
    val overlayWarning: ZvaviColor,
    val overlayNegative: ZvaviColor,
    val overlayInfo: ZvaviColor,
    val overlayStaticLight: ZvaviColor,
    val overlayStaticDark: ZvaviColor,

// Border
    val borderNeutralPrimary: ZvaviColor,
    val borderBrandPrimary: ZvaviColor,
    val borderPositivePrimary: ZvaviColor,
    val borderWarningPrimary: ZvaviColor,
    val borderNegativePrimary: ZvaviColor,
    val borderInfoPrimary: ZvaviColor,
    val borderNeutralSecondary: ZvaviColor,
    val borderNeutralTertiary: ZvaviColor,

// Layer
    val layerFloor0: ZvaviColor,
    val layerFloor1: ZvaviColor,
    val layerFloorScrim: ZvaviColor,
    val layerFloorOverlay: ZvaviColor,
)

val DarkColors = ZvaviColors(
    contentNeutralPrimary = DarkPalette.goose0,
    contentBrandPrimary = DarkPalette.brand200,

//    contentAttentionPrimary = darkPalette.attention200
    contentPositivePrimary = DarkPalette.absinthe200,
    contentWarningPrimary = DarkPalette.prosecco200,
    contentNegativePrimary = DarkPalette.negroni200,
    contentInfoPrimary = DarkPalette.curacao200,
    contentNeutralSecondary = DarkPalette.goose400,
    contentBrandSecondary = DarkPalette.brand400,

//    contentAttentionSecondary = darkPalette.attention400
    contentPositiveSecondary = DarkPalette.absinthe400,
    contentWarningSecondary = DarkPalette.prosecco400,
    contentNegativeSecondary = DarkPalette.negroni400,
    contentInfoSecondary = DarkPalette.curacao400,
    contentNeutralTertiary = DarkPalette.goose500,
    contentBrandTertiary = DarkPalette.brand500,

//    contentAttentionTertiary = darkPalette.attention500
    contentPositiveTertiary = DarkPalette.absinthe500,
    contentWarningTertiary = DarkPalette.prosecco500,
    contentNegativeTertiary = DarkPalette.negroni500,
    contentInfoTertiary = DarkPalette.curacao400,
    contentNeutralPrimaryInverted = DarkPalette.goose900,
    contentStaticLightPrimary = DarkPalette.goose0,
    contentStaticLightSecondary = DarkPalette.goose0.copy(alpha = ZvaviOpacity.opacityContentSecondaryLight),
    contentStaticDarkPrimary = DarkPalette.goose999,
    contentStaticDarkSecondary = DarkPalette.goose999.copy(alpha = ZvaviOpacity.opacityContentSecondaryLight),

// Background
    backgroundNeutralHigh = DarkPalette.goose500,
    backgroundBrandHigh = DarkPalette.brand500,

//    backgroundAttentionHigh = darkPalette.attention500
    backgroundPositiveHigh = DarkPalette.absinthe500,
    backgroundWarningHigh = DarkPalette.prosecco500,
    backgroundNegativeHigh = DarkPalette.negroni500,
    backgroundInfoHigh = DarkPalette.curacao500,
    backgroundNeutralLow = DarkPalette.goose900,
    backgroundBrandLow = DarkPalette.brand900,

//    backgroundAttentionLow = darkPalette.attention900
    backgroundPositiveLow = DarkPalette.absinthe900,
    backgroundWarningLow = DarkPalette.prosecco900,
    backgroundNegativeLow = DarkPalette.negroni900,
    backgroundInfoLow = DarkPalette.curacao900,
    backgroundNeutralHighInverted = DarkPalette.goose0,
    backgroundStaticLightHigh = DarkPalette.goose0,
    backgroundStaticDarkHigh = DarkPalette.goose999,

// Overlay
    overlayNeutral = DarkPalette.goose500.copy(alpha = ZvaviOpacity.opacityOverlayPrimaryDark),
    overlayBrand = DarkPalette.brand500.copy(alpha = ZvaviOpacity.opacityOverlayPrimaryDark),

//    overlayAttention = darkPalette.attention500.copy(alpha = ZvaviOpacity.opacityOverlayPrimaryDark)
    overlayPositive = DarkPalette.absinthe500.copy(alpha = ZvaviOpacity.opacityOverlayPrimaryDark),
    overlayWarning = DarkPalette.prosecco500.copy(alpha = ZvaviOpacity.opacityOverlayPrimaryDark),
    overlayNegative = DarkPalette.negroni500.copy(alpha = ZvaviOpacity.opacityOverlayPrimaryDark),
    overlayInfo = DarkPalette.curacao500.copy(alpha = ZvaviOpacity.opacityOverlayPrimaryDark),
    overlayStaticLight = DarkPalette.goose0.copy(alpha = ZvaviOpacity.opacityOverlayPrimaryStatic),
    overlayStaticDark = DarkPalette.goose999.copy(alpha = ZvaviOpacity.opacityOverlayPrimaryStatic),

// Border
    borderNeutralPrimary = DarkPalette.goose0,
    borderBrandPrimary = DarkPalette.brand500,

//    borderAttentionPrimary = darkPalette.attention500
    borderPositivePrimary = DarkPalette.absinthe500,
    borderWarningPrimary = DarkPalette.prosecco500,
    borderNegativePrimary = DarkPalette.negroni500,
    borderInfoPrimary = DarkPalette.curacao500,
    borderNeutralSecondary = DarkPalette.goose0.copy(alpha = ZvaviOpacity.opacityBorderSecondaryDark),
    borderNeutralTertiary = DarkPalette.goose0.copy(alpha = ZvaviOpacity.opacityBorderTertiaryDark),

// Layer
    layerFloor0 = DarkPalette.goose999,
    layerFloor1 = DarkPalette.goose900,
    layerFloorScrim = DarkPalette.goose999.copy(alpha = ZvaviOpacity.opacityLayerFloorScrimDark),
    layerFloorOverlay = DarkPalette.goose900.copy(alpha = ZvaviOpacity.opacityLayerFloorOverlayDark),
)


val LightColors = ZvaviColors(
    // Content
    contentNeutralPrimary = LightPalette.goose900,
    contentBrandPrimary = LightPalette.brand800,
//        contentAttentionPrimary = LightPalette.attention800
    contentPositivePrimary = LightPalette.absinthe800,
    contentWarningPrimary = LightPalette.prosecco800,
    contentNegativePrimary = LightPalette.negroni800,
    contentInfoPrimary = LightPalette.curacao800,
    contentNeutralSecondary = LightPalette.goose600,
    contentBrandSecondary = LightPalette.brand600,
//        contentAttentionSecondary = LightPalette.attention600
    contentPositiveSecondary = LightPalette.absinthe600,
    contentWarningSecondary = LightPalette.prosecco600,
    contentNegativeSecondary = LightPalette.negroni600,
    contentInfoSecondary = LightPalette.curacao600,
    contentNeutralTertiary = LightPalette.goose400,
    contentBrandTertiary = LightPalette.brand400,
//        contentAttentionTertiary = LightPalette.attention400
    contentPositiveTertiary = LightPalette.absinthe400,
    contentWarningTertiary = LightPalette.prosecco400,
    contentNegativeTertiary = LightPalette.negroni400,
    contentInfoTertiary = LightPalette.curacao400,
    contentNeutralPrimaryInverted = LightPalette.goose0,
    contentStaticLightPrimary = LightPalette.goose0,
    contentStaticLightSecondary = LightPalette.goose0.copy(alpha = ZvaviOpacity.opacityContentSecondaryLight),
    contentStaticDarkPrimary = LightPalette.goose999,
    contentStaticDarkSecondary = LightPalette.goose999.copy(alpha = ZvaviOpacity.opacityContentSecondaryLight),

// Background
    backgroundNeutralHigh = LightPalette.goose900,
    backgroundBrandHigh = LightPalette.brand500,
//        backgroundAttentionHigh = LightPalette.attention500
    backgroundPositiveHigh = LightPalette.absinthe500,
    backgroundWarningHigh = LightPalette.prosecco500,
    backgroundNegativeHigh = LightPalette.negroni500,
    backgroundInfoHigh = LightPalette.curacao500,
    backgroundNeutralLow = LightPalette.goose100,
    backgroundBrandLow = LightPalette.brand100,
//        backgroundAttentionLow = LightPalette.attention100
    backgroundPositiveLow = LightPalette.absinthe100,
    backgroundWarningLow = LightPalette.prosecco100,
    backgroundNegativeLow = LightPalette.negroni100,
    backgroundInfoLow = LightPalette.curacao100,
    backgroundNeutralHighInverted = LightPalette.goose900,
    backgroundStaticLightHigh = LightPalette.goose0,
    backgroundStaticDarkHigh = LightPalette.goose999,

// Overlay
    overlayNeutral = LightPalette.goose500.copy(alpha = ZvaviOpacity.opacityOverlayPrimaryLight),
    overlayBrand = LightPalette.brand500.copy(alpha = ZvaviOpacity.opacityOverlayPrimaryLight),
//        overlayAttention = LightPalette.attention500.copy(alpha = ZvaviOpacity.opacityOverlayPrimaryLight)
    overlayPositive = LightPalette.absinthe500.copy(alpha = ZvaviOpacity.opacityOverlayPrimaryLight),
    overlayWarning = LightPalette.prosecco500.copy(alpha = ZvaviOpacity.opacityOverlayPrimaryLight),
    overlayNegative = LightPalette.negroni500.copy(alpha = ZvaviOpacity.opacityOverlayPrimaryLight),
    overlayInfo = LightPalette.curacao500.copy(alpha = ZvaviOpacity.opacityOverlayPrimaryLight),
    overlayStaticLight = LightPalette.goose0.copy(alpha = ZvaviOpacity.opacityOverlayPrimaryStatic),
    overlayStaticDark = LightPalette.goose999.copy(alpha = ZvaviOpacity.opacityOverlayPrimaryStatic),

// Border
    borderNeutralPrimary = LightPalette.goose999,
    borderBrandPrimary = LightPalette.brand600,
//        borderAttentionPrimary = LightPalette.attention600
    borderPositivePrimary = LightPalette.absinthe600,
    borderWarningPrimary = LightPalette.prosecco600,
    borderNegativePrimary = LightPalette.negroni600,
    borderInfoPrimary = LightPalette.curacao600,
    borderNeutralSecondary = LightPalette.goose999.copy(alpha = ZvaviOpacity.opacityBorderSecondaryLight),
    borderNeutralTertiary = LightPalette.goose999.copy(alpha = ZvaviOpacity.opacityBorderTertiaryLight),

// Layer
    layerFloor0 = LightPalette.goose0,
    layerFloor1 = LightPalette.goose0,
    layerFloorScrim = LightPalette.goose999.copy(alpha = ZvaviOpacity.opacityLayerFloorScrimLight),
    layerFloorOverlay = LightPalette.goose0.copy(alpha = ZvaviOpacity.opacityLayerFloorOverlayLight),
)