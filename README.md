## shopify-inventory
### Shopify Technical Challenge Submission

#### Developer : Archana Miyar Kamath <br />
#### [LinkedIn](https://www.linkedin.com/in/archana-kamath-018/)<br />
#### Application video demonstration - [Link](https://drive.google.com/file/d/10nxelN67LGNXgqxTXyzKVWGoDIDfjEEV/view?usp=sharing)<br />

#### User features <br />
•	Add item details to the database along with an image of item.<br />
•	Delete item details from database. <br />
•	Update item details in the database.<br />
•	List all the item details with a link to view the picture of item.<br />
•	Uploaded image is saved and can be viewed on view page.  <br />
2nd Option from feature list provided  - Allow image uploads and store image with generated thumbnails.<br />
The images are saved in Amazon S3 bucket and are displayed in the View Page via Amazon CloudFront.<br />

#### Tools and technologies:
AWS  Amazon S3, Amazon CloudFront,  Amazon RDS (MySQL) <br />
Backend: Spring Boot, Java 11<br />
Frontend: React, Bootstrap<br />
AWS SDK and AWS Eclipse Toolkit, Visual Studio Code, Ecplise, Beyond Compare, MySQL, Notepad++<br />


#### Steps to set up the application <br /><br />
Download and install Java 11 and Maven. Set JAVA_HOME and MAVEN_HOME in environment variables.<br />
Download and install npm and node.<br />
Download and install git. Set up Eclpise and Visual studio <br />

#### Steps to launch Reach Application<br />
Do git init and clone the repository.<br />
Navigate to shopify-ui in terminal and run the below commands to download all the node modules and run the React Application - http://localhost:3000/<br />
npm install<br />
npm start<br />
<br />
#### Steps to launch Spring Boot Application<br />
Open Eclipse, import shopifyapp as an existing maven project.
Go to application.properties file and add AWS ID and Secret Key to connect to the MySQL database on Amazon RDS.<br />
Enter the MySQL datasource URL, database username and password. <br />
Navigate to the below path and select the class, Right click -> Run As -> Java Application<br />
Application class - /shopifyapp/src/main/java/com/shopify/shopifyapp/ShopifyappApplication.java<br />
Spring Boot Application is configured to run on post 8082 - http://localhost:8082<br />

#### Possible errors
1)If you get a main class not found error, do a Maven update. <br />
2)Change the port if the above mentioned ports are not available.<br />

#### Backend code includes <br />
1) Validation<br />
2) Exception handling<br />
3) Test cases (Positive and negative)<br />

#### Action Items
1) The application can be deployed on EC2(backend) and S3(Frontend).<br />
2) To add more valiations.<br />
3) Write more test cases to increase the coverage.<br />

#### Screenprint of Application 

![alt text](https://github.com/archana-kamath/shopify-inventory/blob/main/screenprint/Add.JPG?raw=true)

![alt text](https://github.com/archana-kamath/shopify-inventory/blob/main/screenprint/Delete.JPG?raw=true)

![alt text](https://github.com/archana-kamath/shopify-inventory/blob/main/screenprint/Update.JPG?raw=true)

![alt text](https://github.com/archana-kamath/shopify-inventory/blob/main/screenprint/View.JPG?raw=true)
