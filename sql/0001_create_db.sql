CREATE USER tob_dev WITH PASSWORD 'tob_dev';
CREATE SCHEMA IF NOT EXISTS tob_dev AUTHORIZATION tob_dev;
ALTER DATABASE tob_dev SET search_path = tob_dev;