package com.salah.amr.codingtaskapp.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.RemoteViews;

import com.salah.amr.codingtaskapp.MyApp;
import com.salah.amr.codingtaskapp.R;
import com.salah.amr.codingtaskapp.dagger.WidgetModule;
import com.salah.amr.codingtaskapp.model.WeatherSharedPreferences;

import javax.inject.Inject;


public class NewAppWidget extends AppWidgetProvider {
    private static final String TAG = "NewAppWidget";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: ");
        super.onReceive(context, intent);
        int [] array = intent.getIntArrayExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS);
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        updateAppWidget(context ,appWidgetManager  , AppWidgetManager.INVALID_APPWIDGET_ID);
    }

    public static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                       int appWidgetId) {
        Log.d(TAG, "updateAppWidget: ");
        CharSequence widgetText = NewAppWidgetConfigureActivity.loadTitlePref(context, appWidgetId);
        String temp = NewAppWidgetConfigureActivity.loadTemp(context);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
        views.setTextViewText(R.id.appwidget_text, widgetText);

        views.setTextViewText(R.id.widget_temp , temp);
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        // When the user deletes the widget, delete the preference associated with it.
        for (int appWidgetId : appWidgetIds) {
            NewAppWidgetConfigureActivity.deleteTitlePref(context, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

