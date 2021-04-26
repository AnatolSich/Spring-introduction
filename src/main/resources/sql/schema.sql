CREATE TABLE public.user
(
    id BIGINT NOT NULL,
    name VARCHAR(40) NOT NULL,
    email VARCHAR(30),
    PRIMARY KEY (id)
);

CREATE TABLE public.user_account
(
    user_id BIGINT NOT NULL,
    score FLOAT NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE public.event
(
    id BIGINT NOT NULL,
    title VARCHAR(32) NOT NULL,
--    date TIME,
   date TIMESTAMP WITHOUT TIME ZONE,
    price FLOAT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.ticket
(
    id BIGINT NOT NULL,
    event_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    category VARCHAR(15),
    place INTEGER,
    PRIMARY KEY (id),
    FOREIGN KEY (event_id) REFERENCES public.event (id),
    FOREIGN KEY (user_id) REFERENCES public.user (id)
);
