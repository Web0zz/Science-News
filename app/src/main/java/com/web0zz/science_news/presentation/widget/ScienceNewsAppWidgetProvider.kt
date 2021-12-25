package com.web0zz.science_news.presentation.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.RemoteViews
import androidx.navigation.NavDeepLinkBuilder
import com.web0zz.science_news.presentation.MainActivity
import com.web0zz.science_news.R

const val DETAIL_ACTION = "com.web0zz.android.listwidget.DETAIL_ACTION"
const val ARTICLE_ID = "com.web0zz.android.listwidget.ARTICLE_ID"

class ScienceNewsAppWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds)
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == DETAIL_ACTION) {
            val articleID = intent.getIntExtra(ARTICLE_ID, 0)

            val args = Bundle()
            args.putInt("articleId", articleID)

            NavDeepLinkBuilder(context!!)
                .setGraph(R.navigation.main_nav_graph)
                .setDestination(R.id.detailFragment)
                .setArguments(args)
                .setComponentName(MainActivity::class.java)
                .createPendingIntent()
                .send()
        }
        super.onReceive(context, intent)
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val intent = Intent(context, ListWidgetService::class.java)
    intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
    intent.data = Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME))

    val views = RemoteViews(context.packageName, R.layout.science_news_app_widget)
    views.setRemoteAdapter(R.id.widget_article_listView, intent)

    val toDetailIntent = Intent(context, ScienceNewsAppWidgetProvider::class.java).apply {
        action = DETAIL_ACTION
        putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
        data = Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME))
    }

    val toDetailPendingIntent = PendingIntent.getBroadcast(
        context,
        0,
        toDetailIntent,
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        } else {
            PendingIntent.FLAG_UPDATE_CURRENT
        }
    )

    views.setPendingIntentTemplate(R.id.widget_article_listView, toDetailPendingIntent)

    appWidgetManager.updateAppWidget(appWidgetId, views)
}