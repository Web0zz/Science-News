package com.web0zz.science_news.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import androidx.core.net.toUri
import androidx.core.os.bundleOf
import androidx.navigation.NavDeepLinkBuilder
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.AppWidgetTarget
import com.bumptech.glide.request.transition.Transition
import com.web0zz.science_news.MainActivity
import com.web0zz.science_news.R
import com.web0zz.science_news.data.dummySource.DummyDataSource
import com.web0zz.science_news.data.model.Article

class ListWidgetService : RemoteViewsService() {
    override fun onGetViewFactory(p0: Intent): RemoteViewsFactory {
        return ListWidgetServiceFactory(this.applicationContext)
    }
}

class ListWidgetServiceFactory(
    private val context: Context
) : RemoteViewsService.RemoteViewsFactory {
    private lateinit var widgetItems: MutableList<Article>

    override fun onCreate() {
        widgetItems = DummyDataSource().articleList.toMutableList()
    }

    override fun onDataSetChanged() { }

    override fun onDestroy() { widgetItems.clear() }

    override fun getCount(): Int = widgetItems.size

    override fun getViewAt(p0: Int): RemoteViews {
        return RemoteViews(context.packageName, R.layout.view_widget_item_article).apply {
            val imageBitmap = Glide.with(context.applicationContext)
                .asBitmap()
                .load(widgetItems[p0].thumbnail)
                .submit(85,65)
                .get()

            setTextViewText(R.id.widget_item_article_title_textView, widgetItems[p0].title)
            setTextViewText(R.id.widget_item_article_short_description_textView, widgetItems[p0].shortBody)
            setImageViewBitmap(R.id.widget_item_article_thumbnail_imageView, imageBitmap)

            val args = Bundle()
            args.putInt(ARTICLE_ID, widgetItems[p0].id)

            val fillInIntent = Intent()
            fillInIntent.putExtras(args)

            setOnClickFillInIntent(R.id.view_widget_item_relativeLayout, fillInIntent)
        }
    }

    override fun getLoadingView(): RemoteViews {
        return RemoteViews(context.packageName, R.layout.view_widget_item_article)
    }

    override fun getViewTypeCount(): Int {
        return 1
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }
}