CREATE DATABASE mini_football_db;

CREATE ROLE mini_football_db_manager WITH LOGIN PASSWORD 'ChangeMeStrongPassword!';

\connect mini_football_db

CREATE TYPE position_enum AS ENUM ('GK', 'DEF', 'MIDF', 'STR');
CREATE TYPE continent_enum AS ENUM ('AFRICA', 'EUROPA', 'ASIA', 'AMERICA');

CREATE TABLE team (
                      id SERIAL PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      continent continent_enum NOT NULL
);

CREATE TABLE player (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        age INTEGER,
                        position position_enum NOT NULL,
                        id_team INTEGER REFERENCES team(id)
);

GRANT CONNECT ON DATABASE mini_football_db TO mini_football_db_manager;
GRANT USAGE ON SCHEMA public TO mini_football_db_manager;
GRANT USAGE ON TYPE position_enum TO mini_football_db_manager;
GRANT USAGE ON TYPE continent_enum TO mini_football_db_manager;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO mini_football_db_manager;
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public TO mini_football_db_manager;

ALTER DEFAULT PRIVILEGES IN SCHEMA public
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO mini_football_db_manager;

ALTER DEFAULT PRIVILEGES IN SCHEMA public
GRANT USAGE ON SEQUENCES TO mini_football_db_manager;
