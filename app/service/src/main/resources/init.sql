CREATE DATABASE mastermindnd;
CREATE USER dndadmin WITH PASSWORD 'dnd123';
GRANT ALL PRIVILEGES ON DATABASE mastermindnd TO dndadmin;
GRANT USAGE ON SCHEMA public TO dndadmin;
GRANT CREATE ON SCHEMA public TO dndadmin;
ALTER DATABASE mastermindnd OWNER TO dndadmin;
GRANT CONNECT ON DATABASE mastermindnd TO dndadmin;