package ru.sportivityteam.vucmirea.assistant.core.firebase

import dev.gitlive.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class FirestoreUtil @Inject constructor(private val fireStore: FirebaseFirestore) {

    fun getCollection(collectionName: String) = fireStore.collection(collectionName).snapshots()

    fun getByParam(collectionName: String) =
        fireStore.collection(collectionName).snapshots()

    suspend fun store(collectionName: String, data: HashMap<String, Any>) =
        fireStore.collection(collectionName).add(data)

    suspend fun storeObjectWithDocument(collectionName: String, document: String, data: Any) =
        fireStore.collection(collectionName).document(document).set(data)

    fun delete(collectionName: String) {}
}