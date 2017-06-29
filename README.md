# JLiuTest

1 install maven, update system env to include maven bin dir, eg "D:\Program\apache-maven-3.3.3\bin" ( https://archive.apache.org/dist/maven/maven-3/3.3.3/binaries/ )

2 copy geckodriver.exe to driver (download from https://github.com/mozilla/geckodriver/releases/download/v0.17.0/geckodriver-v0.17.0-win64.zip)

3 run test

    #run all test
    mvn test

    #run test of a test class
    mvn -Dtest=RadioPageTest

    #run a single test method
    mvn -Dtest=RadioPageTest#testFBShare test
 
    #Specify test env
    mvn -DpropDomain="abc.com" -Dtest=APITest test	#default program.abcradio.net.au
