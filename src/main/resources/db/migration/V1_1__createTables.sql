CREATE TABLE skills (
id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
name VARCHAR(255),
status VARCHAR(32));

CREATE TABLE specialties (
id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
name VARCHAR(255),
status VARCHAR(32));

CREATE TABLE developers (
id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
first_name VARCHAR(255),
last_name VARCHAR(255),
specialty_id INT,
status VARCHAR(32),
FOREIGN KEY(specialty_id) REFERENCES specialties(id)
);

CREATE TABLE skills_developers(
developers_id INT NOT NULL,
skills_id INT NOT NULL,
FOREIGN KEY (developers_id) REFERENCES developers (id),
FOREIGN KEY (skills_id) REFERENCES skills (id),
UNIQUE(developers_id, skills_id));