
-- create tables

create table user_app (
	userno INT PRIMARY KEY,
	user_name VARCHAR(49),
	user_password VARCHAR(14)
);

create table recomendation_song (
	recomendation_songno INT PRIMARY KEY,
	song_name VARCHAR(39),
	song_time INT,
	author VARCHAR(49)
);

create table songlist (
	songlistno INT PRIMARY KEY,
	song_name VARCHAR(39) CHECK(song_name < 40),
	song_time INT CHECK(song_time > 0),
	author VARCHAR(49),
	id_userno INT REFERENCES user_app(userno),
	id_recomendation_songno INT REFERENCES recomendation_song(recomendation_songno)
);

create table recomendation_song_songlist (
	recomendation_song_songlistno INT PRIMARY KEY,
	id_songlistno INT REFERENCES songlist(songlistno),
	id_recomendation_songno INT REFERENCES recomendation_song(recomendation_songno)
);

create table record_song (
	recordsongno INT PRIMARY KEY,
	song VARCHAR(39),
	song_time INT
);

create table analyze_voice (
	analyzevoiceno INT PRIMARY KEY,
	id_recordsongno INT REFERENCES record_song(recordsongno)
);

create table recomendation_sing (
	recomendationsingno INT PRIMARY KEY,
	song_name VARCHAR(39) CHECK(song_name < 40),
	recomendation VARCHAR(199),
	id_analyzevoiceno INT REFERENCES analyze_voice(analyzevoiceno)
);

create table save_song (
	savesongno INT PRIMARY KEY,
	song_name VARCHAR(39) CHECK(song_name < 40),
	song_time INT CHECK(song_time > 0),
	author VARCHAR(49),
	id_userno INT REFERENCES user_app(userno),
	id_recomendationsingno INT REFERENCES recomendation_sing(recomendationsingno)
);
