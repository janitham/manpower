insert into head_hunter(first_name, last_name, ssn_id) 
values
('Hunter1', 'Hunter1', 'hh001'),
('Hunter2', 'Hunter2', 'hh002'),
('Hunter3', 'Hunter3', 'hh003'),
('Hunter4', 'Hunter4', 'hh004'),
('Hunter5', 'Hunter5', 'hh005'),
('Hunter6', 'Hunter6', 'hh006'),
('Hunter7', 'Hunter7', 'hh007');

insert into employee_type(name,amount) 
values
('manson',200),
('carpenter',250);

insert into employee(first_name, last_name, ssn_id, recruited_date, employee_type_id, head_hunter_id) 
values
('EMP1','EMP1', 'em001', '2018-06-02', 1, 1),
('EMP2','EMP2', 'em002', '2018-07-02', 1, 1),
('EMP3','EMP3', 'em003', '2018-07-03', 1, 1),
('EMP4','EMP4', 'em004', '2018-07-04', 1, 1),
('EMP5','EMP5', 'em005', '2018-07-05', 1, 1),
('EMP6','EMP6', 'em006', '2018-07-06', 1, 1),
('EMP7','EMP7', 'em007', '2018-07-07', 1, 1);


