PGDMP                         x            progetto    12.1    12.1 x    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16513    progetto    DATABASE     �   CREATE DATABASE progetto WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Italian_Italy.1252' LC_CTYPE = 'Italian_Italy.1252';
    DROP DATABASE progetto;
                postgres    false            �           0    0    DATABASE progetto    ACL     )   GRANT ALL ON DATABASE progetto TO admin;
                   postgres    false    2991            �            1259    16625    alloggio    TABLE     ?  CREATE TABLE public.alloggio (
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
       public         heap    postgres    false            �            1259    16623    alloggio_codal_seq    SEQUENCE     �   CREATE SEQUENCE public.alloggio_codal_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.alloggio_codal_seq;
       public          postgres    false    221            �           0    0    alloggio_codal_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.alloggio_codal_seq OWNED BY public.alloggio.codal;
          public          postgres    false    220            �            1259    16576 
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
       public         heap    postgres    false            �            1259    16574    attrazione_codat_seq    SEQUENCE     �   CREATE SEQUENCE public.attrazione_codat_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.attrazione_codat_seq;
       public          postgres    false    213            �           0    0    attrazione_codat_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.attrazione_codat_seq OWNED BY public.attrazione.codat;
          public          postgres    false    212            �            1259    16648    beb    TABLE     �   CREATE TABLE public.beb (
    codb integer NOT NULL,
    checkout date NOT NULL,
    checkin date NOT NULL,
    colazione character varying(100),
    codal4 integer
);
    DROP TABLE public.beb;
       public         heap    postgres    false            �            1259    16646    beb_codb_seq    SEQUENCE     �   CREATE SEQUENCE public.beb_codb_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.beb_codb_seq;
       public          postgres    false    225            �           0    0    beb_codb_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.beb_codb_seq OWNED BY public.beb.codb;
          public          postgres    false    224            �            1259    16661    casa    TABLE     �   CREATE TABLE public.casa (
    codca integer NOT NULL,
    giardino boolean NOT NULL,
    location character varying(100) NOT NULL,
    codal5 integer
);
    DROP TABLE public.casa;
       public         heap    postgres    false            �            1259    16659    casa_codca_seq    SEQUENCE     �   CREATE SEQUENCE public.casa_codca_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.casa_codca_seq;
       public          postgres    false    227            �           0    0    casa_codca_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.casa_codca_seq OWNED BY public.casa.codca;
          public          postgres    false    226            �            1259    16586    cinema    TABLE     �   CREATE TABLE public.cinema (
    codci integer NOT NULL,
    capienza integer NOT NULL,
    nsale integer NOT NULL,
    codat3 integer
);
    DROP TABLE public.cinema;
       public         heap    postgres    false            �            1259    16584    cinema_codci_seq    SEQUENCE     �   CREATE SEQUENCE public.cinema_codci_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.cinema_codci_seq;
       public          postgres    false    215            �           0    0    cinema_codci_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.cinema_codci_seq OWNED BY public.cinema.codci;
          public          postgres    false    214            �            1259    16635    hotel    TABLE     �   CREATE TABLE public.hotel (
    codh integer NOT NULL,
    servizio character varying(100) NOT NULL,
    stelle integer NOT NULL,
    codal3 integer
);
    DROP TABLE public.hotel;
       public         heap    postgres    false            �            1259    16633    hotel_codh_seq    SEQUENCE     �   CREATE SEQUENCE public.hotel_codh_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.hotel_codh_seq;
       public          postgres    false    223            �           0    0    hotel_codh_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.hotel_codh_seq OWNED BY public.hotel.codh;
          public          postgres    false    222            �            1259    16535    mare    TABLE     b   CREATE TABLE public.mare (
    codm integer NOT NULL,
    tipom character varying(20) NOT NULL
);
    DROP TABLE public.mare;
       public         heap    postgres    false            �            1259    16533    mare_codm_seq    SEQUENCE     �   CREATE SEQUENCE public.mare_codm_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.mare_codm_seq;
       public          postgres    false    207            �           0    0    mare_codm_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.mare_codm_seq OWNED BY public.mare.codm;
          public          postgres    false    206            �            1259    16599    museo    TABLE     �   CREATE TABLE public.museo (
    codmu integer NOT NULL,
    guida boolean NOT NULL,
    patrimonio character varying(100),
    codat4 integer
);
    DROP TABLE public.museo;
       public         heap    postgres    false            �            1259    16597    museo_codmu_seq    SEQUENCE     �   CREATE SEQUENCE public.museo_codmu_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.museo_codmu_seq;
       public          postgres    false    217            �           0    0    museo_codmu_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.museo_codmu_seq OWNED BY public.museo.codmu;
          public          postgres    false    216            �            1259    16612    parco    TABLE     �   CREATE TABLE public.parco (
    codpa integer NOT NULL,
    ngiostre integer NOT NULL,
    zoo boolean NOT NULL,
    settacoli boolean NOT NULL,
    codat5 integer
);
    DROP TABLE public.parco;
       public         heap    postgres    false            �            1259    16610    parco_codpa_seq    SEQUENCE     �   CREATE SEQUENCE public.parco_codpa_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.parco_codpa_seq;
       public          postgres    false    219            �           0    0    parco_codpa_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.parco_codpa_seq OWNED BY public.parco.codpa;
          public          postgres    false    218            �            1259    16706 
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
       public         heap    postgres    false            �            1259    16704    recensione_codre_seq    SEQUENCE     �   CREATE SEQUENCE public.recensione_codre_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.recensione_codre_seq;
       public          postgres    false    229            �           0    0    recensione_codre_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.recensione_codre_seq OWNED BY public.recensione.codre;
          public          postgres    false    228            �            1259    16551 
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
       public         heap    postgres    false            �            1259    16549    ristorante_codri_seq    SEQUENCE     �   CREATE SEQUENCE public.ristorante_codri_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.ristorante_codri_seq;
       public          postgres    false    211            �           0    0    ristorante_codri_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.ristorante_codri_seq OWNED BY public.ristorante.codri;
          public          postgres    false    210            �            1259    16527    terra    TABLE     c   CREATE TABLE public.terra (
    codt integer NOT NULL,
    tipot character varying(20) NOT NULL
);
    DROP TABLE public.terra;
       public         heap    postgres    false            �            1259    16525    terra_codt_seq    SEQUENCE     �   CREATE SEQUENCE public.terra_codt_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.terra_codt_seq;
       public          postgres    false    205            �           0    0    terra_codt_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.terra_codt_seq OWNED BY public.terra.codt;
          public          postgres    false    204            �            1259    16516    utente    TABLE     �  CREATE TABLE public.utente (
    codu integer NOT NULL,
    username character varying(20) NOT NULL,
    password character varying(20) NOT NULL,
    nome character varying(20) NOT NULL,
    cognome character varying(20) NOT NULL,
    tipo character varying(11) NOT NULL,
    CONSTRAINT utente_tipo_check CHECK (((tipo)::text = ANY ((ARRAY['base'::character varying, 'admin'::character varying, 'moderatore'::character varying])::text[])))
);
    DROP TABLE public.utente;
       public         heap    postgres    false            �            1259    16514    utente_codu_seq    SEQUENCE     �   CREATE SEQUENCE public.utente_codu_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.utente_codu_seq;
       public          postgres    false    203            �           0    0    utente_codu_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.utente_codu_seq OWNED BY public.utente.codu;
          public          postgres    false    202            �            1259    16543    vegan    TABLE     c   CREATE TABLE public.vegan (
    codv integer NOT NULL,
    tipov character varying(20) NOT NULL
);
    DROP TABLE public.vegan;
       public         heap    postgres    false            �            1259    16541    vegan_codv_seq    SEQUENCE     �   CREATE SEQUENCE public.vegan_codv_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.vegan_codv_seq;
       public          postgres    false    209            �           0    0    vegan_codv_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.vegan_codv_seq OWNED BY public.vegan.codv;
          public          postgres    false    208            �
           2604    16628    alloggio codal    DEFAULT     p   ALTER TABLE ONLY public.alloggio ALTER COLUMN codal SET DEFAULT nextval('public.alloggio_codal_seq'::regclass);
 =   ALTER TABLE public.alloggio ALTER COLUMN codal DROP DEFAULT;
       public          postgres    false    220    221    221            �
           2604    16579    attrazione codat    DEFAULT     t   ALTER TABLE ONLY public.attrazione ALTER COLUMN codat SET DEFAULT nextval('public.attrazione_codat_seq'::regclass);
 ?   ALTER TABLE public.attrazione ALTER COLUMN codat DROP DEFAULT;
       public          postgres    false    213    212    213            �
           2604    16651    beb codb    DEFAULT     d   ALTER TABLE ONLY public.beb ALTER COLUMN codb SET DEFAULT nextval('public.beb_codb_seq'::regclass);
 7   ALTER TABLE public.beb ALTER COLUMN codb DROP DEFAULT;
       public          postgres    false    225    224    225            �
           2604    16664 
   casa codca    DEFAULT     h   ALTER TABLE ONLY public.casa ALTER COLUMN codca SET DEFAULT nextval('public.casa_codca_seq'::regclass);
 9   ALTER TABLE public.casa ALTER COLUMN codca DROP DEFAULT;
       public          postgres    false    226    227    227            �
           2604    16589    cinema codci    DEFAULT     l   ALTER TABLE ONLY public.cinema ALTER COLUMN codci SET DEFAULT nextval('public.cinema_codci_seq'::regclass);
 ;   ALTER TABLE public.cinema ALTER COLUMN codci DROP DEFAULT;
       public          postgres    false    215    214    215            �
           2604    16638 
   hotel codh    DEFAULT     h   ALTER TABLE ONLY public.hotel ALTER COLUMN codh SET DEFAULT nextval('public.hotel_codh_seq'::regclass);
 9   ALTER TABLE public.hotel ALTER COLUMN codh DROP DEFAULT;
       public          postgres    false    223    222    223            �
           2604    16538 	   mare codm    DEFAULT     f   ALTER TABLE ONLY public.mare ALTER COLUMN codm SET DEFAULT nextval('public.mare_codm_seq'::regclass);
 8   ALTER TABLE public.mare ALTER COLUMN codm DROP DEFAULT;
       public          postgres    false    207    206    207            �
           2604    16602    museo codmu    DEFAULT     j   ALTER TABLE ONLY public.museo ALTER COLUMN codmu SET DEFAULT nextval('public.museo_codmu_seq'::regclass);
 :   ALTER TABLE public.museo ALTER COLUMN codmu DROP DEFAULT;
       public          postgres    false    216    217    217            �
           2604    16615    parco codpa    DEFAULT     j   ALTER TABLE ONLY public.parco ALTER COLUMN codpa SET DEFAULT nextval('public.parco_codpa_seq'::regclass);
 :   ALTER TABLE public.parco ALTER COLUMN codpa DROP DEFAULT;
       public          postgres    false    218    219    219            �
           2604    16709    recensione codre    DEFAULT     t   ALTER TABLE ONLY public.recensione ALTER COLUMN codre SET DEFAULT nextval('public.recensione_codre_seq'::regclass);
 ?   ALTER TABLE public.recensione ALTER COLUMN codre DROP DEFAULT;
       public          postgres    false    229    228    229            �
           2604    16554    ristorante codri    DEFAULT     t   ALTER TABLE ONLY public.ristorante ALTER COLUMN codri SET DEFAULT nextval('public.ristorante_codri_seq'::regclass);
 ?   ALTER TABLE public.ristorante ALTER COLUMN codri DROP DEFAULT;
       public          postgres    false    210    211    211            �
           2604    16530 
   terra codt    DEFAULT     h   ALTER TABLE ONLY public.terra ALTER COLUMN codt SET DEFAULT nextval('public.terra_codt_seq'::regclass);
 9   ALTER TABLE public.terra ALTER COLUMN codt DROP DEFAULT;
       public          postgres    false    205    204    205            �
           2604    16519    utente codu    DEFAULT     j   ALTER TABLE ONLY public.utente ALTER COLUMN codu SET DEFAULT nextval('public.utente_codu_seq'::regclass);
 :   ALTER TABLE public.utente ALTER COLUMN codu DROP DEFAULT;
       public          postgres    false    202    203    203            �
           2604    16546 
   vegan codv    DEFAULT     h   ALTER TABLE ONLY public.vegan ALTER COLUMN codv SET DEFAULT nextval('public.vegan_codv_seq'::regclass);
 9   ALTER TABLE public.vegan ALTER COLUMN codv DROP DEFAULT;
       public          postgres    false    208    209    209            �          0    16625    alloggio 
   TABLE DATA           k   COPY public.alloggio (codal, nome, citta, via, civico, telefono, bagni, camere, letti, metriq) FROM stdin;
    public          postgres    false    221   ��       �          0    16576 
   attrazione 
   TABLE DATA           d   COPY public.attrazione (codat, nome, citta, via, civico, telefono, descrizione, orario) FROM stdin;
    public          postgres    false    213   �       �          0    16648    beb 
   TABLE DATA           I   COPY public.beb (codb, checkout, checkin, colazione, codal4) FROM stdin;
    public          postgres    false    225   M�       �          0    16661    casa 
   TABLE DATA           A   COPY public.casa (codca, giardino, location, codal5) FROM stdin;
    public          postgres    false    227   j�       �          0    16586    cinema 
   TABLE DATA           @   COPY public.cinema (codci, capienza, nsale, codat3) FROM stdin;
    public          postgres    false    215   ��       �          0    16635    hotel 
   TABLE DATA           ?   COPY public.hotel (codh, servizio, stelle, codal3) FROM stdin;
    public          postgres    false    223   ��       �          0    16535    mare 
   TABLE DATA           +   COPY public.mare (codm, tipom) FROM stdin;
    public          postgres    false    207   �       �          0    16599    museo 
   TABLE DATA           A   COPY public.museo (codmu, guida, patrimonio, codat4) FROM stdin;
    public          postgres    false    217   H�       �          0    16612    parco 
   TABLE DATA           H   COPY public.parco (codpa, ngiostre, zoo, settacoli, codat5) FROM stdin;
    public          postgres    false    219   e�       �          0    16706 
   recensione 
   TABLE DATA           w   COPY public.recensione (codre, valutazione, titolo, testo, data, codu2, codri2, codal2, codat2, approvata) FROM stdin;
    public          postgres    false    229   ��       �          0    16551 
   ristorante 
   TABLE DATA           �   COPY public.ristorante (codri, nome, citta, via, civico, telefono, specialita, provenienza, qualita, codt2, codm2, codv2) FROM stdin;
    public          postgres    false    211   ��       �          0    16527    terra 
   TABLE DATA           ,   COPY public.terra (codt, tipot) FROM stdin;
    public          postgres    false    205   �       �          0    16516    utente 
   TABLE DATA           O   COPY public.utente (codu, username, password, nome, cognome, tipo) FROM stdin;
    public          postgres    false    203   *�       �          0    16543    vegan 
   TABLE DATA           ,   COPY public.vegan (codv, tipov) FROM stdin;
    public          postgres    false    209   Ƌ       �           0    0    alloggio_codal_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.alloggio_codal_seq', 2, true);
          public          postgres    false    220            �           0    0    attrazione_codat_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.attrazione_codat_seq', 1, true);
          public          postgres    false    212            �           0    0    beb_codb_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.beb_codb_seq', 1, false);
          public          postgres    false    224            �           0    0    casa_codca_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.casa_codca_seq', 1, false);
          public          postgres    false    226            �           0    0    cinema_codci_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.cinema_codci_seq', 1, false);
          public          postgres    false    214            �           0    0    hotel_codh_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.hotel_codh_seq', 1, true);
          public          postgres    false    222            �           0    0    mare_codm_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.mare_codm_seq', 3, true);
          public          postgres    false    206            �           0    0    museo_codmu_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.museo_codmu_seq', 1, false);
          public          postgres    false    216            �           0    0    parco_codpa_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.parco_codpa_seq', 1, false);
          public          postgres    false    218            �           0    0    recensione_codre_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.recensione_codre_seq', 1, false);
          public          postgres    false    228            �           0    0    ristorante_codri_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.ristorante_codri_seq', 11, true);
          public          postgres    false    210            �           0    0    terra_codt_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.terra_codt_seq', 3, true);
          public          postgres    false    204            �           0    0    utente_codu_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.utente_codu_seq', 4, true);
          public          postgres    false    202            �           0    0    vegan_codv_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.vegan_codv_seq', 3, true);
          public          postgres    false    208            �
           2606    16630    alloggio alloggio_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.alloggio
    ADD CONSTRAINT alloggio_pkey PRIMARY KEY (codal);
 @   ALTER TABLE ONLY public.alloggio DROP CONSTRAINT alloggio_pkey;
       public            postgres    false    221            �
           2606    16632    alloggio alloggio_telefono_key 
   CONSTRAINT     ]   ALTER TABLE ONLY public.alloggio
    ADD CONSTRAINT alloggio_telefono_key UNIQUE (telefono);
 H   ALTER TABLE ONLY public.alloggio DROP CONSTRAINT alloggio_telefono_key;
       public            postgres    false    221            �
           2606    16581    attrazione attrazione_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.attrazione
    ADD CONSTRAINT attrazione_pkey PRIMARY KEY (codat);
 D   ALTER TABLE ONLY public.attrazione DROP CONSTRAINT attrazione_pkey;
       public            postgres    false    213            �
           2606    16583 "   attrazione attrazione_telefono_key 
   CONSTRAINT     a   ALTER TABLE ONLY public.attrazione
    ADD CONSTRAINT attrazione_telefono_key UNIQUE (telefono);
 L   ALTER TABLE ONLY public.attrazione DROP CONSTRAINT attrazione_telefono_key;
       public            postgres    false    213            �
           2606    16653    beb beb_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.beb
    ADD CONSTRAINT beb_pkey PRIMARY KEY (codb);
 6   ALTER TABLE ONLY public.beb DROP CONSTRAINT beb_pkey;
       public            postgres    false    225                        2606    16666    casa casa_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY public.casa
    ADD CONSTRAINT casa_pkey PRIMARY KEY (codca);
 8   ALTER TABLE ONLY public.casa DROP CONSTRAINT casa_pkey;
       public            postgres    false    227            �
           2606    16591    cinema cinema_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.cinema
    ADD CONSTRAINT cinema_pkey PRIMARY KEY (codci);
 <   ALTER TABLE ONLY public.cinema DROP CONSTRAINT cinema_pkey;
       public            postgres    false    215            �
           2606    16640    hotel hotel_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.hotel
    ADD CONSTRAINT hotel_pkey PRIMARY KEY (codh);
 :   ALTER TABLE ONLY public.hotel DROP CONSTRAINT hotel_pkey;
       public            postgres    false    223            �
           2606    16540    mare mare_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.mare
    ADD CONSTRAINT mare_pkey PRIMARY KEY (codm);
 8   ALTER TABLE ONLY public.mare DROP CONSTRAINT mare_pkey;
       public            postgres    false    207            �
           2606    16604    museo museo_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.museo
    ADD CONSTRAINT museo_pkey PRIMARY KEY (codmu);
 :   ALTER TABLE ONLY public.museo DROP CONSTRAINT museo_pkey;
       public            postgres    false    217            �
           2606    16617    parco parco_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.parco
    ADD CONSTRAINT parco_pkey PRIMARY KEY (codpa);
 :   ALTER TABLE ONLY public.parco DROP CONSTRAINT parco_pkey;
       public            postgres    false    219                       2606    16715    recensione recensione_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.recensione
    ADD CONSTRAINT recensione_pkey PRIMARY KEY (codre);
 D   ALTER TABLE ONLY public.recensione DROP CONSTRAINT recensione_pkey;
       public            postgres    false    229            �
           2606    16556    ristorante ristorante_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.ristorante
    ADD CONSTRAINT ristorante_pkey PRIMARY KEY (codri);
 D   ALTER TABLE ONLY public.ristorante DROP CONSTRAINT ristorante_pkey;
       public            postgres    false    211            �
           2606    16558 "   ristorante ristorante_telefono_key 
   CONSTRAINT     a   ALTER TABLE ONLY public.ristorante
    ADD CONSTRAINT ristorante_telefono_key UNIQUE (telefono);
 L   ALTER TABLE ONLY public.ristorante DROP CONSTRAINT ristorante_telefono_key;
       public            postgres    false    211            �
           2606    16532    terra terra_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.terra
    ADD CONSTRAINT terra_pkey PRIMARY KEY (codt);
 :   ALTER TABLE ONLY public.terra DROP CONSTRAINT terra_pkey;
       public            postgres    false    205            �
           2606    16522    utente utente_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.utente
    ADD CONSTRAINT utente_pkey PRIMARY KEY (codu);
 <   ALTER TABLE ONLY public.utente DROP CONSTRAINT utente_pkey;
       public            postgres    false    203            �
           2606    16524    utente utente_username_key 
   CONSTRAINT     Y   ALTER TABLE ONLY public.utente
    ADD CONSTRAINT utente_username_key UNIQUE (username);
 D   ALTER TABLE ONLY public.utente DROP CONSTRAINT utente_username_key;
       public            postgres    false    203            �
           2606    16548    vegan vegan_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.vegan
    ADD CONSTRAINT vegan_pkey PRIMARY KEY (codv);
 :   ALTER TABLE ONLY public.vegan DROP CONSTRAINT vegan_pkey;
       public            postgres    false    209                       2606    16716    recensione fk_1    FK CONSTRAINT     o   ALTER TABLE ONLY public.recensione
    ADD CONSTRAINT fk_1 FOREIGN KEY (codu2) REFERENCES public.utente(codu);
 9   ALTER TABLE ONLY public.recensione DROP CONSTRAINT fk_1;
       public          postgres    false    229    203    2784                       2606    16605    museo fk_10    FK CONSTRAINT     q   ALTER TABLE ONLY public.museo
    ADD CONSTRAINT fk_10 FOREIGN KEY (codat4) REFERENCES public.attrazione(codat);
 5   ALTER TABLE ONLY public.museo DROP CONSTRAINT fk_10;
       public          postgres    false    2798    213    217                       2606    16618    parco fk_11    FK CONSTRAINT     q   ALTER TABLE ONLY public.parco
    ADD CONSTRAINT fk_11 FOREIGN KEY (codat5) REFERENCES public.attrazione(codat);
 5   ALTER TABLE ONLY public.parco DROP CONSTRAINT fk_11;
       public          postgres    false    219    2798    213            	           2606    16641    hotel fk_12    FK CONSTRAINT     o   ALTER TABLE ONLY public.hotel
    ADD CONSTRAINT fk_12 FOREIGN KEY (codal3) REFERENCES public.alloggio(codal);
 5   ALTER TABLE ONLY public.hotel DROP CONSTRAINT fk_12;
       public          postgres    false    2808    221    223                       2606    16667 
   casa fk_13    FK CONSTRAINT     n   ALTER TABLE ONLY public.casa
    ADD CONSTRAINT fk_13 FOREIGN KEY (codal5) REFERENCES public.alloggio(codal);
 4   ALTER TABLE ONLY public.casa DROP CONSTRAINT fk_13;
       public          postgres    false    2808    227    221                       2606    16721    recensione fk_2    FK CONSTRAINT     u   ALTER TABLE ONLY public.recensione
    ADD CONSTRAINT fk_2 FOREIGN KEY (codri2) REFERENCES public.ristorante(codri);
 9   ALTER TABLE ONLY public.recensione DROP CONSTRAINT fk_2;
       public          postgres    false    211    229    2794                       2606    16726    recensione fk_3    FK CONSTRAINT     s   ALTER TABLE ONLY public.recensione
    ADD CONSTRAINT fk_3 FOREIGN KEY (codal2) REFERENCES public.alloggio(codal);
 9   ALTER TABLE ONLY public.recensione DROP CONSTRAINT fk_3;
       public          postgres    false    221    2808    229                       2606    16731    recensione fk_4    FK CONSTRAINT     u   ALTER TABLE ONLY public.recensione
    ADD CONSTRAINT fk_4 FOREIGN KEY (codat2) REFERENCES public.attrazione(codat);
 9   ALTER TABLE ONLY public.recensione DROP CONSTRAINT fk_4;
       public          postgres    false    2798    229    213                       2606    16559    ristorante fk_5    FK CONSTRAINT     n   ALTER TABLE ONLY public.ristorante
    ADD CONSTRAINT fk_5 FOREIGN KEY (codt2) REFERENCES public.terra(codt);
 9   ALTER TABLE ONLY public.ristorante DROP CONSTRAINT fk_5;
       public          postgres    false    2788    211    205                       2606    16564    ristorante fk_6    FK CONSTRAINT     m   ALTER TABLE ONLY public.ristorante
    ADD CONSTRAINT fk_6 FOREIGN KEY (codm2) REFERENCES public.mare(codm);
 9   ALTER TABLE ONLY public.ristorante DROP CONSTRAINT fk_6;
       public          postgres    false    2790    207    211                       2606    16569    ristorante fk_7    FK CONSTRAINT     n   ALTER TABLE ONLY public.ristorante
    ADD CONSTRAINT fk_7 FOREIGN KEY (codv2) REFERENCES public.vegan(codv);
 9   ALTER TABLE ONLY public.ristorante DROP CONSTRAINT fk_7;
       public          postgres    false    211    2792    209                       2606    16592    cinema fk_8    FK CONSTRAINT     q   ALTER TABLE ONLY public.cinema
    ADD CONSTRAINT fk_8 FOREIGN KEY (codat3) REFERENCES public.attrazione(codat);
 5   ALTER TABLE ONLY public.cinema DROP CONSTRAINT fk_8;
       public          postgres    false    215    213    2798            
           2606    16654    beb fk_9    FK CONSTRAINT     l   ALTER TABLE ONLY public.beb
    ADD CONSTRAINT fk_9 FOREIGN KEY (codal4) REFERENCES public.alloggio(codal);
 2   ALTER TABLE ONLY public.beb DROP CONSTRAINT fk_9;
       public          postgres    false    2808    225    221            �   v   x�M���0痯� 'ѝ,�N]��j-E�D˒�oY7��q��f��j�jk����J��5+�i w>r���ߺ2"�a.�I�E�n����P�9+�6E�@8�����~s#�      �   '   x�3��M��-�ȯ�*����t�L���#�=... ��
�      �      x������ � �      �      x������ � �      �      x������ � �      �   T   x�3���M�TH/J,�,�Qp���M��TH��M-.��Qp��I����KU��K�)-N�)�LTH��K�I$�$r�pr��qqq 7��      �   0   x�3�.-���2��MM�,I-*J�K��2�H-N�H-�L�����  ��      �      x������ � �      �      x������ � �      �      x������ � �      �   >  x�mR�n�0<�����R��,��Į#�q��@.��Q��.E�N��~Z��K�I[�� ����̎`i��5pi*��d�ƴ�LC������e^&����4�������C�TR�j�L�
xX�%��a0�׏���a�C�]��yD�Y-@�w>*�Q�ä�����8H�x.T�d*
�Q���k��i	ʧ\Y(H��A���S�pc^(T���+��
Փ����$JaJX���Ɂsb�=����!	m`�e�ee|�2h��8tb����e�U�H]�OF.Έ�.��Q�fܿ����rC-�(tJE����Q%��l�����M"0g%�N�W���n{��ۤgl[ܽ�XG)�q���ﾽٳE�B�zA��4�Z²�rk�f=;�{o>�.>�So4�v��@z��%�X���Z��`ፈ�u�d6���k�S_(|���kbQ]���Ѡ,M�X�;����,�$&W\[�֣�{��jl�T 8>��YV7��}
 /u"���?�m�'u�5z�B�=�HkXO��}H�~.�p��@ ����#�{٢ST���]#�=�>EQ��!      �   -   x�3�.IM�V��/-N�2�(M�2�tK,.Qp��O����� ��	�      �   �   x�5�A
�@Ͻ��ª,�H$hN�e܌aH2����oMQTG�y�-uh#Z'�\�!�#���h8`0�$!%�VS1\�M��Fv�����ە��4��p)��:����=�w{����ON򻭢�'�}��X4;      �   0   x�3�Ȭ�J-�L�2�t.*M3�9�2�K��Kt�R���b���� ;�i     