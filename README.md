# Sports Event Calendar


## About

**Sports Event Calendar** is a web app built with **Spring Boot** and **MySQL** to help you manage and keep track of sports events. Whether you're organizing local football matches or ice hockey tournaments, this calendar makes it easy to view, add, and manage your events.

## Features

- **View All Events:** See a list of all scheduled sports events.
- **View Single Event:** Get details about a specific event.
- **Create New Event:** Easily add new events with all the necessary info.
- **Manage Sports, Teams, and Venues:** Add, edit, or remove sports, teams, and venues.
- **Fast Data Retrieval:** Optimized queries to keep things running smoothly.
- **Validation and Error Handling:** Ensures your data is correct and handles errors gracefully.

## Tech Stack

- **Java 17**
- **Spring Boot 3.3.5**
- **Spring Data JPA**
- **Hibernate ORM**
- **MySQL 8**
- **Lombok**
- **Maven**
- **Postman** (for testing)

## Database Schema

### Sport

| Column   | Type         | Description                |
|----------|--------------|----------------------------|
| sport_id | INT (PK)     | Primary key, auto-increment |
| name     | VARCHAR(100) | Name of the sport          |

### Team

| Column     | Type         | Description                        |
|------------|--------------|------------------------------------|
| team_id    | INT (PK)     | Primary key, auto-increment        |
| name       | VARCHAR(100) | Name of the team                    |
| _sport_id  | INT (FK)     | References Sport(sport_id)          |

### Venue

| Column   | Type         | Description                       |
|----------|--------------|-----------------------------------|
| venue_id | INT (PK)     | Primary key, auto-increment       |
| name     | VARCHAR(100) | Name of the venue                 |
| address  | VARCHAR(255) | Address of the venue              |
| capacity | INT          | Seating capacity of the venue     |

### Event

| Column        | Type         | Description                           |
|---------------|--------------|---------------------------------------|
| event_id      | INT (PK)     | Primary key, auto-increment           |
| date_time     | DATETIME     | Date and time of the event            |
| _sport_id     | INT (FK)     | References Sport(sport_id)            |
| _venue_id     | INT (FK)     | References Venue(venue_id)            |
| _home_team_id | INT (FK)     | References Team(team_id)              |
| _away_team_id | INT (FK)     | References Team(team_id)              |
| description   | TEXT         | Description of the event              |

## API Endpoints

### Events

- **Get All Events**
  - **GET** `/api/events`
  - **Description:** Retrieves all sports events.
  - **Response:** JSON array of events.

- **Get Event by ID**
  - **GET** `/api/events/{id}`
  - **Description:** Retrieves a specific event by ID.
  - **Response:** JSON object of the event.
  - **Error:** 404 if not found.

- **Create New Event**
  - **POST** `/api/events`
  - **Description:** Adds a new sports event.
  - **Body:**
    ```json
    {
      "date_time": "2024-11-08T20:00:00",
      "sport_id": 1,
      "venue_id": 1,
      "home_team_id": 1,
      "away_team_id": 2,
      "description": "New Football Match"
    }
    ```
  - **Response:** JSON object of the created event.
  - **Error:** 400 if input is invalid.

## Getting Started

### Prerequisites

- **Java 17** or higher
- **Maven**
- **MySQL Server** running
- **IntelliJ IDEA** or another IDE
- **Postman** for testing

### Installation

1. **Clone the Repo**
   ```bash
   git clone https://github.com/your-username/sports-calendar.git
   cd sports-calendar
   ```

2. **Set Up the Database**
   - Start MySQL.
   - Create the `sports_calendar` database and tables.
   - Add sample data as per [Database Schema](#database-schema).

3. **Configure Application**
   - Open `src/main/resources/application.properties`.
   - Update with your MySQL credentials:
     ```properties
     spring.application.name=sports-calendar

     spring.datasource.url=jdbc:mysql://localhost:3306/sports_calendar?useSSL=false&serverTimezone=UTC
     spring.datasource.username=root
     spring.datasource.password=weissenbach

     spring.jpa.hibernate.ddl-auto=none
     spring.jpa.show-sql=true
     spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
     ```

4. **Build the Project**
   ```bash
   mvn clean install
   ```

### Running the Application

1. **Via IDE**
   - Open in IntelliJ IDEA.
   - Run `SportsCalendarApplication.java`.

2. **Via Command Line**
   ```bash
   mvn spring-boot:run
   ```

3. **Access the API**
   - Open browser or Postman.
   - Go to `http://localhost:8080/api/events`.

## Testing

### Using Postman

1. **Get All Events**
   - **Method:** `GET`
   - **URL:** `http://localhost:8080/api/events`
   - **Response:** List of events.

2. **Get Event by ID**
   - **Method:** `GET`
   - **URL:** `http://localhost:8080/api/events/1`
   - **Response:** Event details.

3. **Create New Event**
   - **Method:** `POST`
   - **URL:** `http://localhost:8080/api/events`
   - **Headers:** `Content-Type: application/json`
   - **Body:**
     ```json
     {
       "date_time": "2024-11-08T20:00:00",
       "sport_id": 1,
       "venue_id": 1,
       "home_team_id": 1,
       "away_team_id": 2,
       "description": "New Football Match"
     }
     ```
   - **Response:** Created event.

### Using cURL

1. **Get All Events**
   ```bash
   curl -X GET http://localhost:8080/api/events
   ```

2. **Get Event by ID**
   ```bash
   curl -X GET http://localhost:8080/api/events/1
   ```

3. **Create New Event**
   ```bash
   curl -X POST http://localhost:8080/api/events \
   -H "Content-Type: application/json" \
   -d '{
     "date_time": "2024-11-08T20:00:00",
     "sport_id": 1,
     "venue_id": 1,
     "home_team_id": 1,
     "away_team_id": 2,
     "description": "New Football Match"
   }'
   ```

### Verify in MySQL

1. **Login to MySQL**
   ```bash
   mysql -u root -p
   ```

2. **Use Database**
   ```sql
   USE sports_calendar;
   ```

3. **Check Events**
   ```sql
   SELECT * FROM Event;
   ```

## Contributing

Contributions are welcome! Follow these steps:

1. **Fork the Repo**
2. **Create a Branch**
   ```bash
   git checkout -b feature/YourFeature
   ```
3. **Commit Changes**
   ```bash
   git commit -m "Add new feature"
   ```
4. **Push to Branch**
   ```bash
   git push origin feature/YourFeature
   ```
5. **Create a Pull Request**

Make sure your code follows the project's standards and includes tests.

## License

This project is licensed under the [MIT License](LICENSE). Feel free to use, modify, and distribute as per the license terms.

## Contact

**Mervan Polat**  
Email: [mervanpolat@icloud.com.com](mailto:mervanpolat@icloud.com)  
LinkedIn: [linkedin.com/in/mervanpolat](https://linkedin.com/in/mervanpolat)  
