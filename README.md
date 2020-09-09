# my-small-satellite

A coding challenge solution `my-small-satellite`



#### Requirements
- [maven 3](http://maven.apache.org/download.cgi)
- [openjdk-8](https://openjdk.java.net)
- [git](https://git-scm.com)

#### Quick start
- clone the repository
```bash
git clone https://code.poweronoff.click/steam/my-small-satellite.git
```
#####Test
To test the application you can run the following command in the application directory:
````bash
mvn clean verify
````

#####Build
To build the application you can run the following command in the application directory:
````bash
mvn clean package
````

#####Configure
You have to configure the application. To do this, you have to create application.properties with following content in a same directory wit your JAR file.
```
# configuration for the json data storage relative path
storage.file.path=json/source-data.json
``` 
Please replace the value of `storage.file.path` with your own. You can use relative and absolute path to your source-data.json file

#####How to run
```bash
java -jar my-small-satellite-<Version>.jar
```

####API Documentation
you can reach the REST-API under port `8080` on the `localhost`

#####List of features 
```bash
GET http://localhost:8080/features
```
This call will return a list of features as json in following format:
```json
[
    {
        "id": "39c2f29e-c0f8-4a39-a98b-deed547d6aea",
        "timestamp": 1554831167697,
        "beginViewingDate": 1554831167697,
        "endViewingDate": 1554831202043,
        "missionName": "Sentinel-1B"
    },
    {
        "id": "cf5dbe37-ab95-4af1-97ad-2637aec4ddf0",
        "timestamp": 1556904743783,
        "beginViewingDate": 1556904743783,
        "endViewingDate": 1556904768781,
        "missionName": "Sentinel-1B"
    }
...
]
```
#####One special feature representation
```bash
GET http://localhost:8080/features/{id}
```
where `id` is a feature ID. This call will return a single representation for the given feature ID in following format:
```json
{
  "id": "39c2f29e-c0f8-4a39-a98b-deed547d6aea",
  "timestamp": 1554831167697,
  "beginViewingDate": 1554831167697,
  "endViewingDate": 1554831202043,
  "missionName": "Sentinel-1B"
}
```

#####Image for the single feature
```bash
GET http://localhost:8080/features/{id}/quicklook
```
This call will return a picture for the given feature ID


Enjoy ٩(◕‿◕｡)۶



