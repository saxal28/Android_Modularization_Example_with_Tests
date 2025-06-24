package com.example.ud1_modularization_example_2.core.data

import com.example.ud1_modularization_example_2.core.data.network.NetworkModule
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import retrofit2.converter.gson.GsonConverterFactory

class NetworkModuleTest {

    @Test
    fun `provideHttpLoggingInterceptor should return configured interceptor`() {
        // When
        val interceptor = NetworkModule.provideHttpLoggingInterceptor()

        // Then
        assertNotNull(interceptor)
        assertEquals(HttpLoggingInterceptor.Level.BODY, interceptor.level)
    }

    @Test
    fun `provideOkHttpClient should return configured client with logging interceptor`() {
        // Given
        val loggingInterceptor = NetworkModule.provideHttpLoggingInterceptor()

        // When
        val okHttpClient = NetworkModule.provideOkHttpClient(loggingInterceptor)

        // Then
        assertNotNull(okHttpClient)
        assertTrue(okHttpClient.interceptors.contains(loggingInterceptor))
        assertEquals(30_000, okHttpClient.connectTimeoutMillis)
        assertEquals(30_000, okHttpClient.readTimeoutMillis)
        assertEquals(30_000, okHttpClient.writeTimeoutMillis)
    }

    @Test
    fun `provideRetrofitBuilder should return configured builder`() {
        // Given
        val loggingInterceptor = NetworkModule.provideHttpLoggingInterceptor()
        val okHttpClient = NetworkModule.provideOkHttpClient(loggingInterceptor)

        // When
        val retrofitBuilder = NetworkModule.provideRetrofitBuilder(okHttpClient)

        // Then
        assertNotNull(retrofitBuilder)

        // Build a retrofit instance to verify configuration
        val retrofit = retrofitBuilder
            .baseUrl("https://test.com/")
            .build()

        // Verify the converter factory is GsonConverterFactory
        val converterFactories = retrofit.converterFactories()
        assertTrue(converterFactories.any { it is GsonConverterFactory })
    }

    @Test
    fun `complete network setup integration test`() {
        // Given & When
        val loggingInterceptor = NetworkModule.provideHttpLoggingInterceptor()
        val okHttpClient = NetworkModule.provideOkHttpClient(loggingInterceptor)
        val retrofitBuilder = NetworkModule.provideRetrofitBuilder(okHttpClient)

        // Then - Verify full integration works
        val retrofit = retrofitBuilder
            .baseUrl("https://api.test.com/")
            .build()

        assertNotNull(retrofit)
        assertEquals("https://api.test.com/", retrofit.baseUrl().toString())
    }

    @Test
    fun `okHttpClient should have correct timeout configurations`() {
        // Given
        val loggingInterceptor = NetworkModule.provideHttpLoggingInterceptor()

        // When
        val client = NetworkModule.provideOkHttpClient(loggingInterceptor)

        // Then
        assertEquals("Connect timeout should be 30 seconds", 30_000, client.connectTimeoutMillis)
        assertEquals("Read timeout should be 30 seconds", 30_000, client.readTimeoutMillis)
        assertEquals("Write timeout should be 30 seconds", 30_000, client.writeTimeoutMillis)
    }
}