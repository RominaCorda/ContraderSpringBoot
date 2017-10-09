# Capital Reporting App

### Setup

Run

    gradle bootRun
    

### DEPLOY TO BLUEMIX (DE)

    cf api https://api.eu-de.bluemix.net
    cf login --sso -o "alessiosaltarin@it.ibm.com" -s Dev
    cf push
    
    
### DEPLOY TO 9 NETWORK

Application Server Console:

    http://9.137.251.187:9990 
    
Oracle 12C:

    jdbc:oracle:thin:@9.137.251.186:1521:CRDEV  
    
#### SEE LOGS
    
    cf logs CapitalReporting
    