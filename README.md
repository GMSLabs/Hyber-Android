# Hyber SDK for Android
[![Release][release-svg]][release-link]
[![Build Status][jenkins-build-status-svg]][jenkins-build-status-link]

A library that gives you access to the powerful Hyber cloud platform from your Android app.
For more information about Hyber and its features, see [hyber.im][hyber.im].
***

### Introduction
First of all you need to configure [Google Services Plugin][google-services-plugin] and [Firebase Cloud Messaging][firebase-cloud-messaging]

After that you need to initialize the Hyber inside onCreate method in your application class.
```
    buildConfigField 'String', 'HYBER_CLIENT_API_KEY', hyber_client_api_key
```

And after that you need to write next line to app level build.gradle file inside build config block
```java
    Hyber.with(this, BuildConfig.HYBER_CLIENT_API_KEY)
        .setNotificationListener(...)
        .init();
```
***

### Download
#### GRADLE
Add next repository to project level build.gradle:
```groovy
    maven { url 'https://raw.github.com/Incuube/Hyber-SDK-Android/maven/' }
```

Then add next dependencies to app level build.gradle:
```groovy
    compile 'com.hyber:hyber-messaging:2.2.0'
```

*Hyber SDK requires at minimum Java 7 or Android 4.1.*
***

### PROGUARD
If you are using Proguard in your project add the following lines to your configuration:
```proguard

```

### Logging
For manipulation with logs from library you can create a subclass ```HyberLogger.Tree```.
Example:
```java
private class CrashReportingTree extends HyberLogger.Tree {
    @Override
    protected void log(int priority, String tag, String message, Throwable t) {
        if (priority <= Log.WARN) return; else {/*Do something with error*/}
    }
}
```

[release-svg]: http://github-release-version.herokuapp.com/github/Incuube/Hyber-SDK-Android/release.svg?style=flat
[release-link]: https://github.com/Incuube/Hyber-SDK-Android/releases/latest

[jenkins-build-status-svg]: http://52.39.48.57:8080/buildStatus/icon?job=Incuube/Hyber-SDK-Android/master-2.0
[jenkins-build-status-link]: http://52.39.48.57:8080/job/Incuube/job/Hyber-SDK-Android/job/master-2.0/

[hyber.im]: https://hyber.im/
[google-services-plugin]: https://developers.google.com/android/guides/google-services-plugin
[firebase-cloud-messaging]: https://firebase.google.com/docs/cloud-messaging/android/client
