CREATE TABLE movies (
    movie_ID VARCHAR(50) NOT NULL,
    MovieTitle VARCHAR(50) NOT NULL,
    Genre VARCHAR(50) DEFAULT NULL,
    RunTime INT DEFAULT NULL,
    PRIMARY KEY(MovieTitle)
);

INSERT INTO movies (movie_ID, MovieTitle, Genre, RunTime) VALUES (1, 'The Godfather', 'Crime', 175), (2, 'The Dark Knight', 'Action', 152), (3, 'The Wolf of Wall Street', 'Comedy', 180), (4, '
John Wick', 'Action', 101), (5, '3 Idiots', 'Comedy', 170);