create table "films"
(
    film_id integer by default generated as identity primary key,
    title varchar(64),
    description varchar,
    releaseDate timestamp,
    durationOfFilm integer,
    peopleWhoLiked int,
    filmGenre varchar(10)
    filmMPArate varchar (5),
    foreign key (popleWhoLiked) references (all_users.user_id)
)

create table "all_users"
(
    user_id integer by default generated as identity primary key,
    name varchar(20),
    email varchar(20),
    login varchar(20),
    birthDate timestamp,
    friends int,
    likedFilms int,
    foreign key (likedFilms) references (films.film_id)
)