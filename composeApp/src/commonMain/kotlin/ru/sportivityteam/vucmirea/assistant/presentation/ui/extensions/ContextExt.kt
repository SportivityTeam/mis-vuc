package ru.sportivityteam.vucmirea.assistant.presentation.ui.extensions

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log

fun Context.sendMail(email: String) {
    try {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "vnd.android.cursor.item/email" // or "message/rfc822"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
        startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        Log.e(e.cause.toString(), e.message.toString())
    } catch (t: Throwable) {
        Log.e(t.cause.toString(), t.message.toString())
    }
}

fun Context.dial(phone: String) {
    try {
        val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
        startActivity(intent)
    } catch (t: Throwable) {
        Log.e(t.cause.toString(), t.message.toString())
    }
}