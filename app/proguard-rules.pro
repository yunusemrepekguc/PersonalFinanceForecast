# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
# app/proguard-rules.pro

# ========== Hilt ==========
# app/proguard-rules.pro

# ========== Annotation Processors (Compile-time only) ==========
# app/proguard-rules.pro

# ========== Annotation Processors (Compile-time only) ==========
-dontwarn com.google.auto.value.**
-dontwarn com.google.auto.service.**
-dontwarn com.google.common.**
-dontwarn javax.annotation.processing.**
-dontwarn javax.lang.model.**
-dontwarn javax.tools.**

# Remove annotation processor classes
-dontnote com.google.auto.value.**
-dontnote com.google.auto.service.**
-dontnote com.google.common.**

# ========== Guava (annotation processor için) ==========
-dontwarn com.google.common.collect.**
-dontwarn com.google.common.base.**
-dontwarn com.google.common.util.**

# ========== Hilt ==========
-keep class dagger.hilt.** { *; }
-keep class javax.inject.** { *; }
-keep @dagger.hilt.InstallIn class * { *; }
-keep @dagger.hilt.android.lifecycle.HiltViewModel class * { *; }

-keepclassmembers,allowobfuscation class * {
    @dagger.hilt.** <methods>;
    @javax.inject.** <fields>;
}

# Keep Hilt generated classes
-keep class **_HiltModules { *; }
-keep class **_HiltComponents { *; }
-keep class **_Factory { *; }
-keep class **_MembersInjector { *; }
-keep class * extends dagger.hilt.android.internal.managers.ViewComponentManager$** { *; }

# ========== Dagger ==========
-keep class dagger.** { *; }
-keepclassmembers class * {
    @dagger.** <methods>;
}

# ========== Room ==========
-keep class * extends androidx.room.RoomDatabase
-keep @androidx.room.Entity class *
-dontwarn androidx.room.paging.**

-keepclassmembers class * extends androidx.room.RoomDatabase {
    public abstract ** *Dao();
}

# ========== Retrofit ==========
-keepattributes Signature, InnerClasses, EnclosingMethod
-keepattributes RuntimeVisibleAnnotations, RuntimeVisibleParameterAnnotations
-keepattributes AnnotationDefault

-keepclassmembers,allowshrinking,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}

-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
-dontwarn javax.annotation.**
-dontwarn kotlin.Unit
-dontwarn retrofit2.KotlinExtensions
-dontwarn retrofit2.KotlinExtensions$*

# OkHttp
-dontwarn okhttp3.**
-dontwarn okio.**
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }

# ========== Kotlin ==========
-keep class kotlin.** { *; }
-keep class kotlin.Metadata { *; }
-dontwarn kotlin.**
-keepclassmembers class **$WhenMappings {
    <fields>;
}

# Coroutines
-keepnames class kotlinx.coroutines.internal.MainDispatcherFactory {}
-keepnames class kotlinx.coroutines.CoroutineExceptionHandler {}
-keepclassmembers class kotlinx.** {
    volatile <fields>;
}

# ========== Serialization ==========
-keepattributes *Annotation*, InnerClasses
-dontnote kotlinx.serialization.AnnotationsKt

-keepclassmembers class kotlinx.serialization.json.** {
    *** Companion;
}
-keepclasseswithmembers class kotlinx.serialization.json.** {
    kotlinx.serialization.KSerializer serializer(...);
}

# ========== Data Models ==========
-keep class com.yempe.personalfinanceforecast.domain.model.** { *; }
-keep class com.yempe.personalfinanceforecast.data.remote.dto.** { *; }
-keep class com.yempe.personalfinanceforecast.data.local.entity.** { *; }

# ========== General ==========
-keepattributes SourceFile,LineNumberTable
-keepattributes Signature
-keepattributes *Annotation*
-renamesourcefileattribute SourceFile

