# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in F:\Android\sdk/tools/proguard/proguard-android.txt
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

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#####################################################################################
# Start on 2017/5/16 15:59
# Update on 2017/7/4 17:53  http://blog.csdn.net/gfg156196
# Email：sin2t@sina.com
#
#####################################################################################
    #指定代码的压缩级别
    -optimizationpasses 5
    #包名不混合大小写
    -dontusemixedcaseclassnames
    #不去忽略非公共的库类
    -dontskipnonpubliclibraryclasses
     #优化  不优化输入的类文件
    -dontoptimize
     #混淆时是否做预校验
    -dontpreverify
     #混淆时是否记录日志
    -verbose
     # 混淆时所采用的算法
    -optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
    #保护注解
    -keepattributes *Annotation*
     #如果引用了v4或者v7包
    -dontwarn android.support.**
    #保持 native 方法不被混淆
    -keepclasseswithmembernames class * {
        native <methods>;
    }
    #保持自定义控件类不被混淆
    -keepclasseswithmembers class * {
        public <init>(android.content.Context, android.util.AttributeSet);
    }
    #保持自定义控件类不被混淆
    -keepclassmembers class * extends android.app.Activity {
       public void *(android.view.View);
    }
     # 保持自定义控件类不被混淆
    -keepclasseswithmembers class * {
        public <init>(android.content.Context, android.util.AttributeSet);
    }
    # 保持自定义控件类不被混淆
    -keepclasseswithmembers class * {
        public <init>(android.content.Context, android.util.AttributeSet, int);
    }
    #保持 Parcelable 不被混淆
    -keep class * implements android.os.Parcelable {
      public static final android.os.Parcelable$Creator *;
    }
    #保持 Serializable 不被混淆
    -keepnames class * implements java.io.Serializable
    #保持 Serializable 不被混淆并且enum 类也不被混淆
    -keepclassmembers class * implements java.io.Serializable {
        static final long serialVersionUID;
        private static final java.io.ObjectStreamField[] serialPersistentFields;
        !static !transient <fields>;
        !private <fields>;
        !private <methods>;
        private void writeObject(java.io.ObjectOutputStream);
        private void readObject(java.io.ObjectInputStream);
        java.lang.Object writeReplace();
        java.lang.Object readResolve();
    }
    #保持枚举 enum 类不被混淆 如果混淆报错，建议直接使用上面的 -keepclassmembers class * implements java.io.Serializable即可
    #-keepclassmembers enum * {
    #  public static **[] values();
    #  public static ** valueOf(java.lang.String);
    #}

    -keepclassmembers class * {
        public void *ButtonClicked(android.view.View);
    }
    #不混淆资源类
    -keepclassmembers class **.R$* {
        public static <fields>;
    }
    #避免混淆泛型 如果混淆报错建议关掉
    #–keepattributes Signature

    #关闭所有日志 log, java.io.Print, printStackTrace
    -assumenosideeffects class android.util.Log {
        public static *** e(...);
        public static *** w(...);
        public static *** i(...);
        public static *** d(...);
        public static *** v(...);
    }
    -assumenosideeffects class java.io.PrintStream {
        public *** print(...);
        public *** println(...);
    }
    -assumenosideeffects class java.lang.Throwable {
        public *** printStackTrace(...);
    }

   ########## sharesdk分享 ###################
      -keep class cn.sharesdk.**{*;}
      -keep class com.sina.**{*;}
      -keep class **.R$* {*;}
      -keep class **.R{*;}
      -keep class com.mob.**{*;}
      -dontwarn com.mob.**
      -dontwarn cn.sharesdk.**
      -dontwarn **.R$*
   ########## sharesdk分享-->以上内容 ########



#####################################################################################
#  end 2017/7/12 17:53
#   hao_qi blog：http://blog.csdn.net/gfg156196
#
#####################################################################################
