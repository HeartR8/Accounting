PGDMP  "    '                 |         
   accounting    16.1    16.1                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    24771 
   accounting    DATABASE     l   CREATE DATABASE accounting WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'C';
    DROP DATABASE accounting;
                postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                pg_database_owner    false                       0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   pg_database_owner    false    4            �            1259    24793    accounts    TABLE     �   CREATE TABLE public.accounts (
    id uuid NOT NULL,
    account_type character varying(50) NOT NULL,
    value integer NOT NULL
);
    DROP TABLE public.accounts;
       public         heap    postgres    false    4            �            1259    24798    history    TABLE     �   CREATE TABLE public.history (
    id uuid NOT NULL,
    account_id uuid NOT NULL,
    value integer NOT NULL,
    update_datetime timestamp with time zone NOT NULL
);
    DROP TABLE public.history;
       public         heap    postgres    false    4            
          0    24793    accounts 
   TABLE DATA           ;   COPY public.accounts (id, account_type, value) FROM stdin;
    public          postgres    false    215   �                 0    24798    history 
   TABLE DATA           I   COPY public.history (id, account_id, value, update_datetime) FROM stdin;
    public          postgres    false    216   E       w           2606    24797    accounts accounts_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.accounts
    ADD CONSTRAINT accounts_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.accounts DROP CONSTRAINT accounts_pkey;
       public            postgres    false    215            y           2606    24802    history history_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.history
    ADD CONSTRAINT history_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.history DROP CONSTRAINT history_pkey;
       public            postgres    false    216            z           2606    24803    history account_id_f_key    FK CONSTRAINT     }   ALTER TABLE ONLY public.history
    ADD CONSTRAINT account_id_f_key FOREIGN KEY (account_id) REFERENCES public.accounts(id);
 B   ALTER TABLE ONLY public.history DROP CONSTRAINT account_id_f_key;
       public          postgres    false    3447    216    215            
   �  x�M���0��s�-�0���@)����_��9ץi�����9X�\Y�s"؎N9+�q=�����A���sjm��F�q��P�M�#7���������bT�>p��`���B�O��3��NH:	��@�Oh)�\��>�x��TF�0����>����Yc�:�.6텠��(��W�*=N�Q)@oa>��+�C(��x�m��1`E��G�y�&�I����lz�%8%L�0�X2�N  ��e���?��G�uA�"0�|S8Dyβ��/�[q����_%&�����������`s���求;癫�&>BA�p�<����}�������Y">�iS�`�?�Y��Y�SMt��֗�ò���7�����@d	�&�,����{�Ȉ�����=ƥn-
���UA�[�o�o&�>=�Ͽd�#         &  x���;�\A���*��hA�kqRj�K��Il�t��8�®9lڄa� ��g��]��_�����	d��a@k�EX��W�&�Q�̷�'����]zkA����ni):�d�>>������,/,wȮ���>X_
�r��fN�ۼԔ�� ���$�,ﰍ%�ͨ���|J���aIia�c.�E
'�	im϶+���n�ZL� ���4	��/]#�MR���*!�G��N"
{�9���Sʲ�m��� �O���k���X&y�;K�p%$�	��5;��I��~?��7���     