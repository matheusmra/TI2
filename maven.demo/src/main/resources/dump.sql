--
-- PostgreSQL database dump
--

-- Dumped from database version 13.6 (Ubuntu 13.6-0ubuntu0.21.10.1)
-- Dumped by pg_dump version 13.6 (Ubuntu 13.6-0ubuntu0.21.10.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: usuario; Type: TABLE; Schema: public; Owner: ti2cc
--

CREATE TABLE public.locatario (
    id integer NOT NULL,
   	nome text,
    endereco text,
    sexo character(1)
);


ALTER TABLE public.locatario OWNER TO ti2cc;

--
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: ti2cc
--

ALTER TABLE ONLY public.locatario
    ADD CONSTRAINT locatario_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--
