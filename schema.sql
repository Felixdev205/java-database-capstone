CREATE TABLE Doctor (
    id INT PRIMARY KEY IDENTITY(1,1),
    name VARCHAR(100) NOT NULL,
    specialty VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(15)
);

CREATE TABLE Patient (
    id INT PRIMARY KEY IDENTITY(1,1),
    name VARCHAR(100) NOT NULL,
    dob DATE,
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(15)
);

CREATE TABLE Appointment (
    id INT PRIMARY KEY IDENTITY(1,1),
    doctor_id INT,
    patient_id INT,
    appointment_date DATE,
    appointment_time TIME,
    status VARCHAR(50),
    FOREIGN KEY (doctor_id) REFERENCES Doctor(id),
    FOREIGN KEY (patient_id) REFERENCES Patient(id)
);

CREATE TABLE Prescription (
    id INT PRIMARY KEY IDENTITY(1,1),
    appointment_id INT,
    medicine VARCHAR(255),
    dosage VARCHAR(255),
    FOREIGN KEY (appointment_id) REFERENCES Appointment(id)
);

CREATE TABLE Token (
    id INT PRIMARY KEY IDENTITY(1,1),
    patient_id INT,
    token VARCHAR(255) UNIQUE,
    expiration DATETIME,
    FOREIGN KEY (patient_id) REFERENCES Patient(id)
);
