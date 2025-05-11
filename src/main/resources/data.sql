INSERT INTO USERS (name, date_Of_Birth, password) VALUES ('Екатерина', '1993-05-01', '123');
INSERT INTO ACCOUNT (user_id, balance) VALUES ((SELECT id FROM USERS WHERE name = 'Екатерина'), 1000);
INSERT INTO EMAIL_DATA (user_id, email) VALUES (1, 'home');
UPDATE USERS SET ACCOUNT_ID = (SELECT id FROM ACCOUNT WHERE user_id = 1) WHERE id = 1;
INSERT INTO PHONE_DATA (user_id, phone) VALUES (1, '79207865432');