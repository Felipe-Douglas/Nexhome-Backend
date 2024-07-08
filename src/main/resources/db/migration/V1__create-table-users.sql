CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(60) NOT NULL,
    email VARCHAR(220) NOT NULL,
    pass VARCHAR(30) NOT NULL,
    role SMALLINT NOT NULL
);

CREATE TABLE properties(
    id SERIAL PRIMARY KEY,
    name VARCHAR(220) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    description TEXT,
    image TEXT
);