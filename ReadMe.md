# PSPOS Product Catalog Microservice Readme
### Installation and Setup Guide
### This readme provides step-by-step instructions for setting up and deploying the PSPOS Product Catalog Microservice.

## Prerequisites
    Java Development Kit (JDK) version 8 or higher installed on your system.
    Apache Maven for building and managing dependencies.
    MySQL or PostgreSQL database server.
    Apache Solr for search engine functionality.
## Installation Steps
### Database Setup:

    Create a new database for the microservice in your MySQL or PostgreSQL server.
    Update the database configuration in src/main/resources/application.properties file with your database credentials and connection details.

### Solr Setup:
    Download and install Apache Solr from the official website.
    Create a new Solr core for the microservice using the Solr Admin UI or command line.
    Define the schema.xml file for the core to map relevant product attributes.
    Update Solr configuration in src/main/resources/application.properties with the Solr server URL and core name.

### Build and Run:

    Build the microservice using Maven:
    mvn clean package
    Run the microservice:
    java -jar target/pspos-product-catalog-microservice.jar
### API Documentation:
    Upload File Endpoint

    URL: POST /upload
    Description: Endpoint for uploading a CSV or TSV file.
    Request Parameters:
    file: Multipart file containing the data to be processed.
    Request Body:
    None
    Response:
    Status Code:
    200 OK if the file is processed successfully.
    400 Bad Request if the file is empty or of invalid type.
    Body:
    For successful processing, returns a Response object with a success message.
    For empty or invalid files, returns a Response object with an appropriate error message.
    Get Data Endpoint

    URL: GET /search
    Description: Endpoint for searching data in Apache Solr based on provided search criteria.
    Request Parameters:
    None
    Request Body:
    productDto: DTO object containing search criteria.
    Response:
    Status Code:
    200 OK if the search is successful.
    Body:
    Returns a SolrDocumentList containing the search results.
    Throws SolrServerException or IOException if an error occurs during the search process.
### Testing:
    Test the file upload functionality by sending a POST request to the /upload endpoint with a TSV/CSV file.
    Use the search API endpoints to test product search functionality.