# Android SDK Boilerplate

This project is the boilerplate of REST API based Android SDK/library.
The example of one REST API based SDK is [Microsoft Cognitive Face SDK](https://github.com/microsoft/Cognitive-Face-Android).

# How SDK users will use it

Users can use it as follows:

### Initialize the SDK with an APK key:
```java
SystangoRestClient systangoRestClient = new SystangoRestClient("{{API_KEY}}");
```

### Call any method according the the feature:
```java
systangoRestClient.feature1Method("value1", this);
```
where `value1` is the parameter from user and `this` is the callback

### Receive the result in callback:
```java
@Override
    public void onFeature1Response(SampleResponse sampleResponse) {
        if (sampleResponse.getError() != null) {
            //Use sampleResponse here
            String sampleField = sampleResponse.getBaseField();
        } else {
            //Handle error case here
            Toast.makeText(this, sampleResponse.getError(), Toast.LENGTH_LONG).show();
        }
    }
```

The example of SDK usage is demonstrated in [ExampleActivity](https://github.com/SystangoTechnologies/Android-SDK-Boilerplate/blob/master/app/src/main/java/com/systango/boilerplate/activity/ExampleActivity.java).
