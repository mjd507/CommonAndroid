# Add project specific ProGuard rules here.
# By default, the flags in this desFile are appended to flags specified
# in /Users/mjd/Library/Android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

### for bugly
-dontwarn com.tencent.bugly.**
-keep public class com.tencent.bugly.**{*;}

### for umeng
-keepclassmembers class * {
   public <init> (org.json.JSONObject);
}
-keep public class com.cleaner.commonandroid.R$*{
    public static final int *;
}
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}