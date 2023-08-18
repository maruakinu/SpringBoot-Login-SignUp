# SpringBoot Login and SignUp Features + Security with JWT

INSTRUCTIONS

IDE for Java SpringBoot, MySQL and API testing tool are required for this project

API TESTING ( Open your API Testing Tool )

1. User Register

        POST METHOD
        localhost:8080/users

         {
            "user": {
              "username": "johndoe",
              "email": "johndoe@gmail.com",
              "password": "123456"
            }
          }

2. User Login

        POST METHOD
        localhost:8080/users/login

         {
            "user": {
              "email": "johndoe@gmail.com",
              "password": "123456"
            }
          }

-------------------------------------------------------

        OUTPUT

       {
          "id": "f2e69e00-07ba-47e6-9858-93d8dbd944c1",
          "username": "johndoe",
          "email": "johndoe@gmail.com",
          "password": "$2a$10$LQacKGpysknMaRxe2/RFTOTuVBmBbHwHRYe804xvYQEU/tdU/YoOS",
          "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtYXJsb0BnbWFpbC5jb20iLCJpYXQiOjE2OTIzNDEzOTQsImV4cCI6MTY5MjM0NDk5NH0.JxQg1CiTo-ZEhXjL1vLHyutJ62V6PbKw5zzLKZf1Y8Y"
       }








