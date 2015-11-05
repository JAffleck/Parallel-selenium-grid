# Parallel-selenium-grid
Super-simple example of how to make WebDriver Parallel tests with Selenium grid for TestNG

## Running WebDriver Tests in Parallel using TestNG

### Download the following to C:\Selenium
1. [Download latest Selenium-server file](http://goo.gl/PJUZfa) on grid hub and all grid nodes
2. [Download Latest IEDriver](http://selenium-release.storage.googleapis.com/index.html) 
3. [Download Latest ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/downloads) to all Grid Nodes that will run tests (and hub if it will as well)
4. Configure .bat files for JSON files for HUB and Nodes, and save to C:\Selenium as shown in files below.

### Start Grid computers, and Run tests in IDE
1. Start grid nodes and hub by running corresponding batch files. On hub run 'C:\Selenium\startHub.bat'; on Nodes run 'C:\Selenium\startNode.bat'. For more detailed info see [Grid configuration instructions](https://github.com/SeleniumHQ/selenium/wiki/Grid2)
2. Import `Parallel` folder into Eclipse or Intellij, and run as a TestNG test. (I assume you know how to do that already and just wanted to know how to make tests parallel (if not, please [see SeleniumSimplified videos](http://seleniumsimplified.com/get-started/) for tips on getting set up from the very basics to get this working

**[startHub.bat]**
````batch
java -jar selenium-server-standalone-2.48.2.jar -role hub -hubConfig hubconfig.json
````

**[startNode.bat]**
````batch
@REM replace localhost with IP address of Hub Computer
java -jar selenium-server-standalone-2.48.2.jar -role node -hub http://localhost:4444/grid/register -nodeConfig nodeconfig.json
````

Replace localhost in sections below Hub's IP Address

**[hubconfig.json]**
````
{
"host": null,
"port": 4444,
"newSessionWaitTimeout": -1,
"servlets" : [],
"prioritizer": null,
"capabilityMatcher": "org.openqa.grid.internal.utils.DefaultCapabilityMatcher",
"throwOnCapabilityNotPresent": true,
"nodePolling": 5000,
"cleanUpCycle": 10000,
"timeout": 300000,"browserTimeout": 0,
"maxSession": 5,
"hubHost": "http://localhost:4444",
"role": hub
}
````

**[nodeconfig.json]**
````
{
  "capabilities":
      [
        {
          "browserName": "firefox",
          "maxInstances": 1,
          "seleniumProtocol": "WebDriver"
        },
        {
          "browserName": "chrome",
          "maxInstances": 5,
          "seleniumProtocol": "WebDriver"
        },
        {
          "platform": "WINDOWS",
          "browserName": "internet explorer",
          "maxInstances": 1,
          "seleniumProtocol": "WebDriver"
        }
      ],
  "configuration":
  {
    "proxy": "org.openqa.grid.selenium.proxy.DefaultRemoteProxy",
    "maxSession": 5,
    "port": 5555,
    "host": IP,
    "register": true,
    "registerCycle": 5000,
    "hubPort": 4444,
    "hubHost": localhost,
    "hub": "http://localhost:4444/grid/register",
    "role": "node"
  }
}
````
