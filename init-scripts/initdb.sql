-- Enable UUID extension in the default database
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Create databases
CREATE DATABASE oe;
CREATE DATABASE iam;
CREATE DATABASE cart;

-- Grant privileges
GRANT ALL PRIVILEGES ON DATABASE oe TO oeuser;
GRANT ALL PRIVILEGES ON DATABASE iam TO oeuser;
GRANT ALL PRIVILEGES ON DATABASE cart TO oeuser;

-- ============================
-- OE DATABASE
-- ============================
\connect oe;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS menu_item (
                                         id SERIAL PRIMARY KEY,
                                         name VARCHAR(255) NOT NULL UNIQUE,
    quantity INTEGER NOT NULL CHECK (quantity >= 1 AND quantity <= 20),
    category VARCHAR(50) NOT NULL,
    sugar_free BOOLEAN NOT NULL,
    gluten_free BOOLEAN NOT NULL
    );

GRANT ALL PRIVILEGES ON TABLE menu_item TO oeuser;

-- ============================
-- IAM DATABASE
-- ============================
\connect iam;

CREATE TABLE IF NOT EXISTS users (
                                     id SERIAL PRIMARY KEY,
                                     username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
    );

GRANT ALL PRIVILEGES ON TABLE users TO oeuser;

-- ============================
-- CART DATABASE
-- ============================
\connect cart;

CREATE TABLE IF NOT EXISTS cart_item (
                                         id SERIAL PRIMARY KEY,
                                         user_id INTEGER NOT NULL,
                                         menu_item_id INTEGER NOT NULL,
                                         quantity INTEGER NOT NULL
);

GRANT ALL PRIVILEGES ON TABLE cart_item TO oeuser;
