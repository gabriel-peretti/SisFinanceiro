PGDMP     #                    w            SisFinanceiro    11.2    11.2 V    x           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            y           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            z           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            {           1262    16384    SisFinanceiro    DATABASE     ?   CREATE DATABASE "SisFinanceiro" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE "SisFinanceiro";
             postgres    false            ?            1259    16385    caixas    TABLE     ?   CREATE TABLE public.caixas (
    caixa_id integer NOT NULL,
    nome character varying(40),
    dt_ult_lancamento date,
    saldo_atual character varying(25)
);
    DROP TABLE public.caixas;
       public         postgres    false            ?            1259    16646    clientes    TABLE     &  CREATE TABLE public.clientes (
    cliente_id integer NOT NULL,
    nome character varying(100),
    rg character varying(12),
    telefone character varying(15),
    email character varying(100),
    situacao character(1),
    endereco character varying(100),
    cpf character varying(16)
);
    DROP TABLE public.clientes;
       public         postgres    false            ?            1259    16644    clientes_cliente_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.clientes_cliente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.clientes_cliente_id_seq;
       public       postgres    false    215            |           0    0    clientes_cliente_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.clientes_cliente_id_seq OWNED BY public.clientes.cliente_id;
            public       postgres    false    214            ?            1259    16391    conta_pagar    TABLE     ?   CREATE TABLE public.conta_pagar (
    contapagar_id integer NOT NULL,
    data_vencimento date,
    valor_titulo numeric(10,2),
    data_pagamento date,
    valor_pago numeric(10,2),
    lancamento_id integer NOT NULL
);
    DROP TABLE public.conta_pagar;
       public         postgres    false            ?            1259    16394    empresas    TABLE     o  CREATE TABLE public.empresas (
    empresa_id integer NOT NULL,
    nome character varying(60),
    cnpj character varying(14),
    logradouro character varying(50),
    numero character varying(5),
    complemento character varying(10),
    cep character varying(8),
    bairro character varying(20),
    uf character varying(2),
    cidade character varying(50)
);
    DROP TABLE public.empresas;
       public         postgres    false            ?            1259    16397 
   fornecedor    TABLE     ?   CREATE TABLE public.fornecedor (
    fornecedor_id integer NOT NULL,
    nome character varying(100),
    email character varying(100),
    telefone character varying(15),
    situacao character varying(1)
);
    DROP TABLE public.fornecedor;
       public         postgres    false            ?            1259    16400    gasto    TABLE     ?   CREATE TABLE public.gasto (
    gasto_id integer NOT NULL,
    descricao character varying(100),
    tipo character varying(1),
    situacao character varying(1)
);
    DROP TABLE public.gasto;
       public         postgres    false            ?            1259    16403 
   lancamento    TABLE     ?   CREATE TABLE public.lancamento (
    lancamento_id integer NOT NULL,
    datalancamento timestamp without time zone,
    fornecedor_id integer NOT NULL,
    usuario_id integer NOT NULL
);
    DROP TABLE public.lancamento;
       public         postgres    false            ?            1259    16406    produto_lancamento    TABLE     ?   CREATE TABLE public.produto_lancamento (
    produtolancamento_id integer NOT NULL,
    valor numeric(10,2),
    qtde numeric(10,2),
    lancamento_id integer NOT NULL,
    gasto_id integer NOT NULL
);
 &   DROP TABLE public.produto_lancamento;
       public         postgres    false            ?            1259    16578    produtos    TABLE     ?   CREATE TABLE public.produtos (
    produto_id integer NOT NULL,
    descricao character varying(100),
    valorcompra numeric(10,2),
    valorvenda numeric(10,2),
    quantidade numeric(10,2),
    situacao character varying(1)
);
    DROP TABLE public.produtos;
       public         postgres    false            ?            1259    16576    produtos_produto_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.produtos_produto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.produtos_produto_id_seq;
       public       postgres    false    205            }           0    0    produtos_produto_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.produtos_produto_id_seq OWNED BY public.produtos.produto_id;
            public       postgres    false    204            ?            1259    16412    tipomov    TABLE     ?   CREATE TABLE public.tipomov (
    tipomov_id integer NOT NULL,
    nome character varying(40),
    ent_sai character varying(1)
);
    DROP TABLE public.tipomov;
       public         postgres    false            ?            1259    16654    usuario    TABLE     ?   CREATE TABLE public.usuario (
    usuario_id integer NOT NULL,
    nome character varying(40),
    email character varying(100),
    senha character varying(100),
    situacao character(1)
);
    DROP TABLE public.usuario;
       public         postgres    false            ?            1259    16652    usuario_usuario_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.usuario_usuario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.usuario_usuario_id_seq;
       public       postgres    false    217            ~           0    0    usuario_usuario_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.usuario_usuario_id_seq OWNED BY public.usuario.usuario_id;
            public       postgres    false    216            ?            1259    16590    vendas    TABLE     ?   CREATE TABLE public.vendas (
    vendas_id integer NOT NULL,
    produto_id integer NOT NULL,
    cliente_id integer NOT NULL,
    datavenda date NOT NULL,
    valor numeric(10,2),
    valortotal numeric(10,2),
    desconto numeric(10,2)
);
    DROP TABLE public.vendas;
       public         postgres    false            ?            1259    16588    vendas_cliente_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.vendas_cliente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.vendas_cliente_id_seq;
       public       postgres    false    209                       0    0    vendas_cliente_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.vendas_cliente_id_seq OWNED BY public.vendas.cliente_id;
            public       postgres    false    208            ?            1259    16614    vendas_produto    TABLE     ?   CREATE TABLE public.vendas_produto (
    vendasproduto_id integer NOT NULL,
    produto_id integer NOT NULL,
    vendas_id integer NOT NULL,
    vendaproduto_valor numeric(10,2),
    vendaproduto_quantidade numeric(10,2)
);
 "   DROP TABLE public.vendas_produto;
       public         postgres    false            ?            1259    16586    vendas_produto_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.vendas_produto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.vendas_produto_id_seq;
       public       postgres    false    209            ?           0    0    vendas_produto_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.vendas_produto_id_seq OWNED BY public.vendas.produto_id;
            public       postgres    false    207            ?            1259    16610    vendas_produto_produto_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.vendas_produto_produto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.vendas_produto_produto_id_seq;
       public       postgres    false    213            ?           0    0    vendas_produto_produto_id_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.vendas_produto_produto_id_seq OWNED BY public.vendas_produto.produto_id;
            public       postgres    false    211            ?            1259    16612    vendas_produto_vendas_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.vendas_produto_vendas_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.vendas_produto_vendas_id_seq;
       public       postgres    false    213            ?           0    0    vendas_produto_vendas_id_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.vendas_produto_vendas_id_seq OWNED BY public.vendas_produto.vendas_id;
            public       postgres    false    212            ?            1259    16608 #   vendas_produto_vendasproduto_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.vendas_produto_vendasproduto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 :   DROP SEQUENCE public.vendas_produto_vendasproduto_id_seq;
       public       postgres    false    213            ?           0    0 #   vendas_produto_vendasproduto_id_seq    SEQUENCE OWNED BY     k   ALTER SEQUENCE public.vendas_produto_vendasproduto_id_seq OWNED BY public.vendas_produto.vendasproduto_id;
            public       postgres    false    210            ?            1259    16584    vendas_vendas_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.vendas_vendas_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.vendas_vendas_id_seq;
       public       postgres    false    209            ?           0    0    vendas_vendas_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.vendas_vendas_id_seq OWNED BY public.vendas.vendas_id;
            public       postgres    false    206            ?
           2604    16649    clientes cliente_id    DEFAULT     z   ALTER TABLE ONLY public.clientes ALTER COLUMN cliente_id SET DEFAULT nextval('public.clientes_cliente_id_seq'::regclass);
 B   ALTER TABLE public.clientes ALTER COLUMN cliente_id DROP DEFAULT;
       public       postgres    false    215    214    215            ?
           2604    16633    produtos produto_id    DEFAULT     z   ALTER TABLE ONLY public.produtos ALTER COLUMN produto_id SET DEFAULT nextval('public.produtos_produto_id_seq'::regclass);
 B   ALTER TABLE public.produtos ALTER COLUMN produto_id DROP DEFAULT;
       public       postgres    false    204    205    205            ?
           2604    16657    usuario usuario_id    DEFAULT     x   ALTER TABLE ONLY public.usuario ALTER COLUMN usuario_id SET DEFAULT nextval('public.usuario_usuario_id_seq'::regclass);
 A   ALTER TABLE public.usuario ALTER COLUMN usuario_id DROP DEFAULT;
       public       postgres    false    217    216    217            ?
           2604    16634    vendas vendas_id    DEFAULT     t   ALTER TABLE ONLY public.vendas ALTER COLUMN vendas_id SET DEFAULT nextval('public.vendas_vendas_id_seq'::regclass);
 ?   ALTER TABLE public.vendas ALTER COLUMN vendas_id DROP DEFAULT;
       public       postgres    false    209    206    209            ?
           2604    16594    vendas produto_id    DEFAULT     v   ALTER TABLE ONLY public.vendas ALTER COLUMN produto_id SET DEFAULT nextval('public.vendas_produto_id_seq'::regclass);
 @   ALTER TABLE public.vendas ALTER COLUMN produto_id DROP DEFAULT;
       public       postgres    false    209    207    209            ?
           2604    16635    vendas cliente_id    DEFAULT     v   ALTER TABLE ONLY public.vendas ALTER COLUMN cliente_id SET DEFAULT nextval('public.vendas_cliente_id_seq'::regclass);
 @   ALTER TABLE public.vendas ALTER COLUMN cliente_id DROP DEFAULT;
       public       postgres    false    208    209    209            ?
           2604    16636    vendas_produto vendasproduto_id    DEFAULT     ?   ALTER TABLE ONLY public.vendas_produto ALTER COLUMN vendasproduto_id SET DEFAULT nextval('public.vendas_produto_vendasproduto_id_seq'::regclass);
 N   ALTER TABLE public.vendas_produto ALTER COLUMN vendasproduto_id DROP DEFAULT;
       public       postgres    false    210    213    213            ?
           2604    16637    vendas_produto produto_id    DEFAULT     ?   ALTER TABLE ONLY public.vendas_produto ALTER COLUMN produto_id SET DEFAULT nextval('public.vendas_produto_produto_id_seq'::regclass);
 H   ALTER TABLE public.vendas_produto ALTER COLUMN produto_id DROP DEFAULT;
       public       postgres    false    211    213    213            ?
           2604    16638    vendas_produto vendas_id    DEFAULT     ?   ALTER TABLE ONLY public.vendas_produto ALTER COLUMN vendas_id SET DEFAULT nextval('public.vendas_produto_vendas_id_seq'::regclass);
 G   ALTER TABLE public.vendas_produto ALTER COLUMN vendas_id DROP DEFAULT;
       public       postgres    false    213    212    213            `          0    16385    caixas 
   TABLE DATA               P   COPY public.caixas (caixa_id, nome, dt_ult_lancamento, saldo_atual) FROM stdin;
    public       postgres    false    196   ?e       s          0    16646    clientes 
   TABLE DATA               b   COPY public.clientes (cliente_id, nome, rg, telefone, email, situacao, endereco, cpf) FROM stdin;
    public       postgres    false    215   
f       a          0    16391    conta_pagar 
   TABLE DATA               ~   COPY public.conta_pagar (contapagar_id, data_vencimento, valor_titulo, data_pagamento, valor_pago, lancamento_id) FROM stdin;
    public       postgres    false    197   ?g       b          0    16394    empresas 
   TABLE DATA               t   COPY public.empresas (empresa_id, nome, cnpj, logradouro, numero, complemento, cep, bairro, uf, cidade) FROM stdin;
    public       postgres    false    198   h       c          0    16397 
   fornecedor 
   TABLE DATA               T   COPY public.fornecedor (fornecedor_id, nome, email, telefone, situacao) FROM stdin;
    public       postgres    false    199   "h       d          0    16400    gasto 
   TABLE DATA               D   COPY public.gasto (gasto_id, descricao, tipo, situacao) FROM stdin;
    public       postgres    false    200   ?h       e          0    16403 
   lancamento 
   TABLE DATA               ^   COPY public.lancamento (lancamento_id, datalancamento, fornecedor_id, usuario_id) FROM stdin;
    public       postgres    false    201   \h       f          0    16406    produto_lancamento 
   TABLE DATA               h   COPY public.produto_lancamento (produtolancamento_id, valor, qtde, lancamento_id, gasto_id) FROM stdin;
    public       postgres    false    202   yh       i          0    16578    produtos 
   TABLE DATA               h   COPY public.produtos (produto_id, descricao, valorcompra, valorvenda, quantidade, situacao) FROM stdin;
    public       postgres    false    205   ?h       g          0    16412    tipomov 
   TABLE DATA               <   COPY public.tipomov (tipomov_id, nome, ent_sai) FROM stdin;
    public       postgres    false    203   ?i       u          0    16654    usuario 
   TABLE DATA               K   COPY public.usuario (usuario_id, nome, email, senha, situacao) FROM stdin;
    public       postgres    false    217   ?i       m          0    16590    vendas 
   TABLE DATA               k   COPY public.vendas (vendas_id, produto_id, cliente_id, datavenda, valor, valortotal, desconto) FROM stdin;
    public       postgres    false    209   wj       q          0    16614    vendas_produto 
   TABLE DATA               ~   COPY public.vendas_produto (vendasproduto_id, produto_id, vendas_id, vendaproduto_valor, vendaproduto_quantidade) FROM stdin;
    public       postgres    false    213   ?j       ?           0    0    clientes_cliente_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.clientes_cliente_id_seq', 21, true);
            public       postgres    false    214            ?           0    0    produtos_produto_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.produtos_produto_id_seq', 27, true);
            public       postgres    false    204            ?           0    0    usuario_usuario_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.usuario_usuario_id_seq', 3, true);
            public       postgres    false    216            ?           0    0    vendas_cliente_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.vendas_cliente_id_seq', 1, false);
            public       postgres    false    208            ?           0    0    vendas_produto_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.vendas_produto_id_seq', 1, false);
            public       postgres    false    207            ?           0    0    vendas_produto_produto_id_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.vendas_produto_produto_id_seq', 1, false);
            public       postgres    false    211            ?           0    0    vendas_produto_vendas_id_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public.vendas_produto_vendas_id_seq', 1, false);
            public       postgres    false    212            ?           0    0 #   vendas_produto_vendasproduto_id_seq    SEQUENCE SET     R   SELECT pg_catalog.setval('public.vendas_produto_vendasproduto_id_seq', 1, false);
            public       postgres    false    210            ?           0    0    vendas_vendas_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.vendas_vendas_id_seq', 1, false);
            public       postgres    false    206            ?
           2606    16651    clientes clientes_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT clientes_pkey PRIMARY KEY (cliente_id);
 @   ALTER TABLE ONLY public.clientes DROP CONSTRAINT clientes_pkey;
       public         postgres    false    215            ?
           2606    16422    caixas pk_caixa_id 
   CONSTRAINT     V   ALTER TABLE ONLY public.caixas
    ADD CONSTRAINT pk_caixa_id PRIMARY KEY (caixa_id);
 <   ALTER TABLE ONLY public.caixas DROP CONSTRAINT pk_caixa_id;
       public         postgres    false    196            ?
           2606    16426    conta_pagar pk_contapagar_id 
   CONSTRAINT     e   ALTER TABLE ONLY public.conta_pagar
    ADD CONSTRAINT pk_contapagar_id PRIMARY KEY (contapagar_id);
 F   ALTER TABLE ONLY public.conta_pagar DROP CONSTRAINT pk_contapagar_id;
       public         postgres    false    197            ?
           2606    16428    empresas pk_empresa_id 
   CONSTRAINT     \   ALTER TABLE ONLY public.empresas
    ADD CONSTRAINT pk_empresa_id PRIMARY KEY (empresa_id);
 @   ALTER TABLE ONLY public.empresas DROP CONSTRAINT pk_empresa_id;
       public         postgres    false    198            ?
           2606    16430    fornecedor pk_fornecedor_id 
   CONSTRAINT     d   ALTER TABLE ONLY public.fornecedor
    ADD CONSTRAINT pk_fornecedor_id PRIMARY KEY (fornecedor_id);
 E   ALTER TABLE ONLY public.fornecedor DROP CONSTRAINT pk_fornecedor_id;
       public         postgres    false    199            ?
           2606    16432    gasto pk_gasto_id 
   CONSTRAINT     U   ALTER TABLE ONLY public.gasto
    ADD CONSTRAINT pk_gasto_id PRIMARY KEY (gasto_id);
 ;   ALTER TABLE ONLY public.gasto DROP CONSTRAINT pk_gasto_id;
       public         postgres    false    200            ?
           2606    16434    lancamento pk_lancamento_id 
   CONSTRAINT     d   ALTER TABLE ONLY public.lancamento
    ADD CONSTRAINT pk_lancamento_id PRIMARY KEY (lancamento_id);
 E   ALTER TABLE ONLY public.lancamento DROP CONSTRAINT pk_lancamento_id;
       public         postgres    false    201            ?
           2606    16438 *   produto_lancamento pk_produtolancamento_id 
   CONSTRAINT     z   ALTER TABLE ONLY public.produto_lancamento
    ADD CONSTRAINT pk_produtolancamento_id PRIMARY KEY (produtolancamento_id);
 T   ALTER TABLE ONLY public.produto_lancamento DROP CONSTRAINT pk_produtolancamento_id;
       public         postgres    false    202            ?
           2606    16440    tipomov pk_tipomov_id 
   CONSTRAINT     [   ALTER TABLE ONLY public.tipomov
    ADD CONSTRAINT pk_tipomov_id PRIMARY KEY (tipomov_id);
 ?   ALTER TABLE ONLY public.tipomov DROP CONSTRAINT pk_tipomov_id;
       public         postgres    false    203            ?
           2606    16583    produtos produtos_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.produtos
    ADD CONSTRAINT produtos_pkey PRIMARY KEY (produto_id);
 @   ALTER TABLE ONLY public.produtos DROP CONSTRAINT produtos_pkey;
       public         postgres    false    205            ?
           2606    16659    usuario usuario_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (usuario_id);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public         postgres    false    217            ?
           2606    16597    vendas vendas_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.vendas
    ADD CONSTRAINT vendas_pkey PRIMARY KEY (vendas_id);
 <   ALTER TABLE ONLY public.vendas DROP CONSTRAINT vendas_pkey;
       public         postgres    false    209            ?
           2606    16621 "   vendas_produto vendas_produto_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY public.vendas_produto
    ADD CONSTRAINT vendas_produto_pkey PRIMARY KEY (vendasproduto_id);
 L   ALTER TABLE ONLY public.vendas_produto DROP CONSTRAINT vendas_produto_pkey;
       public         postgres    false    213            ?
           2606    16450    lancamento fk_fornecedor_id    FK CONSTRAINT     ?   ALTER TABLE ONLY public.lancamento
    ADD CONSTRAINT fk_fornecedor_id FOREIGN KEY (fornecedor_id) REFERENCES public.fornecedor(fornecedor_id);
 E   ALTER TABLE ONLY public.lancamento DROP CONSTRAINT fk_fornecedor_id;
       public       postgres    false    199    201    2765            ?
           2606    16455    produto_lancamento fk_gasto_id    FK CONSTRAINT     ?   ALTER TABLE ONLY public.produto_lancamento
    ADD CONSTRAINT fk_gasto_id FOREIGN KEY (gasto_id) REFERENCES public.gasto(gasto_id);
 H   ALTER TABLE ONLY public.produto_lancamento DROP CONSTRAINT fk_gasto_id;
       public       postgres    false    202    200    2767            ?
           2606    16460    conta_pagar fk_lancamento_id    FK CONSTRAINT     ?   ALTER TABLE ONLY public.conta_pagar
    ADD CONSTRAINT fk_lancamento_id FOREIGN KEY (lancamento_id) REFERENCES public.lancamento(lancamento_id);
 F   ALTER TABLE ONLY public.conta_pagar DROP CONSTRAINT fk_lancamento_id;
       public       postgres    false    197    201    2769            ?
           2606    16465 #   produto_lancamento fk_lancamento_id    FK CONSTRAINT     ?   ALTER TABLE ONLY public.produto_lancamento
    ADD CONSTRAINT fk_lancamento_id FOREIGN KEY (lancamento_id) REFERENCES public.lancamento(lancamento_id);
 M   ALTER TABLE ONLY public.produto_lancamento DROP CONSTRAINT fk_lancamento_id;
       public       postgres    false    202    2769    201            ?
           2606    16598    vendas fk_vendas_produto    FK CONSTRAINT     ?   ALTER TABLE ONLY public.vendas
    ADD CONSTRAINT fk_vendas_produto FOREIGN KEY (produto_id) REFERENCES public.produtos(produto_id);
 B   ALTER TABLE ONLY public.vendas DROP CONSTRAINT fk_vendas_produto;
       public       postgres    false    2775    209    205            ?
           2606    16622 (   vendas_produto fk_vendas_produto_produto    FK CONSTRAINT     ?   ALTER TABLE ONLY public.vendas_produto
    ADD CONSTRAINT fk_vendas_produto_produto FOREIGN KEY (produto_id) REFERENCES public.produtos(produto_id);
 R   ALTER TABLE ONLY public.vendas_produto DROP CONSTRAINT fk_vendas_produto_produto;
       public       postgres    false    2775    213    205            ?
           2606    16627 '   vendas_produto fk_vendas_produto_vendas    FK CONSTRAINT     ?   ALTER TABLE ONLY public.vendas_produto
    ADD CONSTRAINT fk_vendas_produto_vendas FOREIGN KEY (vendas_id) REFERENCES public.vendas(vendas_id);
 Q   ALTER TABLE ONLY public.vendas_produto DROP CONSTRAINT fk_vendas_produto_vendas;
       public       postgres    false    209    213    2777            `      x?????? ? ?      s   ?  x??RMs?0=?_??=??`疝?K/?????I?@bC??_?i???삍퇞$?)??w?j??ꪾ??????vJ?\??D?晦?i????p?U?]??+??w??c_?{q1???.nٿ??k$? ??2& ?f?AZhyq????چ?f?$ao????h?B	@ox???o??1Bk???Z5y??Ö?޸?M????2???e??R?,??'%?9?՘?\???m?????r)?#S???)?????IJw??mn<?f)!?#7y-"!n??H?????g????g??]?ظx???D?,i???H??a˩
??\!$J8%??S?????? ?v?<	??wݒ<5H??p?GM?=d_W?A?Y[_sSԏi???YK]@?)fR???C???ql???r??$?HA???K??$??WS?????nG???T????^??o??K?(?/%+      a      x?????? ? ?      b      x?????? ? ?      c      x?????? ? ?      d      x?????? ? ?      e      x?????? ? ?      f      x?????? ? ?      i   %  x?mQ?r?0<??????c.??\??&L]?P??W~ &???f??j-qpz~?U? ??D??4????FcGD???_l??0ESA?*??40?Ǫ?<????,*?&c`??ءJ?Hp???_?uv????????f'9J?K?֯2????ۛ????@?w%?????㺅?w;U:??=?????Dr
ƺ??y????]?њ8?]Y?????Y\?aI$??g??sE???0>5?i?P???t??'\?\>??V[????x????}??cAO{at?uEyy?+?a2?d?o3??t?!ғ?      g      x?????? ? ?      u      x?5???0 ??ǐv???}У_?eATL????k0&???hq??X??o??_+/???U(J???i3?D*???|?h?r$??|O|????)???P??\lQ??7????|l?]w1\~ȡ?R~ ?A&?      m      x?????? ? ?      q      x?????? ? ?     