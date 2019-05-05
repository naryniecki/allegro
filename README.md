### Running tests
To run all tests:

    mvn clean test

To run GUI tests only:

    test -Dcucumber.options="--tags @gui"

To run API tests only:

    test -Dcucumber.options="--tags @gui"
    
### Test properties
See resources/tests.properties for browser configuration and API authentication settings.
 
 ```
 browser=[Chrome, Firefox]
 driver=<Path to the selenium driver, for example drivers/macos/chromedriver>
 gui_url=<Web UI URL>
 ```
 
 ```
 auth_url=<URL of auth token endpoint>
 client_id=<Client id of the registred application>
 client_secret=<Client secret of the registred application>
 api_url=<API URL>
```

### Test scenarios
Test scenarios are written with Gherking in feature files, for example: pl/allegro/qa/features/shopping_cart.feature