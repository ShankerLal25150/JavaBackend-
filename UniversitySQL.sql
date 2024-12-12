CREATE DATABASE university_management;

USE university_management;

CREATE TABLE Departments (
    department_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    building VARCHAR(50),
    head_of_department INT DEFAULT NULL
);

CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15),
    user_type ENUM('student', 'teacher', 'staff') NOT NULL,
    department_id INT DEFAULT NULL,
    FOREIGN KEY (department_id) REFERENCES Departments(department_id)
);

CREATE TABLE Teachers (
    teacher_id INT PRIMARY KEY,
    designation VARCHAR(50),
    qualification VARCHAR(100),
    FOREIGN KEY (teacher_id) REFERENCES Users(user_id)
);

CREATE TABLE Students (
    student_id INT PRIMARY KEY,
    enrollment_year YEAR NOT NULL,
    major VARCHAR(100),
    FOREIGN KEY (student_id) REFERENCES Users(user_id)
);

CREATE TABLE Staff (
    staff_id INT PRIMARY KEY,
    job_title VARCHAR(50),
    salary DECIMAL(10, 2),
    FOREIGN KEY (staff_id) REFERENCES Users(user_id)
);

CREATE TABLE Courses (
    course_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    credits INT NOT NULL,
    department_id INT,
    teacher_id INT,
    FOREIGN KEY (department_id) REFERENCES Departments(department_id),
    FOREIGN KEY (teacher_id) REFERENCES Teachers(teacher_id)
);

CREATE TABLE Enrollments (
    enrollment_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    course_id INT,
    enrollment_date DATE,
    grade VARCHAR(2),
    FOREIGN KEY (student_id) REFERENCES Students(student_id),
    FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);

CREATE TABLE Classrooms (
    classroom_id INT AUTO_INCREMENT PRIMARY KEY,
    room_number VARCHAR(10) NOT NULL,
    building VARCHAR(50),
    capacity INT NOT NULL
);

CREATE TABLE Schedules (
    schedule_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT,
    teacher_id INT,
    classroom_id INT,
    day_of_week ENUM('Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday'),
    time_start TIME,
    time_end TIME,
    FOREIGN KEY (course_id) REFERENCES Courses(course_id),
    FOREIGN KEY (teacher_id) REFERENCES Teachers(teacher_id),
    FOREIGN KEY (classroom_id) REFERENCES Classrooms(classroom_id)
);

ALTER TABLE Departments 
ADD CONSTRAINT fk_head_of_department 
FOREIGN KEY (head_of_department) REFERENCES Teachers(teacher_id);
