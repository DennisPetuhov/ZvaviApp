package ge.avalanche.zvavi.designsystem.typography

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font
import zvaviapp.common.core.designsystem.generated.resources.Res
import zvaviapp.common.core.designsystem.generated.resources.noto_sans_regular

val LocalTypographyProvider =
    staticCompositionLocalOf<ZvaviTypography> { error("No default implementation for typography") }

val LETTER_SPACING = 0.sp

@Composable
fun CreateZvaviTypography() = ZvaviTypography(
    display350Default = TextStyle(
        fontFamily = FontFamily(ZvaviFont.brand),
        fontWeight = ZvaviFontWeight.brandDefault,
        fontSize = ZvaviFontSize.fontSize350,
        lineHeight = ZvaviLineHeight.compact350,
        letterSpacing = LETTER_SPACING,
    ),
    display350Numeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.brand),
        fontWeight = ZvaviFontWeight.brandDefault,
        fontSize = ZvaviFontSize.fontSize350,
        lineHeight = ZvaviLineHeight.compact350,
        letterSpacing = LETTER_SPACING
    ),
    display350Accent = TextStyle(
        fontFamily = FontFamily(ZvaviFont.brand),
        fontWeight = ZvaviFontWeight.brandAccent,
        fontSize = ZvaviFontSize.fontSize350,
        lineHeight = ZvaviLineHeight.compact350,
        letterSpacing = LETTER_SPACING
    ),
    display350AccentNumeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.brand),
        fontWeight = ZvaviFontWeight.brandAccent,
        fontSize = ZvaviFontSize.fontSize350,
        lineHeight = ZvaviLineHeight.compact350,
        letterSpacing = LETTER_SPACING
    ),
    display400Default = TextStyle(
        fontFamily = FontFamily(ZvaviFont.brand),
        fontWeight = ZvaviFontWeight.brandDefault,
        fontSize = ZvaviFontSize.fontSize400,
        lineHeight = ZvaviLineHeight.compact400,
        letterSpacing = LETTER_SPACING
    ),
    display400Numeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.brand),
        fontWeight = ZvaviFontWeight.brandDefault,
        fontSize = ZvaviFontSize.fontSize400,
        lineHeight = ZvaviLineHeight.compact400,
        letterSpacing = LETTER_SPACING
    ),
    display400Accent = TextStyle(
        fontFamily = FontFamily(ZvaviFont.brand),
        fontWeight = ZvaviFontWeight.brandAccent,
        fontSize = ZvaviFontSize.fontSize400,
        lineHeight = ZvaviLineHeight.compact400,
        letterSpacing = LETTER_SPACING
    ),
    display400AccentNumeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.brand),
        fontWeight = ZvaviFontWeight.brandAccent,
        fontSize = ZvaviFontSize.fontSize400,
        lineHeight = ZvaviLineHeight.compact400,
        letterSpacing = LETTER_SPACING
    ),
    display450Default = TextStyle(
        fontFamily = FontFamily(ZvaviFont.brand),
        fontWeight = ZvaviFontWeight.brandDefault,
        fontSize = ZvaviFontSize.fontSize450,
        lineHeight = ZvaviLineHeight.compact450,
        letterSpacing = LETTER_SPACING
    ),
    display450Numeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.brand),
        fontWeight = ZvaviFontWeight.brandDefault,
        fontSize = ZvaviFontSize.fontSize450,
        lineHeight = ZvaviLineHeight.compact450,
        letterSpacing = LETTER_SPACING
    ),
    display450Accent = TextStyle(
        fontFamily = FontFamily(ZvaviFont.brand),
        fontWeight = ZvaviFontWeight.brandAccent,
        fontSize = ZvaviFontSize.fontSize450,
        lineHeight = ZvaviLineHeight.compact450,
        letterSpacing = LETTER_SPACING
    ),
    display450AccentNumeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.brand),
        fontWeight = ZvaviFontWeight.brandAccent,
        fontSize = ZvaviFontSize.fontSize450,
        lineHeight = ZvaviLineHeight.compact450,
        letterSpacing = LETTER_SPACING
    ),
    display500Default = TextStyle(
        fontFamily = FontFamily(ZvaviFont.brand),
        fontWeight = ZvaviFontWeight.brandDefault,
        fontSize = ZvaviFontSize.fontSize500,
        lineHeight = ZvaviLineHeight.compact500,
        letterSpacing = LETTER_SPACING
    ),
    display500Numeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.brand),
        fontWeight = ZvaviFontWeight.brandDefault,
        fontSize = ZvaviFontSize.fontSize500,
        lineHeight = ZvaviLineHeight.compact500,
        letterSpacing = LETTER_SPACING
    ),
    display500Accent = TextStyle(
        fontFamily = FontFamily(ZvaviFont.brand),
        fontWeight = ZvaviFontWeight.brandAccent,
        fontSize = ZvaviFontSize.fontSize500,
        lineHeight = ZvaviLineHeight.compact500,
        letterSpacing = LETTER_SPACING
    ),
    display500AccentNumeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.brand),
        fontWeight = ZvaviFontWeight.brandAccent,
        fontSize = ZvaviFontSize.fontSize500,
        lineHeight = ZvaviLineHeight.compact500,
        letterSpacing = LETTER_SPACING
    ),
    display600Default = TextStyle(
        fontFamily = FontFamily(ZvaviFont.brand),
        fontWeight = ZvaviFontWeight.brandDefault,
        fontSize = ZvaviFontSize.fontSize600,
        lineHeight = ZvaviLineHeight.compact600,
        letterSpacing = LETTER_SPACING
    ),
    display600Numeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.brand),
        fontWeight = ZvaviFontWeight.brandDefault,
        fontSize = ZvaviFontSize.fontSize600,
        lineHeight = ZvaviLineHeight.compact600,
        letterSpacing = LETTER_SPACING
    ),
    display600Accent = TextStyle(
        fontFamily = FontFamily(ZvaviFont.brand),
        fontWeight = ZvaviFontWeight.brandAccent,
        fontSize = ZvaviFontSize.fontSize600,
        lineHeight = ZvaviLineHeight.compact600,
        letterSpacing = LETTER_SPACING
    ),
    display600AccentNumeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.brand),
        fontWeight = ZvaviFontWeight.brandAccent,
        fontSize = ZvaviFontSize.fontSize600,
        lineHeight = ZvaviLineHeight.compact600,
        letterSpacing = LETTER_SPACING
    ),
    display650Default = TextStyle(
        fontFamily = FontFamily(ZvaviFont.brand),
        fontWeight = ZvaviFontWeight.brandDefault,
        fontSize = ZvaviFontSize.fontSize650,
        lineHeight = ZvaviLineHeight.compact650,
        letterSpacing = LETTER_SPACING
    ),
    display650Numeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.brand),
        fontWeight = ZvaviFontWeight.brandDefault,
        fontSize = ZvaviFontSize.fontSize650,
        lineHeight = ZvaviLineHeight.compact650,
        letterSpacing = LETTER_SPACING
    ),
    display650Accent = TextStyle(
        fontFamily = FontFamily(ZvaviFont.brand),
        fontWeight = ZvaviFontWeight.brandAccent,
        fontSize = ZvaviFontSize.fontSize650,
        lineHeight = ZvaviLineHeight.compact650,
        letterSpacing = LETTER_SPACING
    ),
    display650AccentNumeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.brand),
        fontWeight = ZvaviFontWeight.brandAccent,
        fontSize = ZvaviFontSize.fontSize650,
        lineHeight = ZvaviLineHeight.compact650,
        letterSpacing = LETTER_SPACING
    ),
    display700Default = TextStyle(
        fontFamily = FontFamily(ZvaviFont.brand),
        fontWeight = ZvaviFontWeight.brandDefault,
        fontSize = ZvaviFontSize.fontSize700,
        lineHeight = ZvaviLineHeight.compact700,
        letterSpacing = LETTER_SPACING
    ),
    display700Numeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.brand),
        fontWeight = ZvaviFontWeight.brandDefault,
        fontSize = ZvaviFontSize.fontSize700,
        lineHeight = ZvaviLineHeight.compact700,
        letterSpacing = LETTER_SPACING
    ),
    display700Accent = TextStyle(
        fontFamily = FontFamily(ZvaviFont.brand),
        fontWeight = ZvaviFontWeight.brandAccent,
        fontSize = ZvaviFontSize.fontSize700,
        lineHeight = ZvaviLineHeight.compact700,
        letterSpacing = LETTER_SPACING
    ),
    display700AccentNumeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.brand),
        fontWeight = ZvaviFontWeight.brandAccent,
        fontSize = ZvaviFontSize.fontSize700,
        lineHeight = ZvaviLineHeight.compact700,
        letterSpacing = LETTER_SPACING
    ),
    text150Default = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textDefault,
        fontSize = ZvaviFontSize.fontSize150,
        lineHeight = ZvaviLineHeight.default150,
        letterSpacing = LETTER_SPACING
    ),
    text150Numeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textDefault,
        fontSize = ZvaviFontSize.fontSize150,
        lineHeight = ZvaviLineHeight.default150,
        letterSpacing = LETTER_SPACING
    ),
    text150Accent = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textAccent,
        fontSize = ZvaviFontSize.fontSize150,
        lineHeight = ZvaviLineHeight.default150,
        letterSpacing = LETTER_SPACING
    ),
    text150AccentNumeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textAccent,
        fontSize = ZvaviFontSize.fontSize150,
        lineHeight = ZvaviLineHeight.default150,
        letterSpacing = LETTER_SPACING
    ),
    text200Default = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textDefault,
        fontSize = ZvaviFontSize.fontSize200,
        lineHeight = ZvaviLineHeight.default200,
        letterSpacing = LETTER_SPACING
    ),
    text200Numeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textDefault,
        fontSize = ZvaviFontSize.fontSize200,
        lineHeight = ZvaviLineHeight.default200,
        letterSpacing = LETTER_SPACING
    ),
    text200Accent = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textAccent,
        fontSize = ZvaviFontSize.fontSize200,
        lineHeight = ZvaviLineHeight.default200,
        letterSpacing = LETTER_SPACING
    ),
    text200AccentNumeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textAccent,
        fontSize = ZvaviFontSize.fontSize200,
        lineHeight = ZvaviLineHeight.default200,
        letterSpacing = LETTER_SPACING
    ),
    text250Default = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textDefault,
        fontSize = ZvaviFontSize.fontSize250,
        lineHeight = ZvaviLineHeight.default250,
        letterSpacing = LETTER_SPACING
    ),
    text250Numeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textDefault,
        fontSize = ZvaviFontSize.fontSize250,
        lineHeight = ZvaviLineHeight.default250,
        letterSpacing = LETTER_SPACING
    ),
    text250Accent = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textAccent,
        fontSize = ZvaviFontSize.fontSize250,
        lineHeight = ZvaviLineHeight.default250,
        letterSpacing = LETTER_SPACING
    ),
    text250AccentNumeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textAccent,
        fontSize = ZvaviFontSize.fontSize250,
        lineHeight = ZvaviLineHeight.default250,
        letterSpacing = LETTER_SPACING
    ),
    text300Default = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textDefault,
        fontSize = ZvaviFontSize.fontSize300,
        lineHeight = ZvaviLineHeight.default300,
        letterSpacing = LETTER_SPACING
    ),
    text300Numeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textDefault,
        fontSize = ZvaviFontSize.fontSize300,
        lineHeight = ZvaviLineHeight.default300,
        letterSpacing = LETTER_SPACING
    ),
    text300Accent = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textAccent,
        fontSize = ZvaviFontSize.fontSize300,
        lineHeight = ZvaviLineHeight.default300,
        letterSpacing = LETTER_SPACING
    ),
    text300AccentNumeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textAccent,
        fontSize = ZvaviFontSize.fontSize300,
        lineHeight = ZvaviLineHeight.default300,
        letterSpacing = LETTER_SPACING
    ),
    text350Default = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textDefault,
        fontSize = ZvaviFontSize.fontSize350,
        lineHeight = ZvaviLineHeight.default350,
        letterSpacing = LETTER_SPACING
    ),
    text350Numeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textDefault,
        fontSize = ZvaviFontSize.fontSize350,
        lineHeight = ZvaviLineHeight.default350,
        letterSpacing = LETTER_SPACING
    ),
    text350Accent = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textAccent,
        fontSize = ZvaviFontSize.fontSize350,
        lineHeight = ZvaviLineHeight.default350,
        letterSpacing = LETTER_SPACING
    ),
    text350AccentNumeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textAccent,
        fontSize = ZvaviFontSize.fontSize350,
        lineHeight = ZvaviLineHeight.default350,
        letterSpacing = LETTER_SPACING
    ),
    text400Default = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textDefault,
        fontSize = ZvaviFontSize.fontSize400,
        lineHeight = ZvaviLineHeight.default400,
        letterSpacing = LETTER_SPACING
    ),
    text400Numeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textDefault,
        fontSize = ZvaviFontSize.fontSize400,
        lineHeight = ZvaviLineHeight.default400,
        letterSpacing = LETTER_SPACING
    ),
    text400Accent = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textAccent,
        fontSize = ZvaviFontSize.fontSize400,
        lineHeight = ZvaviLineHeight.default400,
        letterSpacing = LETTER_SPACING
    ),
    text400AccentNumeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textAccent,
        fontSize = ZvaviFontSize.fontSize400,
        lineHeight = ZvaviLineHeight.default400,
        letterSpacing = LETTER_SPACING
    ),
    compact150Default = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textDefault,
        fontSize = ZvaviFontSize.fontSize150,
        lineHeight = ZvaviLineHeight.compact150,
        letterSpacing = LETTER_SPACING
    ),
    compact150Numeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textDefault,
        fontSize = ZvaviFontSize.fontSize150,
        lineHeight = ZvaviLineHeight.compact150,
        letterSpacing = LETTER_SPACING
    ),
    compact150Accent = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textAccent,
        fontSize = ZvaviFontSize.fontSize150,
        lineHeight = ZvaviLineHeight.compact150,
        letterSpacing = LETTER_SPACING
    ),
    compact150AccentNumeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textAccent,
        fontSize = ZvaviFontSize.fontSize150,
        lineHeight = ZvaviLineHeight.compact150,
        letterSpacing = LETTER_SPACING
    ),
    compact200Default = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textDefault,
        fontSize = ZvaviFontSize.fontSize200,
        lineHeight = ZvaviLineHeight.compact200,
        letterSpacing = LETTER_SPACING
    ),
    compact200Numeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textDefault,
        fontSize = ZvaviFontSize.fontSize200,
        lineHeight = ZvaviLineHeight.compact200,
        letterSpacing = LETTER_SPACING
    ),
    compact200Accent = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textAccent,
        fontSize = ZvaviFontSize.fontSize200,
        lineHeight = ZvaviLineHeight.compact200,
        letterSpacing = LETTER_SPACING
    ),
    compact200AccentNumeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textAccent,
        fontSize = ZvaviFontSize.fontSize200,
        lineHeight = ZvaviLineHeight.compact200,
        letterSpacing = LETTER_SPACING
    ),
    compact250Default = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textDefault,
        fontSize = ZvaviFontSize.fontSize250,
        lineHeight = ZvaviLineHeight.compact250,
        letterSpacing = LETTER_SPACING
    ),
    compact250Numeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textDefault,
        fontSize = ZvaviFontSize.fontSize250,
        lineHeight = ZvaviLineHeight.compact250,
        letterSpacing = LETTER_SPACING
    ),
    compact250Accent = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textAccent,
        fontSize = ZvaviFontSize.fontSize250,
        lineHeight = ZvaviLineHeight.compact250,
        letterSpacing = LETTER_SPACING
    ),
    compact250AccentNumeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textAccent,
        fontSize = ZvaviFontSize.fontSize250,
        lineHeight = ZvaviLineHeight.compact250,
        letterSpacing = LETTER_SPACING
    ),
    compact300Default = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textDefault,
        fontSize = ZvaviFontSize.fontSize300,
        lineHeight = ZvaviLineHeight.compact300,
        letterSpacing = LETTER_SPACING
    ),
    compact300Numeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textDefault,
        fontSize = ZvaviFontSize.fontSize300,
        lineHeight = ZvaviLineHeight.compact300,
        letterSpacing = LETTER_SPACING
    ),
    compact300Accent = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textAccent,
        fontSize = ZvaviFontSize.fontSize300,
        lineHeight = ZvaviLineHeight.compact300,
        letterSpacing = LETTER_SPACING
    ),
    compact300AccentNumeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textAccent,
        fontSize = ZvaviFontSize.fontSize300,
        lineHeight = ZvaviLineHeight.compact300,
        letterSpacing = LETTER_SPACING
    ),
    compact350Default = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textDefault,
        fontSize = ZvaviFontSize.fontSize350,
        lineHeight = ZvaviLineHeight.compact350,
        letterSpacing = LETTER_SPACING
    ),
    compact350Numeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textDefault,
        fontSize = ZvaviFontSize.fontSize350,
        lineHeight = ZvaviLineHeight.compact350,
        letterSpacing = LETTER_SPACING
    ),
    compact350Accent = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textAccent,
        fontSize = ZvaviFontSize.fontSize350,
        lineHeight = ZvaviLineHeight.compact350,
        letterSpacing = LETTER_SPACING
    ),
    compact350AccentNumeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textAccent,
        fontSize = ZvaviFontSize.fontSize350,
        lineHeight = ZvaviLineHeight.compact350,
        letterSpacing = LETTER_SPACING
    ),
    compact400Default = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textDefault,
        fontSize = ZvaviFontSize.fontSize400,
        lineHeight = ZvaviLineHeight.compact400,
        letterSpacing = LETTER_SPACING
    ),
    compact400Numeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textDefault,
        fontSize = ZvaviFontSize.fontSize400,
        lineHeight = ZvaviLineHeight.compact400,
        letterSpacing = LETTER_SPACING
    ),
    compact400Accent = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textAccent,
        fontSize = ZvaviFontSize.fontSize400,
        lineHeight = ZvaviLineHeight.compact400,
        letterSpacing = LETTER_SPACING
    ),
    compact400AccentNumeric = TextStyle(
        fontFamily = FontFamily(ZvaviFont.text),
        fontWeight = ZvaviFontWeight.textAccent,
        fontSize = ZvaviFontSize.fontSize400,
        lineHeight = ZvaviLineHeight.compact400,
        letterSpacing = LETTER_SPACING
    )
)

@Immutable
class ZvaviTypography(
    val display350Default: TextStyle,
    val display350Numeric: TextStyle,
    val display350Accent: TextStyle,
    val display350AccentNumeric: TextStyle,
    val display400Default: TextStyle,
    val display400Numeric: TextStyle,
    val display400Accent: TextStyle,
    val display400AccentNumeric: TextStyle,
    val display450Default: TextStyle,
    val display450Numeric: TextStyle,
    val display450Accent: TextStyle,
    val display450AccentNumeric: TextStyle,
    val display500Default: TextStyle,
    val display500Numeric: TextStyle,
    val display500Accent: TextStyle,
    val display500AccentNumeric: TextStyle,
    val display600Default: TextStyle,
    val display600Numeric: TextStyle,
    val display600Accent: TextStyle,
    val display600AccentNumeric: TextStyle,
    val display650Default: TextStyle,
    val display650Numeric: TextStyle,
    val display650Accent: TextStyle,
    val display650AccentNumeric: TextStyle,
    val display700Default: TextStyle,
    val display700Numeric: TextStyle,
    val display700Accent: TextStyle,
    val display700AccentNumeric: TextStyle,
    val text150Default: TextStyle,
    val text150Numeric: TextStyle,
    val text150Accent: TextStyle,
    val text150AccentNumeric: TextStyle,
    val text200Default: TextStyle,
    val text200Numeric: TextStyle,
    val text200Accent: TextStyle,
    val text200AccentNumeric: TextStyle,
    val text250Default: TextStyle,
    val text250Numeric: TextStyle,
    val text250Accent: TextStyle,
    val text250AccentNumeric: TextStyle,
    val text300Default: TextStyle,
    val text300Numeric: TextStyle,
    val text300Accent: TextStyle,
    val text300AccentNumeric: TextStyle,
    val text350Default: TextStyle,
    val text350Numeric: TextStyle,
    val text350Accent: TextStyle,
    val text350AccentNumeric: TextStyle,
    val text400Default: TextStyle,
    val text400Numeric: TextStyle,
    val text400Accent: TextStyle,
    val text400AccentNumeric: TextStyle,
    val compact150Default: TextStyle,
    val compact150Numeric: TextStyle,
    val compact150Accent: TextStyle,
    val compact150AccentNumeric: TextStyle,
    val compact200Default: TextStyle,
    val compact200Numeric: TextStyle,
    val compact200Accent: TextStyle,
    val compact200AccentNumeric: TextStyle,
    val compact250Default: TextStyle,
    val compact250Numeric: TextStyle,
    val compact250Accent: TextStyle,
    val compact250AccentNumeric: TextStyle,
    val compact300Default: TextStyle,
    val compact300Numeric: TextStyle,
    val compact300Accent: TextStyle,
    val compact300AccentNumeric: TextStyle,
    val compact350Default: TextStyle,
    val compact350Numeric: TextStyle,
    val compact350Accent: TextStyle,
    val compact350AccentNumeric: TextStyle,
    val compact400Default: TextStyle,
    val compact400Numeric: TextStyle,
    val compact400Accent: TextStyle,
    val compact400AccentNumeric: TextStyle
)

object ZvaviFont {
    val brand @Composable get() = brand()
    val text @Composable get() = text()
}

@Composable
internal fun brand() = Font(Res.font.noto_sans_regular)

@Composable
internal fun text() = Font(Res.font.noto_sans_regular)

@Immutable
object ZvaviFontSize {
    val fontSize150 = 10.sp
    val fontSize200 = 12.sp
    val fontSize250 = 14.sp
    val fontSize300 = 16.sp
    val fontSize350 = 18.sp
    val fontSize400 = 22.sp
    val fontSize450 = 28.sp
    val fontSize500 = 32.sp
    val fontSize600 = 36.sp
    val fontSize650 = 40.sp
    val fontSize700 = 48.sp
    val fontSize800 = 56.sp
    val fontSize900 = 64.sp
}

@Immutable
object ZvaviLineHeight {
    val lineHeight150 = 12.sp
    val lineHeight200 = 14.sp
    val lineHeight250 = 16.sp
    val lineHeight300 = 18.sp
    val lineHeight350 = 22.sp
    val lineHeight400 = 26.sp
    val lineHeight450 = 32.sp
    val lineHeight500 = 38.sp
    val lineHeight600 = 42.sp
    val lineHeight650 = 48.sp
    val lineHeight700 = 56.sp
    val lineHeight800 = 64.sp
    val lineHeight900 = 76.sp

    val default150 = 14.sp
    val default200 = 16.sp
    val default250 = 20.sp
    val default300 = 22.sp
    val default350 = 24.sp
    val default400 = 30.sp
    val default450 = 40.sp
    val default500 = 44.sp
    val default600 = 50.sp
    val default650 = 58.sp
    val default700 = 66.sp
    val default800 = 78.sp
    val default900 = 90.sp

    val compact150 = 12.sp
    val compact200 = 14.sp
    val compact250 = 16.sp
    val compact300 = 18.sp
    val compact350 = 22.sp
    val compact400 = 26.sp
    val compact450 = 32.sp
    val compact500 = 38.sp
    val compact600 = 42.sp
    val compact650 = 48.sp
    val compact700 = 56.sp
    val compact800 = 64.sp
    val compact900 = 76.sp
}

@Immutable
object ZvaviParagraphSpacing {
    val spacing0 = 0.sp
    val spacing150 = 2.sp
    val spacing200 = 4.sp
    val spacing250 = 6.sp
    val spacing300 = 8.sp
    val spacing350 = 10.sp
    val spacing400 = 12.sp
    val spacing450 = 14.sp
    val spacing500 = 16.sp
    val spacing600 = 18.sp
    val spacing650 = 20.sp
    val spacing700 = 24.sp
    val spacing800 = 28.sp
    val spacing900 = 32.sp
}

@Immutable
object ZvaviFontWeight {
    val brandDefault = FontWeight.W500
    val brandAccent = FontWeight.W600
    val textDefault = FontWeight.W500
    val textAccent = FontWeight.W600
}