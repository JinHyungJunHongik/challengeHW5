package com.example.challengehw5.network

import android.annotation.SuppressLint
import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor : Interceptor {
    @SuppressLint("SuspiciousIndentation")
    override fun intercept(chain: Interceptor.Chain): Response {
      val Request = chain.request().newBuilder()
          .addHeader(
              "Authorization",
              "KakaoAK %s".format(
                  "c2e35e66f144e5d544ec6782c56b342b"
              )
          ).build()

        return chain.proceed(Request)
    }
}