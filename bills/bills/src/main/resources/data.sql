INSERT INTO BILLS ( name, amount, due_date, paid) VALUES ( 'Electricity', 120.50, '2025-10-20', false);
INSERT INTO BILLS (name, amount, due_date, paid) VALUES ( 'Internet', 75.00, '2025-10-10', true);
INSERT INTO BILLS ( name, amount, due_date, paid) VALUES ( 'Water', 45.25, '2025-10-22', false);
INSERT INTO BILLS (name, amount, due_date, paid) VALUES ( 'Netflix', 18.99, '2025-10-15', false);

INSERT INTO USERS (id, username, password, role) VALUES (1, 'user1', '{noop}password1', 'USER');
INSERT INTO USERS (id, username, password, role) VALUES (2, 'user2', '{noop}password2', 'USER');

INSERT INTO USER_BILLS (user_id, bill_id) VALUES (1,1);
INSERT INTO USER_BILLS (user_id, bill_id) VALUES (1,2);
INSERT INTO USER_BILLS (user_id, bill_id) VALUES (1,3);
INSERT INTO USER_BILLS (user_id, bill_id) VALUES (2,3);
INSERT INTO USER_BILLS (user_id, bill_id) VALUES (2,4);