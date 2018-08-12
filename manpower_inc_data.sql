insert into head_hunter(id, first_name, last_name, ssn_id) 
values
(1, 'Hunter1', 'Hunter1', 'hh001'),
(2, 'Hunter2', 'Hunter2', 'hh002'),
(3, 'Hunter3', 'Hunter3', 'hh003'),
(4, 'Hunter4', 'Hunter4', 'hh004'),
(5, 'Hunter5', 'Hunter5', 'hh005'),
(6, 'Hunter6', 'Hunter6', 'hh006'),
(7, 'Hunter7', 'Hunter7', 'hh008'),
(9, 'Hunter9', 'Hunter9', 'hh009');

insert into employee_type(id, name,amount) 
values
(1,'manson',200),
(2,'carpenter',250);

insert into employee(id, first_name, last_name, ssn_id, recruited_date, employee_type_id, head_hunter_id) 
values
(1,'EMP1','EMP1', 'em001', '2018-07-02', 1, 1),
(2,'EMP2','EMP2', 'em002', '2018-08-02', 1, 1),
(3,'EMP3','EMP3', 'em003', '2018-08-03', 1, 1),
(4,'EMP4','EMP4', 'em004', '2018-08-04', 1, 1),
(5,'EMP5','EMP5', 'em005', '2018-08-05', 1, 1),
(6,'EMP6','EMP6', 'em006', '2018-08-06', 1, 1),
(7,'EMP7','EMP7', 'em007', '2018-08-07', 1, 1);