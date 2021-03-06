PGDMP     $                    x           progetto    12.2    12.2 z    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    25127    progetto    DATABASE     �   CREATE DATABASE progetto WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Italian_Italy.1252' LC_CTYPE = 'Italian_Italy.1252';
    DROP DATABASE progetto;
                postgres    false            �            1259    25128    alloggio    TABLE     ?  CREATE TABLE public.alloggio (
    codal integer NOT NULL,
    nome character varying(20) NOT NULL,
    citta character varying(20) NOT NULL,
    via character varying(20) NOT NULL,
    civico integer,
    telefono character(10),
    bagni integer,
    camere integer,
    letti integer NOT NULL,
    metriq integer
);
    DROP TABLE public.alloggio;
       public         heap    postgres    false            �            1259    25131    alloggio_codal_seq    SEQUENCE     �   CREATE SEQUENCE public.alloggio_codal_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.alloggio_codal_seq;
       public          postgres    false    202            �           0    0    alloggio_codal_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.alloggio_codal_seq OWNED BY public.alloggio.codal;
          public          postgres    false    203            �            1259    25133 
   attrazione    TABLE     5  CREATE TABLE public.attrazione (
    codat integer NOT NULL,
    nome character varying(20) NOT NULL,
    citta character varying(20) NOT NULL,
    via character varying(20) NOT NULL,
    civico integer,
    telefono character(10),
    descrizione character varying(300),
    orario time without time zone
);
    DROP TABLE public.attrazione;
       public         heap    postgres    false            �            1259    25136    attrazione_codat_seq    SEQUENCE     �   CREATE SEQUENCE public.attrazione_codat_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.attrazione_codat_seq;
       public          postgres    false    204            �           0    0    attrazione_codat_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.attrazione_codat_seq OWNED BY public.attrazione.codat;
          public          postgres    false    205            �            1259    25138    beb    TABLE     �   CREATE TABLE public.beb (
    codb integer NOT NULL,
    checkout date NOT NULL,
    checkin date NOT NULL,
    colazione character varying(100),
    codal4 integer
);
    DROP TABLE public.beb;
       public         heap    postgres    false            �            1259    25141    beb_codb_seq    SEQUENCE     �   CREATE SEQUENCE public.beb_codb_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.beb_codb_seq;
       public          postgres    false    206            �           0    0    beb_codb_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.beb_codb_seq OWNED BY public.beb.codb;
          public          postgres    false    207            �            1259    25143    casa    TABLE     �   CREATE TABLE public.casa (
    codca integer NOT NULL,
    giardino boolean NOT NULL,
    location character varying(100) NOT NULL,
    codal5 integer
);
    DROP TABLE public.casa;
       public         heap    postgres    false            �            1259    25146    casa_codca_seq    SEQUENCE     �   CREATE SEQUENCE public.casa_codca_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.casa_codca_seq;
       public          postgres    false    208            �           0    0    casa_codca_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.casa_codca_seq OWNED BY public.casa.codca;
          public          postgres    false    209            �            1259    25148    cinema    TABLE     �   CREATE TABLE public.cinema (
    codci integer NOT NULL,
    capienza integer NOT NULL,
    nsale integer NOT NULL,
    codat3 integer
);
    DROP TABLE public.cinema;
       public         heap    postgres    false            �            1259    25151    cinema_codci_seq    SEQUENCE     �   CREATE SEQUENCE public.cinema_codci_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.cinema_codci_seq;
       public          postgres    false    210            �           0    0    cinema_codci_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.cinema_codci_seq OWNED BY public.cinema.codci;
          public          postgres    false    211            �            1259    25153    hotel    TABLE     �   CREATE TABLE public.hotel (
    codh integer NOT NULL,
    servizio character varying(100) NOT NULL,
    stelle integer NOT NULL,
    codal3 integer
);
    DROP TABLE public.hotel;
       public         heap    postgres    false            �            1259    25156    hotel_codh_seq    SEQUENCE     �   CREATE SEQUENCE public.hotel_codh_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.hotel_codh_seq;
       public          postgres    false    212            �           0    0    hotel_codh_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.hotel_codh_seq OWNED BY public.hotel.codh;
          public          postgres    false    213            �            1259    25158    mare    TABLE     b   CREATE TABLE public.mare (
    codm integer NOT NULL,
    tipom character varying(20) NOT NULL
);
    DROP TABLE public.mare;
       public         heap    postgres    false            �            1259    25161    mare_codm_seq    SEQUENCE     �   CREATE SEQUENCE public.mare_codm_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.mare_codm_seq;
       public          postgres    false    214            �           0    0    mare_codm_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.mare_codm_seq OWNED BY public.mare.codm;
          public          postgres    false    215            �            1259    25163    museo    TABLE     �   CREATE TABLE public.museo (
    codmu integer NOT NULL,
    guida boolean NOT NULL,
    patrimonio character varying(100),
    codat4 integer
);
    DROP TABLE public.museo;
       public         heap    postgres    false            �            1259    25166    museo_codmu_seq    SEQUENCE     �   CREATE SEQUENCE public.museo_codmu_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.museo_codmu_seq;
       public          postgres    false    216            �           0    0    museo_codmu_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.museo_codmu_seq OWNED BY public.museo.codmu;
          public          postgres    false    217            �            1259    25168    parco    TABLE     �   CREATE TABLE public.parco (
    codpa integer NOT NULL,
    ngiostre integer NOT NULL,
    zoo boolean NOT NULL,
    spettacoli boolean NOT NULL,
    codat5 integer
);
    DROP TABLE public.parco;
       public         heap    postgres    false            �            1259    25171    parco_codpa_seq    SEQUENCE     �   CREATE SEQUENCE public.parco_codpa_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.parco_codpa_seq;
       public          postgres    false    218            �           0    0    parco_codpa_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.parco_codpa_seq OWNED BY public.parco.codpa;
          public          postgres    false    219            �            1259    25173 
   recensione    TABLE     f  CREATE TABLE public.recensione (
    codre integer NOT NULL,
    valutazione real NOT NULL,
    titolo character varying(20) NOT NULL,
    testo character varying(500) NOT NULL,
    data date NOT NULL,
    codu2 integer,
    codri2 integer,
    codal2 integer,
    codat2 integer,
    approvata boolean DEFAULT false,
    CONSTRAINT v_1 CHECK ((((codri2 <> NULL::integer) AND (codal2 = NULL::integer) AND (codat2 = NULL::integer)) OR ((codri2 = NULL::integer) AND (codal2 <> NULL::integer) AND (codat2 = NULL::integer)) OR ((codri2 = NULL::integer) AND (codal2 = NULL::integer) AND (codat2 <> NULL::integer))))
);
    DROP TABLE public.recensione;
       public         heap    postgres    false            �            1259    25181    recensione_codre_seq    SEQUENCE     �   CREATE SEQUENCE public.recensione_codre_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.recensione_codre_seq;
       public          postgres    false    220            �           0    0    recensione_codre_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.recensione_codre_seq OWNED BY public.recensione.codre;
          public          postgres    false    221            �            1259    25183 
   ristorante    TABLE     �  CREATE TABLE public.ristorante (
    codri integer NOT NULL,
    nome character varying(20) NOT NULL,
    citta character varying(20) NOT NULL,
    via character varying(20) NOT NULL,
    civico integer,
    telefono character(10),
    specialita character varying(100),
    provenienza character varying(50),
    qualita character varying(20),
    codt2 integer,
    codm2 integer,
    codv2 integer
);
    DROP TABLE public.ristorante;
       public         heap    postgres    false            �            1259    25186    ristorante_codri_seq    SEQUENCE     �   CREATE SEQUENCE public.ristorante_codri_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.ristorante_codri_seq;
       public          postgres    false    222            �           0    0    ristorante_codri_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.ristorante_codri_seq OWNED BY public.ristorante.codri;
          public          postgres    false    223            �            1259    25188    terra    TABLE     c   CREATE TABLE public.terra (
    codt integer NOT NULL,
    tipot character varying(20) NOT NULL
);
    DROP TABLE public.terra;
       public         heap    postgres    false            �            1259    25191    terra_codt_seq    SEQUENCE     �   CREATE SEQUENCE public.terra_codt_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.terra_codt_seq;
       public          postgres    false    224            �           0    0    terra_codt_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.terra_codt_seq OWNED BY public.terra.codt;
          public          postgres    false    225            �            1259    25193    utente    TABLE     �  CREATE TABLE public.utente (
    codu integer NOT NULL,
    username character varying(20) NOT NULL,
    password character varying(20) NOT NULL,
    nome character varying(20) NOT NULL,
    cognome character varying(20) NOT NULL,
    tipo character varying(11) NOT NULL,
    CONSTRAINT utente_tipo_check CHECK (((tipo)::text = ANY (ARRAY[('base'::character varying)::text, ('admin'::character varying)::text, ('moderatore'::character varying)::text])))
);
    DROP TABLE public.utente;
       public         heap    postgres    false            �            1259    25197    utente_codu_seq    SEQUENCE     �   CREATE SEQUENCE public.utente_codu_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.utente_codu_seq;
       public          postgres    false    226            �           0    0    utente_codu_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.utente_codu_seq OWNED BY public.utente.codu;
          public          postgres    false    227            �            1259    25199    vegan    TABLE     c   CREATE TABLE public.vegan (
    codv integer NOT NULL,
    tipov character varying(20) NOT NULL
);
    DROP TABLE public.vegan;
       public         heap    postgres    false            �            1259    25202    vegan_codv_seq    SEQUENCE     �   CREATE SEQUENCE public.vegan_codv_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.vegan_codv_seq;
       public          postgres    false    228            �           0    0    vegan_codv_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.vegan_codv_seq OWNED BY public.vegan.codv;
          public          postgres    false    229            �
           2604    25204    alloggio codal    DEFAULT     p   ALTER TABLE ONLY public.alloggio ALTER COLUMN codal SET DEFAULT nextval('public.alloggio_codal_seq'::regclass);
 =   ALTER TABLE public.alloggio ALTER COLUMN codal DROP DEFAULT;
       public          postgres    false    203    202            �
           2604    25205    attrazione codat    DEFAULT     t   ALTER TABLE ONLY public.attrazione ALTER COLUMN codat SET DEFAULT nextval('public.attrazione_codat_seq'::regclass);
 ?   ALTER TABLE public.attrazione ALTER COLUMN codat DROP DEFAULT;
       public          postgres    false    205    204            �
           2604    25206    beb codb    DEFAULT     d   ALTER TABLE ONLY public.beb ALTER COLUMN codb SET DEFAULT nextval('public.beb_codb_seq'::regclass);
 7   ALTER TABLE public.beb ALTER COLUMN codb DROP DEFAULT;
       public          postgres    false    207    206            �
           2604    25207 
   casa codca    DEFAULT     h   ALTER TABLE ONLY public.casa ALTER COLUMN codca SET DEFAULT nextval('public.casa_codca_seq'::regclass);
 9   ALTER TABLE public.casa ALTER COLUMN codca DROP DEFAULT;
       public          postgres    false    209    208            �
           2604    25208    cinema codci    DEFAULT     l   ALTER TABLE ONLY public.cinema ALTER COLUMN codci SET DEFAULT nextval('public.cinema_codci_seq'::regclass);
 ;   ALTER TABLE public.cinema ALTER COLUMN codci DROP DEFAULT;
       public          postgres    false    211    210            �
           2604    25209 
   hotel codh    DEFAULT     h   ALTER TABLE ONLY public.hotel ALTER COLUMN codh SET DEFAULT nextval('public.hotel_codh_seq'::regclass);
 9   ALTER TABLE public.hotel ALTER COLUMN codh DROP DEFAULT;
       public          postgres    false    213    212            �
           2604    25210 	   mare codm    DEFAULT     f   ALTER TABLE ONLY public.mare ALTER COLUMN codm SET DEFAULT nextval('public.mare_codm_seq'::regclass);
 8   ALTER TABLE public.mare ALTER COLUMN codm DROP DEFAULT;
       public          postgres    false    215    214            �
           2604    25211    museo codmu    DEFAULT     j   ALTER TABLE ONLY public.museo ALTER COLUMN codmu SET DEFAULT nextval('public.museo_codmu_seq'::regclass);
 :   ALTER TABLE public.museo ALTER COLUMN codmu DROP DEFAULT;
       public          postgres    false    217    216            �
           2604    25212    parco codpa    DEFAULT     j   ALTER TABLE ONLY public.parco ALTER COLUMN codpa SET DEFAULT nextval('public.parco_codpa_seq'::regclass);
 :   ALTER TABLE public.parco ALTER COLUMN codpa DROP DEFAULT;
       public          postgres    false    219    218            �
           2604    25213    recensione codre    DEFAULT     t   ALTER TABLE ONLY public.recensione ALTER COLUMN codre SET DEFAULT nextval('public.recensione_codre_seq'::regclass);
 ?   ALTER TABLE public.recensione ALTER COLUMN codre DROP DEFAULT;
       public          postgres    false    221    220            �
           2604    25214    ristorante codri    DEFAULT     t   ALTER TABLE ONLY public.ristorante ALTER COLUMN codri SET DEFAULT nextval('public.ristorante_codri_seq'::regclass);
 ?   ALTER TABLE public.ristorante ALTER COLUMN codri DROP DEFAULT;
       public          postgres    false    223    222            �
           2604    25215 
   terra codt    DEFAULT     h   ALTER TABLE ONLY public.terra ALTER COLUMN codt SET DEFAULT nextval('public.terra_codt_seq'::regclass);
 9   ALTER TABLE public.terra ALTER COLUMN codt DROP DEFAULT;
       public          postgres    false    225    224            �
           2604    25216    utente codu    DEFAULT     j   ALTER TABLE ONLY public.utente ALTER COLUMN codu SET DEFAULT nextval('public.utente_codu_seq'::regclass);
 :   ALTER TABLE public.utente ALTER COLUMN codu DROP DEFAULT;
       public          postgres    false    227    226            �
           2604    25217 
   vegan codv    DEFAULT     h   ALTER TABLE ONLY public.vegan ALTER COLUMN codv SET DEFAULT nextval('public.vegan_codv_seq'::regclass);
 9   ALTER TABLE public.vegan ALTER COLUMN codv DROP DEFAULT;
       public          postgres    false    229    228            �          0    25128    alloggio 
   TABLE DATA           k   COPY public.alloggio (codal, nome, citta, via, civico, telefono, bagni, camere, letti, metriq) FROM stdin;
    public          postgres    false    202   �       �          0    25133 
   attrazione 
   TABLE DATA           d   COPY public.attrazione (codat, nome, citta, via, civico, telefono, descrizione, orario) FROM stdin;
    public          postgres    false    204   %�       �          0    25138    beb 
   TABLE DATA           I   COPY public.beb (codb, checkout, checkin, colazione, codal4) FROM stdin;
    public          postgres    false    206   O�       �          0    25143    casa 
   TABLE DATA           A   COPY public.casa (codca, giardino, location, codal5) FROM stdin;
    public          postgres    false    208   l�       �          0    25148    cinema 
   TABLE DATA           @   COPY public.cinema (codci, capienza, nsale, codat3) FROM stdin;
    public          postgres    false    210   ��       �          0    25153    hotel 
   TABLE DATA           ?   COPY public.hotel (codh, servizio, stelle, codal3) FROM stdin;
    public          postgres    false    212   $�       �          0    25158    mare 
   TABLE DATA           +   COPY public.mare (codm, tipom) FROM stdin;
    public          postgres    false    214   ��       �          0    25163    museo 
   TABLE DATA           A   COPY public.museo (codmu, guida, patrimonio, codat4) FROM stdin;
    public          postgres    false    216   Ȍ       �          0    25168    parco 
   TABLE DATA           I   COPY public.parco (codpa, ngiostre, zoo, spettacoli, codat5) FROM stdin;
    public          postgres    false    218   �       �          0    25173 
   recensione 
   TABLE DATA           w   COPY public.recensione (codre, valutazione, titolo, testo, data, codu2, codri2, codal2, codat2, approvata) FROM stdin;
    public          postgres    false    220   �       �          0    25183 
   ristorante 
   TABLE DATA           �   COPY public.ristorante (codri, nome, citta, via, civico, telefono, specialita, provenienza, qualita, codt2, codm2, codv2) FROM stdin;
    public          postgres    false    222   �       �          0    25188    terra 
   TABLE DATA           ,   COPY public.terra (codt, tipot) FROM stdin;
    public          postgres    false    224   m�       �          0    25193    utente 
   TABLE DATA           O   COPY public.utente (codu, username, password, nome, cognome, tipo) FROM stdin;
    public          postgres    false    226   ��       �          0    25199    vegan 
   TABLE DATA           ,   COPY public.vegan (codv, tipov) FROM stdin;
    public          postgres    false    228   F�       �           0    0    alloggio_codal_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.alloggio_codal_seq', 6, true);
          public          postgres    false    203            �           0    0    attrazione_codat_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.attrazione_codat_seq', 4, true);
          public          postgres    false    205            �           0    0    beb_codb_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.beb_codb_seq', 1, false);
          public          postgres    false    207            �           0    0    casa_codca_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.casa_codca_seq', 2, true);
          public          postgres    false    209            �           0    0    cinema_codci_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.cinema_codci_seq', 1, true);
          public          postgres    false    211            �           0    0    hotel_codh_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.hotel_codh_seq', 1, true);
          public          postgres    false    213            �           0    0    mare_codm_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.mare_codm_seq', 3, true);
          public          postgres    false    215            �           0    0    museo_codmu_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.museo_codmu_seq', 1, false);
          public          postgres    false    217            �           0    0    parco_codpa_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.parco_codpa_seq', 3, true);
          public          postgres    false    219            �           0    0    recensione_codre_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.recensione_codre_seq', 32, true);
          public          postgres    false    221            �           0    0    ristorante_codri_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.ristorante_codri_seq', 11, true);
          public          postgres    false    223            �           0    0    terra_codt_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.terra_codt_seq', 3, true);
          public          postgres    false    225            �           0    0    utente_codu_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.utente_codu_seq', 4, true);
          public          postgres    false    227            �           0    0    vegan_codv_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.vegan_codv_seq', 3, true);
          public          postgres    false    229            �
           2606    25219    alloggio alloggio_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.alloggio
    ADD CONSTRAINT alloggio_pkey PRIMARY KEY (codal);
 @   ALTER TABLE ONLY public.alloggio DROP CONSTRAINT alloggio_pkey;
       public            postgres    false    202            �
           2606    25221    alloggio alloggio_telefono_key 
   CONSTRAINT     ]   ALTER TABLE ONLY public.alloggio
    ADD CONSTRAINT alloggio_telefono_key UNIQUE (telefono);
 H   ALTER TABLE ONLY public.alloggio DROP CONSTRAINT alloggio_telefono_key;
       public            postgres    false    202            �
           2606    25223    attrazione attrazione_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.attrazione
    ADD CONSTRAINT attrazione_pkey PRIMARY KEY (codat);
 D   ALTER TABLE ONLY public.attrazione DROP CONSTRAINT attrazione_pkey;
       public            postgres    false    204            �
           2606    25225 "   attrazione attrazione_telefono_key 
   CONSTRAINT     a   ALTER TABLE ONLY public.attrazione
    ADD CONSTRAINT attrazione_telefono_key UNIQUE (telefono);
 L   ALTER TABLE ONLY public.attrazione DROP CONSTRAINT attrazione_telefono_key;
       public            postgres    false    204            �
           2606    25227    beb beb_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.beb
    ADD CONSTRAINT beb_pkey PRIMARY KEY (codb);
 6   ALTER TABLE ONLY public.beb DROP CONSTRAINT beb_pkey;
       public            postgres    false    206            �
           2606    25229    casa casa_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY public.casa
    ADD CONSTRAINT casa_pkey PRIMARY KEY (codca);
 8   ALTER TABLE ONLY public.casa DROP CONSTRAINT casa_pkey;
       public            postgres    false    208            �
           2606    25231    cinema cinema_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.cinema
    ADD CONSTRAINT cinema_pkey PRIMARY KEY (codci);
 <   ALTER TABLE ONLY public.cinema DROP CONSTRAINT cinema_pkey;
       public            postgres    false    210            �
           2606    25233    hotel hotel_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.hotel
    ADD CONSTRAINT hotel_pkey PRIMARY KEY (codh);
 :   ALTER TABLE ONLY public.hotel DROP CONSTRAINT hotel_pkey;
       public            postgres    false    212            �
           2606    25320    recensione limite1 
   CONSTRAINT     V   ALTER TABLE ONLY public.recensione
    ADD CONSTRAINT limite1 UNIQUE (codu2, codri2);
 <   ALTER TABLE ONLY public.recensione DROP CONSTRAINT limite1;
       public            postgres    false    220    220            �
           2606    25322    recensione limite2 
   CONSTRAINT     V   ALTER TABLE ONLY public.recensione
    ADD CONSTRAINT limite2 UNIQUE (codu2, codal2);
 <   ALTER TABLE ONLY public.recensione DROP CONSTRAINT limite2;
       public            postgres    false    220    220            �
           2606    25324    recensione limite3 
   CONSTRAINT     V   ALTER TABLE ONLY public.recensione
    ADD CONSTRAINT limite3 UNIQUE (codu2, codat2);
 <   ALTER TABLE ONLY public.recensione DROP CONSTRAINT limite3;
       public            postgres    false    220    220            �
           2606    25235    mare mare_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.mare
    ADD CONSTRAINT mare_pkey PRIMARY KEY (codm);
 8   ALTER TABLE ONLY public.mare DROP CONSTRAINT mare_pkey;
       public            postgres    false    214            �
           2606    25237    museo museo_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.museo
    ADD CONSTRAINT museo_pkey PRIMARY KEY (codmu);
 :   ALTER TABLE ONLY public.museo DROP CONSTRAINT museo_pkey;
       public            postgres    false    216            �
           2606    25239    parco parco_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.parco
    ADD CONSTRAINT parco_pkey PRIMARY KEY (codpa);
 :   ALTER TABLE ONLY public.parco DROP CONSTRAINT parco_pkey;
       public            postgres    false    218            �
           2606    25241    recensione recensione_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.recensione
    ADD CONSTRAINT recensione_pkey PRIMARY KEY (codre);
 D   ALTER TABLE ONLY public.recensione DROP CONSTRAINT recensione_pkey;
       public            postgres    false    220            �
           2606    25243    ristorante ristorante_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.ristorante
    ADD CONSTRAINT ristorante_pkey PRIMARY KEY (codri);
 D   ALTER TABLE ONLY public.ristorante DROP CONSTRAINT ristorante_pkey;
       public            postgres    false    222                        2606    25245 "   ristorante ristorante_telefono_key 
   CONSTRAINT     a   ALTER TABLE ONLY public.ristorante
    ADD CONSTRAINT ristorante_telefono_key UNIQUE (telefono);
 L   ALTER TABLE ONLY public.ristorante DROP CONSTRAINT ristorante_telefono_key;
       public            postgres    false    222                       2606    25247    terra terra_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.terra
    ADD CONSTRAINT terra_pkey PRIMARY KEY (codt);
 :   ALTER TABLE ONLY public.terra DROP CONSTRAINT terra_pkey;
       public            postgres    false    224                       2606    25249    utente utente_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.utente
    ADD CONSTRAINT utente_pkey PRIMARY KEY (codu);
 <   ALTER TABLE ONLY public.utente DROP CONSTRAINT utente_pkey;
       public            postgres    false    226                       2606    25251    utente utente_username_key 
   CONSTRAINT     Y   ALTER TABLE ONLY public.utente
    ADD CONSTRAINT utente_username_key UNIQUE (username);
 D   ALTER TABLE ONLY public.utente DROP CONSTRAINT utente_username_key;
       public            postgres    false    226                       2606    25253    vegan vegan_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.vegan
    ADD CONSTRAINT vegan_pkey PRIMARY KEY (codv);
 :   ALTER TABLE ONLY public.vegan DROP CONSTRAINT vegan_pkey;
       public            postgres    false    228                       2606    25254    recensione fk_1    FK CONSTRAINT     o   ALTER TABLE ONLY public.recensione
    ADD CONSTRAINT fk_1 FOREIGN KEY (codu2) REFERENCES public.utente(codu);
 9   ALTER TABLE ONLY public.recensione DROP CONSTRAINT fk_1;
       public          postgres    false    220    2820    226                       2606    25259    museo fk_10    FK CONSTRAINT     q   ALTER TABLE ONLY public.museo
    ADD CONSTRAINT fk_10 FOREIGN KEY (codat4) REFERENCES public.attrazione(codat);
 5   ALTER TABLE ONLY public.museo DROP CONSTRAINT fk_10;
       public          postgres    false    204    216    2788                       2606    25264    parco fk_11    FK CONSTRAINT     q   ALTER TABLE ONLY public.parco
    ADD CONSTRAINT fk_11 FOREIGN KEY (codat5) REFERENCES public.attrazione(codat);
 5   ALTER TABLE ONLY public.parco DROP CONSTRAINT fk_11;
       public          postgres    false    218    2788    204                       2606    25269    hotel fk_12    FK CONSTRAINT     o   ALTER TABLE ONLY public.hotel
    ADD CONSTRAINT fk_12 FOREIGN KEY (codal3) REFERENCES public.alloggio(codal);
 5   ALTER TABLE ONLY public.hotel DROP CONSTRAINT fk_12;
       public          postgres    false    202    212    2784            
           2606    25274 
   casa fk_13    FK CONSTRAINT     n   ALTER TABLE ONLY public.casa
    ADD CONSTRAINT fk_13 FOREIGN KEY (codal5) REFERENCES public.alloggio(codal);
 4   ALTER TABLE ONLY public.casa DROP CONSTRAINT fk_13;
       public          postgres    false    2784    202    208                       2606    25279    recensione fk_2    FK CONSTRAINT     u   ALTER TABLE ONLY public.recensione
    ADD CONSTRAINT fk_2 FOREIGN KEY (codri2) REFERENCES public.ristorante(codri);
 9   ALTER TABLE ONLY public.recensione DROP CONSTRAINT fk_2;
       public          postgres    false    2814    220    222                       2606    25284    recensione fk_3    FK CONSTRAINT     s   ALTER TABLE ONLY public.recensione
    ADD CONSTRAINT fk_3 FOREIGN KEY (codal2) REFERENCES public.alloggio(codal);
 9   ALTER TABLE ONLY public.recensione DROP CONSTRAINT fk_3;
       public          postgres    false    2784    202    220                       2606    25289    recensione fk_4    FK CONSTRAINT     u   ALTER TABLE ONLY public.recensione
    ADD CONSTRAINT fk_4 FOREIGN KEY (codat2) REFERENCES public.attrazione(codat);
 9   ALTER TABLE ONLY public.recensione DROP CONSTRAINT fk_4;
       public          postgres    false    2788    220    204                       2606    25294    ristorante fk_5    FK CONSTRAINT     n   ALTER TABLE ONLY public.ristorante
    ADD CONSTRAINT fk_5 FOREIGN KEY (codt2) REFERENCES public.terra(codt);
 9   ALTER TABLE ONLY public.ristorante DROP CONSTRAINT fk_5;
       public          postgres    false    224    222    2818                       2606    25299    ristorante fk_6    FK CONSTRAINT     m   ALTER TABLE ONLY public.ristorante
    ADD CONSTRAINT fk_6 FOREIGN KEY (codm2) REFERENCES public.mare(codm);
 9   ALTER TABLE ONLY public.ristorante DROP CONSTRAINT fk_6;
       public          postgres    false    214    222    2800                       2606    25304    ristorante fk_7    FK CONSTRAINT     n   ALTER TABLE ONLY public.ristorante
    ADD CONSTRAINT fk_7 FOREIGN KEY (codv2) REFERENCES public.vegan(codv);
 9   ALTER TABLE ONLY public.ristorante DROP CONSTRAINT fk_7;
       public          postgres    false    222    2824    228                       2606    25309    cinema fk_8    FK CONSTRAINT     q   ALTER TABLE ONLY public.cinema
    ADD CONSTRAINT fk_8 FOREIGN KEY (codat3) REFERENCES public.attrazione(codat);
 5   ALTER TABLE ONLY public.cinema DROP CONSTRAINT fk_8;
       public          postgres    false    2788    204    210            	           2606    25314    beb fk_9    FK CONSTRAINT     l   ALTER TABLE ONLY public.beb
    ADD CONSTRAINT fk_9 FOREIGN KEY (codal4) REFERENCES public.alloggio(codal);
 2   ALTER TABLE ONLY public.beb DROP CONSTRAINT fk_9;
       public          postgres    false    2784    202    206            �   �   x�M��J�0�ϓ��H�4m�ڲz��"{J��v�����P���7�/�ቒ�����'�WZׅb�>$;q]��tUk��6��U��*�/a�E6�>�h?����1zهq�`A�0\����ӌ�y��pį͍�qc��J��f���V�f΀V��o�y�kȍ��(�)�1�P����{���y�-t4Q��s˷�D�{�[�<ă.�<��� ��`�(��x�9-�����@v�wIl�dU8�'OwB��"d;      �     x�}�9NAE�S|rdy<vD��Ii�0%�FO�BD��.��pj�&!����73Kz�N<;{����;!�p�ԋ�O�Yc�墹(�vs�zD�|�c����c�xt�"y�st���YF䄘�pΔb�ĬWEe�C���X~�pճ�c>�`����ʦV�C7�E߻GF�d:r)S=�BIY��g:"w��񆳮�F�ڜ���VM=oZ�|��[u֩�q���g+i$�Q��=mIX=��z�lRP1��!VE�?ieD&���'EQ|*���      �      x������ � �      �      x��1B!Dk8���D������f��l�,�,���Г�L�2y�wѝ*�GAp�����?8s�BxR#HA/�����F���Ńs0ZO�~�T\tۺfف��<@���,<��������x���.Y      �      x�3�4400�44�4����� �X      �   T   x�3���M�TH/J,�,�Qp���M��TH��M-.��Qp��I����KU��K�)-N�)�LTH��K�I$�$r�pr��qqq 7��      �   0   x�3�.-���2��MM�,I-*J�K��2�H-N�H-�L�����  ��      �      x������ � �      �      x�3��L�,�4�2�4 �%��\1z\\\ 6m�      �   �   x�u��
�0���)|�[����}0v��K�A��K笩�$�����i� ����R�N���~�~�l�	(.H��{"8��iAR[���C�����������m>u�%����<�1歊�k��0��F�>��푍�*_y�����2��*�t�M�S	]��b������E��{�E�������i�yNp��צ������ǖ�N�|��T��E��Ah�]��N�����t�T�VK��<����      �   >  x�mR�n�0<�����R��,��Į#�q��@.��Q��.E�N��~Z��K�I[�� ����̎`i��5pi*��d�ƴ�LC������e^&����4�������C�TR�j�L�
xX�%��a0�׏���a�C�]��yD�Y-@�w>*�Q�ä�����8H�x.T�d*
�Q���k��i	ʧ\Y(H��A���S�pc^(T���+��
Փ����$JaJX���Ɂsb�=����!	m`�e�ee|�2h��8tb����e�U�H]�OF.Έ�.��Q�fܿ����rC-�(tJE����Q%��l�����M"0g%�N�W���n{��ۤgl[ܽ�XG)�q���ﾽٳE�B�zA��4�Z²�rk�f=;�{o>�.>�So4�v��@z��%�X���Z��`ፈ�u�d6���k�S_(|���kbQ]���Ѡ,M�X�;����,�$&W\[�֣�{��jl�T 8>��YV7��}
 /u"���?�m�'u�5z�B�=�HkXO��}H�~.�p��@ ����#�{٢ST���]#�=�>EQ��!      �   -   x�3�.IM�V��/-N�2�(M�2�tK,.Qp��O����� ��	�      �   �   x�5�A
�@Ͻ��ª,�H$hN�e܌aH2����oMQTG�y�-uh#Z'�\�!�#���h8`0�$!%�VS1\�M��Fv�����ە��4��p)��:����=�w{����ON򻭢�'�}��X4;      �   0   x�3�Ȭ�J-�L�2�t.*M3�9�2�K��Kt�R���b���� ;�i     