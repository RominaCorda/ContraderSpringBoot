# Capital Reporting App

### Setup

Run

    gradle bootRun
    

### DEPLOY TO BLUEMIX (DE)

    cf api https://api.eu-de.bluemix.net
    cf login --sso -o "alessiosaltarin@it.ibm.com" -s Dev
    cf push
    
#### SEE LOGS
    
    cf logs CapitalReporting
    