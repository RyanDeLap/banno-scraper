# Banno.com Web Scraper
This is a web scraper to scrape information from Banno.com

Built on Java 8, and uses the popular HTTP Client and HTML parser Jsoup.

To compile and shade libraries, use maven and run:
```
mvn clean compile assembly:single 
```

To compile without libraries and run unit tests, run: 
```
mvn clean install
```

Run the BannoWebScraper-1.0-SNAPSHOT-jar-with-dependencies.jar inside of the target folder to run the project.