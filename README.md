### Running tests
To run all tests:

    mvn clean test

To run GUI tests only(sometimes fails when "random" add window pops up:

    mvn test -Dcucumber.options="--tags @gui"

To run API tests only(not all steps are implemented:

    mvn test -Dcucumber.options="--tags @api"
    
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

### Test reports
Reports are saved to reports/ directory, available are:
- HTML - index.html
- JSON - tests.json
- JUNIT - tests.xml

If the GUI test fails, screen shot taken on failure is included. 
