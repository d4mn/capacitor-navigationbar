package io.d4mn.capacitor.navigationbar;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

@NativePlugin()
public class NavigationBar extends Plugin {

    private static final String TAG = "NavigationBar";

    @PluginMethod()
    public void show(PluginCall call) {
        final Activity activity = bridge.getActivity();
        final Window window = activity.getWindow();

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // SYSTEM_UI_FLAG_FULLSCREEN is available since JellyBean, but we
                // use KitKat here to be aligned with "Fullscreen"  preference
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    int uiOptions = window.getDecorView().getSystemUiVisibility();
                    uiOptions &= ~View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
                    uiOptions &= ~View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

                    window.getDecorView().setSystemUiVisibility(uiOptions);

                    window.getDecorView().setOnFocusChangeListener(null);
                    window.getDecorView().setOnSystemUiVisibilityChangeListener(null);
                }

                // CB-11197 We still need to update LayoutParams to force navigation bar
                // to be hidden when entering e.g. text fields
                window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                JSObject ret = new JSObject();
                ret.put("status", "hidden");
                call.success(ret);
            }
        });
    }
}
