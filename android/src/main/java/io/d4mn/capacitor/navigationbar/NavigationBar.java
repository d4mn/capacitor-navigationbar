package io.d4mn.capacitor.navigationbar;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

@NativePlugin()
public class NavigationBar extends Plugin {

    private static final String TAG = "NavigationBar";

    @PluginMethod()
    public void show(final PluginCall call) {
        final Activity activity = bridge.getActivity();
        final Window window = activity.getWindow();
        final View decorView = window.getDecorView();

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                int uiOptions = window.getDecorView().getSystemUiVisibility();
                uiOptions &= ~View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
                uiOptions &= ~View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
                uiOptions &= ~View.SYSTEM_UI_FLAG_FULLSCREEN;
                decorView.setSystemUiVisibility(uiOptions);
                JSObject ret = new JSObject();
                ret.put("status", "showed");
                call.success(ret);
            }
        });
    }

    @PluginMethod()
    public void hide(final PluginCall call) {
        final Activity activity = bridge.getActivity();
        final Window window = activity.getWindow();
        final View decorView = window.getDecorView();
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                final int uiOptions = window.getDecorView().getSystemUiVisibility()
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
                decorView.setSystemUiVisibility(uiOptions);
                JSObject ret = new JSObject();
                ret.put("status", "hidden");
                call.success(ret);
            }
        });
    }
}
