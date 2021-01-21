# Hellio Messaging SMS
![](https://ibb.co/tLxfc1q)
(https://jitpack.io/#desmondcharlesboamah/helliomessaging_sms/1.0.2)


![image](https://i.ibb.co/g4P1wcS/hellio-messaging-logo-1.png)

>The Messaging API allows businesses send text messages to their customers.


This library allow you to integrate helliomessaging sms api in android application.

### Screenshot

![Image](https://i.ibb.co/4ZxvykN/Screenshot-20210121-191206.png)

### Integration

Step 1.Add it in your root build.gradle at the end of repositories:
```java
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```
Step 2. Add the dependency
```kotlin
dependencies {
  implementation 'com.github.desmondcharlesboamah:helliomessaging_sms:1.0.2'
}
```

Step 3. Add to your manifest
```java
<uses-permission android:name="android.permission.INTERNET" />
```
Step 4. Add to your activity
Call sendSMS() in your main thread, the function return response and message as a callback
```java
class MainActivity : AppCompatActivity() {

		override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_main)

       sendSMS( PHONE_NUMBER, CLIENT_ID, APPLICATION_SECRET, SENDER_ID, MESSAGE){response, message ->
						Log.d("TAG","response=$response message=$message")
			}
   }
}
```

