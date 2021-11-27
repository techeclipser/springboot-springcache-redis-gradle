CREATE TABLE IF NOT EXISTS EMPLOYEE (
    EMPLOYEE_ID              INTEGER PRIMARY KEY AUTO_INCREMENT,
    FIRST_NAME               VARCHAR(100) NOT NULL,
    LAST_NAME                VARCHAR(100) NOT NULL,
    LAST_UPDATED_BY          VARCHAR(100) NOT NULL,
    LAST_UPDATED_TS          DATETIME NOT NULL
);
CREATE TABLE IF NOT EXISTS DEPARTMENT (
    DEPARTMENT_ID          INTEGER PRIMARY KEY AUTO_INCREMENT,
    DEPARTMENT_NAME        VARCHAR(100) NOT NULL,
    LAST_UPDATED_BY          VARCHAR(100) NOT NULL,
    LAST_UPDATED_TS          DATETIME NOT NULL
);