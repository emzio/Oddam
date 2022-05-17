INSERT INTO institution (name, description) VALUES ('Avalon', 'Subkonta dla osób');
INSERT INTO institution (name, description) VALUES ('Promyk', 'Dzieci');
INSERT INTO institution (name, description) VALUES ('Emigrant', 'pomoc');
INSERT INTO institution (name, description) VALUES ('Lekarze bez granic', 'medycyna');
INSERT INTO institution (name, description) VALUES ('Czytamy!!!', 'promowanie czytelnictwa');


INSERT INTO donation (city, pick_up_comment, picked_up_date, picked_up_time, quantity, street, zip_code, institution_id) VALUES ('Warsaw', null, '1970-01-01', '2022-05-04', 12, 'Brzozowa', '01-0345', 1);
INSERT INTO donation (city, pick_up_comment, picked_up_date, picked_up_time, quantity, street, zip_code, institution_id) VALUES ('Kraków', 'broken', '1970-01-01', '18:10', 14, 'Wadliwa', '01-023', 2);

INSERT INTO CharityDonation.category (name) VALUES ('buty');
INSERT INTO CharityDonation.category (name) VALUES ('książki');
INSERT INTO CharityDonation.category (name) VALUES ('ubrania');
INSERT INTO CharityDonation.category (name) VALUES ('meble');

