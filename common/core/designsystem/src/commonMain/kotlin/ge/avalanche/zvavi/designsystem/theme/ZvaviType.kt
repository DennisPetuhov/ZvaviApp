package ge.avalanche.zvavi.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.ResourceFont
import zvaviapp.common.core.designsystem.generated.resources.Res

//import org.jetbrains.compose.ui.uiUtil.fastAll
//import org.jetbrains.compose.ui.uiUtil.fastAny


//val ZvaviTypography = ZvaviType(
////    display350Default = ZvaviTextStyle( fontFamily = )
//)

@Composable
fun ZvaviFontFamily() = FontFamily(
//    Font(Res.font, FontWeight.W400),
)


@Immutable
class ZvaviTextStyle(
    val fontFamily: String,
    val fontWeight: FontWeight,
    val fontSize: TextUnit,
    val lineHeight: TextUnit,
    val letterSpacing: TextUnit,
    val paragraphSpacing:TextUnit,
)

@Immutable
class ZvaviType(
    val display350Default: ZvaviTextStyle,
    val display350Numeric: ZvaviTextStyle,
    val display350Accent: ZvaviTextStyle,
    val display350AccentNumeric: ZvaviTextStyle,
    val display400Default: ZvaviTextStyle,
    val display400Numeric: ZvaviTextStyle,
    val display400Accent: ZvaviTextStyle,
    val display400AccentNumeric: ZvaviTextStyle,
    val display450Default: ZvaviTextStyle,
    val display450Numeric: ZvaviTextStyle,
    val display450Accent: ZvaviTextStyle,
    val display450AccentNumeric: ZvaviTextStyle,
    val display500Default: ZvaviTextStyle,
    val display500Numeric: ZvaviTextStyle,
    val display500Accent: ZvaviTextStyle,
    val display500AccentNumeric: ZvaviTextStyle,
    val display600Default: ZvaviTextStyle,
    val display600Numeric: ZvaviTextStyle,
    val display600Accent: ZvaviTextStyle,
    val display600AccentNumeric: ZvaviTextStyle,
    val display650Default: ZvaviTextStyle,
    val display650Numeric: ZvaviTextStyle,
    val display650Accent: ZvaviTextStyle,
    val display650AccentNumeric: ZvaviTextStyle,
    val display700Default: ZvaviTextStyle,
    val display700Numeric: ZvaviTextStyle,
    val display700Accent: ZvaviTextStyle,
    val display700AccentNumeric: ZvaviTextStyle,
    val text150Default: ZvaviTextStyle,
    val text150Numeric: ZvaviTextStyle,
    val text150Accent: ZvaviTextStyle,
    val text150AccentNumeric: ZvaviTextStyle,
    val text200Default: ZvaviTextStyle,
    val text200Numeric: ZvaviTextStyle,
    val text200Accent: ZvaviTextStyle,
    val text200AccentNumeric: ZvaviTextStyle,
    val text250Default: ZvaviTextStyle,
    val text250Numeric: ZvaviTextStyle,
    val text250Accent: ZvaviTextStyle,
    val text250AccentNumeric: ZvaviTextStyle,
    val text300Default: ZvaviTextStyle,
    val text300Numeric: ZvaviTextStyle,
    val text300Accent: ZvaviTextStyle,
    val text300AccentNumeric: ZvaviTextStyle,
    val text350Default: ZvaviTextStyle,
    val text350Numeric: ZvaviTextStyle,
    val text350Accent: ZvaviTextStyle,
    val text350AccentNumeric: ZvaviTextStyle,
    val text400Default: ZvaviTextStyle,
    val text400Numeric: ZvaviTextStyle,
    val text400Accent: ZvaviTextStyle,
    val text400AccentNumeric: ZvaviTextStyle,
    val compact150Default: ZvaviTextStyle,
    val compact150Numeric: ZvaviTextStyle,
    val compact150Accent: ZvaviTextStyle,
    val compact150AccentNumeric: ZvaviTextStyle,
    val compact200Default: ZvaviTextStyle,
    val compact200Numeric: ZvaviTextStyle,
    val compact200Accent: ZvaviTextStyle,
    val compact200AccentNumeric: ZvaviTextStyle,
    val compact250Default: ZvaviTextStyle,
    val compact250Numeric: ZvaviTextStyle,
    val compact250Accent: ZvaviTextStyle,
    val compact250AccentNumeric: ZvaviTextStyle,
    val compact300Default: ZvaviTextStyle,
    val compact300Numeric: ZvaviTextStyle,
    val compact300Accent: ZvaviTextStyle,
    val compact300AccentNumeric: ZvaviTextStyle,
    val compact350Default: ZvaviTextStyle,
    val compact350Numeric: ZvaviTextStyle,
    val compact350Accent: ZvaviTextStyle,
    val compact350AccentNumeric: ZvaviTextStyle,
    val compact400Default: ZvaviTextStyle,
    val compact400Numeric: ZvaviTextStyle,
    val compact400Accent: ZvaviTextStyle,
    val compact400AccentNumeric: ZvaviTextStyle
)

object FontFamily {
    val brand = "Noto Sans Georgian"
    val text = "Noto Sans Georgian"
}
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

//ParagraphSpacing in json
object ZvaviLetterSpacing {
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

object ZvaviFontWeight {
    val brandDefault = FontWeight.W500
    val brandAccent = FontWeight.W600

    val textDefault = FontWeight.W500
    val textAccent = FontWeight.W600
}