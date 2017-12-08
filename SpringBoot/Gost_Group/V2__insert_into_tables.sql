TRUNCATE TABLE departments CASCADE;
insert into departments(type) VALUES
  ('cushioned'), ('store'), ('office');

-- =========
TRUNCATE TABLE employees CASCADE;
insert into employees(full_name, depart_id) VALUES
  ('Hermie Indonesia Stannislawski', 1),
  ('Karita Greece Adriani', 1),
  ('Bevin Bangladesh Tremouille', 1),
  ('Bond Mexico Elies', 1),

  ('Aubert Indonesia Spellacey', 2),
  ('Ynez Brazil Pailin', 2),
  ('Athena Azerbaijan Dunklee', 2),

  ('Aggi Thailand Immings', 3),
  ('Natale Portugal Ditt', 3),
  ('Olva Sweden Falcus', 3),
  ('Angelique Iraq Mityukov', 3);

-- =========
TRUNCATE TABLE client_orders CASCADE;
insert into
  client_orders(name, order_date, finish_till, depart_id, employee_id) VALUES
  ('Ischaemum byrone (Trin.) Hitchc.', current_timestamp, current_timestamp + interval '8 day', 1, null),
  ('Thurovia triflora Rose', current_timestamp, current_timestamp + interval '3 day', null, 2),
  ('Nonea vesicaria (L.) Rchb.', current_timestamp - INTERVAL '5 day', current_timestamp + interval '3 day', 1, null),
  ('Indigofera kirilowii Maxim. ex Palib.', current_timestamp - INTERVAL '5 day', current_timestamp, 1, null),

  ('Eucalyptus nitida Hook. f.', current_timestamp - INTERVAL '5 day', current_timestamp + interval '3 day', 2, null),
  ('Hibiscadelphus ×puakuahiwi K. Baker & S. Allen', current_timestamp , current_timestamp + interval '3 day', 2, null),
  ('Dissotis rotundifolia (Sm.) Triana', current_timestamp - INTERVAL '2 day', current_timestamp, null, 6),

  ('Penstemon heterodoxus A. Gray', current_timestamp - INTERVAL '2 day', current_timestamp, 3, null),
  ('Hypnum revolutum (Mitt.) Lindb.', current_timestamp - INTERVAL '2 day', current_timestamp, 3, null),
  ('Spergularia macrotheca (Hornem.)', current_timestamp, current_timestamp + interval '1 day', null, 11);
