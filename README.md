# Banno.com Web Scraper
This is a web scraper to scrape information from Banno.com

Built on Java 8, and uses the popular HTTP Client and HTML parser Jsoup.


Expected output:
```
================[Banno Web Scraper]================
 Twitter: @bannoJHA
 Products Offered: 2
 Images: 26
 "Financial Institution" appears 5 times in the HTML
 Top 3 characters within the HTML page are:
  * Character: 1 Count: 6764
  * Character: 3 Count: 6140
  * Character: 0 Count: 5744

```
To compile and shade libraries, use maven and run:
```
mvn clean compile assembly:single 
```

To compile without libraries and run unit tests, run: 
```
mvn clean install
```

Run the BannoWebScraper-1.0-SNAPSHOT-jar-with-dependencies.jar inside of the target folder to run the project.