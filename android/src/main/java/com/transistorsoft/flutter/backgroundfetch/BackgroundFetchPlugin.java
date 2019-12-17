package com.transistorsoft.flutter.backgroundfetch;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** BackgroundFetchPlugin */
public class BackgroundFetchPlugin implements FlutterPlugin {
    public static final String TAG                          = "TSBackgroundFetch";

    // @deprecated Not used by v2.
    public static void registerWith(Registrar registrar) {
        BackgroundFetchModule.getInstance().onAttachedToEngine(registrar.context(), registrar.messenger());
    }

    // @deprecated Called by Application#onCreate
    public static void setPluginRegistrant(PluginRegistry.PluginRegistrantCallback callback) {
        HeadlessTask.setPluginRegistrant(callback);
    }

    public BackgroundFetchPlugin() { }

    @Override
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        BackgroundFetchModule.getInstance().onAttachedToEngine(binding.getApplicationContext(), binding.getFlutterEngine().getDartExecutor());
    }

    @Override
    public void onDetachedFromEngine(FlutterPluginBinding binding) {
        BackgroundFetchModule.getInstance().onDetachedFromEngine(binding);
    }
}
