CREATE DATABASE IF NOT EXISTS VSA CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS 'vsa'@'localhost' IDENTIFIED BY 'vsa';
GRANT ALL PRIVILEGES ON VSA.* TO 'vsa'@'localhost';
FLUSH PRIVILEGES;