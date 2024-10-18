import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MobilJDM(
    val name: String,
    val description: String,
    val photo: Int,
    val detailDescription: String
) : Parcelable
