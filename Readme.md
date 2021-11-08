
############################# LocalMachine ###################
How to run UI tests on local machine 

To run test on local machine follow the steps:

1) Need to have chrome installed - check the verion
2) Need maven installed
3) Need java Installed
4) chrome driver installed with respective to your chrome on your local machine version
5) Clone Code from git hub and chnage chrome driver in JArs folder if its 96 version of chrom driver which is suitable to you browser version
6) need to update the jar file location in the Java class -Baset Test (Src->Stepdefinations->BaseTest)
   // System.setProperty("webdriver.chrome.driver", "jars\\chromedriver95.exe");  change the chrome driver name to reflect the new driver version

open terminal from the project folder and type :
mvn clean "-Dcucumber.options=--tags  @gui_basket_registerUSer" -Dbrowser=chrome-local install

################################### API ##########################

open terminal from the project folder and type :

mvn clean "-Dcucumber.options=--tags @Api" -Dbrowser=API install

################################### BrowserSTack #######################
The username and password on browser stack had been created on free trial, and it may be valid for a week to run tests
To run test on Browser stack cloud  follow the steps:

open terminal from the project folder and type :

mvn clean "-Dcucumber.options=--tags  @gui_basket_registerUSer" -Dbrowser=chrome install


to check the results on browserstack login with username and password
https://automate.browserstack.com/dashboard/

Username: catchmeatsuneethan@gmail.com
Password :Tester1@369

####  by default the tests wil run on windows machine in Browserstack




