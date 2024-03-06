import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings

class AppPermissions {

    companion object {
        const val REQUEST_MANAGE_ALL_FILES_PERMISSION: Int = 456

        fun permissionGranted(context: Context): Boolean {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                android.os.Environment.isExternalStorageManager()
            } else {
                // Handle permission check for pre-Android 11 devices
                // For example, using your existing permission check logic
                false
            }
        }

        fun requestManageAllFilesPermission(activity: Activity) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                val intent = Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)
                activity.startActivityForResult(intent, REQUEST_MANAGE_ALL_FILES_PERMISSION)
            }
        }
    }
}
