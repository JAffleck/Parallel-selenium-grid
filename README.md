# Parallel-selenium-grid
Super-simple example of how to make WebDriver Parallel tests with Selenium grid for TestNG

## Running WebDriver Tests in Parallel using TestNG

### Download the following to C:\Selenium
1. [Download latest Selenium-server file](http://goo.gl/PJUZfa) to C:\Selenium on grid hub and all grid nodes
2. [Download Latest IEDriver](http://selenium-release.storage.googleapis.com/index.html) and [Download Latest ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/downloads) to all Grid Nodes that will run tests (and hub if it will as well)
3. Start grid nodes and hub. The simplest way on windows VM's / machines is with a batch file) see example .bat and .json files below. (I.e. On the hub, run 'C:\selenium\startHub.bat' and on Nodes 'C:\selenium\startNode.bat' [Grid configuration instructions](https://github.com/SeleniumHQ/selenium/wiki/Grid2)
4. Import `Parallel` folder into Eclipse or Intellij, and run as a TestNG test. (I assume you know how to do that already and just wanted to know how to make tests parallel (if not, please [see SeleniumSimplified videos](http://seleniumsimplified.com/get-started/) for tips on getting set up from the very basics to get this working

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
