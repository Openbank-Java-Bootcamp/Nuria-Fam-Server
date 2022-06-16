# Fam-Server
## Description of the project
For the final project, I created an application to manage restaurant menus and employees.

There are three types of users: restaurant owners, users and anonymous.

The restaurant owner can create restaurants with all the information that the customers need, plates and drinks grouped by categories and employees.
This way the owner can customize the menu with new plates and drinks, and it will always be up to date.
It is also possible to update the information of the restaurant, plates, drinks and employees and delete them if the owner wants.
The restaurant list the owners can see, will only show their restaurants so it is easier to manage them.

The user can see a list of all the restaurants in the application and to find the restaurant faster, a search bar is available.
They can also see the menus of each of them with images and click on the plates and drinks if they want more information, like the ingredients and price.
Only the users can rate the restaurant, so they que give feedback to the owner.

And the anonymous can see everything the user can, but they can't rate the restaurant.
These type of users do not have an account in the application.

With this application customers will have all the menus in one location and they will not have look for it on the internet, scan a qr or have an application for every restaurant.
And the can also see photos os everything and all the informations they need.

## User Stories
**Owner**
- As an owner I want to create, update and delete restaurants in order to manage all my restaurants.
- As an owner I want to see a list of only my restaurants in order to manage them.
- As an owner I want to create plate and drink categories in order to organize the plates and drinks by categories.
- As an owner I want to create, update, and delete plates and drinks in order to manage the menu.
- As an owner I want to create, update and delete employees in order to manage the employees.

**User**
- As a user I want to edit my information in order to update the profile.
- As a user I want to see a list of all the restaurants in order to choose the one I want to see.
- As a user I want to see one restaurant in order to have all the information.
- As a user I want to see a list of all the plates and drinks in order to see all the menu.
- As a user I want to see a plate or a drink in order to have all the information.
- As a user I want to rate and see the rating of a restaurant in order to know what the people think.
- As a user I want to search a restaurant in order to find it faster.

**Anonymous**
- As an anon I want to see a list of all the restaurants in order to choose the one I want.
- As an anon I want to see one restaurant in order to have all the information.
- As an anon I want to see a list of all the plates and drinks in order to see all the menu.
- As an anon I want to see a plate or a drink in order to have all the information.
- As an anon I want to search a restaurant in order to find it faster.

## Technologies Used
**Spring Boot**

Spring Boot is a technology that help us create self-contained applications, this way we can focus on the development.

**Hibernate & JPA**

For the database communications.
- Hibernate provides a framework for mapping an object-oriented domain model to a relational database.
- JPA is a Jakarta EE application programming interface specification that describes the management of relational data in enterprise Java applications.

## Models
- Role (id, name, users)
- User (id, name, email, password, image, role, restaurants)
- Restaurant (id, name, phone, image, address, user, plates, drinks, emloyees, ratings)
- Employee (id, name, phone, jobTitle, image, restaurant)
- Rating (id, rating, restaurant)
- Plate (id, name, ingredients, price, image, category)
- PlateCategory (id, name, restaurant, plates)
- Drink (id, name, information, price, image, category)
- DrinkCategory (id, name, restaurant, drinks)
- Address embeddable class (street, number, city, country)

## Server Routes
http://localhost:5005

**User**
| Method | Route                | Description                        |
|--------|----------------------|------------------------------------|
| POST   | /api/auth/signup     | Create a new account               |
| GET    | /api/auth/users/{id} | Get the information of one user    |
| PUT    | /api/auth/users/{id} | Update the information of one user |
| DELETE | /api/auth/users/{id} | Delete a user                      |

**Role**
| Method | Route                | Description                      |
|--------|----------------------|----------------------------------|
| POST   | /api/roles/addtouser | Add a role to the user           |

**Restaurant**
| Method | Route                        | Description                              |
|--------|------------------------------|------------------------------------------|
| POST   | /api/restaurants             | Create a restaurant                      |
| GET    | /api/restaurants             | Get all the restaurants                  |
| GET    | /api/restaurants/{id}        | Get the information of one restaurant    |
| GET    | /api/restaurants/userid/{id} | Get the restaurants of one user          |
| PUT    | /api/restaurants/{id}        | Update the information of one restaurant |
| DELETE | /api/restaurant/{id}         | Delete a restaurant                      |

**Employee**
| Method | Route               | Description                            |
|--------|---------------------|----------------------------------------|
| POST   | /api/employees      | Create an employee                     |
| GET    | /api/{id}/employees | Get employees of one restaurant        |
| GET    | /api/employees/{id} | Get the information of one employee    |
| PUT    | /api/employees/{id} | Update the information of one employee |
| DELETE | /api/employees/{id} | Delete an employee                     |

**Rating**
| Method | Route               | Description                            |
|--------|---------------------|----------------------------------------|
| POST   | /api/ratings        | Create a rating                        |
| GET    | /api/{id}/ratings   | Get ratings of one restaurant          |

**Plate Category**
| Method | Route                   | Description                            |
|--------|-------------------------|----------------------------------------|
| POST   | /api/platecategory      | Create a plate category                |
| GET    | /api/{id}/platecategory | Get plate categories of one restaurant |

**Plate**
| Method | Route                     | Description                         |
|--------|---------------------------|-------------------------------------|
| POST   | /api/plates               | Create a plate                      |
| GET    | /api/plates/category/{id} | Get plates of one category          |
| GET    | /api/plates/{id}          | Get the information of one plate    |
| PUT    | /api/plates/{id}          | Update the information of one plate |
| DELETE | /api/plates/{id}          | Delete a plate                      |

**Drink Category**
| Method | Route                   | Description                            |
|--------|-------------------------|----------------------------------------|
| POST   | /api/drinkcategory      | Create a drink category                |
| GET    | /api/{id}/drinkcategory | Get drink categories of one restaurant |

**Drink**
| Method | Route                     | Description                         |
|--------|---------------------------|-------------------------------------|
| POST   | /api/drinks               | Create a drink                      |
| GET    | /api/drinks/category/{id} | Get drinks of one category          |
| GET    | /api/drinks/{id}          | Get the information of one drink    |
| PUT    | /api/drinks/{id}          | Update the information of one drink |
| DELETE | /api/drinks/{id}          | Delete a drink                      |

## Future work
For future work I would like to create menus, like night menus, weekend menus, this way the owners would add plates and drinks and put a price for the menu.
Add comments, so the users can add more feedback and the owners will know what they think about their restaurants.

Also work on the design for the user experience and make it responsive, for mobiles and tablets and try to put the dark mode.

## Resources
Link to the [Trello](https://trello.com/invite/b/dY098zTk/8f889a099ca009a7e1f5582c379e9d72/final-project) board.

Thank you Raymond and Shaun for all the help during this project.
