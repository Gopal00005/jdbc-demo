CREATE TABLE Student(
   ID   INT NOT NULL AUTO_INCREMENT,
   NAME VARCHAR(20) NOT NULL,
   AGE  INT NOT NULL,
   PRIMARY KEY (ID)
);

CREATE or update PROCEDURE demo.getCustomer(OUT firstName VARCHAR(16), IN customerId INTEGER)
BEGIN
SELECT first_name INTO firstName FROM customers WHERE id = customerId;
end;

CALL getCustomer(@firstName, 1);

SELECT @firstName;

