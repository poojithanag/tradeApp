# Trade App Tests


#### Please make sure below settings are right

Issue with IntellJ : https://intellij-support.jetbrains.com/hc/en-us/community/posts/207728949-Java-version-keeps-getting-reset-to-1-5-when-I-change-something-libraries-in-Project-Settings-
Please set Javac compiler in preferences 1.8 
LANGUAGE_LEVEL="JDK_1_8" in trade-app.iml is set to 1_8


## Commands
mvn clean install
mvn test

#### Sample test

    results for list of trades between  11/11/2017 23:11:01 | 17/11/2017 23:11:01

    Result 1, for "Print list of Inst and the volume in the specified date range" 
    InID: IN1 Quantity:   400
    
   
    Result 2, for "Print list of Inst and the volume not in the specified date range"
   
    InID: IN1 Quantity:   100
    InID: IN2 Quantity:   200
    InID: IN3 Quantity:   300
