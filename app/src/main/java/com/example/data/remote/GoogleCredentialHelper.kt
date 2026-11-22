package com.example.data.remote

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.util.Log
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.GetCredentialCancellationException
import androidx.credentials.exceptions.NoCredentialException
import com.example.R
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential

fun Context.findActivity(): Activity {
    var context = this
    while (context is ContextWrapper) {
        if (context is Activity) return context
        context = context.baseContext
    }
    throw IllegalStateException("Credentials must be requested from an Activity context")
}

object GoogleCredentialHelper {
    private const val TAG = "GoogleCredentialHelper"

    suspend fun requestGoogleIdToken(
        context: Context,
        onTokenReceived: (idToken: String, displayName: String?, email: String) -> Unit,
        onError: (String) -> Unit
    ) {
        val activity = try {
            context.findActivity()
        } catch (e: Exception) {
            onError(e.localizedMessage ?: "Activity context required for Google Sign-In")
            return
        }

        val credentialManager = CredentialManager.create(activity)
        val webClientId = try {
            activity.getString(R.string.default_web_client_id)
        } catch (e: Exception) {
            onError("Google Web Client ID resource is not configured.")
            return
        }

        try {
            val googleIdOption = GetGoogleIdOption.Builder()
                .setFilterByAuthorizedAccounts(false)
                .setServerClientId(webClientId)
                .setAutoSelectEnabled(true)
                .build()

            val request = GetCredentialRequest.Builder()
                .addCredentialOption(googleIdOption)
                .build()

            val result = credentialManager.getCredential(activity, request)
            handleCredentialResult(result.credential, onTokenReceived, onError)
        } catch (e: NoCredentialException) {
            try {
                val signInWithGoogleOption = GetSignInWithGoogleOption.Builder(webClientId).build()
                val fallbackRequest = GetCredentialRequest.Builder()
                    .addCredentialOption(signInWithGoogleOption)
                    .build()
                val result = credentialManager.getCredential(activity, fallbackRequest)
                handleCredentialResult(result.credential, onTokenReceived, onError)
            } catch (cancelEx: GetCredentialCancellationException) {
                Log.d(TAG, "User cancelled explicit Google Sign-In flow")
                onError("Sign-in cancelled.")
            } catch (fallbackEx: Exception) {
                Log.e(TAG, "Explicit Google Sign-In failed", fallbackEx)
                onError(fallbackEx.localizedMessage ?: "No Google account found on this device.")
            }
        } catch (e: GetCredentialCancellationException) {
            Log.d(TAG, "User cancelled Google Sign-In")
            onError("Sign-in cancelled.")
        } catch (e: Exception) {
            Log.e(TAG, "Credential Manager sign-in error", e)
            onError(e.localizedMessage ?: "Google Sign-In failed.")
        }
    }

    private fun handleCredentialResult(
        credential: androidx.credentials.Credential,
        onTokenReceived: (idToken: String, displayName: String?, email: String) -> Unit,
        onError: (String) -> Unit
    ) {
        if (credential is CustomCredential &&
            credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL
        ) {
            val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(credential.data)
            onTokenReceived(
                googleIdTokenCredential.idToken,
                googleIdTokenCredential.displayName,
                googleIdTokenCredential.id
            )
        } else {
            onError("Unexpected credential type returned from Credential Manager.")
        }
    }
}
