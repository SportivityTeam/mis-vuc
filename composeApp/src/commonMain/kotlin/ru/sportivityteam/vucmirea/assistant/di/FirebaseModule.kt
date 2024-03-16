package ru.sportivityteam.vucmirea.assistant.di

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.FirebaseApp
import dev.gitlive.firebase.firestore.FirebaseFirestore
import dev.gitlive.firebase.firestore.firestore
import dev.gitlive.firebase.initialize
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ru.sportivityteam.vucmirea.assistant.core.firebase.FirestoreUtil

internal val firebaseModule = module {
    single<FirebaseApp> {
        Firebase.initialize(androidContext())!!
    }
    single<FirebaseFirestore> { Firebase.firestore(get()) }
    single { FirestoreUtil(get()) }
}