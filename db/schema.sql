CREATE TYPE IF NOT EXISTS position_enum AS ENUM ('GK','DEF','MIDF','STR');
CREATE TYPE IF NOT EXISTS continent_enum AS ENUM ('AFRICA','EUROPA','ASIA','AMERICA');

CREATE TABLE IF NOT EXISTS team (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  continent continent_enum NOT NULL
);

CREATE TABLE IF NOT EXISTS player (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  age INTEGER,
  position position_enum NOT NULL,
  id_team INTEGER REFERENCES team(id)
);
