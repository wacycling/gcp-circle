CREATE SCHEMA IF NOT EXISTS gcp_circle_db collate utf8_general_ci;
GRANT ALL ON gcp_circle_db.* TO gcp@'%' IDENTIFIED BY 'gcp';
